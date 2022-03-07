package com.iup.tp.twitup.components.creationCompteComponent;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class InscriptionComponentTest {

	
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		
		JFrame frame = new JFrame("Test componenet");
		
		frame.setSize(900,900);
		
		
		
		frame.getContentPane().add((new InscriptionComponentView().getView()));
		frame.setVisible(true);
		
	}
}
