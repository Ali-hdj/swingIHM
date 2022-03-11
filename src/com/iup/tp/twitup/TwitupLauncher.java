package com.iup.tp.twitup;

import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.ihm.TwitupMock;

/**
 * Classe de lancement de l'application.
 * 
 * @author S.Lucas
 */
public class TwitupLauncher {

	/**
	 * Launcher.
	 * 
	 * @param args
	 */
	
	static Twitup twitup;
	
	
	public static void main(String[] args) {
		twitup = new Twitup();
		twitup.show();
		
	}

}
