package com.iup.tp.twitup.components.profileItem;

import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.iup.tp.twitup.datamodel.User;

public class ProfileComponentItemTest {

	
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		JFrame frame = new JFrame("Test componenet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900,900);
		
		frame.getContentPane().add((new ProfileItemComponentView(null,new User(UUID.randomUUID(),"@ali","test","Ali HADJ-SAID",null,"AliProfile.png")).getView()));
		frame.setVisible(true);
		
	}
	
}
