package com.iup.tp.twitup.components.tweetsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
	JPanel panelGauche=new JPanel();
	panelGauche.setPreferredSize(new Dimension(200,100));
	this.add(panelGauche,BorderLayout.WEST);
	
	
	JPanel listTweetsView = new JPanel();
	if(controler.getListtweets().size()>4) {
		listTweetsView.setLayout(new GridLayout(controler.getListtweets().size(), 1,20,10));
	
	for(Twit t: controler.getListtweets())
	{
		listTweetsView.add((new TweetComponent(t)).getView());
		
	}}
	else
	{
		listTweetsView.setLayout(new GridLayout(controler.getListtweets().size()+2, 1,10,10));
		for(Twit t: controler.getListtweets())
		{
			listTweetsView.add((new TweetComponent(t)).getView());
			
		}
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,200));
		
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(200,200));
		
		//listTweetsView.add(panel);
	//	listTweetsView.add(panel2);
		
		
	}
	
	 scrollPane = new JScrollPane(listTweetsView);
	scrollPane.setBackground(Color.red);
	this.add(scrollPane,BorderLayout.CENTER);
	
	
	}
	
	
	protected JScrollPane getView ()
	{
		return  scrollPane;
	}
}
