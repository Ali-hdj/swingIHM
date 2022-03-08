package com.iup.tp.twitup.components.homePage;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentListener;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class HomePageComponentControler implements IDatabaseObserver,NavBarHautComponentListener {

	List<Twit> listT;
	
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

	HomePageComponentControler(List<Twit> listT,IDatabase db)
	{
		this.listT=listT;
		this.db=db;
	}

	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		listT.add(addedTwit);
		
		for(TweetsListeners t : listViewListeners)
		{
			t.twitAdded();
		}
	}
	
	protected List<User> getUsersFromReq(String req)
	{
		List<User> listUsers =new ArrayList<>();
		this.db.getUsers().forEach(e-> {
			if(e.getName().contains(req))
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
}
