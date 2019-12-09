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
import javax.swing.JOptionPane;

import load.Descriptor;
import load.PlateForm;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static JOptionPane jop = new JOptionPane();
	static int l = 0;
	static int k = 0;
	static int j = 0;
	//instance de plateforme
	static PlateForm plateform = new PlateForm();
	//barre de menu
	private JMenuBar menuBar = new JMenuBar();	
	//menu convertisseur
	private JMenu menualexandre = new JMenu("Convertisseur");
	//menu afficher
	private JMenu menusimon = new JMenu("A propos");
	//menu solde
	private JMenu menupierre = new JMenu("Calcul d'intérêt");
	//list d'item d'alexandre
	ArrayList<JMenuItem> ItemAlexandre = new ArrayList<JMenuItem>();
	//List d'item de simon
	ArrayList<JMenuItem> ItemSimon = new ArrayList<JMenuItem>();
	//List d'item de pierre
	ArrayList<JMenuItem> ItemPierre = new ArrayList<JMenuItem>();
	
	//méthode de création de listes des ItemMenu pour des interfaces de plugin 
	public static ArrayList<JMenuItem> creationItem(List<Descriptor> plug, String inter){
		ArrayList<JMenuItem> Item = new ArrayList<JMenuItem>();
		plug = plateform.getDescriptor(inter);
		for(int i = 0; i < plug.size(); i++)
	    { 
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
	public static void action(ArrayList<JMenuItem> param, ArrayList<JMenuItem> param1, ArrayList<JMenuItem> param2, 
			List<Descriptor> listdescriptor, List<Descriptor> listdescriptor1, List<Descriptor> listdescriptor2) {
		for(j = 0; j < listdescriptor.size(); j++) {
			listdescriptor.get(j);
			for(int i = 0; i < param.size(); i++)
		    { 
				if(param.get(i).getText().equals(listdescriptor.get(j).getName())
						&& listdescriptor.get(j).getAutorun().equals("true")){
					param.get(i).addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							IAfficheur plugin = (IAfficheur) plateform.loadPlugin(listdescriptor.get(j));
			                plugin.afficher();
						}
					});	
				}
		    }
		}
		j = 0;
		for(k = 0; k < listdescriptor1.size(); k++) {
			listdescriptor1.get(k);
			for(int i = 0; i < param1.size(); i++)
		    { 
				if(param1.get(i).getText().equals(listdescriptor1.get(k).getName())
						&& listdescriptor1.get(k).getAutorun().equals("true")) {
					param1.get(i).addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
			                @SuppressWarnings("unused")
							IConvertisseur plugin = (IConvertisseur) plateform.loadPlugin(listdescriptor1.get(k));
			                plugin.convertir();
						}
					});
		    	}
			}
		}
		k=0;
		for(l = 0; l < listdescriptor2.size(); l++) {
			listdescriptor2.get(l);
			for(int i = 0; i < param2.size(); i++)
		    { 
				if(param2.get(i).getText().equals(listdescriptor2.get(l).getName())
						&& listdescriptor2.get(k).getAutorun().equals("true")) {
					param2.get(i).addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							IInteret plugin = (IInteret) plateform.loadPlugin(listdescriptor2.get(l));
			                plugin.calculerInterets();
						}
					});
				}
		    }
		}
		l=0;
	}
	
	//constructeur
	public Application(List<Descriptor> alexandre, List<Descriptor> simon, List<Descriptor> pierre) throws IOException {		
		super("notre appli");
	    this.setSize(400, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
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
