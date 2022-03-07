package com.iup.tp.twitup.components.profileCompteComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponent;

public class ProfileCompteComponentView extends JPanel {

	protected ProfileCompteComponentView() {
		
		NavBarHautComponent hautComponenet = new NavBarHautComponent();
		
		JPanel haut=hautComponenet.getView();

		// haut.setPreferredSize(new Dimension(900, 200));
		
		
		
		haut.setBackground(Color.black.white);
		this.add(haut,BorderLayout.NORTH);
	}

	JPanel getView() {
		return this;
	}

}
