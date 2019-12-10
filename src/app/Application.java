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

public class Application {

	private static final long serialVersionUID = 1L;
	
	static int l = 0;
	static int k = 0;
	static int j = 0;
	//instance de plateforme
	static PlateForm plateform = new PlateForm();
	
	//méthode de création de listes des ItemMenu pour des interfaces de plugin 
	public static ArrayList<JMenuItem> creationItem(List<Descriptor> plug, String inter){
		ArrayList<JMenuItem> Item = new ArrayList<JMenuItem>();
		plug = plateform.getDescriptor(inter);
		if(plug != null) {
			for(int i = 0; i < plug.size(); i++)
		    { 
		      JMenuItem item = new JMenuItem(plug.get(i).getName());
		      Item.add(item);
		    } 
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
		if(listdescriptor != null) {
			for(j = 0; j < listdescriptor.size(); j++) {
				listdescriptor.get(j);
				for(int i = 0; i < param.size(); i++)
			    { 
					if(param.get(i).getText().equals(listdescriptor.get(j).getName())){
						param.get(i).addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0) {
								IDisplayAPropos plugin = (IDisplayAPropos) plateform.loadPlugin(getDescriptorAction(listdescriptor, arg0.getActionCommand()));
				                plugin.afficher();
							}
						});	
					}
			    }
			}
		}
		j = 0;
		if(listdescriptor1 != null) {
			for(k = 0; k < listdescriptor1.size(); k++) {
				listdescriptor1.get(k);
				for(int i = 0; i < param1.size(); i++)
			    { 
					if(param1.get(i).getText().equals(listdescriptor1.get(k).getName())) {
						param1.get(i).addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0) {
								IConvertisseur plugin = (IConvertisseur) plateform.loadPlugin(getDescriptorAction(listdescriptor1, arg0.getActionCommand()));
				                plugin.convertir();
							}
						});
			    	}
				}
			}
		}
		k=0;
		if(listdescriptor2 != null) {
			for(l = 0; l < listdescriptor2.size(); l++) {
				listdescriptor2.get(l);
				for(int i = 0; i < param2.size(); i++)
			    { 
					if(param2.get(i).getText().equals(listdescriptor2.get(l).getName())) {
						param2.get(i).addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0) {
								IInteret plugin = (IInteret) plateform.loadPlugin(getDescriptorAction(listdescriptor2, arg0.getActionCommand()));
				                plugin.calculerInterets();
							}
						});
					}
			    }
			}
		}
		l=0;
	}
	
	static Descriptor getDescriptorAction(List<Descriptor> liste, String name){
		Descriptor desc = null;
		for(int i=0; i<liste.size(); i++){
			if(liste.get(i).getName().equals(name)){
				desc = liste.get(i);
			}
		}
		return desc;
	}

	//constructeur
	public Application(List<Descriptor> alexandre, List<Descriptor> simon, List<Descriptor> pierre) throws IOException {		
	   	   
	    
	   
	}
		
}
