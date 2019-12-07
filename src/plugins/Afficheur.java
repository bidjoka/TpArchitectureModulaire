package plugins;

import app.IAfficheur;

public class Afficheur implements IAfficheur{
	
	public Afficheur() {};
	
	public void afficher() {
		System.out.println("salut");
	}
}
