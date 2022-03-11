package com.iup.tp.twitup.components.creationCompteComponent;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class InscriptionComponentControler {

	IDatabase db;
	EntityManager em;
	protected InscriptionComponentControler(IDatabase db,EntityManager em)
	{
		this.em=em;
		this.db=db;
	}
	
	
	protected boolean addUser(User user)
	{
		
		for (User u : this.db.getUsers())
		{
			if(u.getUserTag().equals(user.getUserTag()))
				return false;
		}
		this.em.sendUser(user);
		return true;
	}
}
