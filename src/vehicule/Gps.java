package vehicule;

import java.io.Serializable;

public class Gps implements Option, Serializable{

	@Override
	public double getPrix() {
		// TODO Auto-generated method stub
		return 150;
	}
	
	@Override
	public String toString(){
		
		return "(GPS, " + this.getPrix() + " $)";
	}
	
}
