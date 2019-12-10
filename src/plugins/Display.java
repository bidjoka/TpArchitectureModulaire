package plugins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.Application;
import app.IAfficheur;
import load.Descriptor;

public class Display extends JFrame implements IAfficheur {
	private static final long serialVersionUID = 1L;
	
	public Display() throws IOException {
		super("Boite à outil bancaire");
		this.setSize(400, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	}
	
	private final JMenuBar topMenu = new JMenuBar();	
	//menu convertisseur
	private final JMenu convertisseurMenu = new JMenu("Convertisseur");
	//menu afficher
	private final JMenu aProposMenu = new JMenu("A propos");
	//menu solde
	private final JMenu calculInteretMenu = new JMenu("Calcul d'interet");
	
	@Override
	public void afficher(final List<Descriptor> listConvertisseur, final List<Descriptor> listAPropos, final List<Descriptor> listCalculInteret) {
		
	    //liste
	    final ArrayList<JMenuItem> itemConvertisseurMenu = Application.creationItem(listConvertisseur, "IConvertisseur");
	    final ArrayList<JMenuItem> itemAProposMenu = Application.creationItem(listAPropos, "IDisplayAPropos");
	    final ArrayList<JMenuItem> itemCalculInteretMenu = Application.creationItem(listCalculInteret, "IInteret");
	   
	    //création des menus 
	    final JMenuBar menuB = Application.PlacerPlugin(itemAProposMenu, itemConvertisseurMenu, itemCalculInteretMenu, aProposMenu,convertisseurMenu,calculInteretMenu, topMenu);
	    this.setJMenuBar(menuB);
	    Application.action(itemAProposMenu, itemConvertisseurMenu, itemCalculInteretMenu, listAPropos, listConvertisseur, listCalculInteret);
	    //création des actions pour les menus		
	    this.setVisible(true);
	}
}
