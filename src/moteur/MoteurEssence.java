package moteur;

public class MoteurEssence extends Moteur{

	
	public MoteurEssence(String cylindre, double prix){
		super(cylindre,prix);
		this.type = TypeMoteur.ESSENCE;
	}

	public double getPrix(){
		
		return this.prix;
	}
	
}
