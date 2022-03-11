package com.iup.tp.twitup.components.creationCompteComponent;

import javax.swing.JPanel;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;

public class InscriptionComponent {

	
	InscriptionComponentControler controler;
	
	InscriptionComponentView view ;
	
	public InscriptionComponent(IDatabase db,EntityManager em)
	{
		controler= new InscriptionComponentControler(db,em);
		view = new InscriptionComponentView(controler);
		
		
	}
	
	public JPanel getView()
	{
		return view;
	}
	
	
	
	
}
