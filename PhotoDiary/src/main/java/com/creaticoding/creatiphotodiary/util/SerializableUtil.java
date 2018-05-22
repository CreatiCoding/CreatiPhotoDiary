package com.creaticoding.creatiphotodiary.util;

import java.io.*;
import org.springframework.stereotype.Component;

/**
 * 직렬화 유틸 
 * @author creaticoding
 *
 */
@Component
public class SerializableUtil {
	/**
	 * object를 fileName에 직렬화하여 저장 
	 * @param object
	 * @param fileName
	 */
	public void writeObject(Object object, String fileName) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(object);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("에러가 발생하였습니다.");
		}
	}
	/**
	 * fileName의 파일로부터 객체 직렬화하여 반환 
	 * @param object
	 * @param fileName
	 */
	public Object readObject(String fileName) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		Object object = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			object = in.readObject();
			in.close();
		} catch (Exception ex) {
			System.out.println("에러가 발생하였습니다.");
		}
		return object;
	}
}
