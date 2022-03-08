package com.iup.tp.twitup.components.profileItem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.User;

public class ProfileItemComponentView extends JPanel {
	
	/**
	 * 
	 */
	JLabel followBtn;
	private static final long serialVersionUID = 1L;

	ProfileItemComponentControler controler;
	
	
	
	ProfileItemComponentView(ProfileItemComponentControler controler,  User user){
	this.setLayout(new GridBagLayout());
	
	this.controler=controler;
	
	JPanel profileAndTag = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
	profileAndTag.setBackground(Color.white);
	

	JPanel nomtext = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	nomtext.add(new JLabel(user.getName()));
	
	
	
	JLabel profileImage=null;
	followBtn=null;
	BufferedImage wPic;
	try {
		if(user.getAvatarPath() == null||user.getAvatarPath().equals(""))
		{
			user.setAvatarPath("AliProfile.png");
		}
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/"+user.getAvatarPath()));
		profileImage = new JLabel(new ImageIcon(wPic));
		
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/followBtn.png"));
		followBtn = new JLabel(new ImageIcon(wPic));
		followBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	profileAndTag.remove(followBtn);
            	profileAndTag.add(new JLabel("Already Followed"));
            	repaint();
            	revalidate();
            }

        });;
	} catch (IOException e) {
		try {
			wPic = ImageIO.read(this.getClass().getResource("/resources/images/AliProfile.png"));
			profileImage = new JLabel(new ImageIcon(wPic));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	
	
	JLabel tagText = new JLabel(user.getUserTag());
	tagText.setFont(new Font("Serif", Font.BOLD, 16));
	tagText.setForeground(Color.gray);
	this.setBackground(Color.white);
	profileAndTag.add(profileImage);
	profileAndTag.add(nomtext);
	profileAndTag.add(tagText);
	profileAndTag.add(followBtn);
	GridBagConstraints c= new GridBagConstraints();
	//this.add(profileAndTag);
	c.gridx=0;
	c.gridy=0;
	c.anchor=GridBagConstraints.WEST;
	this.add(profileAndTag,c);
	this.setBackground(Color.white);
	
	}
	
	JPanel getView() {
		return this;
	}


}
