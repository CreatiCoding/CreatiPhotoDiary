package com.creaticoding.springswing.tutorial;

import java.awt.*;
import javax.swing.JFrame;
import org.springframework.boot.*;
import org.springframework.boot.builder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).headless(false).web(WebApplicationType.NONE).run(args);
	}

	@Bean
	public HelloWorld frame() {
		return new HelloWorld();
	}
}

class HelloWorld extends JFrame {
	private static final long serialVersionUID = -651405855813691971L;

	HelloWorld() {
		this.setSize(500, 200);
		setTitle("Hello World");
		Label label1 = new Label("Hello World", Label.CENTER);
		label1.setFont(new Font("Consolas", Font.BOLD, 20));
		this.add(label1);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
