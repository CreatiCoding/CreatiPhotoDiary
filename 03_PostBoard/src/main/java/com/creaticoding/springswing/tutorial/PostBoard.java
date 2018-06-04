package com.creaticoding.springswing.tutorial;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.stereotype.Component;

@Component
public class PostBoard extends JFrame {
	private SerializeUtil serializeUtil = SerializeUtil.getSingletonObject();
	private JFrame self = this;

	private static final long serialVersionUID = -181856681765423629L;
	private ArrayList<JPanel> list;
	private PostListVO data;

	public PostBoard() {
		// set about frame
		list = new ArrayList<JPanel>();
		self.setLocationRelativeTo(null);
		self.setTitle("PostBoard");
		self.setSize(500, 500);
		self.setResizable(true);
		GridBagConstraints[] gbc = new GridBagConstraints[2];
		gbc[0] = new GridBagConstraints(0,0,1,1,0,0,10,0, new Insets(0, 0, 0, 0),0,0);
		gbc[1] = new GridBagConstraints(0,1,1,3,0,0,10,0, new Insets(0, 0, 0, 0),0,0);
		
		self.setLayout(new GridBagLayout());
		data = (PostListVO)serializeUtil.output("data.dat");
		// add panel twice
		JPanel mPanel1 = new JPanel();
		JScrollPane mPanel2 = new JScrollPane();
		//JPanel mPanel3 = new JPanel();
		//mPanel3.setLayout(new BoxLayout(mPanel3, BoxLayout.Y_AXIS));
		// mPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		mPanel1.setSize(500, 200);
		//mPanel3.setSize(500, 300);
		mPanel2.setPreferredSize(new Dimension(1000, 900));
		//mPanel2.add(mPanel3);
		self.add(mPanel1, gbc[0]);
		self.add(mPanel2, gbc[1]);

		// exit button event
		self.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				serializeUtil.input("data.dat", data);
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

				JPanel panel = new JPanel(new FlowLayout());
				// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setLayout(new FlowLayout());
				TextArea text = new TextArea(input.getText(), 4, 60);
				data.getList().add(new PostVO(data.getList().size(), input.getText()));
				input.setText("");
				text.setEditable(false);
				panel.add(text);
				// panel.setBackground(new Color(240,240,240));
				panel.setBackground(Color.lightGray);
				list.add(panel);
				mPanel2.removeAll();
				// mPanel2.setScrollPosition(0,0);
				int size = list.size();
				for (int i = size; i > 0; i--) {
					mPanel2.add(list.get(i - 1));
				}
				self.pack();
			}
		});
		
		ArrayList <PostVO> postlist = data.getList();
		for (int i = 1; i < postlist.size(); i++) {
			JPanel panel = new JPanel(new FlowLayout());
			panel.setLayout(new FlowLayout());
			TextArea text;
			text = new TextArea(postlist.get(i).getContents(), 4, 60);
			text.setEditable(false);
			panel.add(text);
			panel.setBackground(Color.lightGray);
			list.add(panel);
			mPanel2.removeAll();
			int size = list.size();
			for (int j = size; j > 0; j--) {
				mPanel2.add(list.get(j - 1));
			}
		}

		// show
		self.pack();
		self.setMaximumSize(new Dimension(500, 500));
		self.setVisible(true);
	}
}
