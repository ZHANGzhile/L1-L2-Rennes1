

    // Ceci est un squelette a  REMPLIR pour le projet INF1 sur le jeu de demineur
    //
    // - N'oubliez pas de renseigner vos deux noms
    // Prenom Nom Groupe : Zhile ZHANG (IE-4B)
    // Prenom Nom Groupe : Matheo GUEGAN (IE-4B)
    //
    // - Pour chaque question, le squelette donne le nom de la fonction a  e©crire mais *pas* la signature
    //   il faut remplir les types d'entrees et de sorties (indiques par ?) et remplir l'interieur du code de chaque fonction.
    //
    // - L'unique fichier de code que vous soumettrez sera ce fichier Java, donc n'hesitez pas a  le commenter abondamment.
    //   inutile d'exporter votre projet comme archive Zip et de rendre ce zip.
    //   Optionnel : vous pouvez aussi joindre un document PDF donnant des explications supplementaires (si vous utilisez OpenOffice/LibreOffice/Word, exportez le document en PDF), avec eventuellement des captures d'ecran montrant des etapes affichees dans la console
    //
    // - Regardez en ligne sur le Moodle pour le reste des consignes, et dans le fichier PDF du sujet du projet
    //   https://foad.univ-rennes1.fr/mod/assign/view.php?id=534254
    //
    // - A rendre avant le vendredi 04 decembre, maximum 23h59.
    //
    // - ATTENTION Le projet est assez long, ne commencez pas au dernier moment !
    //
    // - Enfin, n'hesitez pas a  contacter l'equipe pedagogique, en posant une question sur le forum du Moodle, si quelque chose n'est pas clair.
    //
     
    // Pour utiliser des scanners pour lire des entrees depuis le clavier
    // utilises en questions 4.d] pour la fonction jeu()
    import java.util.Scanner;
     
    // Pour la fonction entierAleatoire(a, b) que l'on vous donne ci-dessous
    import java.util.concurrent.ThreadLocalRandom;
     
    // L'unique classe de votre projet
    public class projet_demineur {
     
        // Donne, utile pour la question 1.b]
        public static int entierAleatoire(int a, int b){
            // Renvoie un entier aleatoire uniforme entre a (inclus) et b (inclus).
            return ThreadLocalRandom.current().nextInt(a, b + 1);
        }
     
     
        //
        // Exercice 1 : Initialisation des tableaux
        //
     
        // Question 1.a] declarez les variables globales T et Tadj ici
        static int[][] T; //Voici les variables globale
        static int[][] Tadj;
     
        // Question 1.b] Fonction init
        public static void init(int h,int l,int n) { // ATTENTION, vous devez modifier la signature de cette fonction
            T = new int[h][l];
            Tadj = new int[h][l];
           
            for(int x=0;x<=n;){
                int posX=entierAleatoire(0,l-1);//case aleatoire en largeur
                int posY=entierAleatoire(0,h-1);//case aleatoire en hauteur
                if(Tadj[posY][posX]!=-1) {
                    Tadj[posY][posX]=-1;
                    x++;
                }
            }
        }
     
        // Question 1.c] Fonction caseCorrecte
        public static boolean caseCorrecte(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction)
            return(i>=0 && j>=0 && i<Tadj.length && j<Tadj[i].length);
        }
     
        // Question 1.d] Fonction calculerAdjacent
        public static void calculerAdjacent() {
            for(int y=0;y<Tadj.length;y++) {
                for(int x=0;x<Tadj[y].length;x++) {
                    if(Tadj[y][x] >=0) {
                        int adjCount = 0;
                        if(caseCorrecte(y-1,x) && Tadj[y-1][x]==-1) { //case en haut
                            adjCount++;
                        }
                        if(caseCorrecte(y-1,x+1) && Tadj[y-1][x+1]==-1) { //case en haut a droite
                            adjCount++;
                        }
                        if(caseCorrecte(y,x+1) && Tadj[y][x+1]==-1) { //case a droite
                            adjCount++;
                        }
                        if(caseCorrecte(y+1,x+1) && Tadj[y+1][x+1]==-1) { //case en bas a droite
                            adjCount++;
                        }
                        if(caseCorrecte(y+1,x) && Tadj[y+1][x]==-1) { //case en bas
                            adjCount++;
                        }
                        if(caseCorrecte(y+1,x-1) && Tadj[y+1][x-1]==-1) { //case en bas a gauche
                            adjCount++;
                        }
                        if(caseCorrecte(y,x-1) && Tadj[y][x-1]==-1) { //case a gauche
                            adjCount++;
                        }
                        if(caseCorrecte(y-1,x-1) && Tadj[y-1][x-1]==-1) { //case en haut a gauche
                            adjCount++;
                        }
                        Tadj[y][x] = adjCount;
                    }
                }
            }
        }
     
        //
        // Exercice 2 : Affichage de la grille
        //
     
        // Question 2.a]
        public static void afficherGrille(boolean affMines) { // ATTENTION, vous devez modifier la signature de cette fonction
     
            // Note : Dans un premier temps, considerer que la grille contiendra au plus 52 colonnes
            String indiceX = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            // (une pour chaque lettre de l'alphabet en majuscule et minuscule) et au plus 100 lignes
            // (entiers de 0 a 99).
            //char c = indiceX.charAt(0);
            for(int y=-1;y<T.length;y++) {
                if(y==-1) { //affichage de la premiere ligne
                    System.out.print("  |");
                    for(int x1=0;x1<T[0].length;x1++) {
                        System.out.print(indiceX.charAt(x1)+"|");
                    }
                }else {
                    String isZero = "0"; //pour afficher un zero avant la ligne si y<10 (ex: 01, 02, 03...)
                    if(y>=10) {
                        isZero = "";
                    }
                    for(int x2=0;x2<T[y].length;x2++) {
                        if(x2==0) {
                            System.out.print(isZero+y+"|");
                        }
                        if(affMines && Tadj[y][x2]==-1) { // si il y a une bombe
                            System.out.print("!");
                        }else if(T[y][x2]==1 && Tadj[y][x2] >= 0) { //si la case est révélé
                            System.out.print(Tadj[y][x2]);
                        }else if(T[y][x2]==2) {     //si il y a un drapeau
                            System.out.print("X");
                        }else{      //sinon (si elle n'est pas affichée)
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    }
                }
                System.out.print("\n");
            }
        }
     
     
        //
        // Exercice 3 : Reveler une case
        //
     
        // Question 3.a]
        public static boolean caseAdjacenteZero(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction
            return(
                caseCorrecte(i-1,j) && Tadj[i-1][j] == 0 ||
                caseCorrecte(i-1,j+1) && Tadj[i-1][j+1] == 0 ||
                caseCorrecte(i,j+1) && Tadj[i][j+1] == 0 ||
                caseCorrecte(i+1,j+1) && Tadj[i+1][j+1] == 0 ||
                caseCorrecte(i+1,j) && Tadj[i+1][j] == 0 ||
                caseCorrecte(i+1,j-1)  && Tadj[i+1][j-1] == 0 ||
                caseCorrecte(i,j-1) && Tadj[i][j-1] == 0 ||
                caseCorrecte(i-1,j-1) && Tadj[i-1][j-1] == 0
            );     
        }
     
        // Question 3.b]
        public static void revelation(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction
            T[i][j]=1;
            if(caseAdjacenteZero(i,j) && Tadj[i][j]==0) {
            	for(int i1 = i-1; i1<=i+1; i1++) {
            		for(int j1=j-1; j1<=j+1; j1++) {
            			if(caseCorrecte(i1, j1) && T[i1][j1] == 0 && !(i1==i && j1==j)) {
            				revelation(i1, j1);
            			}
            		}
            	}
            }
        }
     
     
        // Question 3.c] Optionnel
        public static void relevation2() { // ATTENTION, vous devez modifier la signature de cette fonction
           
        	//deja fait dans revlation 1
        }
     
        // Question 3.d]
        public static void actionDrapeau(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction
            if(T[i][j]==0) { //si la case n'est pas afficher
                T[i][j]=2;
            }else if(T[i][j]==2) { //si il y a un drapeau
                T[i][j]=0;
            }
        }
       
       
        // Question 3.e]
        public static boolean revelerCase(int i, int j) { // ATTENTION, vous devez modifier la signature de cette fonction
            if(Tadj[i][j] == -1) { // si il y a une mine
                return false;
            }else {
                revelation(i, j);
            }
            return true;
        }
     
     
        //
        // Exercice 4 : Boucle de jeu
        //
     
        // Question 4.a]
    	public static boolean aGagne() {
    		for(int i=0;i<T.length;i++) {
    			for(int j=0;j<T[0].length;j++) {
    				if(T[i][j] !=1 && Tadj[i][j] != -1) return false;
    			}
    		}
    		return true;
    	}
     
        // Question 4.b]
    	public static boolean verifierFormat(String s) { // ATTENTION, vous devez modifier la signature de cette fonction
    		if(s.length()!=4) {
    			return false;
    		}
    		char a =s.charAt(0); //Le premier caractère
    		char c =s.charAt(3); //Le dernier caractère
    		char m1 = s.charAt(1); //Le prmeier chiffre du millieu
    		char m2 = s.charAt(2); //Le deuxieme chiffre du millieu
    		return(
    			(a=='r' || a=='d') &&  //si le premier caractère est r ou d
    			((c>='a' && c<='z') || (c>='A' && c<='Z')) && //si le dernier cracatère est une lettre
    			(m1 >= '0' && m1 <= '9' && m2 >= '0' && m2 <= '9')//si les charactère du millieu sont deux chiffres
    		);
    	}
     
        // Question 4.c]
    	public static int[] conversionCoordonnees(String input) { // ATTENTION, vous devez modifier la signature de cette fonction
    		int[] t= new int[3];
    		String letterOrder = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
    		t[1] = 0;
    		while(letterOrder.charAt(t[1]) != input.charAt(3)) {
    			t[1]++;
    		}
    		int m1 = Character.getNumericValue(input.charAt(1)); //Le prmeier chiffre du millieu
    		int m2 = Character.getNumericValue(input.charAt(2)); //Le deuxieme chiffre du millieu
    		int result = m1*10+m2;
    		t[0] = result;
    		t[2] = 0;
    		if(input.charAt(0)=='r') {
    			t[2] = 1;
    		}
    		return t;
    		
    	}
     
        // Question 4.d]
        public static void jeu() {
        	boolean perdu = false;
        	boolean gagne = false;
        	Scanner sc = new Scanner(System.in);
        	String input = "";
        	int[] action = new int[3];
        	boolean inputError = true;
        	while(!perdu && !gagne) {
	        	afficherGrille(false);
	        	inputError= true;
	        	while(inputError) {
		        	System.out.println("Veuillez enter une action: ");
		        	input = sc.nextLine();
		        	if(verifierFormat(input)) {
		        		action = conversionCoordonnees(input);
		        		if(caseCorrecte(action[0], action[1])) {
		        			inputError=false;
		        		}else {
		        			System.out.println("Erreur de coordonnée");
		        		}
		        	}else {
		        		System.out.println("Erreur de format.");
		        	}
	        	}
	        	
	        	if(action[2] == 0) {
	        		actionDrapeau(action[0], action[1]);
	        	}else{
	        		if(!revelerCase(action[0], action[1])) {
	        			perdu=true;
	        			System.out.println("Perdu");
	        			afficherGrille(true);
	        		}

	        		if(aGagne()) {
	        			gagne = true;
	        			System.out.println("Vous avez gagné");
	        		}
	        	}
        	}
        }
     
        // Question 4.e]
        // Votre *unique* methode main
        public static void main(String[] args) {
            init(10,10,5);
            calculerAdjacent();
            jeu();
        }
     
     
        //
        // Exercice 5 bonus challenge : Pour aller plus loin
        //
     
        // Question 5.a] Optionnel
        public static void aide() {
           
        }
     
        // Question 5.b] Optionnel
        public static void intelligenceArtificielle() {
           
        }
     
        // Question 5.c] Optionnel
        public static void statistiquesVictoiresIA() {
           
        }
     
    }

