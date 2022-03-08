package com.iup.tp.twitup.components.navBarHautComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NavBarHautComponentView extends JPanel {

	NavBarHautComponentControler controler;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField searchText ;
	
	public NavBarHautComponentView (NavBarHautComponentControler controler)
	{
		super();
		this.controler=controler;
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		JLabel twitterIcon=null;
		JLabel profileIcon=null;
		JLabel searchIcon=null;
		JLabel notificationIcon=null;
		 searchText =new JTextField(25);
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
			

			wPic = ImageIO.read(this.getClass().getResource("/resources/images/notification.png"));
			notificationIcon = new JLabel(new ImageIcon(wPic));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		searchIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	NavBarHautComponentView.this.controler.profileSearched(searchText.getText());
            }

        });;
		this.add(twitterIcon);
		this.add(new JLabel());
		
		this.add(searchText);
		this.add(searchIcon);
		this.add(profileIcon);
		this.add(notificationIcon);
		
		
			
	}
	
	public JPanel getView()
	{
		return this;
	}
	
}
