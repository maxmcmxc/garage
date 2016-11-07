package moteur;

public enum TypeMoteur {

	DIESEL("Diesel"),
	ESSENCE("Essence"),
	HYBRIDE("Hybride"),
	ELECTRIQUE("Electrique");
	
	private String type;
	
	private TypeMoteur(String type) {
		
		this.type = type;
		
	}
	
}
