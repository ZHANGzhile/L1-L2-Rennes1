package main;

import util.ACX;


public class Main {

	public static int recherche(int cherche, int[] t){
		// A FAIRE!
		for(int i = 0 ; i < t.length ; i++) {
			if(t[i] == cherche) {
				return i;
			}
		}
		return -1;
	}
	public static int recherche2(int cherche , int[] t) {
		int j = 0;
		int i = t.length - 1;
		if(t.length == 0 || cherche > t[i]) return -1;
		if(t.length == 1 && cherche == t[i]) return 0 ;
		if(t.length == 1 && cherche != t[i]) return -1; 
		while(i-j > 0) {
				if(t[j] == cherche) return j;
				if(t[i] == cherche) return i;
				if(i-j == 1) return -1;
				if(cherche < t[j+(i-j)/2]) i =i-(i-j)/2;
				if(cherche > t[j+(i-j)/2]) j =j+(i-j)/2;
				if(cherche == t[j+(i-j)/2]) return j+(i-j)/2;
		}return -1 ;
	}
			
	// Les courbes de référence
	// f(x)=x/4500
	public static int RefLineaire(int x){return x/1500;}
	// f(x)= log(x)
	public static int RefLogarithmique(int x){return (int) Math.log(x);}
	
	public static void main(String[] args) {
		// Ici écrire vos tests.
		int[] tab1= {10,4,-8,2};
		int[] t2 = {1,5,9,8};
		int[] t3 = {1,1,1,2,5,6};
		int[] t4 = {};
		int[] t5 = {1,2,3,4,5,6,7,8,9,};
		int[] t6 = {1};
		int[] t7 = {8,9};
		int cherche=4;
		int cherche1=5;
		int cherche2=6;
		int cherche3=1;
		int cherche4=5;
		int cherche5=6;
		int cherche6=9;
		System.out.println("En cherchant "+cherche+" dans tab1 "+" j'obtiens l'index: "+recherche(cherche,tab1));
		System.out.println("En cherchant "+cherche+" dans t2 "+" j'obtiens l'index: "+recherche(cherche1,t2));
		System.out.println("En cherchant "+cherche+" dans t2 "+" j'obtiens l'index: "+recherche(cherche2,t2));
		System.out.println("En cherchant "+cherche+" dans t3 "+" j'obtiens l'index: "+recherche(cherche3,t3));
		System.out.println("En cherchant "+cherche+" dans t4 "+" j'obtiens l'index: "+recherche(cherche4,t4));
		System.out.println("En cherchant "+cherche+" dans t5 "+" j'obtiens l'index: "+recherche2(cherche5,t5));
		System.out.println("En cherchant "+cherche+" dans t4 "+" j'obtiens l'index: "+recherche2(cherche2,t4));
		System.out.println("En cherchant "+cherche+" dans t4 "+" j'obtiens l'index: "+recherche2(cherche3,t6));
		System.out.println("En cherchant "+cherche+" dans t4 "+" j'obtiens l'index: "+recherche2(cherche6,t7));
		
		// Traçage des courbes de temps de calcul
		String[] fonctions= {"recherche","recherche2"}; 
		String[] reference= {"RefLogarithmique","RefLineaire"};
		ACX.tracerRecherche(fonctions,reference);
	}
}
