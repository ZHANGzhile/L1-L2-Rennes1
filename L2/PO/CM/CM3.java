package CM3;

import java.util.Arrays;

public class CM3 {

	public static int fibonacci(int n) {
		if((n==0)||(n==1)) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] tab = new int[5][5];
		for (int i=0 ; i<5 ; i++)
			for (int j=0 ; j<5 ; j++)
				tab[i][j]= i*5+j;
	
	
		for (int[] ligne : tab){
		System.out.println(Arrays.toString(ligne));
		//System.out.println(ligne);
		}
	
	//////////////** l'Objet ** //////////////////////
		
		
	

	}
}
