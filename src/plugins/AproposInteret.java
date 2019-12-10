package plugins;

import javax.swing.JOptionPane;

import app.IDisplayAPropos;

public class AproposInteret implements IDisplayAPropos{

	static String resultat = "le menu calcul d'interet est un menu qui permet de calculer un interet\r\n"
			+"grace a celui-ci vous avez le choix entre deux calculs d'interets\r\n"+
                "celui des interets simples ou composes, il vous suffit d'indiquer le montant, la duree et le taux";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
