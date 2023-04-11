package pourDebug;

public class PourDebug {

	// Recherche qui sort de la boucle d¨¨s que l'index est trouv¨¦
	public static int recherche(int cherche, int[] t){
		int index=0;
		while (index<t.length){
			if (t[index]==cherche) {
				return index;	
			}
			index = index + 1 ;
		}
		return -1;
	}
	
	// Recherche qui consulte 2 cases du tableau en m¨ºme temps
		public static int recherche2(int cherche, int[] t){
			for (int i=0; i<t.length; i=i+2){
				if (t[i]==cherche ) return i;
				if(t[i+1] == cherche) return i+1;
			}
			return -1;
		}
	
	
	public static void main(String[] args) {
		// Sur recherche, 3 bugs ¨¤ trouver
		System.out.println("recherche");
		int [] t1 = {1,2,3};
		
		// Si l'¨¦l¨¦ment cherch¨¦ n'est pas dans le tableau
		int i= recherche(4,t1);
		System.out.println(i);
		
		// Si l'¨¦l¨¦ment cherch¨¦ est dans le tableau mais pas le premier
		int j= recherche(3,t1);
		System.out.println(j);
		
		// Si l'¨¦l¨¦ment cherch¨¦ est le premier du tableau il n'est m¨ºme pas 
		// visit¨¦
		int k= recherche(1,t1);
		System.out.println(k);
		
		
		// Sur recherche2, 2 bugs ¨¤ trouver
		System.out.println("recherche2");
		
		int l= recherche2(3,t1);
		System.out.println(l);
		
		int m= recherche2(2,t1);
		System.out.println(m);
	
	}

}
