package com.creaticoding.springswing.tutorial;

import static org.junit.Assert.assertEquals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileUtil {
	
	// 싱글톤 지원시 public으로 선언 
/*	public TextFileUtil() {}*/
	
	
	// 싱글톤 미지원시 코드로 싱글톤 구현
	private TextFileUtil() {
	}

	private static class SingletonHolder {
		public static final TextFileUtil INSTANCE = new TextFileUtil();
	}

	public static TextFileUtil getSingletonObject() {
		return SingletonHolder.INSTANCE;
	}

    private BufferedInputStream bis;
    private BufferedOutputStream bos;

    public String readTextFile(String fileName)  {
		StringBuffer result = new StringBuffer("");
		try {
			bis = new BufferedInputStream(new FileInputStream(fileName));
			byte buffer[] = new byte[2];
			while((bis.read(buffer))!=-1){
				result.append(new String(buffer));
	        }
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
			result.setLength(0);
		}
		return result.toString();
    }

    public void writeTextFile(String fileName, String contents)  {
		try {
			bos = new BufferedOutputStream(new FileOutputStream(fileName));
			bos.write(contents.getBytes());
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void appendTextFile(String fileName, String contents)  {
    	this.writeTextFile(fileName, this.readTextFile(fileName)+contents);
    }
    
	//@Test
	public void testReadTextFile() {
		String result = this.readTextFile("file.txt");
        assertEquals(result, "test");
	}

	//@Test
	public void testWriteTextFile() {
		String origin = this.readTextFile("file.txt");
        this.writeTextFile("file.txt", "hello\r\nworld!!");
        String result = this.readTextFile("file.txt");
        assertEquals(result, "hello\r\nworld!!");
        this.writeTextFile("file.txt", origin);
	}
	
	//@Test
	public void testAppendTextFile() {
		String origin = this.readTextFile("file.txt");
        this.appendTextFile("file.txt", "hello\r\nworld!!");
        String result = this.readTextFile("file.txt");
        assertEquals(result, "testhello\r\nworld!!");
        this.writeTextFile("file.txt", origin);
	}
	
}
