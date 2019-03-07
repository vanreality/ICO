package algo_list;

import java.util.List;
import java.util.ArrayList;

public class Machine {
	private int dispo; //Available date
	private List<Tache> list; //List of tasks operated in the machine
	private int id; //id of machine
	
	//Constructor
	public Machine(int id) {
		this.dispo = 0;
		this.list = new ArrayList<>();
		this.id = id;
	}
	
	public void addTache(Tache t) {
		//task start when machine is available or task is finished in the previous machine
		if (id != 0 && t.getC(id - 1) > this.dispo) {
			t.setT(id, t.getC(id - 1));
			this.dispo = t.getC(id - 1);
		}
		else t.setT(id, dispo);
		
		this.dispo += t.getP(id);
		t.setC(id, dispo);
		this.list.add(t);
	}
	
	public int getDispo() {
		return dispo;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Machine " + id +  ", dispo = " + dispo + " : \n";
		return s;
	}

	public static void main(String[] args) {
		int[] x = {1, 2, 3};
		Tache t = new Tache(1, x);
		Machine m1 = new Machine(0);
		Machine m2 = new Machine(1);
		Machine m3 = new Machine(2);
		
		m1.addTache(t);
		m2.addTache(t);
		m3.addTache(t);
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}
}
