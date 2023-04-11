package main;

import static org.junit.Assert.*;
import main.Main;

import org.junit.Test;
 
public class CorrecteurTest{
	String [] t1= {"toiture","hhh"};
	String [] d1= {"toiture"};
	
	@Test
	public void test1(){
		boolean[] ct= Main.corriger(t1,d1);
		assertTrue(ct[0]);
		assertFalse(ct[1]);
	}
	
	@Test
	public void test2(){
		boolean[] ct= Main.corrigerDico(t1);
		assertTrue(ct[0]);
		assertFalse(ct[1]);
	}
	
}	
	
