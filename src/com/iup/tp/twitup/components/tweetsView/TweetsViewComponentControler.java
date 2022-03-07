package com.iup.tp.twitup.components.tweetsView;

import java.util.List;

import com.iup.tp.twitup.datamodel.Twit;

public class TweetsViewComponentControler {

	
	List<Twit> listtweets;

	
	
	public TweetsViewComponentControler(List<Twit> listtweets) {
		super();
		this.listtweets = listtweets;
	}

	public List<Twit> getListtweets() {
		return listtweets;
	}

	public void setListtweets(List<Twit> listtweets) {
		this.listtweets = listtweets;
	}
}
