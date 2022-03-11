package com.iup.tp.twitup.components.homePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.iup.tp.twitup.components.navBarHautComponent.NavBarHautComponent;
import com.iup.tp.twitup.components.profileItems.ProfileItemsComponent;
import com.iup.tp.twitup.components.sendTwit.SendTwitComponent;
import com.iup.tp.twitup.components.tweetsView.TweetsViewComponent;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class HomePageComponentView extends  JPanel implements TweetsListeners,SearchListener{

	
	
	/**
	 * 
	 */
	
	HomePageComponentControler controler;
	
	private static final long serialVersionUID = 1L;
	List<Twit> listT;
	JPanel main ;
	 TweetsViewComponent tweetViewComp;
	 NavBarHautComponent navbarCom;
	 SendTwitComponent sentTwit;
	 
	 JPanel margeGauche;
	 JPanel  margeDroite;
			 
			 
	protected HomePageComponentView(HomePageComponentControler controler,List<Twit> listT)
	{
		
			
		 createHomepage(controler,listT);
		
	}
	
	
	private void createHomepage(HomePageComponentControler controler,List<Twit> listT)
	{
		this.setLayout(new BorderLayout());
		this.listT=listT;
		this.controler=controler;
		this.controler.addListenerSearch(this);
		this.controler.addListenerTwit(this);
		this.setLayout(new BorderLayout());
		 main = new JPanel();
		sentTwit =new SendTwitComponent(controler);
			this.setLayout(new BorderLayout());
		 margeGauche=new JPanel();
		
		 navbarCom=  new NavBarHautComponent();
		 navbarCom.addListener(this.controler);
		 margeGauche.setBackground(Color.white);
		 margeGauche.setLayout(new GridLayout(4,1));
		 
		 

			JLabel twiterImage=null;
			
			
			BufferedImage wPic=null;
			
				try {
					wPic = ImageIO.read(this.getClass().getResource("/resources/images/twiter.png"));
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				 twiterImage = new JLabel(new ImageIcon(wPic));
				 margeGauche.add(twiterImage);
				 twiterImage.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		           
		            	HomePageComponentView.this.removeAll();
		            	HomePageComponentView.this.add(sentTwit.getView());
		            	HomePageComponentView.this.revalidate();
		            	HomePageComponentView.this.repaint();
		            
		            	
		            
		            }

		        });
				JButton seDecconecter = new JButton("Se Deconnecter");
				seDecconecter.setFont(new Font("Serif", Font.BOLD, 20));
				seDecconecter.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	controler.seDeconecter();
		            }

		        });;
						
						
						
					
				
				
				margeGauche.add(seDecconecter);
				
		margeDroite=new JPanel();
		 margeDroite.add(new JPanel());
		 
		 margeDroite.setBackground(Color.white);
		 
		 margeDroite.add(new JLabel("             "));
		// margeDroite.setPreferredSize(new Dimension(150,300));
		 tweetViewComp=  new TweetsViewComponent(listT);
		
		 
		 margeDroite.setBackground(Color.white);
		main.setLayout(new BorderLayout());
		main.add((navbarCom.getView()),BorderLayout.NORTH);
		main.add(tweetViewComp.getView(),BorderLayout.CENTER);
		main.add( margeGauche,BorderLayout.WEST);
		main.add( margeDroite,BorderLayout.EAST);
		
	this.add(main);
	
	
	}
	
	protected JPanel getView()
	{
		return this;
	}


	@Override
	public void twitAdded(Twit addedTwit) {
		this.listT=controler.getListT();
		
		this.removeAll();
		main.removeAll();
		
		
		tweetViewComp=  new TweetsViewComponent(listT);
		margeDroite.setBackground(Color.white);
		main.setLayout(new BorderLayout());
		
		navbarCom=  new NavBarHautComponent();
		navbarCom.addListener(this.controler);
		
		main.add((navbarCom.getView()),BorderLayout.NORTH);
		main.add(tweetViewComp.getView(),BorderLayout.CENTER);
		main.add( margeGauche,BorderLayout.WEST);
		main.add( margeDroite,BorderLayout.EAST);
		
		this.add(main);
		
		
		this.repaint();
		this.revalidate();
	}


	@Override
	public void profileSearched(String req) {
		List<User> users = this.controler.getUsersFromReq(req);
		
		this.removeAll();
		main.removeAll();
		
		ProfileItemsComponent profileItems =new ProfileItemsComponent(users,this.controler);

		margeDroite.setBackground(Color.white);
		main.setLayout(new BorderLayout());
		main.add((navbarCom.getView()),BorderLayout.NORTH);
		main.add(profileItems.getView(),BorderLayout.CENTER);
		main.add( margeGauche,BorderLayout.WEST);
		main.add( margeDroite,BorderLayout.EAST);
		
		this.add(main);
		
		
		this.repaint();
		this.revalidate();
		
		
	}


	@Override
	public void twitsSearched(String req) {
		this.listT=this.controler.getTwitsFromReq(req);
		this.removeAll();
		main.removeAll();
		
		
		tweetViewComp=  new TweetsViewComponent(listT);
		margeDroite.setBackground(Color.white);
		main.setLayout(new BorderLayout());
		
		navbarCom=  new NavBarHautComponent();
		navbarCom.addListener(this.controler);
		
		main.add((navbarCom.getView()),BorderLayout.NORTH);
		main.add(tweetViewComp.getView(),BorderLayout.CENTER);
		main.add( margeGauche,BorderLayout.WEST);
		main.add( margeDroite,BorderLayout.EAST);
		
		this.add(main);
		
		
		this.repaint();
		this.revalidate();
		
	}
}
