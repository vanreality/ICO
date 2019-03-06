package algo_list;

public class Ordo {
	public static void drawGantt(Liste liste) {
		String s = "Gantt\n";
		String s0 = "";
		String s1 = "|";
		String s2 = "|";
		String s3 = "|";
		int l = liste.list.get(liste.list.size() - 1).getC(2) + liste.list.size() - 3;
		s0 = "+" + "-".repeat(l) + "+\n";
		for(Tache t : liste.list) {
			int count1 = t.getT(0) - s1.length() + 1;
			int count2 = t.getT(1) - s2.length() + 1;
			int count3 = t.getT(2) - s3.length() + 1;
			
			if(count2 > 0 && count3 > 0) s3 += "+"; 
			if(count1 > 0) s1 += "+".repeat(count1) + "|";
			if(count2 > 0) s2 += "+".repeat(count2) + "|";
			if(count3 > 0) s3 += "+".repeat(count3) + "|";
			
			s1 += String.format("%" + t.getP(0) + "s|", t.getID());
			s2 += String.format("%" + t.getP(1) + "s|", t.getID());
			s3 += String.format("%" + t.getP(2) + "s|", t.getID());
		}
		s1 += "\n";
		s2 += "\n";
		s3 += "\n";
		s += s0 + s1 + s0 +s2 + s0 +s3 + s0;
		System.out.print(s);
	}
	
	public static void main(String[] args) {
		int[][] conf = {{ 6,  1,  5}, 
						{ 3,  5,  8},
						{10,  4,  1},
						{14,  6,  3},
						{ 5, 10,  6},
						{ 9,  6, 10},
						{ 7,  9, 12},
						{11,  8,  9},
						{ 2,  6,  6},
						{ 3,  1,  7}};
		
		Liste liste = new Liste();
		
		for(int i = 0; i <= 9; i++) {
			liste.addTache(new Tache(i, conf[i]));
		}
		liste.triSpt();
//		liste.triDt();
		
		Machine m0 = new Machine(0);
		Machine m1 = new Machine(1);
		Machine m2 = new Machine(2);
		
		for(Tache t : liste.list) {
			m0.addTache(t);
			m1.addTache(t);
			m2.addTache(t);
		}
		
		System.out.print(m0);
		System.out.print(m1);
		System.out.print(m2);
		System.out.print(liste + "\n");
		
		drawGantt(liste);
	}
}
