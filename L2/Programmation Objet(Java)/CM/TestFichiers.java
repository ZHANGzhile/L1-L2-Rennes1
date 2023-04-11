import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFichiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Path chemin = Paths.get("C:\\Users\\termier\\OneDrive\\Travail\\Enseignement\\PO\\CodesPO\\PO 2021\\src\\UE.java");
		
		Path chemin = Paths.get("C:\\Users\\termier\\Matome\\Z_Archives\\Enseignement\\2011_2012\\M2PGI\\Rendus\\TP1\\Djamel-Eddine-Boumchedda-TP-Hadoop\\5tomes_des_Miserables_de_VictorHugo\\LesMiserables_T1.txt");
		
		
		try {
			System.out.println(Files.getLastModifiedTime(chemin));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListeLignes lst = new ListeLignes();

		try (BufferedReader reader = Files.newBufferedReader(chemin)) {
			
			int cpt = 0;
			String line = null;
			while (((line = reader.readLine()) != null) ) {
				//System.out.println(line);
				lst.ajouteLigne(line);
				cpt++;
			}
			
			System.out.println(lst);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		

	}

}
