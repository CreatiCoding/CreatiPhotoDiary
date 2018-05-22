package com.creaticoding.creatiphotodiary;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 다이어리 일기 정보를 담아두는 객체 모델
 * MVC 패턴 중 Model에 해당
 * 데이터베이스가 아닌 직렬화를 통해 데이터를 저장하므로
 * Serializable 인터페이스를 구현한다.
 * @author creaticoding
 *
 */
public class DiaryModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idx;
	private String contents;
	private Timestamp createTime;
	private byte[] file;
	
	public DiaryModel() {}
	
	public DiaryModel(Integer idx, String contents, Timestamp createTime) {
		this.idx = idx;
		this.contents = contents;
		this.createTime = createTime;
		this.file = null;
	}
	
	public DiaryModel(Integer idx, String contents, Timestamp createTime, byte[] file) {
		this.idx = idx;
		this.contents = contents;
		this.createTime = createTime;
		this.file = file;
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
}
