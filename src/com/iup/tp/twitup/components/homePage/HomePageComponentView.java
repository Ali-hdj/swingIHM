package com.iup.tp.twitup.components.homePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentView;
import com.iup.tp.twitup.components.tweetsView.TweetsViewComponent;
import com.iup.tp.twitup.datamodel.Twit;

public class HomePageComponentView extends  JPanel{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Twit> listT;

	protected HomePageComponentView(HomePageComponentControler controler,List<Twit> listT)
	{
				this.listT=listT;
			//	this.setLayout(new BorderLayout());
				JPanel main = new JPanel();
				this.setLayout(new BorderLayout());
				JPanel margeGauche=new JPanel();
				 margeGauche.setPreferredSize(new Dimension(150,300));
					
				 margeGauche.setBackground(Color.white);
		
				JPanel  margeDroite=new JPanel();
				 margeDroite.setPreferredSize(new Dimension(150,300));
						
				 margeDroite.setBackground(Color.white);
				main.setLayout(new BorderLayout());
				main.add((new NavBarHautComponentView().getView()),BorderLayout.NORTH);
				main.add((new TweetsViewComponent(listT).getView()),BorderLayout.CENTER);
				main.add( margeGauche,BorderLayout.WEST);
				main.add( margeDroite,BorderLayout.EAST);
				
			this.add(main);
			
		
	}
	
	
	protected JPanel getView()
	{
		return this;
	}
}
