public class CC2019{
	public static boolean estUneLettreMajuscule(char c){
		return(c>='A' && c<='Z');
	}

	public static boolean estUneLettreMinusscule(char c){
		return(c >= 'a' && c <= 'z');
	}

	public static boolean estUneLettre(char c){
		return(estUneLettreMajuscule(c) || estUneLettreMinusscule(c));
	}

	public static int nombreDeMots(String s){
		int count = 0;
		for (int i=0;i<s.length();i++ ) {
			if (!estUneLettre(s.charAt(i))) 
				count++;
		}
		if(!estUneLettre(s.charAt(s.length()-1))) return count;
	    else return count+1;
	}

	  public static String[] tousLesMots (String s) {
            String[] tab= new String [nombreDeMots(s)];
            int idx = 0;
            String motActuel = "";
            for (int i = 0; i<s.length(); i++){
                if (estUneLettre(s.charAt(i))==true) {
                    motActuel += s.charAt(i);
                }
                else {
                    tab[idx] = motActuel;
                    idx++;
                    motActuel="";
                }
            }
            tab[idx]= motActuel;
            return tab;
        }

	public static int nombreDeMots2(String s, int n){
		int k = -1;
		int a = 0;
		for (int i=0;i<s.length() ;i++ ) {
			if (!estUneLettre(s.charAt(i))) {
				if(i-k-1 == n){
					a++;
					k=i;
				}else k=i;
			}
			if (i==s.length()-1 && estUneLettre(s.charAt(i)) && i-k==n) {
				a++;
			}
		}
		return a;
	}
   
    public static int nombreDeMotsDifferents(String s){
    	String[] t = tousLesMots(s);
    	//for (int z=0;z<t.length ;z++ ) {
    	//	System.out.print(t[z]+" ");
    	//}
    	int nombre = 0;
    	int a = 0;
    	boolean trouve = true;
    	for (int i=1;i<t.length;i++) {
    		trouve = true;
    		for (int j=0;j<t[i].length() && a<t[0].length() && trouve;j++ ) {
    			if ((t[0].charAt(a) != t[i].charAt(j) && t[i-1].charAt(j)!= t[i].charAt(j)) || t[0].length() != t[i].length()) {
    			    nombre++;
    			    a=0;
    			    trouve = false;
    		    }
    		    else a++;   		
    		}
    	}
    	return nombre+1;
    }

    public static char verMinuscule(char c){
    	if (estUneLettreMajuscule(c)) {
        	return ((char)((int)c - (int)'Z' + (int)'z'));
        }
        else return c;
    }

    public static int[] frequenceLettres(String s){
    	int[] t = new int[26];
    	char c = ' ';
    	for (int i=0;i<s.length();i++ ) {
    		if (estUneLettre(s.charAt(i))) {
    			c = verMinuscule(s.charAt(i));
    			t[(int)c-97]++;
    		}
    	}
    	return t;
    }

    public static char lettreLaPlusFrequente(String s){
    	int[] t=frequenceLettres(s);
    	int a=0;
    	for (int i=0;i<t.length;i++) {
    		if(t[a]<=t[i]) a=i;
    	}
    	return ((char)(a+97));
    }

    public static double indicDeCoincidence(int[] t){
    	double somme = 0;
    	double a = 0;
    	for (int i=0;i<t.length ;i++ ) {
    		somme=somme+t[i];
    	}
    	//System.out.println(somme);
    	for (int j=0;j<t.length ;j++ ) {
    		a=a+(double)(t[j]*(t[j]-1))/(somme*(somme-1));
    	}
    	return a;
    }

    class Rectangle{
    	public Point supgauche;
    	public Point infdroit;
    }

    class Point{
    	public int y;
    	public int x;
    }

    public static boolean interieur(Rectangle r,Point p) {

        return  (r.supgauche.y>=p.y && p.y>r.infdroit.y)&&(r.infdroit.x>=p.x && p.x>=r.supgauche.x);

    }

     public static boolean Disjoint(Rectangle r1,Rectangle r2) {

        return ((!interieur(r1,r2.infdroit))&&(!interieur(r1,r2.supgauche)))||((!interieur(r2,r1.infdroit))&&(!interieur(r2,r1.supgauche)));
    }

    public static int[] compter(int[] t){
    	int[] tab = new int[5];
    	for (int i=0;i<t.length ;i++ ) {
    		tab[t[i]]++;
    	}
    	return tab;
    }

    public static void tri(int[] t){
    	int[] tab=compter(t);
    	int a=0;
    	int i=0;
    	while(i<t.length) {
    		for (int j=0;j<tab[a] ;j++ ) {
    			t[i]=a;
    			i++;
    		}
    		a++;
    	}
    }

	public static void main(String[] args) {
		String s="C'est le derniere examen";
		String s1="Ah ah ah";
		int[] t = frequenceLettres(s);
		int[] t1 = frequenceLettres(s1);
		int[] t2={1,1,3,0,1,1,3,1,1,4};
		tri(t2);
		/*System.out.println(nombreDeMots(s));
		System.out.println(nombreDeMots2(s,6));
		System.out.println(t[4]);
		System.out.println(lettreLaPlusFrequente(s));
		System.out.println(t1[0]);
		System.out.println(indicDeCoincidence(t1));
		System.out.println(nombreDeMotsDifferents(s1));
		System.out.println(nombreDeMotsDifferents(s));*/
		for (int i=0;i<t2.length ;i++ ) {
			System.out.print(t2[i]+" ");
		}
	}
}