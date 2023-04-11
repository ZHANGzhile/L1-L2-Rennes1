package tp;

public class ATList extends AssoTable {

	Element premier;

	private class Element {
		Paire cv;
		Element suivant;

		Element(Paire cv) {
			this.cv = cv;
			this.suivant = null;
		}

		Element(Paire cv, Element suivant) {
			this.cv = cv;
			this.suivant = suivant;
		}

		public Paire getCv() {
			return cv;
		}

		public void setCv(Paire cv) {
			this.cv = cv;
		}

		public Element getSuivant() {
			return suivant;
		}

		public void setSuivant(Element suivant) {
			this.suivant = suivant;
		}

	}

	public ATList() {
		super();
		premier = null;
		// TODO Auto-generated constructor stub
	}

	public boolean estVide() {
		return premier == null;
	}

	@Override
	public void associe(String cle, String valeur) {
		// TODO Auto-generated method stub
		if (!estVide()) {
			Element courant = premier;
			while (courant.suivant != null) {
				courant = courant.suivant;
			}
			courant.suivant = new Element(new Paire(cle, valeur), null);
		} else {
			premier = new Element(new Paire(cle, valeur), null);
		}
	}

	@Override
	public void supprime(String cle) {
		// TODO Auto-generated method stub
		if (!estVide()) {
			Element courant = premier;
			if (premier.cv.getCle() == cle) {
				premier = premier.suivant;
			} else {
				while (courant.suivant != null) {
					if (courant.suivant.cv.getCle() == cle) {
						courant.suivant = courant.suivant.suivant;
					}
				}
			}
		}

	}

	@Override
	public String get(String cle) {
		// TODO Auto-generated method stub
		if (!estVide()) {
			Element courant = premier;
			while (courant != null) {
				if (courant.cv.getCle().equals(cle)) {
					return courant.cv.getValeur();
				}
				courant = courant.suivant;
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		Element courant = premier;
		String s = "";
		while (courant != null) {
			s += courant.cv.getCle() + " " + courant.cv.getValeur() + "\n";
			courant = courant.suivant;
		}
		return s;
	}

	public static void main(String[] args) {
		ATList l1 = new ATList();
		l1.associe("238.124.22.53", "Thomas Dubois, 11 rue des graviers, Rennes");
		l1.associe("74.125.136.99", "Google, 1600 amphiteatre parkway, MountainView");
		System.out.println(l1.toString());
		System.out.println("*******************");
		l1.supprime("238.124.22.53");
		System.out.println(l1.toString());
		System.out.println(l1.get("12"));
	}
}
