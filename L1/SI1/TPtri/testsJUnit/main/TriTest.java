package main;

import static org.junit.Assert.*;
import main.Main;

import org.junit.Test;
 
public class TriTest{
	
	// On DOIT utiliser 2 tableaux différents pour tester le résultat de la fonction de tri
	// comme la fonction de tri modifie le tableau passé en argument.
	
		
	@Test
	public void test1(){
		int [] t1= {1};
		int [] t1trie={1};

		Main.tri(t1);
		assertArrayEquals(t1trie, t1);
	}
	

	
}	
	