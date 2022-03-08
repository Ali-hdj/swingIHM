package com.iup.tp.twitup.components.profileItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import com.iup.tp.twitup.components.profileItem.ProfileItemComponent;
import com.iup.tp.twitup.datamodel.User;

public class ProfileItemsComponentViews extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProfileItemsComponentControler controler;
	JScrollPane scrollPane;
	
	protected ProfileItemsComponentViews(ProfileItemsComponentControler controler,List<User> users)
	{
		this.controler=controler;
		


		this.setLayout(new BorderLayout());
		
		JPanel listTweetsView = new JPanel();
		if(users.size()>4) {
			
			listTweetsView.setLayout(new GridLayout(users.size(), 1,20,10));
		
		for(User u: users)
		{//
			listTweetsView.add((new ProfileItemComponent(u)).getView());
		
		}}
		else
		{
			listTweetsView.setLayout(new GridLayout(users.size()+4, 1,20,10));
			for(User u: users)
			{
				listTweetsView.add((new ProfileItemComponent(u)).getView());
				
			}
			
			
		
			
			
		}
		
		 scrollPane = new JScrollPane(listTweetsView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.red);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );
		scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );
		this.add(scrollPane,BorderLayout.CENTER);
		
		
		}
	
}

