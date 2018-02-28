package com.creaticoding.springswing.tutorial;

public class TextParseUtil {

	// 싱글톤 지원시 public으로 선언
	/*public TextParseUtil() {	}*/
	
	// 싱글톤 미지원시 코드로 싱글톤 구현
	private TextParseUtil() {
	}

	private static class SingletonHolder {
		public static final TextParseUtil INSTANCE = new TextParseUtil();
	}

	public static TextParseUtil getSingletonObject() {
		return SingletonHolder.INSTANCE;
	}

	public String[][] parseTextTypeTable(String source, String separator) {
		String[] lines;
		String[][] result;
		if (source.indexOf("\r\n") != -1) {
			lines = source.split("\r\n");
		} else {
			lines = source.split("\n");
		}
		result = new String[lines.length][];
		for (int i = 0; i < lines.length; i++) {
			result[i] = lines[i].split(separator);
		}
		return result;
	}
}
