package com.iup.tp.twitup.components.tweetComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.iup.tp.twitup.datamodel.Twit;

public class TweetComponentViewTest {

	
	
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		JFrame frame = new JFrame("Test componenet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,500);
		frame.getContentPane().setBackground(Color.red);
		frame.pack(); 
		//In a container that uses a BorderLayout:
		
		JTextArea textArea = new JTextArea(5, 30);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1,10,10));
		panel.add(new TweetComponentView(new Twit(null, "Test tweeeeet !! @ali #un tweet ")).getView());
		panel.add(new TweetComponentView(new Twit(null, "Test tweeeeet !! @ali #un tweet ")).getView());
		panel.add(new TweetComponentView(new Twit(null, "Test tweeeeet !! @ali #un tweet ")).getView());
		panel.add(new TweetComponentView(new Twit(null, "Test tweeeeet !! @ali #un tweet ")).getView());
		JScrollPane scrollPane = new JScrollPane(panel);
		
		frame.getContentPane().setPreferredSize(new Dimension(450, 110));
		
		//frame.getContentPane().setLayout(new GridLayout(1,3));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		//scrollPane.add(new TweetComponentView().getView());
		scrollPane.repaint();
		scrollPane.setLayout(new ScrollPaneLayout());
		//frame.getContentPane().add((new TweetComponentView().getView()));
		frame.setVisible(true);
		
	}
	
	
}
