package plugins;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import app.IConvertisseur;

public class EuroFranc implements IConvertisseur{

	@Override
	public void actionPerformed(ActionEvent e) {
		double resultat = 0;
	   	 
		double nombre1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez un premier nombre")) ;
 
		double nombre2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez un second nombre")) ;
 
		String[] operateurs = new String[]{"+","-","*","/"};
 
		String operateur = (String)JOptionPane.showInputDialog(null,"Choississez un op�rateur",
			"Op�rateur",JOptionPane.QUESTION_MESSAGE, null, operateurs, operateurs[0]);
 
		if("+".equals(operateur)){
			resultat = nombre1 + nombre2;
		}
		else if ("-".equals(operateur)){
			resultat = nombre1 - nombre2;
		}
		else if ("*".equals(operateur)){
			resultat = nombre1 * nombre2; 
		}
		else if ("/".equals(operateur)){
			resultat = nombre1 / nombre2; 
		}
 
		JOptionPane.showMessageDialog(null, nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);
 
		int reponse = JOptionPane.showConfirmDialog(null, "�tes-vous content de ce programme ?", 
			"Satisfaction", JOptionPane.YES_NO_OPTION);
 
		if(reponse == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "Cool :) A la prochaine") ;
		}else if(reponse == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Dommage :( Peut-�tre trouverez-vous votre bonheur" +  
				" dans les futurs programmes que je vais d�velopper") ;
		}
	}


}
