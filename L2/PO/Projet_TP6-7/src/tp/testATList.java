package tp;

import tp.ATTree.Noeud;

public class testATList {

	public static void main(String[] args) {
		
		
		

		/*
		 * 
		 * JUST POUR TEST DES FONCTION !
		 * 
		 * 
		 */
		
		
		
		
		// TODO Auto-generated method stub
		ATList l1 = new ATList();
		l1.associe("238.124.22.53", "Thomas Dubois, 11 rue des graviers, Rennes");
		l1.associe("74.125.136.99","Google, 1600 amphiteatre parkway, MountainView");
		System.out.println(l1.toString());
		System.out.println("*******************");
		l1.supprime("238.124.22.53");
		System.out.println(l1.toString());	

	}


}
