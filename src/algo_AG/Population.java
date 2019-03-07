package algo_AG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
	private List<Trajet> population = new ArrayList<Trajet>();
	private int i = 0;
	
	
	public Population(int n, Ville[] carte) {
		for (i = 0;i<n;i++) {
			population.add(new Trajet(carte));
		}
	}
	public void Selection() {
		Collections.sort(this.population);
		for(int i=0;i<this.population.size()/2;i++) {
			this.population.remove(0);
		}
	}
	public void Reproduction(int n) {
		
	}
	private void Mutation(double p) { // remplacer par private Trajet
		

	}
	public String toString() {
		String s = "";
		for (Trajet t : population) {
			s+= t.toString() + "  \n";
		}
		return s;
	}
}
