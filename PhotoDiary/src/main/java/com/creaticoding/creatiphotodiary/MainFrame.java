package com.creaticoding.creatiphotodiary;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creaticoding.creatiphotodiary.controller.ButtonController;
import com.creaticoding.creatiphotodiary.controller.FrameController;
import com.creaticoding.creatiphotodiary.view.ImageUploadButton;
import com.creaticoding.creatiphotodiary.view.InputFormPanel;
import com.creaticoding.creatiphotodiary.view.OutputPanel;

@Component
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -8316588162150906555L;

	/**
	 * Swing GUI View Component
	 */
	@Autowired
	private InputFormPanel inputFormPanel;
	@Autowired
	private OutputPanel outputPanel;
	@Autowired
	private FrameController frameController;
	@Autowired
	private ButtonController buttonController;
	@Autowired
	private ImageUploadButton imageUploadButton;

	public MainFrame() {
		// 메뉴바와 가상자리 선이 차지하는 두께
		int heigntMenu = 23;
		int widthOutline = 7;
		this.setTitle("Photo Diary");
		this.setLayout(null);
		this.setSize(500 + widthOutline * 2, 500 + widthOutline * 2 + heigntMenu);
	}

	
	@PostConstruct
	public void init() {
		
		this.setViews();
		this.setControllers();
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void setViews() {
		this.add(inputFormPanel);
		this.add(outputPanel);
	}
	private void setControllers() {
		this.addWindowListener(frameController);
		buttonController.registController(imageUploadButton, ButtonController.IMAGE_UPLOAD_BUTTON);
	}
}
