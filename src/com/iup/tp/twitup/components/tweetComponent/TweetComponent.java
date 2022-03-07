package com.iup.tp.twitup.components.tweetComponent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.Twit;

public class TweetComponent {

	JPanel view;
	
	TweetComponentControler controler;
	
	List<TweetComponentListener> listeners = new ArrayList<>();
	
	Twit tweet;
	
	public TweetComponent(Twit tweet)
	{
		this.view = new TweetComponentView(tweet);
		
		this.controler = new TweetComponentControler();
		
	}
	
	public void addListener(TweetComponentListener l)
	{
		this.listeners.add(l);
	}
	

	public JPanel getView()
	{
		return this.view;
	}
}
