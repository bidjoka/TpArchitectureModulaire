package plugins;

import javax.swing.JOptionPane;

import app.IAfficheur;
import app.IDisplayAPropos;

public class AproposInteret implements IDisplayAPropos{

	static String resultat = "le menu calcul d'intérêt est un menu qui permet de calculer un intérêt\r\n"
			+"grâce à celui-ci vous avez le choix entre deux calculs d'intérêts\r\n"+
                "celui des intérêts simples ou composés, il vous suffit d'indiquer le montant, la duree et le taux";
	public void afficher() {
		JOptionPane.showMessageDialog(null, resultat);
	}
}
