package com.iup.tp.twitup.components.homePage;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentListener;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.session.SessionVariables;

public class HomePageComponent implements IDatabaseObserver,NavBarHautComponentListener {

	HomePageComponentView view;
	HomePageComponentControler controler;
	IDatabase db;
	EntityManager mEntityManager;
	
	public HomePageComponent(List<Twit> listT,IDatabase db,EntityManager mEntityManager)
	{
		this.db=db;
		this.mEntityManager=mEntityManager;
		controler = new HomePageComponentControler(listT,db,mEntityManager);
		view = new HomePageComponentView(controler,listT);	
	}
	
	
	
	public void addHomePageComponentListener(HomePageComponentListener l)
	{
		this.controler.addListener(l);
	}
	public JPanel getView ()
	{
		return  view.getView();
	}


	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		
		User currentUser=SessionVariables.getSessionVariables().getConnectedUser();
		User userDeTwit=addedTwit.getTwiter();
		
		
	
		if((currentUser.getFollows()).contains(userDeTwit.getUserTag()))
		{
			senNotif(addedTwit);
			System.out.println("Notification !!! ");
		}
		this.controler.notifyTwitAdded(addedTwit);
		
	
		
	}


	public void senNotif(Twit t)
	{
		try{
		   
		    SystemTray tray = SystemTray.getSystemTray();

		   
		    Image image = Toolkit.getDefaultToolkit().createImage("/resources/images/notification.png");
		   

		    TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
		   
		    trayIcon.setImageAutoSize(true);
		   
		    trayIcon.setToolTip("System tray icon demo");
		   
		    tray.add(trayIcon);
		    
		    trayIcon.displayMessage(t.getTwiter().getName(), t.getText(), MessageType.INFO);
		   
		}catch(Exception ex){
		    System.err.print(ex);
		}
	}
	

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notifyUserAdded(User addedUser) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notifyUserDeleted(User deletedUser) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notifyUserModified(User modifiedUser) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void profileSearched(String userRequest) {
		
		List<User> users=new ArrayList<>();
		
		
		
	}


	@Override
	public void userProfileShow() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void envoieTwit(Twit t)
	{
		this.mEntityManager.sendTwit(t);
	}



	@Override
	public void twitsSearched(String userRequest) {
		// TODO Auto-generated method stub
		
	}
}
