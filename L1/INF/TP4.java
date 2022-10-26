public class TP4{
	public static void main(String[] args) {
		int[] tab ={1,2,3,4,5,1,2,3,4,5};
        //premiereOccurrence(tab,3);
		System.out.println(premiereOccurrence(tab,3));
	System.out.println("***********************************");
		echange(tab,3,2);
		for (int i = 0;i < tab.length ;i++ ) {
			System.out.print(tab[i]);
		}
	System.out.println();
	System.out.println("***********************************");
		System.out.println(nombreOccurrence(tab,5));
	System.out.println("***********************************");
		remplace(tab,5,1);
        for (int j = 0; j < tab.length ;j++ ) {
            System.out.print(tab[j]);
        }
	System.out.println();
	System.out.println("***********************************");
        int[] tab1 ={1,2,3,4,5};
        int[]tab2=miroirCopie(tab1);
        for (int z = 0; z < tab2.length ; z++) {
            System.out.print(tab2[z]);
        }
    System.out.println();
    System.out.println("***********************************");
        miroirEnPlace(tab1);
        for (int x = 0; x < tab1.length ;x++ ) {
            System.out.print(tab1[x]);
        }
	}

    
    /*public static void echange(int[]tab ,int i,int j){    	
    	int a = tab[i];
    	tab [i] = tab [j];
        tab [j] = a;
        for (int b = 0 ;b < tab.length ;b++ ) {
        	System.out.print(tab[b]+" ");
        }
    }*/

    public static void echange(int[]tab,int i,int j){
    	int a = tab[i];
    	tab[i]=tab[j];
    	tab[j]=a;
    }

    /*public static void premiereOccurrence(int[] tab,int a){
    	for (int i = 0;i < tab.length ;i++ ) {
    		if (tab[i] == a) {
    			System.out.println(i);
    			break;
    		}
    	}
    }*/

    public static int premiereOccurrence(int[] tab,int a){
        for (int i = 0;i < tab.length ;i++ ) {
            if (tab[i] == a) {
                return i;
            }
        }return -1;
    }

    public static int nombreOccurrence(int[] tab , int a){
        int j = 0;
    	for (int i = 0;i < tab.length ;i++ ) {
    		if (tab[i] == a) {
    			j = j+1;
    		}
    	}return j ;
    }

    public static void remplace(int[] tab,int a,int b){
    	for (int i = 0;i < tab.length ;i++ ) {
    		if (tab[i] == a) {
    			tab[i] = b;
    		}//System.out.print(tab[i]+" ");
    	}
    }

    /*public static void miroirCopie(int[] tab){
    	for (int i = 0;i <= tab.length / 2; i++ ) {
    		    int a = tab[i];
    		    tab[i] = tab[tab.length - (i+1)];   			
    		    tab[tab.length - (i+1)] = a;
    		System.out.print(tab[i]+" ");
    	}
    	for (int j = (tab.length / 2)+1; j < tab.length  ; j++) {
    		System.out.print(tab[j]+" ");
    	}
    }*/

    public static int[] miroirCopie(int[] tab){
        int[] tab2 = new int[tab.length];
        for (int i = 0;i < tab.length ;i++ ) {
            tab2[i]=tab[tab.length-(i+1)];
        }return tab2;
    }

    public static void miroirEnPlace(int[] tab){
        for (int i = 0; i <= tab.length/2 ;i++ ) {
            echange(tab,i,tab.length-(i+1));
        }
    }
}