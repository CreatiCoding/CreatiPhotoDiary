package com.creaticoding.springswing.tutorial;

import java.io.Serializable;

public class PostVO implements Serializable{
	private static final long serialVersionUID = 8269130938003839277L;
	private int id;
	private String contents;
	
	public PostVO(){
		
	}
	public PostVO(int id, String contents) {
		super();
		this.id = id;
		this.contents = contents;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
