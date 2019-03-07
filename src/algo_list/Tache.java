package algo_list;

import java.util.Arrays;

public class Tache implements Comparable<Tache>{
	private final int id;
	private final int[] p; //array of the execution time
	private int[] t = {0, 0, 0}; //array of the begin dates
	private int[] C = {0, 0, 0}; //array of the finish dates
	
	public Tache(int id, int[] p) {
		this.id = id;
		this.p = p;
	}

	//Getters and setters
	public int getT(int id) {
		return t[id];
	}

	public void setT(int id, int t) {
		this.t[id] = t;
	}

	public int getC(int id) {
		return C[id];
	}

	public void setC(int id, int c) {
		this.C[id] = c;
	}

	public int getP(int id) {
		return p[id];
	}
	
	public int getID() {
		return id;
	}

	@Override
	public String toString() {
		return "Tache " +  id + " [p=" + Arrays.toString(p) + ", t=" + Arrays.toString(t) + ", C=" + Arrays.toString(C) + "]";
	}

	@Override
	public int compareTo(Tache o) {
		//compare the execution time of the first machine
		return this.p[0] - o.p[0];
	}
}
