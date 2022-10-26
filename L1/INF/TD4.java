public class TD4{
	public static void main(String[] args) {
		 table();
		 int[] a = initTableau(3);
		 System.out.println(a);
         afficheTableau(a);
         System.out.println(plusPetitElement(a));
         System.out.println(secondPlusPetit(a));
	}
    public static void table(){
		int t = 0;
		for (int i = 1; i <= 10 ;i++ ) {
			for (int j = 10;j >= i ; j-- ) {    
				t = j*i;
				System.out.print(i+"*"+j+" = "+t+" ");
			}
			System.out.println();
		}
	}
    public static int[] initTableau(int n){
    	int [] t = new int [n];
    	t[0]= 30;
    	t[1]=20;
    	t[2]=10;
    	return t;
    }
    
    public static void afficheTableau(int[] t){
    	for (int i = 0;i < t.length ;i++ ) {
    		System.out.print(t[i]+" ");
    	}System.out.println();
    }

    public static int plusPetitElement(int[]t){
    	int x = t[0];
    	for (int i = 0;i < t.length ; i++ ) {
    		if (x > t[i]) {
    			x = t[i];
    		}
    	}return x ;
    }

    public static int secondPlusPetit(int[]t){
    	int min = plusPetitElement(initTableau(3));
    	int x = t[0];
    	if (x == min) {
    		x = t[1];
    		for (int i = 1;i < t.length ; i++ ) {
    			if (x > min & x > t[i] ){
    				x = t[i];
    			}
    		}
    			
    	}return x ;
    		
    	}
}
