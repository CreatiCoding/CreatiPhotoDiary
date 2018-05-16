package com.creaticoding.creatiphotodiary.view;

import java.awt.Color;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputFormPanel extends JPanel {

	private static final long serialVersionUID = -1360008022287075047L;
	@Autowired
	private ImageUploadButton imageUploadButton;
	@Autowired
	private SubmitButton submitButton;
	@Autowired
	private InputArea inputArea;

	/**
	 * 생성자: UI 컴포넌트의 초기 설정
	 */
	public InputFormPanel() {
		// 레이아웃, 위치 및 크기 지정
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBounds(0, 0, 500, 100);

		// 색 지정
		this.setBackground(new Color(0, 0, 255));
	}

	@PostConstruct
	public void init() {
		this.add(imageUploadButton);
		this.add(inputArea);
		this.add(submitButton);
	}
}
