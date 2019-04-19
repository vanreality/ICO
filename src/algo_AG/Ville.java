package algo_AG;

import java.util.HashMap;
import java.util.Map;

public class Ville {
	private String name;
	private double[] distance;
	private Map<String, Integer> ref = new HashMap<String, Integer>();
	
	public Ville(String name, double[] distance) {
		this.name = name;
		this.distance = distance;
	}
	public Ville(String name, double[] distance, Map<String,Integer> ref) {
		this.name = name;
		this.distance = distance;
		this.ref = ref;
	}
	public Ville(Ville v) {
		this.name = v.name;
		this.distance = v.distance;
		this.ref = v.ref;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDistance(String ville) {
		return distance[ref.get(ville)];
	}
	public int getID() {
		return(ref.get(this.name));
	}

}
