package tp7;

import static org.junit.Assert.*;

import org.junit.Test;

public class Exe2Test {
	
	@Test
	public void testVerifierLignes() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
				        {14,2,10,21,9,16,5},
				        {18,19,3,4,7,11,15}};
		int [][]tab2 = {{1,2,3,4,5,6,7,8,9},
			            {9,8,7,6,5,4,3,2,1},
			            {5,5,5,5,5,5,5,5,5}};
		int [][]tab3 = {{1,2,3,4,5,6,7},
		                {7,6,5,4,3,2,1},
		                {4,4,4,3,4,4,4}};
		boolean t1 = Exe2.verifierLignes(tab1);
		boolean t2 = Exe2.verifierLignes(tab2);
		boolean t3 = Exe2.verifierLignes(tab3);
		assertEquals(t1,true); // Vérifie pour tab1 comme indiqué dans la Figure 1 
		assertEquals(t2,true); 
		assertEquals(t3,false); 
	}
	
	@Test
	public void testVerifierColonnes() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
				        {14,2,10,21,9,16,5},
				        {18,19,3,4,7,11,15}};
		int [][]tab2 = {{1,2,3,4,5,6,7,8,9},
	            		{9,8,7,6,5,4,3,2,1},
	            		{5,5,5,5,5,5,5,5,5}};
		int [][]tab3 = {{1,2,3,4,5,6,7},
		                {7,6,5,4,3,2,1},
		                {4,4,4,3,4,4,4}};
		boolean t1 = Exe2.verifierColonnes(tab1);
		boolean t2 = Exe2.verifierColonnes(tab2);
		boolean t3 = Exe2.verifierColonnes(tab3);
		assertEquals(t1,true); // Vérifie pour tab1 comme indiqué dans la Figure 1 
		assertEquals(t2,true); 
		assertEquals(t3,false); 
	}
	
	@Test
	public void testEstMagique() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
				        {14,2,10,21,9,16,5},
				        {18,19,3,4,7,11,15}};
		int [][]tab2 = {{1,2,3,4,5,6,7,8,9},
        				{9,8,7,6,5,4,3,2,1},
        				{5,5,5,5,5,5,5,5,5}};
		int [][]tab3 = {{1,2,3,4,5,6,7},
		                {6,5,4,3,2,1,7},
		                {4,4,4,4,4,4,4}};
		boolean t1 = Exe2.estMagique(tab1);
		boolean t2 = Exe2.estMagique(tab2);
		boolean t3 = Exe2.estMagique(tab3);
		assertEquals(t1,true); // Vérifie que tab1 comme indiqué dans la Figure 1 est magique 
		assertEquals(t2,true); 
		assertEquals(t3,false); // true pour linges et false pour colonnes
	}
}