package com.iup.tp.twitup.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.iup.tp.twitup.components.connexioncomponent.ConnexionCompListener;
import com.iup.tp.twitup.components.connexioncomponent.ConnexionComponent;
import com.iup.tp.twitup.components.creationCompteComponent.InscriptionComponent;
import com.iup.tp.twitup.components.creationCompteComponent.InscriptionComponentView;
import com.iup.tp.twitup.components.homePage.HomePageComponent;
import com.iup.tp.twitup.components.homePage.HomePageComponentListener;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMock;
import com.iup.tp.twitup.session.SessionVariables;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup implements IDatabaseObserver,ConnexionCompListener,HomePageComponentListener{
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	
	
	protected JFrame mFrame;
	
	
	protected User userConnected;
	
	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupMainView mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;
	
	

	/**
	 * Constructeur.
	 */
	public Twitup() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();
		
		
		this.mDatabase.addObserver(this);

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
		this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du répertoire d'échange
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		// this.mMainView...
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		
		this.initDirectory("D:/echange");
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
		this.mEntityManager.setExchangeDirectory("D:/echange");
	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
		
	}
	
	 JList<String> myList;

	public void show() {
		
    mFrame = new JFrame("Twitup");
		
		
		String[] data = {};
		 myList = new JList<String>(data);
		 
		// Affichage dans l'EDT
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// Custom de l'affichage
						JFrame frame = Twitup.this.mFrame;
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setSize(980,900);
						// Affichage
						Twitup.this.mFrame.setVisible(true);

						//Where the GUI is created:
						JMenuBar menuBar;
						JMenu menu, submenu;
						JMenuItem menuItem;
						JRadioButtonMenuItem rbMenuItem;
						JCheckBoxMenuItem cbMenuItem;

						//Create the menu bar.
						menuBar = new JMenuBar();

						//Build the first menu.
						menu = new JMenu("Fichier");
						menu.setMnemonic(KeyEvent.VK_A);
						menu.getAccessibleContext().setAccessibleDescription(
						        "Fichier");
						menuBar.add(menu);
					

						menuItem = new JMenuItem("Close",
						                         new ImageIcon("./src/resources/images/exitIcon_20.png"));
						menuItem.addActionListener(e->System.exit(0));
						menuItem.setMnemonic(KeyEvent.VK_B);
						
						menu.add(menuItem);
						
						/*exchange directory */
						
						JFileChooser chooser;
						chooser = new JFileChooser(); 
					    //chooser.setCurrentDirectory(new java.io.File("."));
					    chooser.setDialogTitle("choisir exchange directory");
					    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					    //
					    // disable the "All files" option.
					    //
					    chooser.setAcceptAllFileFilterUsed(false);
					    //    //
					    
					
					
						menuItem = new JMenuItem("Choisir exchange directory",
		                         new ImageIcon("./src/resources/images/editIcon_20.png"));
		
						menuItem.setMnemonic(KeyEvent.VK_B);
						menu.add(menuItem);
						menuItem.addActionListener(e->{
							
							if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) { 
								 System.out.println(chooser.getSelectedFile().getAbsolutePath());
								Twitup.this.mEntityManager.setExchangeDirectory(chooser.getCurrentDirectory().getAbsolutePath());
							      
							      }
							    else {
							      System.out.println("No Selection ");
							      }
							     
							
						});
					
						//Build the first menu.
						menu = new JMenu("?");
						
						menu.getAccessibleContext().setAccessibleDescription(
						        "à propo de l'application");
						menuBar.add(menu);
					
					
						// connexion 
						
						menuItem = new JMenuItem("Se connecter",
		                         new ImageIcon(".src/resources/images/editIcon_20.png"));
		
						menuItem.setMnemonic(KeyEvent.VK_B);
						
						menuItem.addActionListener(e->{
							if(Twitup.this.userConnected==null)
							showConnexionComponent();
							else
								userConnected(Twitup.this.userConnected);
							
						});
						menu.add(menuItem);
						
						// add user 
						
						menuItem = new JMenuItem("Ajouter User",
		                         new ImageIcon(".src/resources/images/editIcon_20.png"));
		
						menuItem.setMnemonic(KeyEvent.VK_B);
						
						menuItem.addActionListener(e->{
							
								showInscriptionComponent();
						
						
						});
						
						menu.add(menuItem);
						menu.getAccessibleContext().setAccessibleDescription(
						        "Creer");
						menuBar.add(menu);
					
						
						frame.setJMenuBar(menuBar);
						showConnexionComponent();
						
						
					}
				});
		
	}
	
	
	private void showConnexionComponent()
	{
		Twitup.this.mFrame.getContentPane().removeAll();
		JPanel connexion = new JPanel();
		connexion.setPreferredSize(new Dimension(200,200));
		connexion.setLayout(new BorderLayout());
		
		ConnexionComponent connexionComp=new ConnexionComponent(mDatabase);
		 connexionComp.addListener(Twitup.this);
		 
		 connexion.add(connexionComp.getVue());
		Twitup.this.mFrame.getContentPane().setLayout(new GridLayout(3,3));
		Label l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		
		Twitup.this.mFrame.getContentPane().add(connexionComp.getVue());
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		 l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		l = new Label();
		l.setBackground(Color.getHSBColor(3.57F,0.88F,0.94F));
		Twitup.this.mFrame.getContentPane().add(l);
		Twitup.this.mFrame.repaint();
		Twitup.this.mFrame.revalidate();
	}

	private void showInscriptionComponent()
	{
		Twitup.this.mFrame.getContentPane().removeAll();
		Twitup.this.mFrame.getContentPane().setLayout(new BorderLayout());
		Twitup.this.mFrame.getContentPane().add((new InscriptionComponent(mDatabase,this.mEntityManager)).getView());
		Twitup.this.mFrame.getContentPane().repaint();
		Twitup.this.mFrame.getContentPane().revalidate();
	}
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
	
		
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserAdded(User addedUser) {
		 System.out.println("eoooo ");
	}

	@Override
	public void notifyUserDeleted(User deletedUser) {
		 System.out.println("eoooo ");
	}

	@Override
	public void notifyUserModified(User modifiedUser) {
		 System.out.println("eoooo ");
		
	}

	@Override
	public void userConnected(User user) {
		this.userConnected=user;
		SessionVariables.getSessionVariables().setConnecctedUser(user);
		Twitup.this.mFrame.getContentPane().setLayout(new BorderLayout());
		List<Twit> twits = new ArrayList<>();
		twits.addAll(this.mDatabase.getTwits());
		 HomePageComponent homePage = new HomePageComponent(twits,this.mDatabase,mEntityManager);
		 homePage.addHomePageComponentListener(this);
		this.mDatabase.addObserver(homePage);
		this.mFrame.getContentPane().removeAll();
		this.mFrame.getContentPane().add(homePage.getView(),BorderLayout.CENTER);
		this.mFrame.getContentPane().repaint();
		this.mFrame.getContentPane().revalidate();
	}
	
	@Override
	public void seDeconnecter()
	{this.userConnected=null;
	SessionVariables.getSessionVariables().setConnecctedUser(null);
		showConnexionComponent();
	}

	@Override
	public void twitAdded() {
		
		
	}
}
