package plugins;

import javax.swing.JOptionPane;

import app.IInteret;

public class InteretSimple implements IInteret {

	@Override
	public void calculerInterets() {
		double montant = getValeurOfEntry("Entrez le montant emprunt", "Veuillez renseigner un montant valide");
		if(montant != 0.0){
			int nbAnnee = (int)getValeurOfEntry("Entrez le nombre d'annee de l'emprunt", "Veuillez renseigner un nombre d'annees valide");
			if(nbAnnee != 0.0){
				double interet = getValeurOfEntry("Entrez le taux de l'emprunt", "Veuillez renseigner un taux valide");;
				if(interet != 0.0){		
					double sommeInterets = montant * (interet/100) * nbAnnee;
					JOptionPane.showMessageDialog(null, "Vous paierez " + sommeInterets + " euros d'interets pour cette emprunt"); 
				}
			}
		}
	}
	double getValeurOfEntry(String reason, String erreur) {
		double value = 0;
		try {
			while(value == 0) {
				try {
					value = Double.parseDouble(JOptionPane.showInputDialog(null, reason)) ;
				}catch(NumberFormatException number) {
					value = 0;
				}
				if(value == 0) {
					JOptionPane.showMessageDialog(null, 
					         erreur,
					         " Erreur ",
					         JOptionPane.WARNING_MESSAGE);
				}
			}
		}catch(NullPointerException e){
			value = 0;
		}	
		return value;
	}

}


