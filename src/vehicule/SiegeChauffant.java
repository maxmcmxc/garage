package vehicule;

import java.io.Serializable;

public class SiegeChauffant implements Option, Serializable{

	@Override
	public double getPrix() {
		// TODO Auto-generated method stub
		return 250;
	}
	
	@Override
	public String toString(){
		
		return "(SiegeChauffant, " + this.getPrix() + " $)";
	}
	
}
