package algo_list;

import java.util.Arrays;

public class Tache implements Comparable<Tache>{
	private final int id;
	private final int[] p;
	private int[] t = {0, 0, 0};
	private int[] C = {0, 0, 0};
	
	public Tache(int id, int[] p) {
		this.id = id;
		this.p = p;
	}
	
	public Tache(Tache t) {
		this.id = t.id;
		this.p = t.p;
		this.t = t.t;
		this.C = t.C;
	}

	//Getters and setters
	public int getT(int num) {
		return t[num];
	}

	public void setT(int num, int t) {
		this.t[num] = t;
	}

	public int getC(int num) {
		return C[num];
	}

	public void setC(int num, int c) {
		this.C[num] = c;
	}

	public int getP(int num) {
		return p[num];
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
		return this.p[0] - o.p[0];
	}
}
