package algo_list;

public class Ordo {
	public static void main(String[] args) {
		int[][] conf = {{6, 1, 5}, 
						{3, 5, 8},
						{10, 4, 1},
						{14, 6, 3},
						{5, 10, 6},
						{9, 6, 10},
						{7, 9, 12},
						{11, 8, 9},
						{2, 6, 6},
						{3, 1, 7}
						};
		Liste liste0 = new Liste();
		for(int i = 0; i <= 9; i++) {
			liste0.addTache(new Tache(i, conf[i]));
		}
		liste0.triSpt();
		
		Liste liste1 = new Liste();
		Liste liste2 = new Liste();
		
		Machine m0 = new Machine(0);
		Machine m1 = new Machine(1);
		Machine m2 = new Machine(2);
		
		for(Tache t : liste0.list) {
			m0.addTache(t);
			liste1.addTache(t);
		}
		for(Tache t : liste1.list) {
			m1.addTache(t);
			liste2.addTache(t);
		}
		for(Tache t : liste2.list) {
			m2.addTache(t);
		}
		System.out.print(m0);
		System.out.print(m1);
		System.out.print(m2);
	}
}
