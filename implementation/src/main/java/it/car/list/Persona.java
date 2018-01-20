package it.car.list;





public class Persona {
	
	private String name;
	
	

	public Persona(String name) {
		super();
		this.name = name;
	}
	
	public Persona() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31 * name.hashCode();
		return hashCode;
	}
	

	
	

}
