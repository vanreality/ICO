package algo_AG;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCsv {
    public ReadCsv() {
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
    
}
}
