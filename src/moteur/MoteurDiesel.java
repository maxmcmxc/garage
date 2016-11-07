package moteur;

public class MoteurDiesel extends Moteur{

	
	public MoteurDiesel(String cylindre, double prix){
		super(cylindre,prix);
		this.type = TypeMoteur.DIESEL;
	}

	public double getPrix(){
		
		return this.prix;
	}
	
}
