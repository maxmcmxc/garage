package vehicule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import moteur.Moteur;

public class Vehicule implements vehicule.Option, Serializable{
	
	protected double prix;
	protected String nom;
	protected List<Option> options;
	protected Marque nomMarque;
	protected Moteur moteur;
	
	Vehicule(String nom){
		
		this.nom = nom;
		this.options = new ArrayList<Option>();
	}
	
	@Override
	public String toString(){
		
		String result = "";
		double prixOptions = 0;
		for(Option o:options){
			prixOptions += o.getPrix();
		}
		
		result += "Voiture "+nom+ " de marque "+ this.nomMarque.toString() +". Moteur "+ ((Moteur) this.moteur).toString() +  " (" + (this.prix+this.moteur.getPrix()) + "$). Equipée de ";
		
		for(Option o:options){
			result += o.toString();}
		
		result += ". Prix : "+ String.valueOf(this.prix + prixOptions + this.moteur.getPrix())  +".\n";
		
		return result;
	}
	
	public void addOption(Option opt){
		if(!options.contains(opt)) options.add(opt);
	}

	public double getPrix() {
		return prix;
	}

	public List<Option> getOptions() {
		return options;
	}

	public Marque getNomMarque() {
		return nomMarque;
	}
	
	public void setMoteur(Moteur moteur){
		
		this.moteur = moteur;
		
	}
	
}
