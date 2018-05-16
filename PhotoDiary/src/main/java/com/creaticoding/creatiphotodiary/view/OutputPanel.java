package com.creaticoding.creatiphotodiary.view;

import java.awt.Color;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputPanel extends JPanel {

	private static final long serialVersionUID = -1609076443511525653L;

	@Autowired
	private OutputScrollPane outputScrollPane;

	/**
	 * 생성자: UI 컴포넌트의 초기 설정
	 */
	public OutputPanel() {
		this.setLayout(null);
		this.setBounds(0, 100, 500, 400);
		this.setBackground(new Color(0, 255, 0));
	}

	@PostConstruct
	public void init() {
		this.add(outputScrollPane);
	}
}
