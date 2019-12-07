package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import load.Descriptor;
import load.PlateForm;

public class Application extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instance de plateforme
	static PlateForm plateform = new PlateForm();
	//barre de menu
	private JMenuBar menuBar = new JMenuBar();	
	//menu convertisseur
	private JMenu convertisseur = new JMenu("Convertisseur");
	//menu afficher
	private JMenu menusimon = new JMenu("simon");
	//menu solde
	private JMenu menupierre = new JMenu("pierre");
	//list d'item d'alexandre
	ArrayList<JMenuItem> ItemAlexandre = new ArrayList<JMenuItem>();
	//List d'item de simon
	ArrayList<JMenuItem> ItemSimon = new ArrayList<JMenuItem>();
	//List d'item de pierre
	ArrayList<JMenuItem> ItemPierre = new ArrayList<JMenuItem>();
	
	//méthode de création de listes des ItemMenu pour des interfaces de plugin 
	public static ArrayList<JMenuItem> creationItem(ArrayList<JMenuItem> param, List<Descriptor> plug, String inter){
		ArrayList<JMenuItem> Item = new ArrayList<JMenuItem>();
		plug = plateform.getDescriptor(inter);
		for(int i = 0; i < plug.size(); i++)
	    { 
	      System.out.println("donnée à l'indice " + i + " = " + plug.get(i).getName());
	      JMenuItem item = new JMenuItem(plug.get(i).getName());
	      Item.add(item);
	    } 
		return Item;	
	}
	
	//méthode de création des menu qui conviennent aux interfaces
	public static JMenuBar PlacerPlugin(ArrayList<JMenuItem> param, ArrayList<JMenuItem> param1, ArrayList<JMenuItem> param2, 
										JMenu menu, JMenu menu1, JMenu menu2, JMenuBar menuBar) {
		for(int i = 0; i < param.size(); i++)
	    { 
	      menu.add(param.get(i));
	    } 
		for(int i = 0; i < param1.size(); i++)
	    { 
	      menu1.add(param1.get(i));
	    } 
		for(int i = 0; i < param2.size(); i++)
	    { 
	      menu2.add(param2.get(i));
	    }
		menuBar.add(menu);
		menuBar.add(menu1);
		menuBar.add(menu2);
		return menuBar;
	}
	
	//méthode pour mettre sur pied les actions de nos plugins
	public static void action(ArrayList<JMenuItem> param) {
		for(int i = 0; i < param.size(); i++)
	    { 
			if(param.get(i).getText().equals(""))
				param.get(i).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
	              //à remplir
	            }
	        });
	    }
	}
	
	public Application(List<Descriptor> alexandre, List<Descriptor> simon, List<Descriptor> pierre) throws IOException {		
		super("notre appli");
	    this.setSize(400, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    //liste
	    ArrayList<JMenuItem> ItemMenuAlexandre = Application.creationItem(ItemAlexandre, alexandre, "IConvertisseur");
	    ArrayList<JMenuItem> ItemMenuSimon = Application.creationItem(ItemSimon, simon, "IAfficheur");
	    ArrayList<JMenuItem> ItemMenuPierre = Application.creationItem(ItemPierre, pierre, "ISolde");
	    //création des menus 
	    JMenuBar menuB = Application.PlacerPlugin(ItemMenuAlexandre, ItemMenuSimon, ItemMenuPierre, convertisseur,menusimon,menupierre, menuBar);
	    this.setJMenuBar(menuB);
	    //création des actions pour les menus		
	    this.setVisible(true);
	}
		
}
