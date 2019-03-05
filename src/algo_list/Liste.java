package algo_list;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Liste {
	public List<Tache> list;
	
	public Liste() {
		this.list = new ArrayList<>();
	}
	
	public Tache getTache(int index) {
		Tache t = new Tache(this.list.get(index));
		return t;
	}
	
	public void addTache(Tache t) {
		this.list.add(t);
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.list.size(); i++) {
			s += this.list.get(i) + "\n";
		}
		return s;
	}
	
	public void triSpt() {
		Collections.sort(list);
	}
}
