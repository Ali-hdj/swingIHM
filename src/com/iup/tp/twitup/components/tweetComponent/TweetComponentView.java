package com.iup.tp.twitup.components.tweetComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponentView;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.session.SessionVariables;

public class TweetComponentView  extends JPanel{
	
	JLabel profileImage=null;
	JLabel likeIcon=null;
	JLabel shareIcon=null;
	JLabel commentIcon=null;

	BufferedImage LikeTwitHover=null;
	BufferedImage LikeTwit=null;
	
	boolean liked = false;
	
	protected TweetComponentView  (Twit tweet)
	{
		
	
	this.setLayout(new GridBagLayout());
	
	JPanel profileAndTag = new JPanel(new FlowLayout(FlowLayout.LEFT,20,0));
	profileAndTag.setBackground(Color.white);
	JPanel tweetContent = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	tweetContent.setBackground(Color.white);
	JPanel translatetext = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	//translatetext.setBackground(Color.white);
	JPanel infoTweets = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	infoTweets.setBackground(Color.white);
	JPanel actionsTweet = new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
	actionsTweet.setBackground(Color.white);
	
	
	
	
	BufferedImage wPic;
	try {
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/"+tweet.getTwiter().getAvatarPath()));
		profileImage = new JLabel(new ImageIcon(wPic));
		LikeTwit = ImageIO.read(this.getClass().getResource("/resources/images/likeTweet.png"));
		likeIcon = new JLabel(new ImageIcon(LikeTwit));
		
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/shareTweet.png"));
		shareIcon = new JLabel(new ImageIcon(wPic));
		
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/commentIcon.png"));
		commentIcon = new JLabel(new ImageIcon(wPic));
		
		LikeTwitHover= ImageIO.read(this.getClass().getResource("/resources/images/likeTweet2.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	likeIcon.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
        
        	likeIcon.setIcon(new ImageIcon(LikeTwitHover));
        }

        
        @Override
        public void mouseExited(MouseEvent e) {
        	if(!liked)
        	likeIcon.setIcon(new ImageIcon(LikeTwit));
         }
        
        @Override
        public void mousePressed(MouseEvent e) {
        	likeIcon.setIcon(new ImageIcon(liked?LikeTwit:LikeTwitHover));
        	liked=!liked;
         }
        
    });
	
	
	
	
	JLabel tweetText = new JLabel(tweet.getText());
	JLabel tagText = new JLabel(tweet.getTwiter().getUserTag());
	JLabel translateTextLabel = new JLabel("Translate Tweet");
	JLabel dateText = new JLabel("11:29 PM . Oct 27,2020 . Twitter for Lenovo "+new Date(tweet.getEmissionDate()));
	JLabel infoTweet = new JLabel("2 Retweets   1 Quote Tweet   8 Likes ");
	tweetText.setFont(new Font("Serif", Font.BOLD, 30));
	dateText.setFont(new Font("Serif", Font.BOLD, 16));
	dateText.setForeground(Color.gray);
	
	tagText.setFont(new Font("Serif", Font.BOLD, 16));
	tagText.setForeground(Color.gray);
	
	
	translateTextLabel.setFont(new Font("Serif", Font.BOLD, 16));
	translateTextLabel.setForeground(Color.blue);
	this.setBackground(Color.white);
	
	profileAndTag.add(profileImage);
	profileAndTag.add(tagText);
	
	tweetContent.add(tweetText);
	
	
	infoTweets.add(infoTweet);
	
	actionsTweet.add(commentIcon);
	actionsTweet.add(shareIcon);
	actionsTweet.add(likeIcon);
	
	GridBagConstraints c= new GridBagConstraints();
	//this.add(profileAndTag);
	
	
	c.gridx=0;
	c.gridy=0;
	c.anchor=GridBagConstraints.WEST;
	this.add(profileAndTag,c);
	c.anchor=GridBagConstraints.WEST;
	c.gridx=0;
	c.gridy=1;
	this.add(tweetContent,c);
	c.anchor=GridBagConstraints.WEST;
	c.gridx=0;
	c.gridy=2;
	this.add(translateTextLabel,c);
	this.add(translatetext);
	c.anchor=GridBagConstraints.WEST;
	c.gridx=0;
	c.gridy=3;
	this.add(infoTweet,c);
	c.anchor=GridBagConstraints.WEST;
	c.gridx=0;
	c.gridy=4;
	this.add(actionsTweet,c);
	
	
	this.setBackground(Color.white);
	
	
	}
	
	JPanel getView() {
		return this;
	}

}
