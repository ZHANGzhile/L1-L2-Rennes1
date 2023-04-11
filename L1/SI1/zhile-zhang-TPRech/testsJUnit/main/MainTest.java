package main;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
	int[] t= {10,4,-8,2};
	int[] t2 = {1,5,9,8};
	int[] t3 = {1,1,1,2,5,6};
	int[] t4 = {};
	int[] t5 = {1,2,3,4,5,6,7,8,9};
	int[] t6 = {1};
	int[] t7 = {8,9};
	@Test
	public void test1(){
		assertEquals(2,Main.recherche(-8,t));
	}
	
	@Test
	public void test2(){
		assertEquals(-1,Main.recherche(7,t));
	}
	
	// A compl¨¦ter par VOS tests!!
	
	@Test
	public void test3() {
		assertEquals(1,Main.recherche(5,t2));
	}
	@Test
	public void test4() {
		assertEquals(-1,Main.recherche(6,t2));
	}
	@Test
	public void test5() {
		assertEquals(0,Main.recherche(1,t3));
	}
	@Test
	public void test6() {
		assertEquals(-1,Main.recherche(5,t4));
	}
	@Test
	public void test7() {
		assertEquals(5,Main.recherche2(6,t5));
	}
	@Test
	public void test8() {
		assertEquals(-1,Main.recherche2(6,t4));
	}
	@Test
	public void test9() {
		assertEquals(0,Main.recherche2(1,t6));
	}
	@Test
	public void test10() {
		assertEquals(1,Main.recherche2(9,t7));
	}
	@Test
	public void test11() {
		assertEquals(-1,Main.recherche2(1,t7));
	}
	@Test
	public void test12() {
		assertEquals(0,Main.recherche2(1,t5));
	}
	@Test
	public void test13() {
		assertEquals(1,Main.recherche2(2,t5));
	}
	@Test
	public void test14() {
		assertEquals(6,Main.recherche2(7,t5));
	}


	
}	
	
