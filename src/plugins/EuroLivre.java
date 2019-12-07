package plugins;

import javax.swing.JOptionPane;

import app.IConvertisseur;

public class EuroLivre implements IConvertisseur{
	
	@Override
	public void convertir() {
		double resultat = 0;
	   	 
		double nombre1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez une valeur")) ;
		
		resultat = nombre1 * 2.52;

		JOptionPane.showMessageDialog(null, "elle vaut " + resultat + " livre sterling");
		
	}


}
