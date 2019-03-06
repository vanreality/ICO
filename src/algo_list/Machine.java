package algo_list;

import java.util.List;
import java.util.ArrayList;

public class Machine {
	private int dispo; //available date
	private List<Tache> list;
	private int num;
	
	public Machine(int num) {
		this.dispo = 0;
		this.list = new ArrayList<>();
		this.num = num;
	}
	
	public void addTache(Tache t) {
		if (num != 0 && t.getC(num - 1) > this.dispo) {
			t.setT(num, t.getC(num - 1));
			this.dispo = t.getC(num - 1);
		}
		else t.setT(num, dispo);
		
		this.dispo += t.getP(num);
		t.setC(num, dispo);
		this.list.add(t);
	}
	
	public int getDispo() {
		return dispo;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Machine " + num +  ", dispo = " + dispo + " : \n";
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
