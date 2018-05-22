package com.creaticoding.creatiphotodiary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.*;
import com.creaticoding.creatiphotodiary.util.*;

/**
 * GUI 프로그래밍의 SWING 컴포넌트
 * MVC 패턴 중 View에 해
 * @author creaticoding
 *
 */
@Component
public class View {
	@Autowired
	private ConvertorUtil ConvertorUtil;
	
	// 컴포넌트들 선언 						//	<부모> 
	private JFrame mainFrame;			// 	최상위 컴포넌트 
	private JPanel inputPanel;			//	mainFrame 
	private JPanel outputPanel;			//	mainFrame
	private JButton uploadBtn;			//  inputPanel
	private JScrollPane inputScroll;	//	inputPanel
	private JTextArea inputArea;		//	inputPanel
	private JButton submitBtn;			//	inputPanel
	private JScrollPane outputScroll;	//	outputPanel
	private JPanel scrollInnerPanel;	//	outputScroll

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JPanel getInputPanel() {
		return inputPanel;
	}

	public JPanel getOutputPanel() {
		return outputPanel;
	}

	public JButton getUploadBtn() {
		return uploadBtn;
	}

	public JScrollPane getInputScroll() {
		return inputScroll;
	}

	public JTextArea getInputArea() {
		return inputArea;
	}

	public JButton getSubmitBtn() {
		return submitBtn;
	}

	public JScrollPane getOutputScroll() {
		return outputScroll;
	}

	public JPanel getScrollInnerPanel() {
		return scrollInnerPanel;
	}

	@PostConstruct
	public void StartApp() {
		// 뷰 컴포넌트 초기화 
		mainFrame = new JFrame("Photo Diary");
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		submitBtn = new JButton();
		submitBtn.setSize(50, 100);
		uploadBtn = new JButton();
		uploadBtn.setSize(100, 100);
		// 처음 켜졌을 때 이미지를 로딩하고 있다면 보여줘야하기 때문에 미리 출력해놓는다.
		inputScroll = new JScrollPane(new JTextArea("불러 오는 중 입니다."));
		outputScroll = new JScrollPane(new JPanel());
		// 스크롤 컴포넌트에 등록한 입력과 출력 컴포넌트를 가져와 초기화
		inputArea = (JTextArea) (inputScroll.getViewport().getView());
		scrollInnerPanel = (JPanel) (outputScroll.getViewport().getView());

		// 메인 -> 상단은 입력 패
		mainFrame.setLayout(null);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.setBounds(0, 0, 500, 100);
		mainFrame.add(inputPanel);

		// 메인 -> 하단은 출력 패
		outputPanel.setLayout(null);
		outputPanel.setBounds(0, 100, 500, 600);
		outputPanel.setBackground(new Color(255, 255, 255));
		mainFrame.add(outputPanel);

		// 입력 -> 업로드 버튼
		uploadBtn.setBounds(0, 0, 100, 100);
		uploadBtn.setMargin(new Insets(0, -6, 0, -6));
		setImageOnButton(uploadBtn, "image/ImageUploadButton4.png");
		inputPanel.add(uploadBtn);

		// 입력 -> 스크롤 -> 텍스트입력칸
		inputArea.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		inputArea.setLineWrap(true);
		inputScroll.setPreferredSize(new Dimension(350, 100));
		inputPanel.add(inputScroll);

		// 입력 -> 게시 버튼
		submitBtn.setBounds(450, 0, 50, 100);
		submitBtn.setMargin(new Insets(0, -6, 0, -6));
		setImageOnButton(submitBtn, "image/submit2.png");// "image/submit2.png");
		inputPanel.add(submitBtn);

		// 출력 -> 스크롤 -> 일기 출력부분 
		scrollInnerPanel.setBackground(new Color(255, 255, 255));
		scrollInnerPanel.setLayout(new BoxLayout(scrollInnerPanel, BoxLayout.Y_AXIS));
		outputScroll.setBounds(0, 0, 500, 600);
		outputScroll.getVerticalScrollBar().setUnitIncrement(8);
		outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		outputScroll.setBackground(new Color(255, 255, 255));
		outputPanel.add(outputScroll);

		// 메인 프레임 출력
		mainFrame.setSize(500, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

	// 게시물을 게시한 후 업로드 버튼의 이미지를 초기화해주기 위해 컴포넌트 재생성 
	public JButton afterSubmit() {
		uploadBtn.getParent().remove(0);
		uploadBtn = new JButton();
		uploadBtn.setBounds(0, 0, 100, 100);
		uploadBtn.setMargin(new Insets(0, -6, 0, -6));
		setImageOnButton(uploadBtn, "image/ImageUploadButton4.png");
		inputPanel.add(uploadBtn, 0);
		inputArea.setText("");
		mainFrame.repaint();
		return uploadBtn;
	}

	// 버튼 위에 이미지 그리기
	public void setImageOnButton(JButton btn, String path) {
		File file;
		BufferedImage myPicture;
		try {
			// 전달받은 경로의 파일이 실제로 존재한다, 즉 전달받은 경로가 올바른 경우 
			file = new File(path);
			if (!file.exists()) {
				// 없다면 클래스패스에 존재하는 파일 사용
				btn.setIcon(new ImageIcon(new ClassPathResource(path).getURI().getPath()));
			} else {
				// 데이터 초기
				btn.setText("");
				// 이미지 버튼 크기에 맞게 재조정 
				myPicture = ImageIO.read(file);
				ImageIcon imageIcon = new ImageIcon(myPicture);
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);
				// 다시 이미지 그리기
				btn.setIcon(imageIcon);
			}
		} catch (IOException e) {
			btn.setIcon(null);
		}
	}

	// 출력장소에 아이템 하나 추가하기
	public void addItemInOutputScroll(DiaryModel model) {
		// 추가할 컴포넌트 선언 
		JPanel item = new JPanel();
		item.setLayout(null);

		// 이미지의 크기 조정을 위한 부분 
		double x = 0, y = 0;
		System.out.println(model.getFile());
		if (model.getFile() != null) {
			BufferedImage myPicture;
			// 이미지를 받아서 버퍼로 저장
			myPicture = ConvertorUtil.byteArr2bufferedImage(model.getFile());
			// 너비는 450으로 통일 
			x = 450;
			ImageIcon imageIcon = new ImageIcon(myPicture);
			// 길이가 크냐 작냐에 따라 너비에 맞는 비율로 높이 산정
			if (imageIcon.getIconHeight() > imageIcon.getIconWidth()) {
				y = ((double) (imageIcon.getIconHeight()) / (double) (imageIcon.getIconWidth())) * 450;
				System.out.println(String.valueOf(x) + " " + String.valueOf(y));
			} else if (imageIcon.getIconHeight() < imageIcon.getIconWidth()) {
				y = ((450 / (double) (imageIcon.getIconWidth()))) * imageIcon.getIconHeight();
				System.out.println(String.valueOf(x) + " " + String.valueOf(y));
			} else {
				y = 450;
			}
			// 재 산출한 이미지 크기로 재 생성 후 삽입 
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance((int) x, (int) y, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			JLabel picLabel = new JLabel(imageIcon);
			item.add(picLabel);
			picLabel.setBounds(25, 0, 450, (int) y);
		}

		// 아이템의 크기 설정
		item.setBackground(new Color(255, 255, 255));
		item.setPreferredSize(new Dimension(400, (int) y + 100));
		item.setMaximumSize(new Dimension(400, (int) y + 100));

		// 출력문 중 날짜 및 시간 출력 구함
		String time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(model.getCreateTime());

		// 출력문을 시간 뒤에 붙여서 출력문에 출력
		JTextArea ta = new JTextArea(time + "\n" + model.getContents());
		ta.setLineWrap(true);
		item.add(ta);
		ta.setBounds(25, (int) y, 450, (int) y + 100);
		// 해당 아이템을 스크롤 패널 내부 패널에 삽입 
		scrollInnerPanel.add(item, 0);
		// 게시물과 게시물을 구별하기 위한 구분선 컴포넌트 추가
		JTextField j = new JTextField();
		j.setPreferredSize(new Dimension(450, 4));
		j.setSize(new Dimension(450, 4));
		j.setMaximumSize(new Dimension(450, 4));
		j.setMinimumSize(new Dimension(450, 4));
		j.setBackground(new Color(0, 0, 0));
		// 바로 다음 요소에 추가
		scrollInnerPanel.add(j, 1);

		// 완료사항
		mainFrame.repaint();
	}

	public void repaint() {
		mainFrame.repaint();
	}

}
