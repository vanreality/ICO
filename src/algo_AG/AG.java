package algo_AG;

public class AG {
 
		
		
	public static void main(String[] args) {
		Ville[] carte = new Ville[] {new Ville("Bordeaux", new int[] {0,780,320,580,480,660}),
				new Ville("Lyon", new int[] {780,0,700,460,300,200}),
				new Ville("Nantes", new int[] {320,700,0,380,820,630}),
				new Ville("Paris", new int[] {580,460,380,0,750,310}),
				new Ville("Marseille", new int[] {480,300,820,750,0,500}),
				new Ville("Dijon", new int[] {660,200,630,310,500,0}),
				};
		int generations = 50;
		int n = 20;	
		Population population = new Population(n, carte);
		System.out.print(population+"\n\n");
		population.Selection();
		System.out.print(population+"\n\n");
	}

}
