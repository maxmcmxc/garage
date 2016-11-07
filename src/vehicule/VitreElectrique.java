package vehicule;

import java.io.Serializable;

public class VitreElectrique implements Option, Serializable{

	@Override
	public double getPrix() {
		// TODO Auto-generated method stub
		return 70;
	}
	
	@Override
	public String toString(){
		
		return "(VitreElectrique, " + this.getPrix() + " $)";
	}
	
}
