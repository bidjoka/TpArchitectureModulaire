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
	
	public Display() throws IOException {
		super("notre appli");
		this.setSize(400, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	}
	
	private JMenuBar menuBar = new JMenuBar();	
	//menu convertisseur
	private JMenu menualexandre = new JMenu("Convertisseur");
	//menu afficher
	private JMenu menusimon = new JMenu("A propos");
	//menu solde
	private JMenu menupierre = new JMenu("Calcul d'interet");
	//list d'item d'alexandre
	ArrayList<JMenuItem> ItemAlexandre = new ArrayList<JMenuItem>();
	//List d'item de simon
	ArrayList<JMenuItem> ItemSimon = new ArrayList<JMenuItem>();
	//List d'item de pierre
	ArrayList<JMenuItem> ItemPierre = new ArrayList<JMenuItem>();
	
	@Override
	public void afficher(List<Descriptor> alexandre, List<Descriptor> simon, List<Descriptor> pierre) {
		
	    //liste
	    ArrayList<JMenuItem> ItemMenuAlexandre = Application.creationItem(alexandre, "IConvertisseur");
	    ArrayList<JMenuItem> ItemMenuSimon = Application.creationItem(simon, "IAfficheur");
	    ArrayList<JMenuItem> ItemMenuPierre = Application.creationItem(pierre, "IInteret");
	   
	    //création des menus 
	    JMenuBar menuB = Application.PlacerPlugin(ItemMenuSimon, ItemMenuAlexandre, ItemMenuPierre, menusimon,menualexandre,menupierre, menuBar);
	    this.setJMenuBar(menuB);
	    Application.action(ItemMenuSimon, ItemMenuAlexandre, ItemMenuPierre, simon, alexandre, pierre);
	    //création des actions pour les menus		
	    this.setVisible(true);
	}
}
