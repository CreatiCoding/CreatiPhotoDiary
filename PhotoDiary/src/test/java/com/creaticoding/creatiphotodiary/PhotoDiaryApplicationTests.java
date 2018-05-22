package com.creaticoding.creatiphotodiary;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoDiaryApplicationTests {

	@Test
	public void contextLoads() {
		File file = new File("/Users/creco/cherry blossom.png");
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.exists());
	}

}
