package vehicule;

import java.io.Serializable;

public class BarreDeToit implements Option, Serializable{

	@Override
	public double getPrix() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public String toString(){
		
		return "(BarreDeToit, " + this.getPrix() + " $)";
	}
	
}
