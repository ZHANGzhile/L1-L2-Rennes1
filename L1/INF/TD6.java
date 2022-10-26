public class TD6{
	public static void afficheTab(int[][] tab){
		for (int i = 0; i < tab.length ; i++ ) {
			for (int j = 0 ;j < tab[i].length ; j++ ) {
				System.out.print(tab[i][j]+" ");
			}System.out.println();
		}
	}

	public static Boolean compareTab(int[][] tab1,int[][] tab2){
		if (tab1.length != tab2.length) {
			return false;
		}else{
		    for (int i = 0 ;i <tab1.length ;i++ ) {
				if (tab1[i].length != tab2[i].length) {
					return false;
				}else {for (int j = 0; j < tab1[i].length ; j++ ) { 
				        if (tab1[i][j] != tab2[i][j]) {
					    return false;
				        }
			        }
			        }
		    }return true;
		}
	}

	public static int[][] copieTab(int[][] tab){
		int[][] tab1 = new int[tab.length][];
		for (int i = 0 ;i <tab.length ;i++ ) {
			tab1[i] = new int[tab[i].length];
			for (int j = 0; j< tab[i].length ; j++ ) {
				tab1[i][j] = tab[i][j]; 
			}
		}return tab1;
	}
	
	public static int sommeLigne(int[][] tab ,int i){
		int somme = 0;
		if (i >= tab.length) {
			return 0 ;
		}
		for (int j = 0; j < tab[i].length ;j++ ) {
			somme = somme + tab[i][j];
		}return somme;
	}
    
    public static int sommeColonne(int[][]tab , int i){
    	int somme = 0;
    	for (int x = 0; x < tab.length ;x++ ) {   
    	    if (i>= tab[x].length) {
    	    	somme = somme ;    	
    	    }else{	    
    	    	somme = somme + tab[x][i];
    	    } 
    	}return somme;
    }

    public static boolean estMagiqueColonne(int[][]tab){
    	int k = tab[0].length;
    	for(int j = 0; j < tab.length;j++){
    		if(k < tab[j].length) k = tab[j].length;
    	}
    	for (int z = 0 ;z < k-1 ; k++ ) {
    		if (sommeColonne(tab,z) != sommeColonne(tab,z+1)) {
    			return false;
    		}
    	}return true;
    }
    public static int[] justtest(){
    	return null;
    }


	public static void main(String[] args) {
		int[][] tab1 = {{1,5,8},{5,1,1},{8,8,5}};
        int[][] tab2 = {{1,2,3},{5,6,},{8,9,0}};
		afficheTab(tab1);
        System.out.println(compareTab(tab1,tab2));
        afficheTab(copieTab(tab1));
        System.out.println(sommeLigne(tab2 , 2));
        System.out.println(sommeColonne(tab2,2));
        System.out.println(estMagiqueColonne(tab1));
        System.out.println(justtest());
	}
}