package com.iup.tp.twitup.components.tweetsView;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import com.iup.tp.twitup.datamodel.Twit;

public class TweetsViewComponent {

	List<Twit> listtweets;
	
	TweetsViewComponentControler controler;
	
	TweetsViewComponentView view ;
	
	public TweetsViewComponent()
	{
		listtweets=new ArrayList<>();
		 controler=new TweetsViewComponentControler(listtweets);
		 view = new TweetsViewComponentView(controler);
	}
	
	public TweetsViewComponent(List<Twit> listtweets)
	{
		this.listtweets=listtweets;
		 controler=new TweetsViewComponentControler(listtweets);
		 view = new TweetsViewComponentView(controler);
	}

	public List<Twit> getListtweets() {
		return listtweets;
	}

	public void setListtweets(List<Twit> listtweets) {
		this.listtweets = listtweets;
		this.controler.setListtweets(listtweets);
	}
	
	
	public JScrollPane getView ()
	{
		return view.scrollPane;
	}
	
}
