public class ListeLignes {
	
	private Element premier, dernier;
	
	public ListeLignes() {
		premier = null;
		dernier = null;
	}
	
	public void ajouteLigne(String ligne) {
		
		Element e = new Element(ligne);
		
		if (premier == null) {
			premier = e;
			dernier = e;
		} else {
			dernier.suivant = e;
			dernier = e;
		}
		
	}
	
	public String toString() {
		String resultat = "";
		
		Element tmp = premier;
		while (tmp != null) {
			resultat += tmp.ligne + "\n";
			tmp = tmp.suivant ;
		}
		
		return resultat;
		
	}

	public static void main(String[] args) {
		ListeLignes l1 = new ListeLignes();
		l1.ajouteLigne("a");
		l1.ajouteLigne("b");
		
	}

}
