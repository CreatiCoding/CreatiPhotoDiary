package com.creaticoding.creatiphotodiary;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.creaticoding.creatiphotodiary.util.*;

/**
 * MVC패턴 중 Controller 클래스
 * 사용자의 행동을 감지하는 이벤트 핸들러 클래스
 * 스프링으로 치면 dispatcher 역할
 * @author creaticoding
 *
 */
@Component
public class Controller {

	@Autowired
	private View view;
	@Autowired
	private UploadController UploadController;
	@Autowired
	private SubmitController SubmitController;
	@Autowired
	private CloseController CloseController;
	@Autowired
	private SerializableUtil SerializableUtil;
	@Autowired
	private ConvertorUtil ConvertorUtil;

	private List<DiaryModel> modelList;
	private File uploadedFile;

	// 각 컨트롤러 해당되는 뷰에 매핑 
	@PostConstruct
	public void mappingViewController() {
		view.getSubmitBtn().addActionListener(SubmitController);
		view.getUploadBtn().addActionListener(UploadController);
		view.getMainFrame().addWindowListener(CloseController);
	}

	/**
	 * 글 작성 이벤트 컨트롤
	 * @author creaticoding
	 *
	 */
	@Component
	private class SubmitController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 데이터가 비어있고 이미지가 없다면 아무 글도 올라가지 않는다.
			if ("".equals(view.getInputArea().getText()) && uploadedFile == null) {
				return;
			} else {
				BufferedImage buff = null;
				try {
					// 파일이 없다면 에러가 발생하고 버퍼를 널로 초기화시켜준다.
					buff = ImageIO.read(uploadedFile);
				} catch (IOException e1) {
					buff = null;
				}
				// 모델을 완성한다.
				DiaryModel model = new DiaryModel(modelList.size(), view.getInputArea().getText(),
						new Timestamp(new Date().getTime()), ConvertorUtil.BufferedImage2ByteArray(buff));
				// 완성된 모델을 데이터의 리스트에 담아 보관한다.
				modelList.add(model);
				// 추가된 데이터를 추가적으로 화면의 하단에 표현해준다.
				view.addItemInOutputScroll(model);
				// 성공적으로 화면 하단에 글이 올라가면 업로드 파일 공을 비워준다.
				uploadedFile = null;
				// 글 작성 이후 업로드 버튼의 이미지를 초기화해주기 위해 컴포넌트 재생성하고 이벤트도 새로 등록한다.
				view.afterSubmit().addActionListener(UploadController);
				return;
			}
		}
	}
	/**
	 * 이미지 업로드 컨트롤러 
	 * @author creaticoding
	 *
	 */
	@Component
	private class UploadController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 파일 선택하는 컴포넌트, 생성하면 파일 선택창이 뜨고
			// 파일을 선택할때까지 프로그램은 일시정지된다.
			JFileChooser fc = new JFileChooser();
			// 이미지 업로드는 약간의 시간이 걸리므로 업로드 중임을 알려준다.
			view.getUploadBtn().setText("업로드 중");
			view.getUploadBtn().setIcon(null);
			view.getUploadBtn().setSize(new Dimension(100, 100));
			view.getUploadBtn().setMinimumSize(new Dimension(100, 100));
			view.getUploadBtn().setMaximumSize(new Dimension(100, 100));
			view.getUploadBtn().setPreferredSize(new Dimension(100, 100));
			// 파일선택을 올바르게 하였다면 
			if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
				// 선택된 파일을 가지고 uploadedFile에 보관
				File f = fc.getSelectedFile();
				String filePath = f.getPath();
				uploadedFile = new File(filePath);
				// 실존하는 파일이라
				if (!uploadedFile.exists()) {
					uploadedFile = null;
				}
				// 업로드한 이미지를 버튼 위에 미리보기형태로 보여준다.
				view.setImageOnButton(view.getUploadBtn(), filePath);
			} else {
				// 파일명을 올바르게 선택하지 못했다면 업로드 버튼을 초기화해주고 이벤트를 새롭게 등록한다.
				view.afterSubmit().addActionListener(UploadController);
			}
		}
	}

	/**
	 * 프로그램 종료와 시작할  발생하는 이벤트 컨트롤러  
	 * @author creaticoding
	 *
	 */
	@Component
	private class CloseController extends WindowAdapter {
		// 창이 켜질때 실행되는 함수 
		@SuppressWarnings("unchecked")
		@Override
		public void windowOpened(WindowEvent e) {
			super.windowOpened(e);
			// 우선 입력칸을 초기화합니다.
			view.getInputArea().setText("");
			// PhotoDiary.bk로부터 데이터를 받아와서 직렬화를 통해 리스트에 데이터를 넣는다.
			modelList = (ArrayList<DiaryModel>) SerializableUtil.readObject("PhotoDiary.bk");
			// 만약 리스트가 비어있다면 다시 초기화를 해준다.
			if (modelList == null) {
				modelList = new ArrayList<DiaryModel>();
			} else {
				// 리스트가 비어있지 않다면 화면에 하나씩 표시 해준다.
				for (int i = 0; i < modelList.size(); i++) {
					view.addItemInOutputScroll(modelList.get(i));
				}
			}
		}

		// 창이 꺼질때 실행되는 함수
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			SerializableUtil.writeObject(modelList, "PhotoDiary.bk");
			System.exit(0);
		}
	}
}
