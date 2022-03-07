package com.iup.tp.twitup.components.connexioncomponent;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class ConnexionPageControlerImpl implements ConnexionComponentControler {
	
	IDatabase db;
	User user;
	boolean connected=false;
	ConnexionComponent manager;
	
	List<ConnexionCompListener> listListrers = new ArrayList<>();
	
	public void addListener(ConnexionCompListener l)
	{
		this.listListrers.add(l);
		
	}
	
	
	
	public void notifierConnexion(User user)
	{
		for(ConnexionCompListener l : listListrers)
		{
			l.userConnected(user);
		}
	}
	
	public ConnexionPageControlerImpl(IDatabase db,ConnexionComponent manager)
	{
		this.db=db;
		this.manager=manager;
	}
	
	
	
	@Override
	public void seConnecter(String login, String password) {
		
		db.getUsers().forEach(e->{
			if(e.getName().equals(login)&&e.getUserPassword().equals(password))
			{
				System.out.println("utilisateur connecté");
				user=e;
				connected=true;
				this.notifierConnexion(e);
			}
		});
		
		
	
	}

	
}
