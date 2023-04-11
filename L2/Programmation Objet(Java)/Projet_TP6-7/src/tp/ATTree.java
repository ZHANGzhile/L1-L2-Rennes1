package tp;

public class ATTree extends AssoTable{
	
	public class Noeud{
		Paire cv ;
		Noeud filsGauche ;
		Noeud filsDroit ;
		
		Noeud(Paire cv){
			this.cv = cv;
			this.filsDroit = null;
			this.filsGauche = null;
		}
		
		Noeud(Paire cv, Noeud filsGauche, Noeud filsDroit){
			this.cv = cv;
			this.filsDroit = filsDroit;
			this.filsGauche = filsGauche;
		}
		
	}
	
	private Noeud racine;
	

	public ATTree() {
		super();
		this.racine = racine;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void associe(String cle, String valeur) {
		racine = associe(racine,cle,valeur);
		
	}

	public Noeud associe(Noeud courant, String cle, String valeur) {
		if(courant == null) {
			return new Noeud(new Paire(cle,valeur));
		}
		else {
			if(courant.cv.getCle().compareTo(cle) != 0) {//si un couple (cle,valeur) n'existe pas dans l'arbre
				if(courant.cv.getCle().compareTo(cle) <= 0) {
					courant.filsDroit = associe(courant.filsDroit,cle,valeur);
					}
				else {
					courant.filsGauche = associe(courant.filsGauche,cle,valeur);
				}
			}else {// si un couple (cle,valeur) existe deja, on le ramplace
				courant.cv.setValeur(valeur);
			}
			return courant;
		}
		
	}

	@Override
	public void supprime(String cle) {
		
		racine = supprime(racine,cle);
		
	}
	
	public Noeud supprime(Noeud courant, String cle) {		
		if(courant == null) {	//si on ne trouve pas une association dans l'arbre
			return null;
		}
		else {	
			
			if((courant.cv.getCle().compareTo(cle) == 0)) {		//on trouve la Noeud doit etre supprimer
				
				if(courant.filsDroit == null) return courant.filsGauche; 	//si c'est noeud qui a pas la feuille droite
				if(courant.filsGauche == null) return courant.filsDroit; 	//si c'est noeud qui a pas la feuille gauche
				// si filsDroite et filsGauche de ce noeud ne sont pas null
				
				Noeud tmp = courant;
				courant = trouveMin(tmp.filsDroit);
				courant.filsDroit = supprimeMin(tmp.filsDroit);
				courant.filsGauche = tmp.filsGauche;
				
			}
			
			else if(courant.cv.getCle().compareTo(cle) < 0) courant.filsDroit = supprime(courant.filsDroit,cle);
			else courant.filsGauche = supprime(courant.filsGauche,cle);
			
		}
		return courant;
	}
	
	
	/**
	 * renvoie le noeud minimum dans l'arbre
	 */
	public Noeud trouveMin(Noeud courant) {
		if(courant.filsGauche == null) return courant;
		else {
			return(trouveMin(courant.filsGauche));
		}
	}
	
	
	/**
	 * renvoie le noeud.filsDroit apres la suppression du noeud minimum
	 */
	public Noeud supprimeMin(Noeud courant) {
		if(courant.filsGauche == null) {
			return courant.filsDroit;
		}
		courant.filsGauche = supprimeMin(courant.filsGauche);
		return courant;
	}
	

	@Override
	public String get(String cle) {
		return get(racine,cle);
	}
	
	public String get(Noeud courant, String cle) {
		String s = "";
		if(courant != null) {
			if(courant.cv.getCle().compareTo(cle) == 0) {
				return courant.cv.getValeur();
			}
			else if(courant.cv.getCle().compareTo(cle) < 0) s = get(courant.filsDroit,cle);
			else s = get(courant.filsGauche,cle);
			return s;
		}
		else return null;	
	}
	
	

	public String toString(Noeud courant, String prefixe) {
		String s = "";
		if(courant != null) {
			s += toString(courant.filsGauche,prefixe + "  ");
			s += prefixe + courant.cv.getCle() + "\n";
			s += toString(courant.filsDroit, prefixe + "  ");
		}
		return s;
		
	}
	

	public static void main(String[] args) {
		ATTree t1 = new ATTree();
		t1.associe("20201234", "jojo");
		t1.associe("20203333","gogo");
		System.out.println(t1.toString(t1.racine, ""));
		t1.associe("20204567", "koko");
		System.out.println(t1.toString(t1.racine, ""));
		t1.associe("20110202", "yoyo");
		System.out.println(t1.toString(t1.racine, ""));
		t1.associe("20120333", "toto");
		System.out.println(t1.toString(t1.racine, ""));
		t1.associe("20201333", "momo");
		System.out.println(t1.toString(t1.racine, ""));
		t1.supprime("20203333");
		System.out.println("*******************");
		System.out.println(t1.toString(t1.racine, ""));
		System.out.println("*******************");
		//t1.supprime("20203333");
		//System.out.println(t1.toStringRec(t1.racine, ""));
		System.out.println(t1.get("20204567"));
		System.out.println("######################");
		System.out.println(t1.get("20203333"));
		
		
	}

	

}
