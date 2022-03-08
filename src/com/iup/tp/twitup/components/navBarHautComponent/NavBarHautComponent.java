package com.iup.tp.twitup.components.navBarHautComponent;

import javax.swing.JPanel;

public class NavBarHautComponent {
	
	JPanel view;
	
	NavBarHautComponentControler controler;
	
	
	
	public NavBarHautComponent()
	{
		
		
		this.controler = new NavBarHautComponentControler();
		this.view = new NavBarHautComponentView(controler);
		
	}
	
	public void addListener(NavBarHautComponentListener l)
	{
		this.controler.listeners.add(l);
	}
	

	public JPanel getView()
	{
		return this.view;
	}
}
