package com.creaticoding.creatiphotodiary.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputScrollPane extends JScrollPane {

	private JPanel innerPanel;
	@Autowired
	private OutputPanel outputPanel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9001575190506070540L;

	public OutputScrollPane() {

		this.innerPanel = new JPanel();
		this.innerPanel.setBackground(new Color(255, 0, 255));
		this.innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

		// 스크롤 양 설정
		this.getVerticalScrollBar().setUnitIncrement(8);
		// 스크롤 패널 설정
		this.setBounds(0, 0, 500, 400);
		this.setViewportView(this.innerPanel);
/*		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);
		add(this.innerPanel);*/
	}

	
	public void add(JPanel j) {
		// 화면에 새롭게 컴포넌트은 생성 및 초기화
		/*JScrollBar vertical = this.getVerticalScrollBar();
		JPanel resultPanel = new JPanel();
		Canvas photoCanvas = new Canvas() {
			public void paint(Graphics g) {  
		        Toolkit t=Toolkit.getDefaultToolkit();  
		        Image i=t.getImage("p3.gif");  
		        g.drawImage(i, 120,100,this);  
		          
		    }  
		};
		
		
		// 레이아웃 설정
		todo.setLayout(new BoxLayout(todo, BoxLayout.X_AXIS));
		// 출력 부분 색 및 크기 설정
		result.setBackground(new Color(255, 255, 255));
		result.setMinimumSize(new Dimension(380, 50));
		result.setMaximumSize(new Dimension(380, 50));
		result.setPreferredSize(new Dimension(380, 50));
		// 한글 글꼴 지원으로 설정
		result.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		// 출력부분 문자열 등록 등등
		result.setBorder(BorderFactory.createLineBorder(Color.black));
		result.setEditable(false);
		result.setText("test1");
		// 삭제 버튼 등록
		delBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		delBtn.setMaximumSize(new Dimension(50, 50));
		// 오른쪽 여백 생성해주는 빈 컴포넌트
		JPanel rightEmpty = new JPanel();
		rightEmpty.setBackground(new Color(255, 255, 255));
		rightEmpty.setMaximumSize(new Dimension(15, 50));
		// 생성될 컴포넌트에 추가
		todo.add(result);
		todo.add(delBtn);
		todo.add(rightEmpty);
		// 생성될 컴포넌트 크기 설정
		todo.setPreferredSize(new Dimension(450, 50));
		// 추가 후 다시 그리기, 스크롤 위치 재 설정
		j.add(todo);*/
	}
}
