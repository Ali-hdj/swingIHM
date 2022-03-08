package com.iup.tp.twitup.components.profileItems;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.iup.tp.twitup.components.tweetsView.TweetsViewComponent;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class ProfileItemsComponentTest {

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		JFrame frame = new JFrame("Test componenet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,500);
		//frame.getContentPane().setBackground(Color.red);
		//In a container that uses a BorderLayout:
	
		//frame.pack();
		List<User> users = new ArrayList<>();
		
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		users.add(new User(UUID.randomUUID(),"@ALi","test","Ali",null,"AliProfile.png"));
		//twits.add(new Twit(null,"test tewwttttttttttt ! 2"));
		//twits.add(new Twit(null,"test tewwttttttttttt ! 3"));
		
	JPanel pp=new JPanel();
pp.setPreferredSize(new Dimension(100,300));
		frame.getContentPane().add(pp, BorderLayout.WEST);
		
		frame.getContentPane().add(new ProfileItemsComponentViews(null, users), BorderLayout.CENTER);
		frame.getContentPane().setPreferredSize(new Dimension(450, 110));
		//frame.getContentPane().add((new TweetComponentView().getView()));
		frame.setVisible(true);
		
	}
}
