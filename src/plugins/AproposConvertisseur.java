package plugins;

import javax.swing.JOptionPane;

import app.IAfficheur;

public class AproposConvertisseur implements IAfficheur{
	
	static String resultat = "le menu convertisseur est un menu qui permet de convertir une valeur monétaire\r\n"
							+"grâce à celui-ci vous avez le choix entre trois critères de convertion\r\n"+
			                    "les euros en dollars américain, les euros en franc suisse et les euros en livre sterling ";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
