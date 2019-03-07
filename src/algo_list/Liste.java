package algo_list;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Liste {
	public List<Tache> list;
	
	public Liste() {
		this.list = new ArrayList<>();
	}
	
	public void addTache(Tache t) {
		this.list.add(t);
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.list.size(); i++) {
			s += this.list.get(i) + "\n";
		}
		return s;
	}
	
	static class DureeTotalComparator implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			Tache t1 = (Tache) o1;
			Tache t2 = (Tache) o2;
			int p1 = t1.getP(0) + t1.getP(1) + t1.getP(2);
			int p2 = t2.getP(0) + t2.getP(1) + t2.getP(2);
			return p1 - p2;
		}
		
	}
	
	public void triSpt() {
		Collections.sort(list);
	}
	
	public void triDt() {
		Collections.sort(list, new DureeTotalComparator());
	}
}
