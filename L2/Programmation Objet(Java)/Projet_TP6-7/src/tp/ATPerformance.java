package tp;

//Prenom Nom  : Zhile ZHANG (TP1 - binôme 9)
//Prenom Nom  : Ilyes SAIS  (TP1 - binôme 9)

import java.util.Random;

public class ATPerformance {

	public static void main(String[] args) {
		ATList a1 = new ATList();
		ATTree a2 = new ATTree();

		System.out.println("le temps d'insertion et le temps d'acces list: ");
		listR(a1, 100000);
		System.out.println();
		System.out.println("le temps d'insertion et le temps d'acces arbre: ");
		Tree(a2, 100000);
		System.out.println();
		System.out.println("la difference entre temps d'insertion de la liste est tree");
		differenInsertion_liste_Tree(a2,a1,10000);
		System.out.println();
		System.out.println("la difference entre temps d'acces de la liste est tree");
		differenget_liste_Tree(a2,a1,10000);
	}


	/**
	 * param  a1 ATList , param n la longueur de a1 
	 * utilise une boucle,chaque fois on appele la fonction associe,ajoute un couple(cle-valeur) converti par de nombres aleatoires compris entre 1 et 100 000
	 * renvoie une ATList qui est associe avec des valeur aleatoire  pour l'insertion
	 */
	public static ATList insertionList(ATList a1, int n) {

		for (int i = 0; i < n; i++) {
			a1.associe("" + new Random().nextInt(100000), "" + new Random().nextInt(100000));
		}
		return a1;
	}

	/**
	 * param a2 ATTree , param n le nombre de noeuds de a2
	 * utilise une boucle,chaque fois on appele la fonction associe,ajoute un couple(cle-valeur) converti par de nombres aleatoires compris entre 1 et 100 000
	 * renvoie un arbre qui est associe avec des valeur aleatoire pour l'insertion
	 */
	public static ATTree insertionTree(ATTree a2, int n) {
		for (int i = 0; i < n; i++) {
			a2.associe("" + new Random().nextInt(100000), "" + new Random().nextInt(100000));
		}
		return a2;
	}

	/**
	 * param a1 ATList , param n la longueur de a1
	 * divise la longueur par 1000, dans la boucle, ajoute 1000 longueurs à chaque fois(La valeur de N different),
	 * et chaque fois appele la fonction insertionList et la fonction get,
	 * affiche les temps d'insertion et d'acces requis par chaque longueur.
	 * 	A l'aide la methode nanotime on vas mesurer a chaque fois le temps d'insertion de la methode associe (ATList) +le temps d'acces de la methode get(ATList)
	 */
	public static void listR(ATList a1, int n) {
		long[] temp = new long[n / 10000];
		long[] tempGet = new long[n / 10000];
		for (int i = 10000; i <= n; i += 10000) {
			long time = System.nanoTime();
			insertionList(a1, i);
			long time1 = System.nanoTime();
			temp[i / 10000 - 1] = time1 - time;
			a1.get("" + new Random().nextInt(100000));
			long time2 = System.nanoTime();
			tempGet[i / 10000 - 1] = time2 - time1;
			System.out.println(
					"N: " + i + " temps d'insertion: " + temp[i / 10000 - 1] + " temps d'acces: " + tempGet[i / 10000 - 1]);
		}
	}

	/**
	 * param a2 ATTree, param n le nombre de noeud de a2
	 * divise n par 1000, dans la boucle, ajoute 1000 noeuds à chaque fois(La valeur de N different),
	 * et chaque fois appele la fonction insertionTree et la fonction get,
	 * affiche les temps d'insertion et d'acces requis par chaque longueur.
	 * A l'aide la methode nanotime on vas mesurer a chaque fois le temps d'insertion de la methode associe (ATTree) +le temps d'acces de la methode get(ATTree) 
	 */
	public static void Tree(ATTree a2, int n) {
		long[] temp = new long[n / 10000];
		long[] tempGet = new long[n / 10000];
		for (int i = 10000; i <= n; i += 10000) {
			long time = System.nanoTime();
			insertionTree(a2, i);
			long time1 = System.nanoTime();
			temp[i / 10000 - 1] = time1 - time;
			a2.get("" + new Random().nextInt(100000));
			long time2 = System.nanoTime();
			tempGet[i / 10000 - 1] = time2 - time1;
			System.out.println(
					"N: " + i + " temps d'insertion: " + temp[i / 10000 - 1] + " temps d'acces: " + tempGet[i / 10000 - 1]);
		}
         
	}
	
	
	public static void differenInsertion_liste_Tree(ATTree a1,ATList a2,int n) {
		long[] temp = new long[n / 1000];
		for (int i = 1000; i <= n; i += 1000) {
			
			insertionTree(a1, i);
			long time2=System.nanoTime();
			insertionList(a2, i);
			long time3=System.nanoTime();
			temp[i / 1000 - 1] = time3 -time2;
			System.out.println("N: " + i + " temps d'insertion: " + temp[i / 1000 - 1] );		
			
	}
}
	
	
	public static void differenget_liste_Tree(ATTree a1,ATList a2,int n) {
		
		long[] tempGet = new long[n / 1000];
		for (int i = 1000; i <= n; i += 1000) {
			
			a1.get("" + new Random().nextInt(100000));
			long time2=System.nanoTime();
			a2.get("" + new Random().nextInt(100000));
			long time3=System.nanoTime();
			tempGet[i / 1000 - 1] = time3 - time2;
			System.out.println("N: " + i + " temps d'acces: " + tempGet[i / 1000 - 1]);
			
		}
	}
	
}