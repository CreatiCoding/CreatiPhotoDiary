package com.creaticoding.springswing.tutorial;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;

import org.springframework.stereotype.Component;

@Component
public class PostBoard extends Frame{
	private TextFileUtil textFileUtil = TextFileUtil.getSingletonObject();
	private TextParseUtil textParseUtil = TextParseUtil.getSingletonObject();
	private Frame self = this;
	
	private static final long serialVersionUID = -181856681765423629L;
	private ArrayList<Panel> list;
	
	public PostBoard() {

		String arr[][]=textParseUtil.parseTextTypeTable(textFileUtil.readTextFile("post.txt"), "\t");
		// set about frame
		list = new ArrayList<Panel>();
		self.setLocationRelativeTo(null);
		self.setTitle("PostBoard");
		self.setSize(500, 500);
		self.setResizable(false);
		self.setLayout(new BoxLayout(self, BoxLayout.Y_AXIS));
		
		// add panel twice
		Panel mPanel1 = new Panel();
		ScrollPane mPanel2 = new ScrollPane();
		Panel mPanel3 = new Panel();
		mPanel3.setLayout(new BoxLayout(mPanel3, BoxLayout.Y_AXIS));
		//mPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        mPanel1.setSize(500, 200);
        mPanel2.setSize(500, 300);
        mPanel3.setSize(500, 300);
        
        mPanel2.add(mPanel3);
        self.add(mPanel1);
        self.add(mPanel2);
		
		// exit button event
        self.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
        TextArea input = new TextArea(4, 60);
		// set Button
		Button btn1 = new Button("post");
		
        mPanel1.add(input);
		mPanel1.add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textFileUtil.appendTextFile("post.txt", "\n"+(arr.length+list.size()-1)+"\t"+URLEncoder.encode(input.getText(), "utf-8")+"\t"+new Date().toString());
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Panel panel = new Panel(new FlowLayout());
				//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setLayout(new FlowLayout());
				TextArea text = new TextArea(input.getText(), 4, 60);
				input.setText("");
				text.setEditable(false);
				panel.add(text);
				//panel.setBackground(new Color(240,240,240));
				panel.setBackground(Color.lightGray);
				list.add(panel);
				mPanel3.removeAll();
				//mPanel2.setScrollPosition(0,0);
				int size = list.size();
				for(int i=size;i>0;i--) {
					mPanel3.add(list.get(i-1));
				}
				self.pack();
			}
		});
		
		for(int i=1;i<arr.length;i++) {
			Panel panel = new Panel(new FlowLayout());
			panel.setLayout(new FlowLayout());
			TextArea text;
			try {
				text = new TextArea(URLDecoder.decode(arr[i][1], "utf-8"), 4, 60);
				text.setEditable(false);
				panel.add(text);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panel.setBackground(Color.lightGray);
			list.add(panel);
			mPanel3.removeAll();
			int size = list.size();
			for(int j=size;j>0;j--) {
				mPanel3.add(list.get(j-1));
			}
		}
		
		
		
		// show
		self.pack();
		self.setMaximumSize(new Dimension(500,500));
		self.setVisible(true);
	}
}
