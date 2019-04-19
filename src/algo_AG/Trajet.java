package algo_AG;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Trajet implements Comparable {
	private List<Ville> etapes = new ArrayList<Ville>();
	private int fitness;
	private int nbVilles;
	private Map<String, Integer> ref = new HashMap<String, Integer>();
	
	
	public Trajet(Ville[] carte) {      //create new random trip
		this.nbVilles = carte.length;
		Ville temp;
		for(int i=0;i<nbVilles;i++) {
			etapes.add(new Ville(carte[i]));
		}
		Collections.shuffle(etapes);
		for(int j = 0;j<etapes.size();j++) {
			if(etapes.get(j).getName()=="Bordeaux") {
				temp = etapes.get(j);
				etapes.remove(j);
				etapes.add(0, temp);
			}
		}
		this.calculateFitness();
	}
	
	public Trajet(int n) {
		List<String> noms = new ArrayList<String>();
		List<double[]> distances = new ArrayList<double[]>();
		List<Ville> carte = new ArrayList<Ville>();
		double[] temp;
		// The name of the file to open.
        String fileName = "Liste-villes.txt";
        String fileName2 ="Liste-noms.txt";
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	line = line.substring(1, line.length()-2);
            	temp = Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();
            	distances.add(temp);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader2 = 
                new FileReader(fileName2);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader2 = 
                new BufferedReader(fileReader2);

            while((line = bufferedReader2.readLine()) != null) {
            	noms = new ArrayList<String>(Arrays.asList(line.split(",")));
            }   


            // Always close files.
            bufferedReader2.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        for(int j = 0; j< noms.size();j++) {
        	ref.put(noms.get(j), j);
        }
        for(int i = 0; i< noms.size();i++) {
        	carte.add(new Ville(noms.get(i), distances.get(i),ref));
        }
        this.nbVilles = carte.toArray().length;
		Ville tempo;
		for(int i=0;i<nbVilles;i++) {
			etapes.add(new Ville((Ville)carte.toArray()[i]));
		}
		Collections.shuffle(etapes);
		for(int j = 0;j<etapes.size();j++) {
			if(etapes.get(j).getName()=="BORDEAUX") {
				tempo = etapes.get(j);
				etapes.remove(j);
				etapes.add(0, tempo);
			}
		}
		this.calculateFitness();
        
    
	}
	
	
	public Trajet(Trajet t1, Trajet t2) {
		List<Ville> inter = new ArrayList<Ville>();		
		for(int i = 0; i<Math.min(t2.getnbVilles(),t1.getnbVilles());i++) {
			System.out.println(t1.getEtapes().size());
			inter.add(new Ville(t1.getEtapes().get(i)));
			inter.add(new Ville(t2.getEtapes().get(i)));
		}

		boolean present=false;
		int j;
		for(int i =0; i<inter.size();i++) {
			for(j =0; j<this.etapes.size();j++) {
				if(this.etapes.get(j).getName()==inter.get(i).getName())
					present=true;
			}
			if(present == false)
				this.etapes.add(inter.get(i));
			present=false;
			
		}
		
		this.nbVilles = this.etapes.size();
		this.calculateFitness();
	}
	public void calculateFitness() {
		this.fitness = 0;
		for(int i=0;i<nbVilles-1;i++) {
			this.fitness+=etapes.get(i).getDistance(etapes.get(i+1).getName());
		}
		this.fitness+=etapes.get(0).getDistance(etapes.get(etapes.size()-1).getName());
	}
	public int getFitness() {
		return this.fitness;
	}
	public int getnbVilles() {
		return this.nbVilles;
	}
	public List<Ville> getEtapes() {
		return this.etapes;
	}
	public String toString() {
		String s="";
		for(Ville v : etapes) {
			s+= v.getName()+", ";
		}
			
		return s+etapes.get(0).getName()+"  "+this.fitness;

	}
	@Override
	public int compareTo(Object arg0) {
		
		return ((Trajet)arg0).getFitness()-this.fitness;
	}
	public Trajet Reproduction(Trajet tr) {
		Trajet enfant = new Trajet(this, tr);
		
		return enfant;
	}
	public void echange(int nb1, int nb2) {
		Collections.swap(this.etapes, nb1, nb2);
		this.calculateFitness();
	}
}
