package garage;

import java.util.ArrayList;
import java.util.List;
import moteur.MoteurDiesel;
import moteur.MoteurElectrique;
import moteur.MoteurEssence;
import readWrite.ReadWrite;
import vehicule.A4;
import vehicule.Alpine;
import vehicule.BarreDeToit;
import vehicule.Clim;
import vehicule.Gps;
import vehicule.Laguna;
import vehicule.SiegeChauffant;
import vehicule.Vehicule;
import vehicule.VitreElectrique;

public class Garage {
	
	private List<Vehicule> voitures;
	
	public Garage(){
		//Retrieve existing voitures
		this.voitures = ReadWrite.readObjects("test.txt");
		
	}
	
	public String toString(){
		String result = "";
		result += "Affichage du Garage :\n*************************\n";
		for(Vehicule v:this.voitures){
			result += v.toString();
			}
		result += "********************************\n\n";
		return result;
		
	}
	
	private void addVoiture(Vehicule vehicule){
		
		this.voitures.add(vehicule);
		ReadWrite.writeObjects("test.txt", this.voitures);
		
	}
	
	 public static void main(String[] args) {
		 
		 Garage garage = new Garage();   
	   	 System.out.println(garage);
	   	 test1(garage);
	   	 System.out.println(garage);
	   	 	 
 }
	 
	 public static void test1(Garage garage){
		 
		 Vehicule lag1 = new Laguna();
	   	 lag1.setMoteur(new MoteurEssence("150 Chevaux", 10256d));
	   	 lag1.addOption(new Gps());
	   	 lag1.addOption(new SiegeChauffant());
	   	 lag1.addOption(new VitreElectrique());
	   	 garage.addVoiture(lag1);
	   		 
	   	 Vehicule a4_1 = new A4();
		 a4_1.setMoteur(new MoteurElectrique("1500 W", 1234d));
		 a4_1.addOption(new Clim());
		 a4_1.addOption(new BarreDeToit());
		 a4_1.addOption(new SiegeChauffant());
	   	 garage.addVoiture(a4_1);
	   	 
	   	 Vehicule alpine_1 = new Alpine();
	   	 alpine_1.setMoteur(new MoteurDiesel("200 Hdi", 25684.80d));
	   	 alpine_1.addOption(new BarreDeToit());
	   	 alpine_1.addOption(new Clim());
	   	 alpine_1.addOption(new Gps());
	   	 garage.addVoiture(alpine_1);   	 

	   	 Vehicule alpine_2 = new Alpine();
	   	 alpine_2.setMoteur(new MoteurElectrique("100 KW", 1224d));
	   	 alpine_2.addOption(new SiegeChauffant());
	   	 alpine_2.addOption(new BarreDeToit());
	   	 alpine_2.addOption(new Clim());
	   	 alpine_2.addOption(new Gps());
	   	 alpine_2.addOption(new VitreElectrique());
	   	 garage.addVoiture(alpine_2);   		
		 
	 }
}
