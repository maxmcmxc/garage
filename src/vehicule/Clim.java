package vehicule;

import java.io.Serializable;

public class Clim implements Option, Serializable{

	@Override
	public double getPrix() {
		// TODO Auto-generated method stub
		return 200;
	}
	
	@Override
	public String toString(){
		
		return "(Clim, " + this.getPrix() + " $)";
	}
	
}
