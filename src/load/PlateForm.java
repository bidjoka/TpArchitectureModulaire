package load;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import app.IAfficheur;
import app.Moniteur;

public class PlateForm {

	//map de descriteurs
	static Map<String, List<Descriptor>> allDescriptors;

	//m�thode pour charger tous les descripteurs
	public IAfficheur loadAllDescriptors() throws IOException{
		IAfficheur viewToShow = null;
		Map<String, List<Descriptor>> listOfPlugin =  new HashMap<>();
		
		File repertoire = new File("src/configs");
		File[] files = repertoire.listFiles();
		
		for(File fileTmp : files){
			FileReader file = new FileReader(fileTmp);
			Properties prop = new Properties();
			prop.load(file);
			String nameTmp = prop.getProperty("name");
			String descriptionTmp = prop.getProperty("description");
			String classNameTmp = prop.getProperty("className");
			String categorieTmp = prop.getProperty("categorie");
			String autorun = prop.getProperty("autorun");
			
			Descriptor descTmp = new Descriptor(nameTmp, descriptionTmp, classNameTmp, categorieTmp, autorun);
			String firstView = prop.getProperty("firstView");
			if(firstView != null && firstView.equals("true") && autorun.equals("true")) {
				viewToShow = (IAfficheur)this.loadPlugin(descTmp);
			}
			if(listOfPlugin.get(categorieTmp) == null) {
				List<Descriptor> listOfDesc = new ArrayList<Descriptor>();
				listOfDesc.add(descTmp);
				listOfPlugin.put(categorieTmp, listOfDesc);
			}
			else {
				List<Descriptor> listOfDesc = listOfPlugin.get(categorieTmp);
				listOfDesc.add(descTmp);
				listOfPlugin.put(categorieTmp, listOfDesc);
			}
		}
		
		allDescriptors = listOfPlugin;
		return viewToShow;
	}
	
	public List<Descriptor> getDescriptor(String categorie){
		return allDescriptors.get(categorie);
	}
	
	public Object loadPlugin(Descriptor desc) {
		//cr�e la classe, l'instance, le plugin
	
		Class<?> cl;
		Object o = null;
		try {
			cl = Class.forName(desc.getClassName());
			o = cl.newInstance();
		} catch (ClassNotFoundException	|InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//instance de plateforme
		PlateForm plateform = new PlateForm();
		//chargement des descripteurs
		IAfficheur mainApp = plateform.loadAllDescriptors();
		//mise des descripteurs selon les interfaces
		List<Descriptor> listConvertisseur = plateform.getDescriptor("IConvertisseur");
		List<Descriptor> listAPropos = plateform.getDescriptor("IDisplayAPropos");
		List<Descriptor> listInteret = plateform.getDescriptor("IInteret");
		
		Moniteur mon = new Moniteur();
		mon.verification(listConvertisseur, listAPropos, listInteret);
	
		//lancement de l'application
		mainApp.afficher(listConvertisseur, listAPropos, listInteret);
	}

}
