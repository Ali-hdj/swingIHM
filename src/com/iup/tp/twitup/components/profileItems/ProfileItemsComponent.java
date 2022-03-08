package com.iup.tp.twitup.components.profileItems;

import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.User;

public class ProfileItemsComponent {
	
	ProfileItemsComponentControler controler;
	ProfileItemsComponentViews view;
	
	public ProfileItemsComponent(List<User> users)
	{
		controler= new ProfileItemsComponentControler();
		this.view=new ProfileItemsComponentViews(controler,users);
	}
	
	public JPanel getView ()
	{
		return view;
	}

}
