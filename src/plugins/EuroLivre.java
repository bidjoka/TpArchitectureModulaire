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
	   	try { 
		nombre1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez une valeur !")) ;
	   	}catch(NullPointerException e){}		
		resultat = nombre1 * 2.52;
		if(resultat!=0) {
		JOptionPane.showMessageDialog(null, "elle vaut " + df.format(resultat) + " dollars");
		}
	}


}
