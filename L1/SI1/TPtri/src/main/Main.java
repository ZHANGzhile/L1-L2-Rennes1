package main;

import util.ACX;


public class Main {
	//TODO
	public static void tri(int [] t){
		
	}

	// f(x)= x^2/100000
	public static int refQuadratique(int x){return (int) Math.pow(x,2)/100000;}

	// f(x)= x*log(x)/3000
	public static int refLinearithmique(int x){return (int) (x*Math.log(x)/3000);}


	public static void main(String[] args) {
		String[] fun= {"tri"};
		String[] ref= {"refQuadratique","refLinearithmique"};
		ACX.tracerTriInt(fun,ref);		
	}

}
