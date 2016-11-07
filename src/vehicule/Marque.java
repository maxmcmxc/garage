package vehicule;

public enum Marque{

	R("RENAULT"),
	P("PEUGEOT"),
	A("AUDI");
	
	private String marque;
	
	Marque(String marque){
		
		this.marque = marque;
		
	}
	
	@Override
	public String toString(){
		
		return marque;
		
	}
	
}
