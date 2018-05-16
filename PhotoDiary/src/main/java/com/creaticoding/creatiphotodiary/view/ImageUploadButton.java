package com.creaticoding.creatiphotodiary.view;

import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.creaticoding.creatiphotodiary.MainFrame;

@Component
public class ImageUploadButton extends JButton {

	private static final long serialVersionUID = 7503301764562728195L;

	@Autowired
	private MainFrame mainFrame;

	public ImageUploadButton() throws IOException {
		super(new ImageIcon(new ClassPathResource("image/ImageUploadButton4.png").getURI().getPath()));
		this.setBounds(0, 0, 100, 100);
		this.setMargin(new Insets(0, 0, 0, 0));
	}

	public void setImage(String path) {
		ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		this.setIcon(imageIcon);
		mainFrame.repaint();
	}
}
