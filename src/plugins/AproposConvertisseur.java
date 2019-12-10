package plugins;

import javax.swing.JOptionPane;
import app.IDisplayAPropos;

public class AproposConvertisseur implements IDisplayAPropos{
	
	static String resultat = "le menu convertisseur est un menu qui permet de convertir une valeur monetaire\r\n"
							+"grace a celui-ci vous avez le choix entre trois criteres de convertion\r\n"+
			                    "les euros en dollars americain, les euros en franc suisse et les euros en livre sterling ";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
