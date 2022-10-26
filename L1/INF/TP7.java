public class TP7{
	public static void afficheTab2D(int[][] t) {
		for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < t[i].length ; j++) {
				System.out.print(t[i][j]+" ");
			}System.out.println();
		}
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

	public static boolean verifierLignes(int[][] t){
		for (int i = 0; i < t.length-1;i++ ) {
			if (sommeLigne(t,i) != sommeLigne(t,i+1)) {
				return false;
			}
		}return true;
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

    public static boolean verifierColonne(int[][] t){
    	for (int i = 0; i < t[0].length-1;i++ ) {
    		if (sommeColonne(t,i) != sommeColonne(t,i+1)) {
    			return false;
    		}
    	}return true ;
    }

    public static boolean estMagique(int[][] t){
    	if (verifierLignes(t) && verifierColonne(t)) {
    		return true;
    	}else return false;
    }
    
    public static boolean normal(int[][] t , int a){
       for (int i = 0; i < t.length ; i++ ) {
    		    for (int j = 0; j<t[0].length ;j++ ) {
    			    if (t[i][j] == a) {
    				    return true;
    			    }
    		    }
    		}return false;
    }

    public static boolean estNormal(int[][] t){
    	for (int z = 1;z <= t.length*t[0].length;z++ ) {
    		boolean boo = normal(t,z);
    		if (!boo) {
    			return false;
    		}
    	}return true;
    }

	public static int[][] sommeRectangles(int[][] t1 ,int[][] t2){
		int[][] t = new int[t1.length][t1[0].length];
		for (int i =0; i<t.length ;i++ ) {
			for (int j =0;j<t[0].length ;j++ ) {
				t[i][j] = t1[i][j]+t2[i][j];
			}
		}return t;
	}

	public static int[][] symetrieHorizontale(int[][] t){
		int[][] t2 = new int[t.length][t[0].length];
		for (int i = 0;i<t.length;i++ ) {
			for (int j = 0;j<t[0].length;j++ ) {
				t2[i][j] = t[t.length-1-i][j];
			}
		}return t2;
	}

	public static int[][] symetrieVerticale(int[][] t){
		int[][] t2 = new int[t.length][t[0].length];
		for (int i = 0;i<t.length;i++ ) {
			for (int j = 0;j<t[0].length;j++ ) {
				t2[i][j] = t[i][t[0].length-1-j];
			}
		}return t2;
	}

	public static int[][] transpose(int[][] t){
		int[][] t2 = new int[t[0].length][t.length];
		for (int i = 0;i<t2.length;i++ ) {
			for (int j = 0;j<t2[0].length;j++ ) {
				t2[i][j] = t[j][i];
			}
		}return t2;
	}

	public static int[][] rotation(int[][] t){
		int[][] t2 = transpose(t);
		int[][] t3 = symetrieHorizontale(t2);
		return t3;
	}

	public static void main(String[] args) {
		int[][] rectangle = {{1, 12, 20, 8, 17, 6, 13}, 
    			 			 {14, 2, 10, 21, 9, 16, 5}, 
    			 			 {18, 19, 3, 4, 7, 11, 15}};
		afficheTab2D(rectangle);
		System.out.println(verifierLignes(rectangle));
		System.out.println(verifierColonne(rectangle));
		System.out.println(estMagique(rectangle));
		System.out.println(estNormal(rectangle));
		afficheTab2D(sommeRectangles(rectangle,rectangle));
		System.out.println("**************************************");
		afficheTab2D(symetrieHorizontale(rectangle));
		System.out.println("**************************************");
		afficheTab2D(symetrieVerticale(rectangle));
		System.out.println("**************************************");
		afficheTab2D(transpose(rectangle));
		System.out.println("**************************************");
		afficheTab2D(rotation(rectangle));
	}
}