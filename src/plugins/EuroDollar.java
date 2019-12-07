package plugins;

import javax.swing.JOptionPane;

import app.IConvertisseur;

public class EuroDollar implements IConvertisseur {
	
	@Override
	public void convertir() {
		double resultat = 0;
	   	 
		double nombre1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez une valeur")) ;
		
		resultat = nombre1 * 1.11;

		JOptionPane.showMessageDialog(null, "elle vaut " + resultat + " dollars");
 
	}

}
