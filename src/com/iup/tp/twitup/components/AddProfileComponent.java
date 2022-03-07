package com.iup.tp.twitup.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AddProfileComponent extends JPanel {
	
	public AddProfileComponent()
	{
		super();
		//this.setPreferredSize(new Dimension(500,500));
		TextField nom=new TextField();
		TextField prenom=new TextField();
		TextField age=new TextField();
		JButton creer=new JButton("Creer compte");
		this.setPreferredSize(new Dimension(700, 600));
		this.setSize(new Dimension(400, 400));
		//creer.setMargin(new Insets(50,50,50,50));
		Label nomLabel=new Label();
		nomLabel.setText("Nom");
		Label prenomLabel=new Label();
		prenomLabel.setText("Prénom");
		
		
		Label ageLabel=new Label();
		ageLabel.setText("Age");
		this.setBorder(BorderFactory.createEmptyBorder(100, 200,20,20));
		this.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		this.add(nomLabel);
		this.add(nom);
		this.add(prenomLabel);
		this.add(prenom);
		this.add(ageLabel);
		this.add(age);
		GridLayout experimentLayout = new GridLayout(0,1);
		
		GridBagConstraints c = new GridBagConstraints();
	
		experimentLayout.setVgap(10);
		this.add(creer);
		this.setLayout(experimentLayout);
		
	}
	

}
