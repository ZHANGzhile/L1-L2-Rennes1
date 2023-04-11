package tp7;

import static org.junit.Assert.*;

import org.junit.Test;

public class Exe3Test {
	
	@Test
	public void testEstNormal() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
				        {14,2,10,21,9,16,5},
				        {18,19,3,4,7,11,15}};
		int [][]tab2 = {{1,2,3,4,5,6,7},
			            {14,13,12,11,10,9,8}};
		int [][]tab3 = {{1,12,20,8,17,6,13},
		                {14,2,10,22,9,16,5},
		                {18,19,3,4,7,11,15}};
		int [][]tab4 = {{0,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]tab5 = {{1,12,20,8,17,6,13},
        		        {14,2,10,20,9,16,5},
        		        {18,19,3,4,7,11,15}};
		boolean t1 = Exe3.estNormal(tab1);
		boolean t2 = Exe3.estNormal(tab2);
		boolean t3 = Exe3.estNormal(tab3);    
		boolean t4 = Exe3.estNormal(tab4);     
		boolean t5 = Exe3.estNormal(tab5);
		assertEquals(t1,true); // Vérifie que tab1 comme indiqué dans la Figure 1 est normal
		assertEquals(t2,true); 
		assertEquals(t3,false); // sans 21
		assertEquals(t4,false); // sans 1
		assertEquals(t5,false); // double 20's
	}
}