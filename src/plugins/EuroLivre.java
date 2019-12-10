package plugins;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import app.IConvertisseur;

public class EuroLivre implements IConvertisseur{
	
	@Override
	public void convertir() {
		double resultat = 0;
		double nombre1 = 0;
		DecimalFormat df = new DecimalFormat("0.00"); 
		nombre1 = getValeurOfEntry("Entrez un montant a convertir", "Veuillez renseigner un montant valide");
		if(nombre1 != 0.0){
			resultat = nombre1 * 2.52;
			if(resultat!=0) {
				JOptionPane.showMessageDialog(null, "elle vaut " + df.format(resultat) + " dollars");
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
