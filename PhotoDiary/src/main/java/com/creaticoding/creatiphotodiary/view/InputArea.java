package com.creaticoding.creatiphotodiary.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class InputArea extends JTextField {

	private static final long serialVersionUID = -5902878817485845289L;

	public InputArea() {
		this.setMaximumSize(new Dimension(350, 100));
		this.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
	}
}
