public class TP5{
	//public class Ex1
	public static int[] copieTableau(int[] tab){
		// TODO: écrivez ici le code de la question 1.a
		int[] tab1 = new int[tab.length];
		for(int i = 0 ; i < tab.length ; i++) {
			tab1[i]= tab[i]; 
		}
		return tab1; 
	}	

	public static int[] sousTableau(int[] tab, int i, int j){
		// TODO: écrivez ici le code de la question 1.b
		int[] tab2 = new int[(j-i)+1];
		for(int z = 0 ;z <= j-i ; z++) {
			tab2[z]= tab[z+i];			
		}
		return tab2;  
	}	

	public static int[] concatenation(int[] tab1, int[] tab2){
		// TODO: écrivez ici le code de la question 1.c
		int[] tab3 = new int[tab1.length+tab2.length];
		for(int i = 0 ;i < tab1.length ;i++) {
			 tab3[i] = tab1[i];
		}
		for(int j = 0 ; j < tab2.length ; j++ ) {
			tab3[j+tab1.length] = tab2[j];
		}
		return tab3;  // à modifier
	}

	public static int[] fusion(int[] tab1, int[] tab2){
		// Challenge: écrivez ici le code de la question 1.d
		int[] tab3 = new int[tab1.length+tab2.length];
		int j = 0; int z = 0;
		for(int i = 0 ; i < tab3.length ;) {
			if(j < tab1.length) {
				tab3[i] = tab1[j];
				i++;
				j++;
			}
			if(z < tab2.length) {
				tab3[i] = tab2[z];
				z++;
				i++;
			}
		}
		return tab3;  // à modifier
	}

	// NE PAS MODIFIER
	// Fonction auxiliaire fournie pour vous aider à tester
	// Usage : afficheTableau(tab) vous permet d'afficher les éléments du tableau tab
	public static void afficheTableau(int[] tab) {
		for(int i = 0 ; i < tab.length ; i++) {
			System.out.print(tab[i]+" ");
		}System.out.println();		
	}
	
	
	/*public static void main(String[] args) {

		int[] t1 = {1,0,6,8,6,9,2,2,6};
		int[] t2 = {5,6,9,4,1,5,6,8,4,5};

		// Faites vos propres tests ici à l'aide des tableaux ci-dessus et de la fonction afficheTableau fournie
		afficheTableau(copieTableau(t1));
		System.out.println();
		afficheTableau(sousTableau(t1,3,6));
		System.out.println();
		afficheTableau(concatenation(t1,t2));
		System.out.println();
		afficheTableau(fusion(t1,t2));
		
		// Exécutez les tests dans Exe1Test.java (clic-droit -> Run as -> JUnit test)
		// Chaque fois que vous faites une question, ne regardez que le test qui correspond, et pas les suivants
		// (ils vont automatiquement échouer, c'est normal : vous n'avez pas encore écrit de code pour les questions suivantes)

		
	}*/

    //Ex2

   	// Challenge : écrivez ici la fonction "fusionTrie" de la question 2.a
    public static int[] fusionTrie(int []tab1 , int[]tab2) {
    	int[] tab3 = new int[tab1.length+tab2.length];
    	int j = 0;
    	int z = 0;
    	for(int i = 0 ; i < tab3.length ; i++) {
    		if(z < tab1.length && j < tab2.length) {
    		    if(tab1[z] < tab2[j]) {
    			    tab3[i]=tab1[z];
    			    z++;}
    		    else if(tab1[z] == tab2[j]) {
    			    tab3[i]=tab2[j];
    			    i++;
    			    tab3[i]=tab2[j];
    			    j++;
    			    z++;}
    		}else{
    			if(j < tab2.length) {
    			tab3[i]=tab2[j];
    			j++;}
    		}
    	}return tab3;
    }

	
	
	// NE PAS MODIFIER
	// Fonction auxiliaire fournie pour vous aider à tester
	// Usage : afficheTableau(tab) vous permet d'afficher les éléments du tableau tab
	
	

	/*public static void main(String[] args) {
		int[] t1 = {2,5,6,6}; // trié
		int[] t2 = {3,3,2,4}; // non trié
		int[] t3 = {1,2,3,4,5}; // trié
		
		afficheTableau(fusionTrie(t1,t3));


		// Faites vos propres tests ici à l'aide des tableaux ci-dessus et de la fonction afficheTableau fournie
		
		// Exécutez les tests dans Exe2Test.java (clic-droit -> Run as -> JUnit test)
		// Chaque fois que vous faites une question, ne regardez que le test qui correspond, et pas les suivants
		// (ils vont automatiquement échouer, c'est normal : vous n'avez pas encore écrit de code pour les questions suivantes)

		
	} */



    //public class Exe3 {

	// NE PAS MODIFIER
	// Fonction auxiliaire fournie
	// Usage : premiereOccurrence(tab,a) renvoie l'indice de la première occurrence de a dans tab, ou -1 si a n'apparaît pas
	public static int premiereOccurrence(int[] tab, int a) {
		for(int i = 0 ; i < tab.length ; i++) {
			if(tab[i] == a) {
				return i;
			}
		}
		return -1;
	}


	public static boolean estPermutation (int[] tab){
		// TODO: écrivez ici le code de la question 3.a
		for(int i = 0; i < tab.length ; i++) {
			if(premiereOccurrence(tab,i) == -1) return false;
		}
		return true; // à modifier
	}
	

   	// TODO : écrivez ici la fonction "compose" de la question 3.b
	public static int[] compose(int[] tab1,int[] tab2) {
		int[] tab3 = new int[tab1.length];
		for(int i = 0; i < tab3.length ; i++) {
			tab3[i]=tab2[tab1[i]];
		}
		return tab3;
	}

	
   	// Challenge : écrivez ici la fonction "itere" de la question 3.c
	/*public static int itere(int[] tab,int i ,int k) {
		
	}*/

	
   	// TODO : écrivez ici la fonction "inverse" de la question 3.d
	public static int[] inverse(int[]tab) {
		int[] tab1 = new int[tab.length];
		int j ;
		for(int i = 0 ; i < tab1.length ; i++) {
			j = tab[i];
			tab1[j] = i ;
		}return tab1;
	}


	
	
	// NE PAS MODIFIER
	// Fonction auxiliaire fournie pour vous aider à tester
	// Usage : afficheTableau(tab) vous permet d'afficher les éléments du tableau tab
	

	public static void main(String[] args) {
        
		int[] t11 = {1,0,6,8,6,9,2,2,6};
		int[] t12 = {5,6,9,4,1,5,6,8,4,5};

		// Faites vos propres tests ici à l'aide des tableaux ci-dessus et de la fonction afficheTableau fournie
		afficheTableau(copieTableau(t11));
	
		afficheTableau(sousTableau(t11,3,6));
		
		afficheTableau(concatenation(t11,t12));
		
		afficheTableau(fusion(t11,t12));
		
		// Exécutez les tests dans Exe1Test.java (clic-droit -> Run as -> JUnit test)
		// Chaque fois que vous faites une question, ne regardez que le test qui correspond, et pas les suivants
		// (ils vont automatiquement échouer, c'est normal : vous n'avez pas encore écrit de code pour les questions suivantes)


        int[] t21 = {2,5,6,6}; // trié
		int[] t22 = {3,3,2,4}; // non trié
		int[] t23 = {1,2,3,4,5}; // trié
		
		
		afficheTableau(fusionTrie(t21,t23));


		// Faites vos propres tests ici à l'aide des tableaux ci-dessus et de la fonction afficheTableau fournie
		
		// Exécutez les tests dans Exe2Test.java (clic-droit -> Run as -> JUnit test)
		// Chaque fois que vous faites une question, ne regardez que le test qui correspond, et pas les suivants
		// (ils vont automatiquement échouer, c'est normal : vous n'avez pas encore écrit de code pour les questions suivantes)



		int[] t31 = {1,3,4,2,0}; // permutation
		int[] t32 = {5,2,3}; // pas une permutation
		int[] t33 = {1,0,2,4,3}; // permutation
		
		
		System.out.println(estPermutation(t31));
		System.out.println(estPermutation(t32));
		System.out.println(estPermutation(t33));
		afficheTableau(compose(t31,t33));
	
		afficheTableau(inverse(t31));
		
		// Faites vos propres tests ici à l'aide des tableaux ci-dessus et de la fonction afficheTableau fournie
		
		// Exécutez les tests dans Exe3Test.java (clic-droit -> Run as -> JUnit test)
		// Chaque fois que vous faites une question, ne regardez que le test qui correspond, et pas les suivants
		// (ils vont automatiquement échouer, c'est normal : vous n'avez pas encore écrit de code pour les questions suivantes)

		
		// Bonus : écrivez ici les exemples pour la question 3.e
	}

}