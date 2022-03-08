package com.iup.tp.twitup.session;

import com.iup.tp.twitup.datamodel.User;

public class SessionVariables {

	private static SessionVariables  sessionVariable;
	
	private SessionVariables()
	{
		
	}
	
	private User connectedUser;
	
	


	public User getConnectedUser() {
		return connectedUser;
	}


	public void setConnecctedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}


	public static SessionVariables getSessionVariables()
	{
		if(sessionVariable==null)
		{
			sessionVariable=new SessionVariables();
			
			return sessionVariable;
		}
		return new SessionVariables();
	}
}
