public class TD3{
	public static void main(String[] args) {
	/*	System.out.println(lireEntier());	
		System.out.println(carre(lireEntier()));

		System.out.println("**************************************");

		int j = lireEntier();
		int m = lireEntier();
		int a = lireEntier();
		if (j + 1 > nombreDeJoursDansLeMois(m,a) ) {
			if (m == 12) {
				m = 1;
				a = a + 1;
                j = 1;
			}else{
				j = 1 ;
				m = m + 1;
			}		
		}else{j = j + 1;}
		System.out.println("La date de lendemain de la date "+j+" "+m+ " " +a );
        */
        int[] t4= {7,49,30,56,25,1,88,99};
        triFusion(t4,0,t4.length-1);
        affiche(t4);
}

/*
    public static int lireEntier(){
    	java.util.Scanner sc= new java.util.Scanner(System.in);
	    int a = sc.nextInt();
        return a;   
    }

    public static int carre(int b){
    	return b*b ;
    }

    public static boolean estBissextile(int a){
    	if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
    		return true ;
    	}else{return false ;}
    }

    public static int nombreDeJoursDansLeMois(int m ,int a){
    	if (m == 2) {
    		if (estBissextile(a)) {
    			m = 29;
    		}else{ m = 28;}
        }else if (m == 4 || m == 6 || m == 9 || m == 11) {
        	m = 30;
        }else { m = 31 ;}
        return m ;
    }
    */

    public static void triFusion(int[] t, int gauche, int droite){
        if(gauche < droite){
            int milieu = (gauche+droite)/2;
            triFusion(t, gauche,milieu); /*triFusion(t1)*/
            triFusion(t, milieu+1,droite); /*triFusion(t1)*/
            fusion(t,gauche,milieu,droite); /*fusion(t1_, t2_)*/
        }
    }
    public static void fusion(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r-l+1];
        int i= l;
        int j = mid+1;
       for (int k = l; k <= r; k++) {
            //
            if (i > mid) {
                //左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <aux[j - l]) {
                //左半部分所指元素<右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    public static void affiche(int[] t) {
        for(int i=0;i<t.length;i++) {
            System.out.print(t[i]+" ");
        }System.out.println();
    }    

}

  



