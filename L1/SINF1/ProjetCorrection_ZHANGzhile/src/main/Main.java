package main;

import util.ACX;

public class Main {
	static String[] dico = ACX.lectureDico("lib/dico.txt");
	// A faire!
	public static int recherche(String cherche, String[] t){ //recherche dans un tableau de String non trié
		for(int i=0;i<t.length;i++) {
			if(t[i].compareTo(cherche)==0) {
				return i;
			}
		}
		return -1;
	}
	
	public static String[] sousTableau(String[] t, int i, int j) { //Créer des sous tableau pour la fonction triFusion
		String[] tab = new String[j-i+1];
		for(int index = 0;i+index<=j;index++) { 
			tab[index]=t[i+index];	
		}
		//afficheTabl(tab);
		return(tab);
	}
	
	public static String[] fusion(String[] t1, String[] t2) { //fusionne des tableaux trié pour la fonction triFusion
        String[] t= new String[t1.length+t2.length];//Créer un tableau temporaire pour stocker le tableau temporairement trié 
        int y1=0;
        int y2=0;
        for(int i=0;i<t.length;i++) {// Prenez le plus petit element des deux sous-tableaux dans le tableau temporaire
            if(y1<t1.length && (y2>=t2.length || t1[y1].compareTo(t2[y2])<0)) {////si l'element dans le sous-tableau t1 est plus petit que l'element dans le droite sous-tableau t2
                t[i]=t1[y1];//
                y1++;
            }else {
                t[i]=t2[y2];
                y2++;
            }
        }
        return t;
    }
	
	 public static String[] triFusion(String[] t){ //tri fusion pour un tableau de String
         if(t.length<=2) {//Si le tableau est divisé en plusieurs sous-tableaux, la longueur de chaque sous-tableau est 1 ou 0 
             if(t.length>1) {// On peut trier directemrnt chaque sous-tableau
                 if(t[0].compareTo(t[1])>0) {
                     String save = t[0]; //echange simple
                     t[0] = t[1]; 
                     t[1] = save;
                 }
             }
         }else {//si la longeur du sous-tableau est superieur a 2
        	 
        	 //ces variable vont definir les limites des sous-tableau
             int debut_1=0;
             int fin_1=t.length/2;
             int debut_2=t.length/2+1;
             int fin_2=t.length-1;
             
             String[] t1 = sousTableau(t, debut_1, fin_1); //premier sous tableau
             String[] t2 = sousTableau(t, debut_2, fin_2); //deuxieme sous tableau
             return(fusion(triFusion(t1), triFusion(t2))); //Récurtion
         }
         return(t);
     } 
	
	public static int rechercheDichoString(String cherche, String[] t) {
		int i = (t.length-1)/2; //i de d�part
		int x=4; //diviseur
		boolean find = false;
		if(t.length == 0 || t[0].compareTo(cherche)>0 || t[t.length-1].compareTo(cherche)<0) {
			return -1;
		}
		if(t.length == 1) {
			if(t[0]==cherche) {
				return 0;
			}
			return -1;
		}
		while(!find){
			//si le nombre cherch� est inferieur a celui qu'on vient de trouver on cherche avant
			String num = t[i];
			if(cherche.compareTo(num)<0) {
				i=i-((t.length-1)/x);
			}
			//sinon on cherche apr�s
			else if(cherche.compareTo(num)>0){
				i=i+((t.length-1)/x);
			}
			else {
				//puis on fini la boucle quand on trouve le nombre cherch�
				find = true;
			}
			// System.out.println(i); // [DEBUG]
			//si je regarde si le nombre chercher est compris entre les valeur qui encadre i si c'est le cas c'est que le nombre cherche n'est pas dans le tableau
			if(
				(t[i].compareTo(cherche)<0 && t[i+1].compareTo(cherche)>0) 
				|| 
				(t[i].compareTo(cherche)>0 && t[i-1].compareTo(cherche)<0)
			) {
				return -1;
			}
			// System.out.print((t.length-1)/x+" "); // [DEBUG]
			// System.out.println(x); // [DEBUG]
			// si on a rien trouver on augmente la pr�cision  de recherche donc ca va faire t.length-1/2 puis par 4 puis par 8... 
			// en verifian que t.length-1/x soit toujours superieur a 0 sans quoi on avencerais de 0 au bout d'une certaine valeur de x.
			if((t.length-1)/(x*2)>=1) {
				x=x*2;
			}else{
				x=t.length-1;
			}
		}
		//puis on renvoie l'index (la variable "i")
		return(i);
		
	}
	
	
	
	public static void afficheTabl(String[] t) { //fonction pour afficher les tableau pour les tests
		for(int i=0;i<t.length;i++) {
			System.out.print(t[i]+", ");
		}
		System.out.println();
	}
	
		
	public static boolean [] corriger(String[] texte, String[] dico1){
		boolean[] outTab = new boolean[texte.length]; // on créer un tableau de la taille du tableau texte en entrée
		for(int i=0;i<texte.length;i++) {
			outTab[i]=(recherche(texte[i].toLowerCase(), dico1)>=0);
		}
		return outTab;
	}
	
	public static boolean [] corrigerDico(String[] texte){
		return(corriger(texte, dico));
	}
	
	public static boolean[] corrigerRapide(String[] texte, String[] dico1) {
		dico1=triFusion(dico1);
		boolean[] outTab = new boolean[texte.length]; // on créer un tableau de la taille du tableau texte en entrée
		for(int i=0;i<texte.length;i++) {
			outTab[i]=(rechercheDichoString(texte[i].toLowerCase(), dico1)>=0);
		}
		return outTab;
	}
	
	public static boolean[] corrigerDicoRapide(String[] text) {
		return(corrigerRapide(text, dico));
	}
	
	public static int lettreDifferente(String s1, String s2) { //cette fonction calcule le nombre de lettre différent entre de lettre on cosidère que la taille des entrée sont identiques
		int diffCount=0; //on initialise le compteur de différence a 0
		for(int i=0;i<s1.length();i++) {  //on parcour les chaines
			if(s1.charAt(i)!=s2.charAt(i)) { //si il y a une lettre qui diffère
				diffCount++;	//on incremente le compteur
			}
		}
		return diffCount; //on retourne le compteur
	}
	
	public static String[] proposerCorrection(String mot) {
		int counter=0; //compteur qui va compter le nombre de mot différent de une lettre
		//la premiere boucle va permettre de compter le nombre de mot identique a une lettre près 
		//ce n'est pas génial au niveau de l'optimisation mais nous devons conniatre la taille de notre tableau pour le declarer 
		//car nous n'avon pas encore vu les tableau dynamic
		for(int i=0;i<dico.length;i++) { 	//on parcour le dictionnaire
			if(dico[i].length()==mot.length() && lettreDifferente(dico[i], mot)==1) { //on verifie que les tailles des deux mot sont identique 
			//puis on fait appel a lettreDifferente pour compter le nombre de lettre différente si elle est egale a un on incremente le competeur
				counter++;
			}
		}
		String[] tab = new String[counter]; //une fois qu'on connait le nombre de mot différent d'une lettre on declare le tableau avec la taille nécéssaire
		counter=0;							//on réinitialise a 0 counteur il va nous permttre de placé chaque mot au bonne index dans tab
		for(int i=0;i<dico.length;i++) { 	//puis on parcour a nouveau le dictionnaire
			if(dico[i].length()==mot.length() && lettreDifferente(dico[i], mot)==1) { //on fait la meme verification que dans la boucle precedente
				tab[counter]=dico[i];	//et on  stock a l'indice "counter" le mot a l'indice "i" du dictionnaire 
				counter++;			//puis on incremente le compteur
			}
		}
		return tab;	//enfin on retourne tab
	}
	
	
	public static void main(String[] args){
		boolean[] result = corrigerDico(new String[] {"voiture"});
		//ACX.interfaceCorrection("corrigerDico");
		ACX.interfaceCorrection("corrigerDicoRapide", "proposerCorrection");
		System.out.print(result[0]);
	}
}
