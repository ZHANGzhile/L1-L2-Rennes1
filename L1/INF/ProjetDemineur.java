public class ProjetDemineur{
// Question 1.b] Fonction init
	public static void init(int h,int l,int n) { // ATTENTION, vous devez modifier la signature de cette fonction
		T = new int[h][l];
		Tadj = new int[h][l];
		for(int x =0;x<Tadj.length;x++) {
			for(int y =0;y<Tadj[x].length;y++) {
				Tadj[x][y] = 0;
			}
		}
		for(int i =0 ;i<=n;i++) {
			int a = entierAleatoire(0,h-1);
			int b = entierAleatoire(0,l-1);
			Tadj[a][b]= -1;
		}
	}

	// Question 1.c] Fonction caseCorrecte
	public static boolean caseCorrecte(int i,int j) { // ATTENTION, vous devez modifier la signature de cette fonction)
		if(i<Tadj.length && i>=0) {
			if(j<Tadj[i].length && j>=0) {
				return true;
			}
		}
		return false;
	}

	// Question 1.d] Fonction calculerAdjacent
	public static void calculerAdjacent() {
		for(int i=0;i<Tadj.length;i++) {
			for(int j=0;j<Tadj[i].length;j++) {
				if(caseCorrecte(i,j)) {
					continue;
				}
				int count = 0;
				for(int r = -1 ; (r+i<Tadj.length) && (r<2);r++) {
					if (r+i<0) continue;
					for(int z = -1;(z+j<Tadj[i].length) && z<2;z++) {
						if (z+j < 0) continue;
						if (caseCorrecte(r+i,z+j)) count ++;
					}
				}
				if(count > 0) {
					Tadj[i][j] = count;	
				}
			}
		}
	}

	//
	// Exercice 2 : Affichage de la grille
	//

	// Question 2.a]
	public static void afficherGrille() { // ATTENTION, vous devez modifier la signature de cette fonction

		// Note : Dans un premier temps, considérer que la grille contiendra au plus 52 colonnes
		// (une pour chaque lettre de l'alphabet en majuscule et minuscule) et au plus 100 lignes
		// (entiers de 0 à 99).
		for(int i = 0; i<=T[0].length;i++) {
			if(i == 0) System.out.print(" "+"|");
			else if (i<=26)System.out.print((char)i+64 +"|");
			else if (i<=52)System.out.print((char)i+70 +"|");
		}
		System.out.println();
		for(int a = 0; a < T.length; a++) {
			for(int b = 0; b <=T[a].length ; b++) {
				if(b==0) System.out.print("0i"+"|");
				else System.out.print(" "+"|");
			}System.out.println();
		}
	}

	public static boolean verifierFormat(String s) { // ATTENTION, vous devez modifier la signature de cette fonction
		char a =s.charAt(0); //Le premier caractère
		char c =s.charAt(s.length()-1); //Le dernier caractère
		if(s.length() != 4) {
			return false;
		}else {
		    if((a !='d' && a != 'r') || //Le premier caractère sera toujours soit d soit r
		       ((int) c > 122) || ((int) c < 65) || (((int) c > 90) && ((int) c < 97)) || //Le dernier caractère sera toujours une lettre
		       !Character.isDigit(s.charAt(1)) || !Character.isDigit(s.charAt(2)) ) { //Les autres caracteres doivent être des chiffres
		       return false;
		    }
		}
		return true;
	}

	public static int[] conversionCoordonnees(String input) { // ATTENTION, vous devez modifier la signature de cette fonction
		int[] t= new int[3];
		if(verifierFormat(input)) {
			t[0] =(input.charAt(1)-(int)'0')*10+input.charAt(2)-(int)'0'; //Le premier élément correspond à l'indice de la ligne
			//t[0] = Integer.parseInt("input.charAt(1)"+"input.charAt(2)"); 
			if(input.charAt(3) >='A' && input.charAt(3) <='Z') t[1] = (int)input.charAt(3) - 65;
			else t[1] = (int)input.charAt(3) - 97 + 26; //Le deuxième élément correspond à l'indice de la colonne			
			if(input.charAt(0) == 'd') t[2] = 0; //vaut 0 si il a demandé à marquer la case
			else t[2] = 1; //vaut 1 si il a demandé à révéler la case
		}
		return t;
		
	}
	public static void jeu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez la valeur de l'abscisse : ");
		int x= sc.nextInt();
		System.out.println("Entrez la valeur de l'ordonnee : ");
		int y=sc.nextInt();
		if(!caseCorrecte(x,y)) System.out.println("Les valeur sont fausses,");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print(" Hauteur de la grille entre 1 et 100 : ");
        int h= sc.nextInt();
        System.out.print(" Largeur de la grille entre 1 et 52 : ");
        int l= sc.nextInt();
        System.out.print(" Nombre de mines : ");
        int n= sc.nextInt();
        init(h,l,n);
	}
    
     public static int[] conversionCoordonnees(String input) { // ATTENTION, vous devez modifier la signature de cette fonction
         int[] t= new int[3];
         String letterOrder = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
         t[1] = 0;
         while(letterOrder.charAt(t[1]) != input.charAt(3)) {
             t[1]++;
         }
         String middle = input.substring(1,2);
         t[0] = Integer.parseInt(middle);
         t[2] = 0;
         if(input.charAt(0)=='r') {
             t[2] = 1;
         }
         return t;
     }

     // Question 3.b]
	public static void revelation(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction
		T[i][j]=1;
        if(caseAdjacenteZero(i,j)) {
            if(caseCorrecte(i-1,j) && T[i-1][j]==0) { //case en haut
                revelation(i-1, j);
            }
            if(caseCorrecte(i-1,j+1) && T[i-1][j+1]==0) { //case en haut a droite
                revelation(i-1, j+1);
            }
            if(caseCorrecte(i,j+1) && T[i][j+1]==0) { //case a droite
                revelation(i, j+1);
            }
            if(caseCorrecte(i+1,j+1) && T[i+1][j+1]==0) { //case en bas a droite
                revelation(i+1, j+1);
            }
            if(caseCorrecte(i+1,j) && T[i+1][j]==0) { //case en bas
                revelation(i+1, j);
            }
            if(caseCorrecte(i+1,j-1) && T[i+1][j-1]==0) { //case en bas a gauche
                revelation(i+1, j-1);
            }
            if(caseCorrecte(i,j-1) && T[i][j-1]==0) { //case a gauche
                revelation(i, j-1);
            }
            if(caseCorrecte(i-1,j-1) && T[i-1][j-1]==0) { //case en haut a gauche
                revelation(i-1, j-1);
            }
        }

	}
}