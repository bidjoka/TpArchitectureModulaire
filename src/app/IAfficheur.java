package app;

import java.util.List;

import load.Descriptor;

public interface IAfficheur {
	void afficher(List<Descriptor> listConvertisseur, List<Descriptor> listAPropos, List<Descriptor> listInteret);
}
