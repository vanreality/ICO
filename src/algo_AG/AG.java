package algo_AG;

public class AG {
 
		
		
	public static void main(String[] args) {
		Ville[] carte = new Ville[] {new Ville("Bordeaux", new double[] {0,780,320,580,480,660}),
				new Ville("Lyon", new double[] {780,0,700,460,300,200}),
				new Ville("Nantes", new double[] {320,700,0,380,820,630}),
				new Ville("Paris", new double[] {580,460,380,0,750,310}),
				new Ville("Marseille", new double[] {480,300,820,750,0,500}),
				new Ville("Dijon", new double[] {660,200,630,310,500,0}),
				};
		ReadCsv rc = new ReadCsv();
		int generations = 100;
		int n = 10;	
		double p = 0.2;
		Population population = new Population(n, carte);

		for(int i =0;i<generations;i++) {
		population.Selection();

		population.Reproduction(n);
		
		population.Mutation(p);
		}
		population.tri();
		System.out.println(population.best());
	}

}
