package com.iup.tp.twitup.components.homePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentView;
import com.iup.tp.twitup.components.tweetsView.TweetsViewComponent;
import com.iup.tp.twitup.datamodel.Twit;

public class HomePageComponentViewTest {


	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		List<Twit> list=new ArrayList<>();
		
		list.add(new Twit(null, "toto" ));
		list.add(new Twit(null, "toto  2" ));
	
		JFrame frame = new JFrame("Test componenet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900,900);
		frame.add((new HomePageComponent(list)).getView());
		
		
		
		frame.setVisible(true);
		
	}
}
