package com.creaticoding.creatiphotodiary;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PhotoDiaryApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PhotoDiaryApplication.class);
		builder.headless(false).web(WebApplicationType.NONE).run(args);
	}
}