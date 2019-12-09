package load;

public class Descriptor {
	private String name;
	private String description;
	private String className;
	private String categorie;
	private String autorun;
	
	public Descriptor(String name, String desc, String className, String categorie, String autorun) {
		this.name = name;
		this.className = className;
		this.categorie = categorie;
		this.description = desc;
		this.autorun = autorun;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getAutorun() {
		return autorun;
	}

	public void setAutorun(String autorun) {
		this.autorun = autorun;
	}
	
	

}
