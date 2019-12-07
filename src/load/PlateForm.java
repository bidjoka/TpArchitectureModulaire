package load;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import app.Application;

public class PlateForm {

	static Map<String, List<Descriptor>> allDescriptors;

	public void loadAllDescriptors() throws IOException{
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
			
			Descriptor descTmp = new Descriptor(nameTmp, descriptionTmp, classNameTmp, categorieTmp);
			
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
	}
	
	public List<Descriptor> getDescriptor(String categorie){
		return allDescriptors.get(categorie);
	}
	
	public Object loadPlugin(Descriptor desc) {
		//crée la classe, l'instance, le plugin
	
		Class<?> cl;
		Object o = null;
		try {
			cl = Class.forName(desc.getClassName());
			o = cl.newInstance();
		} catch (ClassNotFoundException	|InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public static void main(String[] args) throws IOException {
		//instance de plateforme
		PlateForm plateform = new PlateForm();
		//chargement des descripteurs
		plateform.loadAllDescriptors();
		//mise des descripteurs selon les interfaces
		List<Descriptor> alexandre = plateform.getDescriptor("IConvertisseur");
		List<Descriptor> simon = plateform.getDescriptor("IAfficheur");
		List<Descriptor> pierre = plateform.getDescriptor("ISolde");
		
		//lancement de l'application
		@SuppressWarnings("unused")
		Application appli = new Application(alexandre, simon, pierre);
	}

}
