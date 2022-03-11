package com.iup.tp.twitup.components.homePage;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentListener;
import com.iup.tp.twitup.components.profileItem.ProfileComponentItemListener;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.session.SessionVariables;

public class HomePageComponentControler implements IDatabaseObserver,NavBarHautComponentListener,ProfileComponentItemListener {

	List<Twit> listT;
	EntityManager em;
	List<TweetsListeners> listViewListeners =new ArrayList<>();;
	
	List<SearchListener> searchListeners= new ArrayList<>();
	
	List<HomePageComponentListener> homePagelisteners= new ArrayList<>();
	
	protected void addListenerSearch(SearchListener l)
	{
		this.searchListeners.add(l);
	}
	
	protected void  addListener(HomePageComponentListener lst)
	{
		this.homePagelisteners.add(lst);
	}
	
	protected void seDeconecter()
	{
		for(HomePageComponentListener hpl : homePagelisteners)
		{
			hpl.seDeconnecter();
		}
	}
	IDatabase db;
	protected void addListenerTwit(TweetsListeners l )
	{
		listViewListeners.add(l);
	}
	
	public List<Twit> getListT() {
		return listT;
	}

	public void setListT(List<Twit> listT) {
		this.listT = listT;
	}

	HomePageComponentControler(List<Twit> listT,IDatabase db,EntityManager em)
	{
		this.listT=listT;
		this.em=em;
		this.db=db;
	}

	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		listT.add(addedTwit);
		
		for(TweetsListeners t : listViewListeners)
		{
			t.twitAdded(addedTwit);
		}
	}
	
	protected List<User> getUsersFromReq(String req)
	{
		if(req.equals("*"))
		{
			return new ArrayList<>(this.db.getUsers());
			
		}
		List<User> listUsers =new ArrayList<>();
		this.db.getUsers().forEach(e-> {
			if(e.getName().contains(req))
			{
				listUsers.add(e);
			}
		});
		return listUsers ;
	}
	
	
	protected List<Twit> getTwitsFromReq(String req)
	{
		
		List<Twit> listUsers =new ArrayList<>();
		if(req.contains("@")) {
		this.db.getTwits().forEach(e-> {
			User usr=SessionVariables.getSessionVariables().getConnectedUser();
			if(e.getTwiter().getUserTag().equals(usr.getUserTag())||e.getText().contains(usr.getUserTag()))
			{
				listUsers.add(e);
			}
		});
		return listUsers ;
		}
		
		if(req.contains("#")) {
			this.db.getTwits().forEach(e-> {
				User usr=SessionVariables.getSessionVariables().getConnectedUser();
				if(e.getText().contains(req))
				{
					listUsers.add(e);
				}
			});
			return listUsers ;
			}
		
		
	
		this.db.getTwits().forEach(e-> {
			User usr=SessionVariables.getSessionVariables().getConnectedUser();
			if(e.getTwiter().getUserTag().equals(usr.getUserTag())||e.getText().contains(usr.getUserTag())||e.getTwiter().getUserTag().equals(usr.getUserTag())||e.getText().contains(usr.getUserTag()))
			{
				listUsers.add(e);
			}
		});
		return listUsers ;
		
		
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		listT.add(deletedTwit);
		
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
		for(SearchListener l : this.searchListeners)
		{
			l.profileSearched(userRequest);
		}
		
	}

	@Override
	public void userProfileShow() {
		// TODO Auto-generated method stub
		
	}
	
	public void envoieTwit(Twit t)
	{
		this.em.sendTwit(t);
	}

	@Override
	public void followBtnClicked(User user, User Follower) {
		user.addFollowing(Follower.getUserTag());
		this.db.modifiyUser(SessionVariables.getSessionVariables().getConnectedUser());
		
		System.out.println("ok follow ");
	}

	@Override
	public void unfollowBtnClicked(User user, User Follower) {
		user.removeFollowing((Follower.getUserTag()));
		this.db.modifiyUser(user);
		
		System.out.println("ok unfollow ");
		
	}

	@Override
	public void twitsSearched(String userRequest) {
		for(SearchListener l : this.searchListeners)
		{
			l.twitsSearched(userRequest);
		}
		
	}
}
