package com.iup.tp.twitup.components.connexioncomponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import com.iup.tp.twitup.components.utils.RoundBtn;

public class ConnexionPageComponent extends JPanel{
	
	ConnexionComponentControler controler;
	
	public ConnexionPageComponent(ConnexionComponentControler controler)
	{
		super();
		
		this.controler=controler;
		
		
		
		TextField login=new TextField();
		login.setFont(new Font("Serif", Font.BOLD, 48));
		JPasswordField password=new JPasswordField();
		
		//password.setBorder(new LineBorder(Color.RED, 10));
		password.setFont(new Font("Serif", Font.BOLD, 48));
		password.setBounds(548, 11, 66, 20);
		
		this.setPreferredSize(new Dimension(350, 200));
		this.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		JButton button=new JButton("Connexion");
		
		//button.setBounds(70,80,100,30);
	    //Round the button with radius = 15
		//button.setBorder(new LineBorder(Color.WHITE, 10));
		//button.setBorder(new RoundBtn(50));  
		JLabel wIcon=null;
		BufferedImage wPic;
		try {
			wPic = ImageIO.read(this.getClass().getResource("/resources/images/Image1.png"));
			wIcon = new JLabel(new ImageIcon(wPic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wIcon.addMouseListener(new MouseAdapter() {

			 @Override
			    public void mousePressed(MouseEvent e) {
				 
				
				 ConnexionPageComponent.this.controler.seConnecter(login.getText(),password.getText());
				 
			    }
			 
        });
		
		//button.setBackground(Color.white);
		button.setFont(new Font("Serif", Font.BOLD, 28));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
	
		GridLayout experimentLayout = new GridLayout(3,1,10,10);
		
		
		this.setLayout(experimentLayout);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(login, c);
		
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		this.add(password, c);
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		if(wIcon!=null)
			this.add(wIcon, c);
		
	}
	
	
	

}
