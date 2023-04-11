package tp7;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Exe4Test {
	
	@Test
	public void testSommeRectangles() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]tab2 = {{-1,-12,-20,-8,-17,-6,-13},
		        		{-14,-2,-10,-21,-9,-16,-5},
		        		{-18,-19,-3,-4,-7,-11,-15}};
		int [][]exp    = {{0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0}};

		int [][]t1 = Exe4.sommeRectangles(tab1,tab2);
		
		Assert.assertArrayEquals(exp, t1); // Vérifie que exp==t1 

	}
	
	@Test
	public void testSymetrieHorizontale() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]exp1 = {{18,19,3,4,7,11,15},
        				{14,2,10,21,9,16,5},
        				{1,12,20,8,17,6,13}};
		int [][]tab2 = {{1,1,1,1,1,1,1,1},
        				{2,2,2,2,2,2,2,2},
        				{3,3,3,3,3,3,3,3},
        				{4,4,4,4,4,4,4,4}};
		int [][]exp2 = {{4,4,4,4,4,4,4,4},
						{3,3,3,3,3,3,3,3},
						{2,2,2,2,2,2,2,2},
						{1,1,1,1,1,1,1,1}};
		int [][]tab3 = {{1,2,3,4,5,6,7,8}};
		int [][]exp3 = {{1,2,3,4,5,6,7,8}};

		int [][]t1 = Exe4.symetrieHorizontale(tab1);
		int [][]t2 = Exe4.symetrieHorizontale(tab2);
		int [][]t3 = Exe4.symetrieHorizontale(tab3);
		
		Assert.assertArrayEquals(exp1, t1); // Vérifie que exp1==t1 (comme exemple dans 4.b)
		Assert.assertArrayEquals(exp2, t2); // 4*8
		Assert.assertArrayEquals(exp3, t3); // 1*8
	}
	
	@Test
	public void testSymetrieVerticale() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]exp1 = {{13,6,17,8,20,12,1},
        				{5,16,9,21,10,2,14},
        				{15,11,7,4,3,19,18}};
		int [][]tab2 = {{1,2,3,4,5,6,7,8},
        				{1,2,3,4,5,6,7,8},
        				{1,2,3,4,5,6,7,8},
        				{1,2,3,4,5,6,7,8}};
		int [][]exp2 = {{8,7,6,5,4,3,2,1},
						{8,7,6,5,4,3,2,1},
						{8,7,6,5,4,3,2,1},
						{8,7,6,5,4,3,2,1}};
		int [][]tab3 = {{1},
						{2},
						{3},
						{4},
						{5},
						{6},
						{7},
						{8}};
		int [][]exp3 = {{1},
						{2},
						{3},
						{4},
						{5},
						{6},
						{7},
						{8}};

		int [][]t1 = Exe4.symetrieVerticale(tab1);
		int [][]t2 = Exe4.symetrieVerticale(tab2);
		int [][]t3 = Exe4.symetrieVerticale(tab3);
		
		Assert.assertArrayEquals(exp1, t1); // Vérifie que exp1==t1 (comme exemple dans 4.c)
		Assert.assertArrayEquals(exp2, t2); // 4*8
		Assert.assertArrayEquals(exp3, t3); // 8*1
	}
	
	@Test
	public void testTranspose() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]exp1 = {{1,14,18},
        				{12,2,19},
						{20,10,3},
						{8,21,4},
						{17,9,7},
						{6,16,11},
						{13,5,15}};
		int [][]tab2 = {{1,1,1,1,1,1,1,1},
        				{2,2,2,2,2,2,2,2},
        				{3,3,3,3,3,3,3,3},
        				{4,4,4,4,4,4,4,4}};
		int [][]exp2 = {{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4},
						{1,2,3,4}};
		int [][]tab3 = {{1,2,3,4,5,6,7,8}};
		int [][]exp3 = {{1},
						{2},
						{3},
						{4},
						{5},
						{6},
						{7},
						{8}};
		int [][]tab4 = {{1},
						{2},
						{3},
						{4},
						{5},
						{6},
						{7},
						{8}};
		int [][]exp4 = {{1,2,3,4,5,6,7,8}};

		int [][]t1 = Exe4.transpose(tab1);
		int [][]t2 = Exe4.transpose(tab2);
		int [][]t3 = Exe4.transpose(tab3);
		int [][]t4 = Exe4.transpose(tab4);
		
		Assert.assertArrayEquals(exp1, t1); // Vérifie que exp1==t1 (comme exemple dans 4.d)
		Assert.assertArrayEquals(exp2, t2); // 4*8
		Assert.assertArrayEquals(exp3, t3); // 1*8
		Assert.assertArrayEquals(exp4, t4); // 8*1
	}
	
	@Test
	public void testRotation() {
		int [][]tab1 = {{1,12,20,8,17,6,13},
                		{14,2,10,21,9,16,5},
                		{18,19,3,4,7,11,15}};
		int [][]exp1 = {{13,5,15},
						{6,16,11},
						{17,9,7},
						{8,21,4},
						{20,10,3},
						{12,2,19},
						{1,14,18}};
		int [][]tab2 = {{1,2,3,4,5,6,7,8},
        				{2,3,4,5,6,7,8,9},
        				{3,4,5,6,7,8,9,10},
        				{4,5,6,7,8,9,10,11}};
		int [][]exp2 = {{8,9,10,11},
						{7,8,9,10},
						{6,7,8,9},
						{5,6,7,8},
						{4,5,6,7},
						{3,4,5,6},
						{2,3,4,5},
						{1,2,3,4}};
		int [][]tab3 = {{1,2,3,4,5,6,7,8}};
		int [][]exp3 = {{8},
						{7},
						{6},
						{5},
						{4},
						{3},
						{2},
						{1}};
		int [][]tab4 = {{1},
						{2},
						{3},
						{4},
						{5},
						{6},
						{7},
						{8}};
		int [][]exp4 = {{1,2,3,4,5,6,7,8}};
		int [][]tab5 = {{1}};
		int [][]exp5 = {{1}};

		int [][]t1 = Exe4.rotation(tab1);
		int [][]t2 = Exe4.rotation(tab2);
		int [][]t3 = Exe4.rotation(tab3);
		int [][]t4 = Exe4.rotation(tab4);
		int [][]t5 = Exe4.rotation(tab5);
		
		Assert.assertArrayEquals(exp1, t1); // Vérifie que exp1==t1 (comme exemple dans 4.b)
		Assert.assertArrayEquals(exp2, t2); // 4*8
		Assert.assertArrayEquals(exp3, t3); // 1*8
		Assert.assertArrayEquals(exp4, t4); // 8*1
		Assert.assertArrayEquals(exp5, t5); // 1*1
	}
	
}