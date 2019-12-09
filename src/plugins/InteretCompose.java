package plugins;

import javax.swing.JOptionPane;

import app.IInteret;

public class InteretCompose implements IInteret {

	@Override
	public void calculerInterets() {
		double montant = getValeurOfEntry("Entrez le montant emprunté", "Veuillez renseigner un montant valide");
		int nbAnnee = (int)getValeurOfEntry("Entrez le nombre d'année de l'emprunt", "Veuillez renseigner un nombre d'années valide");
		double interet = getValeurOfEntry("Entrez le taux de l'emprunt", "Veuillez renseigner un taux valide");;
			
		double sommeARembourserParAn = montant / nbAnnee;
		double sommeRestante = montant;
		double interets = 0;
		double sommeInterets = 0;
		
		for(int i=0; i < nbAnnee; i++) {
			interets = (sommeRestante * (interet/100));
			sommeInterets += interets;
			sommeRestante = sommeRestante - (sommeARembourserParAn - interets);
		}
		JOptionPane.showMessageDialog(null, "Vous paierez " + sommeInterets + " € d'interets pour cette emprunt"); 
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
