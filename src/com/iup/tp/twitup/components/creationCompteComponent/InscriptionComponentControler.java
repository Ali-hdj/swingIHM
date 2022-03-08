package com.iup.tp.twitup.components.creationCompteComponent;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class InscriptionComponentControler {

	IDatabase db;
	protected InscriptionComponentControler(IDatabase db)
	{
		this.db=db;
	}
	
	
	protected void addUser(User user)
	{
		this.db.addUser(user);
	}
}
