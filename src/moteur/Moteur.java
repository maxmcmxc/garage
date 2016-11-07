package moteur;

import java.io.Serializable;

public class Moteur implements Serializable{

	protected TypeMoteur type;
	protected String cylindre;
	protected double prix;
	
	Moteur(String cylindre, double prix){
		
		this.cylindre = cylindre;
		this.prix = prix;
		
	}
	
	@Override
	public String toString(){
		
		return type.toString()+ ", " + this.cylindre;
		
	}
	
	public double getPrix(){
		
		return this.prix;
	}
	
}
