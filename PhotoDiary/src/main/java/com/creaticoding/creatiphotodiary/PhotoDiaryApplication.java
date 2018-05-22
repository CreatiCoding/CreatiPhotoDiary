package com.creaticoding.creatiphotodiary;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 스프링 부트 설정이 더욱 간편해 졌다.
 * @author creaticoding
 */
@SpringBootApplication
public class PhotoDiaryApplication {

	public static void main(String[] args) {
		//스프링 부트 시작 클래스를 선언한다.
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PhotoDiaryApplication.class);
		// 웹이 아니기 때문에 NONE설정으로 둔다.
		builder.headless(false).web(WebApplicationType.NONE).run(args);
	}
}