package com.iup.tp.twitup.components.tweetComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.Twit;

public class TweetComponentView  extends JPanel{
	
	

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
	
	JLabel profileImage=null;
	JLabel likeIcon=null;
	JLabel shareIcon=null;
	JLabel commentIcon=null;
	
	BufferedImage wPic;
	try {
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/AliProfile.png"));
		profileImage = new JLabel(new ImageIcon(wPic));
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/likeTweet.png"));
		likeIcon = new JLabel(new ImageIcon(wPic));
		
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/shareTweet.png"));
		shareIcon = new JLabel(new ImageIcon(wPic));
		
		wPic = ImageIO.read(this.getClass().getResource("/resources/images/commentIcon.png"));
		commentIcon = new JLabel(new ImageIcon(wPic));
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	Label tweetText = new Label(tweet.getText());
	Label tagText = new Label("@Ali");
	Label translateTextLabel = new Label("Translate Tweet");
	Label dateText = new Label("11:29 PM . Oct 27,2020 . Twitter for Lenovo ");
	Label infoTweet = new Label("2 Retweets   1 Quote Tweet   8 Likes ");
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
	//this.add(translatetext);
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
