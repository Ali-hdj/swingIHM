package com.iup.tp.twitup.components.homePage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentListener;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class HomePageComponent implements IDatabaseObserver,NavBarHautComponentListener {

	HomePageComponentView view;
	HomePageComponentControler controler;
	IDatabase db;
	
	public HomePageComponent(List<Twit> listT,IDatabase db)
	{
		this.db=db;
		controler = new HomePageComponentControler(listT,db);
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
		this.controler.notifyTwitAdded(addedTwit);
	
		
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
}
