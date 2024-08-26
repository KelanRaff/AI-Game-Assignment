package gameObjects;

public class Thing {
	private String name;
	private String description;

	public Thing(String aName, String aDescription) {
		this.name=aName;
		this.description=aDescription;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}
	
	public void setName(String aName) {
		this.name = aName;
	}

}
