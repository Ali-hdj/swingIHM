package com.iup.tp.twitup.components.homePage;

import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.Twit;

public class HomePageComponent {

	HomePageComponentView view;
	HomePageComponentControler controler;
	
	public HomePageComponent(List<Twit> listT)
	{
		controler = new HomePageComponentControler(listT);
		view = new HomePageComponentView(controler,listT);	
	}
	
	public JPanel getView ()
	{
		return  view.getView();
	}
}
