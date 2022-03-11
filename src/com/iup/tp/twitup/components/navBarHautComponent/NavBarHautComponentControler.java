package com.iup.tp.twitup.components.navBarHautComponent;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.datamodel.User;

public class NavBarHautComponentControler {

	
	List<NavBarHautComponentListener> listeners= new ArrayList<>();
	
	
	protected void addListener(NavBarHautComponentListener l )
	{
		this.listeners.add(l);
	}
	
	
	protected void profileSearched(String userRequest)
	{
		
		for( NavBarHautComponentListener l :this.listeners)
		{
			l.profileSearched(userRequest);
		}
	}
	
	protected void twitsSearched(String userRequest)
	{
		
		for( NavBarHautComponentListener l :this.listeners)
		{
			l.twitsSearched(userRequest);
		}
	}
	

}
