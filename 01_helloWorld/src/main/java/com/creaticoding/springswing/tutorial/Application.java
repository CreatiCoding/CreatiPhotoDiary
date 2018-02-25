package com.creaticoding.springswing.tutorial;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false).web(WebApplicationType.NONE).run(args);
	}
}

@Component
class HelloWorld extends Frame {
	private static final long serialVersionUID = -651405855813691971L;

	HelloWorld() {
		setTitle("Hello World");
		Label label1 = new Label("Hello World", Label.CENTER);
		label1.setFont(new Font("Consolas", Font.BOLD, 20));
		this.setSize(500, 200);
		this.add(label1);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
