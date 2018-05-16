package com.creaticoding.creatiphotodiary.view;

import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SubmitButton extends JButton {

	private static final long serialVersionUID = 7503301764562728195L;

	public SubmitButton() throws IOException {

		super(new ImageIcon(new ClassPathResource("image/submit2.png").getURI().getPath()));

		this.setBounds(450, 0, 50, 100);
		this.setMargin(new Insets(0, 0, 0, 0));

	}

}
