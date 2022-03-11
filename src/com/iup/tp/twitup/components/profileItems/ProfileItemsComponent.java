package com.iup.tp.twitup.components.profileItems;

import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.components.homePage.HomePageComponentControler;
import com.iup.tp.twitup.datamodel.User;

public class ProfileItemsComponent {
	
	ProfileItemsComponentControler controler;
	ProfileItemsComponentViews view;
	HomePageComponentControler fatherControler;
	public ProfileItemsComponent(List<User> users,HomePageComponentControler fatherControler)
	{
		this.fatherControler=fatherControler;
		controler= new ProfileItemsComponentControler(fatherControler);
		this.view=new ProfileItemsComponentViews(controler,users);
	}
	
	public JPanel getView ()
	{
		return view;
	}

}
