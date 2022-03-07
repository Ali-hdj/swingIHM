package com.iup.tp.twitup.components.navBarHautComponent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class NavBarHautComponent {
	
	JPanel view;
	
	NavBarHautComponentControler controler;
	
	List<NavBarHautComponentListener> listeners = new ArrayList<>();
	
	public NavBarHautComponent()
	{
		this.view = new NavBarHautComponentView();
		
		this.controler = new NavBarHautComponentControler();
		
	}
	
	public void addListener(NavBarHautComponentListener l)
	{
		this.listeners.add(l);
	}
	

	public JPanel getView()
	{
		return this.view;
	}
}
