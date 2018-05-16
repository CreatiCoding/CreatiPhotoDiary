package com.creaticoding.creatiphotodiary.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creaticoding.creatiphotodiary.MainFrame;
import com.creaticoding.creatiphotodiary.view.ImageUploadButton;
import com.creaticoding.creatiphotodiary.view.InputArea;

@Component
public class ButtonController {

	public static final int SUBMIT_BUTTON = 1;
	public static final int IMAGE_UPLOAD_BUTTON = 2;
	@Autowired
	private MainFrame mainFrame;
	@Autowired
	private InputArea inputArea;
	@Autowired
	private ImageUploadButton imageUploadButton;

	private class SubmitController implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}

	private class ImageUploadController implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				inputArea.setText(filepath);
				imageUploadButton.setImage(filepath);
			}
		}
	}

	/**
	 * @param JButton
	 *            button
	 * @param type
	 *            SUBMIT_BUTTON, IMAGE_UPLOAD_BUTTON
	 * @return
	 */
	public boolean registController(JButton button, int type) {
		switch (type) {
		case SUBMIT_BUTTON:
			button.addActionListener(new SubmitController());
			return true;
		case IMAGE_UPLOAD_BUTTON:
			button.addActionListener(new ImageUploadController());
			return true;
		default:
			return false;
		}
	}
}
