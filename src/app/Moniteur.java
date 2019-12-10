package app;

import java.util.List;

import javax.swing.JOptionPane;

import load.Descriptor;

public class Moniteur {
 static String resultat = "les plugins suivant ne sont pas en autorun :\r\n";
 public void verification(List<Descriptor> listdescriptor, 
		 						 List<Descriptor> listdescriptor1,
		 						 List<Descriptor> listdescriptor2) {
	 if(listdescriptor != null) {
		for(int i = 0; i < listdescriptor.size(); i++)
	    { 
		 	if(listdescriptor.get(i).getAutorun().equals("false")) {
		 		resultat += "- " + listdescriptor.get(i).getName()+"\r\n";
		 	}
	    } 
	 }
	 if(listdescriptor1 != null) {
		for(int i = 0; i < listdescriptor1.size(); i++)
	    { 
			if(listdescriptor1.get(i).getAutorun().equals("false")){	 
				resultat += "- " + listdescriptor1.get(i).getName()+"\r\n";
			} 
		}
	 }
	 if(listdescriptor2 != null) {
		for(int i = 0; i < listdescriptor2.size(); i++)
	    { 
			if(listdescriptor2.get(i).getAutorun().equals("false")) {
				resultat += "- " + listdescriptor2.get(i).getName()+"\r\n";
			}
	    }
	 }
		JOptionPane.showMessageDialog(null, resultat);
 	}
 
}
