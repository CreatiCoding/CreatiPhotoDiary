package com.creaticoding.springswing.tutorial;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.springframework.boot.*;
import org.springframework.boot.builder.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
public class Application extends JFrame {

    public Application() {

        initUI();
    }
	 private void initUI() {

	        JButton quitButton = new JButton("Quit");

	        quitButton.addActionListener(new ActionListener()
	        {
	        	  public void actionPerformed(ActionEvent e)
	        	  {
	  	            System.exit(0);
	        	  }
	        });

	        createLayout(quitButton);

	        setTitle("Quit button");
	        setSize(300, 200);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }

	    private void createLayout(JComponent... arg) {

	        Container pane = getContentPane();
	        GroupLayout gl = new GroupLayout(pane);
	        pane.setLayout(gl);

	        gl.setAutoCreateContainerGaps(true);

	        gl.setHorizontalGroup(gl.createSequentialGroup()
	                .addComponent(arg[0])
	        );

	        gl.setVerticalGroup(gl.createSequentialGroup()
	                .addComponent(arg[0])
	        );
	    }

	    public static void main(String[] args) {

	        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
	                .headless(false).run(args);

	        EventQueue.invokeLater(() -> {
	            Application ex = ctx.getBean(Application.class);
	            ex.setVisible(true);
	        });
	    }
}
