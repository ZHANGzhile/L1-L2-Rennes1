package main;

import static org.junit.Assert.*;
import main.Main;

import org.junit.Test;
 
public class CorrecteurTest{
	
    String [] t1= {"voiture","hhh","bonjour"};
    String [] d1= {"voiture"};
    String [] d2= {"voiture","hhh","lll"};
    
	@Test
	public void test1(){
		String [] t1= {"toiture","hhh"};
		String [] d1= {"toiture"};
		boolean[] ct= Main.corriger(t1,d1);
		assertTrue(ct[0]);
		assertFalse(ct[1]);
	}
	
	@Test
	public void test2(){
		String [] t1= {"toiture","toiture"};
		String [] d1= {"toiture"};
		boolean[] ct= Main.corriger(t1,d1);
		assertTrue(ct[0]);
		assertTrue(ct[1]);
	}
	
	@Test
	public void test3(){
		String [] t1= {"hhh","jjj"};
		String [] d1= {"toiture"};
		boolean[] ct= Main.corriger(t1,d1);
		assertFalse(ct[0]);
		assertFalse(ct[1]);
	}
	
	@Test
	public void test4(){
		String [] t1= {"toiture","hhh"};
		boolean[] ct= Main.corrigerDico(t1);
		assertTrue(ct[0]);
		assertFalse(ct[1]);
	}
	

    @Test
    public void test5(){
        boolean[] ct= Main.corrigerDico(t1);
        assertTrue(ct[0]);
        assertFalse(ct[1]);
    }
    
    @Test
    public void test6(){
        boolean[] ct= Main.corriger(t1,d1);
        assertTrue(ct[0]);
        assertFalse(ct[1]);
    }
    
    @Test
    public void test7(){
        boolean[] ct= Main.corrigerRapide(t1,d2);
        assertTrue(ct[0]);
        assertTrue(ct[1]);
        assertFalse(ct[2]);
    }
    
    @Test
    public void test8(){
        boolean[] ct= Main.corrigerDicoRapide(t1);
        assertTrue(ct[0]);
        assertFalse(ct[1]);
    }
    String t = "testz";
    @Test
    public void test9(){
        String[] ct= Main.proposerCorrection(t);
    }
	
}	
	
