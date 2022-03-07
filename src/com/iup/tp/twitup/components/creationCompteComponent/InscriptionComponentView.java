package com.iup.tp.twitup.components.creationCompteComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class InscriptionComponentView extends JPanel {
	
	
	public InscriptionComponentView()
	{
		super();
		this.setPreferredSize(new Dimension(600,600));
		
		JPanel form = new JPanel();
		form.setPreferredSize(new Dimension(500,500));
		form.setLayout(new GridLayout(10,1,0,10));
		Label nomLabel= new Label("Nom :");
		nomLabel.setFont(new Font("Serif", Font.BOLD, 24));
		TextField nom = new TextField();
		nom.setFont(new Font("Serif", Font.BOLD, 30));
		Label tagLabel= new Label("Tag :");
		tagLabel.setFont(new Font("Serif", Font.BOLD, 24));
		TextField tag = new TextField();
		tag.setFont(new Font("Serif", Font.BOLD, 30));
		Label avatarLabel= new Label("Avatar :");
		avatarLabel.setFont(new Font("Serif", Font.BOLD, 24));
		//TextField avatar = new TextField();
		
		
		String s1[] = { "Java", "PHP", "Python", "C++", "Ruby" }; 
		  
        // créer une case à cocher
		JComboBox avatar = new JComboBox(s1); 
        
		Label mdpLabel= new Label("Mot de passe:");
		avatarLabel.setFont(new Font("Serif", Font.BOLD, 24));
		JPasswordField mdp = new JPasswordField();
		mdp.setFont(new Font("Serif", Font.BOLD, 36));
		mdpLabel.setFont(new Font("Serif", Font.BOLD, 24));
		
		avatar.setFont(new Font("Serif", Font.BOLD, 30));
		JButton inscriptionBtn= new JButton("S'inscrire");
		inscriptionBtn.setFont(new Font("Serif", Font.BOLD, 30));
		
		Label messageLabel= new Label("");
		messageLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		inscriptionBtn.addActionListener(e->{
				
			if(nom.getText()==null || nom.getText().equals(""))
			{
				messageLabel.setForeground(Color.white);
				nom.setBackground(Color.red);
				messageLabel.setBackground(Color.red);
				messageLabel.setText(" le champ Nom est obligatoire ! ");
				return ;
			}
			
			
			if(tag.getText()==null || tag.getText().equals(""))
			{
				messageLabel.setForeground(Color.white);
				messageLabel.setText(" le champ Tag est obligatoire ! ");
				messageLabel.setBackground(Color.red);
				tag.setBackground(Color.red);
				return ;
			}
			
			messageLabel.setBackground(Color.DARK_GRAY);
			messageLabel.setText(" Inscription Reussi ! :)  ");
			messageLabel.setForeground(Color.green);
			System.out.println("choisi "+(String) avatar.getSelectedItem());
		});
		
		inscriptionBtn.setBackground(Color.green);
		form.add(nomLabel);
		form.add(nom);
		form.add(tagLabel);
		form.add(tag);
		form.add(mdpLabel);
		form.add(mdp);
		form.add(avatarLabel);
		form.add(avatar);
		form.add(inscriptionBtn);
		form.add(messageLabel);
		this.add(form);
	}
	
	
	JPanel getView()
	{
		return this;
	}

}
