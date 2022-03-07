package com.iup.tp.twitup.ihm;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView implements IDatabaseObserver {
	
	
	public static IDatabase database;
	public static EntityManager entityManager;
	
	
	public TwitupMainView()
	{
		super();
	}
	public static void main(String [] args)
	{
		TwitupMainView v=new TwitupMainView();
		v.main2();
	}
	public void main2()
	{
		
		
		System.out.println("bouh ");
		
		database = new Database();
		entityManager=new EntityManager(database);
		
		TwitupMock mock= new TwitupMock(database,entityManager);
		JFrame frame;
		
		mock.initGUI();
		
		mock.showGUI();
		JFrame mFrame;
		
		// Création de la fenetre principale
				mFrame = new JFrame("MOCK");
				mFrame.setLayout(new GridBagLayout());

				//
				// Gestion de la base de données

				JLabel dbLabel = new JLabel("Database");

				Button addUserButton = new Button("Add User");
				addUserButton.setPreferredSize(new Dimension(100, 50));
				addUserButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				//database.addObserver(this);
				
		
		
	}
	
	





	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		System.out.println("tiwt "+addedTwit.getText());
		
	}



	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		System.out.println("tiwt "+deletedTwit.getText());
		
	}



	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		
		
	}



	@Override
	public void notifyUserAdded(User addedUser) {
		System.out.println("User "+addedUser.getName());
		
	}



	@Override
	public void notifyUserDeleted(User deletedUser) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void notifyUserModified(User modifiedUser) {
		// TODO Auto-generated method stub
		
	}
}
