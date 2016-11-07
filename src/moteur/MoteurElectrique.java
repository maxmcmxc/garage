package moteur;

public class MoteurElectrique extends Moteur{

	
	public MoteurElectrique(String cylindre, double prix){
		super(cylindre,prix);
		this.type = TypeMoteur.ELECTRIQUE;
	}

	
	public double getPrix(){
		
		return this.prix;
	}
	
}
