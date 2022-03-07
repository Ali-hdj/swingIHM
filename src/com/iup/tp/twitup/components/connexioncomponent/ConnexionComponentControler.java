package com.iup.tp.twitup.components.connexioncomponent;

public interface ConnexionComponentControler {

	public void seConnecter(String login,String password);
	void addListener(ConnexionCompListener l);
}
