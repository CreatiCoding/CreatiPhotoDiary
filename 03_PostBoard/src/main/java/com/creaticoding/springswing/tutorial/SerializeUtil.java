package com.creaticoding.springswing.tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {

	// 싱글톤 지원시 public으로 선언
	/* public TextFileUtil() {} */

	// 싱글톤 미지원시 코드로 싱글톤 구현
	private SerializeUtil() {
	}

	private static class SingletonHolder {
		public static final SerializeUtil INSTANCE = new SerializeUtil();
	}

	public static SerializeUtil getSingletonObject() {
		return SingletonHolder.INSTANCE;
	}

	public void input(String filename, Object o) {
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Object output(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			ois.close();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
