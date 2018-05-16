package com.creaticoding.creatiphotodiary.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.springframework.stereotype.Component;


@Component	// 웹의 경우 @Controller
public class FrameController extends WindowAdapter {

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println(111);
		e.getWindow().dispose();
	}
}
