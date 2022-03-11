package com.iup.tp.twitup.components.connexioncomponent;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.IDatabase;

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
