package algo_AG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trajet implements Comparable {
	private List<Ville> etapes = new ArrayList<Ville>();
	private int fitness;
	private int nbVilles;
	
	
	public Trajet(Ville[] carte) {      //create new random trip
		this.nbVilles = carte.length;
		
		for(int i=0;i<nbVilles;i++) {
			etapes.add(new Ville(carte[i]));
		}
		Collections.shuffle(etapes);
		this.calculateFitness();
	}
	public void calculateFitness() {
		this.fitness = 0;
		for(int i=0;i<nbVilles-1;i++) {
			this.fitness+=etapes.get(i).getDistance(etapes.get(i+1).getName());
		}
	}
	public int getFitness() {
		return this.fitness;
	}
	public String toString() {
		String s="";
		for(Ville v : etapes) {
			s+= v.getName()+", ";
		}
			
		return s+"  "+this.fitness;

	}
	@Override
	public int compareTo(Object arg0) {
		
		return ((Trajet)arg0).getFitness()-this.fitness;
	}
}
