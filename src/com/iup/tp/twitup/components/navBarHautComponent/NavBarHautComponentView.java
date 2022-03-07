package com.iup.tp.twitup.components.navBarHautComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NavBarHautComponentView extends JPanel {

	
	
	public NavBarHautComponentView ()
	{
		super();
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		JLabel twitterIcon=null;
		JLabel profileIcon=null;
		JLabel searchIcon=null;
		JTextField searchText =new JTextField(25);
		searchText.setFont(new Font("Serif", Font.BOLD, 30));
		this.setBackground(Color.white);
		BufferedImage wPic;
		try {
			wPic = ImageIO.read(this.getClass().getResource("/resources/images/twitter.png"));
			twitterIcon = new JLabel(new ImageIcon(wPic));
			wPic = ImageIO.read(this.getClass().getResource("/resources/images/profile.png"));
			profileIcon = new JLabel(new ImageIcon(wPic));
			
			wPic = ImageIO.read(this.getClass().getResource("/resources/images/serach.png"));
			searchIcon = new JLabel(new ImageIcon(wPic));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(twitterIcon);
		this.add(new Label());
		
		this.add(searchText);
		this.add(searchIcon);
		this.add(profileIcon);
		
		
			
	}
	
	public JPanel getView()
	{
		return this;
	}
	
}
