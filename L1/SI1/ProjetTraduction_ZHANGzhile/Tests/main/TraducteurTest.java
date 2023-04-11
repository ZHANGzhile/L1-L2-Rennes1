package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TraducteurTest {
	@Before
	public void init(){
		// Si des initialisations sont nécessaires avant de réaliser les tests
		// les lancer ici
	}
	

	@Test
	public void test1(){
		String [] t1= {"je","chercher"};
		String [] t1Attendu= {"I","look for"};
		
		String [] t1Traduit= Main.traduire(t1);
		assertArrayEquals(t1Attendu, t1Traduit);
	}
}
