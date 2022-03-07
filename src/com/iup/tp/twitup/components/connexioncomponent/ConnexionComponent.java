package com.iup.tp.twitup.components.connexioncomponent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class ConnexionComponent {
	
	
	ConnexionComponentControler controler;
	
	
	ConnexionPageComponent connexionView;
	
	

	public ConnexionComponent(IDatabase db)
	{
		controler=new ConnexionPageControlerImpl(db,this);	
		this.connexionView=new ConnexionPageComponent(controler);
		
	}
	
	public void addListener(ConnexionCompListener l)
	{
		this.controler.addListener(l);
		
	}
	
	

	

	public JPanel getVue()
	{
		return this.connexionView;
	}
}
