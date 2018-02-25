package com.creaticoding.springswing.tutorial;

import java.awt.*;
import javax.swing.JFrame;
import org.springframework.boot.*;
import org.springframework.boot.builder.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false)
				.web(WebApplicationType.NONE).run(args);
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
	}

}

@Component
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
