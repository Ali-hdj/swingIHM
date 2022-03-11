package com.iup.tp.twitup.components.profileItem;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.session.SessionVariables;

public class ProfileItemComponentControler {

	List<ProfileComponentItemListener> listeners=new ArrayList<>();
	ProfileItemComponentControler()
	{
		
	}
	
	
	
	protected void addListener(ProfileComponentItemListener listener)
	{
		this.listeners.add(listener);
	}
	
	

	protected void followBtnClicked(User user)
	{
		SessionVariables.getSessionVariables().getConnectedUser().addFollowing(user.getUserTag());
		System.out.println("ok");
		
		
		for(ProfileComponentItemListener l :listeners ) {
			l.followBtnClicked(SessionVariables.getSessionVariables().getConnectedUser(),user);
			
		}
	}
	
	protected void unfollowBtnClicked(User user)
	{
		SessionVariables.getSessionVariables().getConnectedUser().addFollowing(user.getUserTag());
		System.out.println("ok");
		
		
		for(ProfileComponentItemListener l :listeners ) {
			l.unfollowBtnClicked(SessionVariables.getSessionVariables().getConnectedUser(),user);
			
		}
	}
	
}
