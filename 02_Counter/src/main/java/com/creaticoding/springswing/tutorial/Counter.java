package com.creaticoding.springswing.tutorial;

import java.awt.*;
import java.awt.event.*;
import org.springframework.stereotype.Component;

@Component
public class Counter extends Frame{
	private static final long serialVersionUID = -181856681765423629L;
	private int count = 0;
	public Counter() {
		// set about frame
		this.setLocationRelativeTo(null);
		this.setTitle("Counter");
		this.setSize(500, 200);
		
		// add panel twice
		this.setLayout(new GridLayout(2, 1));
		Panel mPanel1 = new Panel();
		Panel mPanel2 = new Panel();
		this.add(mPanel1);
		this.add(mPanel2);
		
		// exit button event
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		// set Label
		Label label1 = new Label("  Click the button to start count  ", Label.CENTER);
		label1.setFont(new Font("Consolas", Font.BOLD, 20));

		// set Button
		Button btn1 = new Button("click");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				label1.setText("button is clicked " + count +" times.");
			}
		});

		// add components
		mPanel1.add(label1);
		mPanel2.add(btn1);
		
		// show
		this.setVisible(true);
	}
}
