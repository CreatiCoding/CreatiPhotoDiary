package com.creaticoding.springswing.tutorial;

import java.io.Serializable;
import java.util.ArrayList;

public class PostListVO implements Serializable{
	private static final long serialVersionUID = -7544486187036419207L;
	private ArrayList <PostVO> list = new ArrayList<PostVO>();
	public ArrayList <PostVO> getList() {
		return list;
	}
	public void setList(ArrayList <PostVO> list) {
		this.list = list;
	}
	
}
