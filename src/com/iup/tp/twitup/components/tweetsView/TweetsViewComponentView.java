package com.iup.tp.twitup.components.tweetsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import com.iup.tp.twitup.components.tweetComponent.TweetComponent;
import com.iup.tp.twitup.datamodel.Twit;

public class TweetsViewComponentView extends JPanel {

	/**
	 * 
	 */
	JScrollPane scrollPane;
	private static final long serialVersionUID = 1L;
	TweetsViewComponentControler controler;
	
	protected TweetsViewComponentView(TweetsViewComponentControler controler) {
		this.controler=controler;
		


	this.setLayout(new BorderLayout());
	
	JPanel listTweetsView = new JPanel();
	if(controler.getListtweets().size()>4) {
		
		listTweetsView.setLayout(new GridLayout(controler.getListtweets().size(), 1,20,10));
	
	for(Twit t: controler.getListtweets())
	{//
		listTweetsView.add((new TweetComponent(t)).getView());
	
	}}
	else
	{
		listTweetsView.setLayout(new GridLayout(controler.getListtweets().size()+4, 1,20,10));
		for(Twit t: controler.getListtweets())
		{
			listTweetsView.add((new TweetComponent(t)).getView());
			
		}
		
		
	
		
		
	}
	
	 scrollPane = new JScrollPane(listTweetsView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBackground(Color.red);
	
	scrollPane.getVerticalScrollBar().setUnitIncrement(20);
	
	scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );
	scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );
	this.add(scrollPane,BorderLayout.CENTER);
	
	
	}
	

}
