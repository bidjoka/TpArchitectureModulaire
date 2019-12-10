package plugins;

import javax.swing.JOptionPane;
import app.IDisplayAPropos;

public class AproposConvertisseur implements IDisplayAPropos{
	
	static String resultat = "le menu convertisseur est un menu qui permet de convertir une valeur mon�taire\r\n"
							+"gr�ce � celui-ci vous avez le choix entre trois crit�res de convertion\r\n"+
			                    "les euros en dollars am�ricain, les euros en franc suisse et les euros en livre sterling ";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
