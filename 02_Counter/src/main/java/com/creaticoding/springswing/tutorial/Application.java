package com.creaticoding.springswing.tutorial;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false).web(WebApplicationType.NONE).run(args);
	}
}
