package plugins;

import javax.swing.JOptionPane;

import app.IInteret;

public class InteretSimple implements IInteret {

	@Override
	public void calculerInterets() {
		double montant = 0;
		int nbAnnee = 0;
		double interet = 0;
		try {
			while(montant == 0) {
				try {
					montant = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez une valeur !")) ;
				}catch(NumberFormatException number) { 
					montant = 0;
				}
				if(montant == 0) {
					JOptionPane.showMessageDialog(null, 
					         "Veuillez entrer un chiffre valide",
					         " Erreur ",
					         JOptionPane.WARNING_MESSAGE);
				}
			}
	   	}catch(NullPointerException e){}	
		double sommeInterets = montant * (interet/100) * nbAnnee;
		JOptionPane.showMessageDialog(null, "Vous paierez " + sommeInterets + " € d'interets pour cette emprunt"); 
		
	}

}
