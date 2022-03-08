package com.iup.tp.twitup.components.profileItem;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.User;

public class ProfileItemComponent {

	ProfileItemComponentControler controler;
	ProfileItemComponentView view; 
	
	
	
	public ProfileItemComponent(User user)
	{
		this.controler = new ProfileItemComponentControler();
		
		this.view = new ProfileItemComponentView(controler,user);
	}
	
	public void addListener(ProfileComponentItemListener listener)
	{
		this.controler.addListener(listener);
	}
	
	
	public JPanel getView()
	{
		return this.view;
	}
}
