package plugins;

import javax.swing.JOptionPane;

import app.IDisplayAPropos;

public class AproposInteret implements IDisplayAPropos{

	static String resultat = "le menu calcul d'int�r�t est un menu qui permet de calculer un int�r�t\r\n"
			+"gr�ce � celui-ci vous avez le choix entre deux calculs d'int�r�ts\r\n"+
                "celui des int�r�ts simples ou compos�s, il vous suffit d'indiquer le montant, la duree et le taux";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
