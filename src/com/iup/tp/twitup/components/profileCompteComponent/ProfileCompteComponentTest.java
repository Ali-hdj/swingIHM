package com.iup.tp.twitup.components.profileCompteComponent;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.iup.tp.twitup.components.creationCompteComponent.InscriptionComponentView;

public class ProfileCompteComponentTest {

	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		JFrame frame = new JFrame("Test componenet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900,900);
		
		frame.getContentPane().add((new ProfileCompteComponentView().getView()));
		frame.setVisible(true);
		
	}
	
}
