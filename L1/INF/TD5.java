public class TD5{
    public static int[] concatenation(int[]tab1 ,int[]tab2){
	    int[]tab = new int[tab1.length+tab2.length];
	    for (int i = 0; i < tab1.length ; i++ ) {
	 	    tab[i]=tab1[i];
	    }
	    for (int j = 0; j < tab2.length ;j++ ) {
	 	    tab[j+tab1.length]=tab2[j];
	    } 
        return tab;
    }

    public static int[] triParite(int[] tab){
    	int[] t = new int[tab.length];
        int x = 0;
    	for (int i = 0; i < t.length ;i++ ) {
    		if (tab[i] % 2 == 0) {
    			t[x] = tab[i];
                x++;
    		}
    	}
        for (int j = 0; j < tab.length ;j++ ) {
        	if(tab[j] % 2 != 0 && x < t.length){
                t[x] = tab[j];
                x++;
            }
        }
    	return t;
    }

    public static void main(String[] args) {
    	int[]tab1 = {1,2,3};
        int[]tab2 = {4,5,6,7};
    	int[]t = concatenation(tab1,tab2);
    	for (int i = 0;i < t.length ;i++ ) {
    		System.out.print(t[i]);
    	}
        System.out.println();
    	int[]t1 = {1,2,3,4,5,6,7,8};
    	int[]t2 = triParite(t1);
    	for (int j = 0;j < t2.length ;j++ ) {
    		System.out.print(t2[j]);
    	}
    }





}
