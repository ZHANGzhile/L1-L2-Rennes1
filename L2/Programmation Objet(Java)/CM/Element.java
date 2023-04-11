public class Element {
	
	public String ligne;
	public Element suivant;
	
	public Element(String ligne) {
		this.ligne = ligne;
		this.suivant = null;
	}

	public Element(String ligne, Element suivant) {
		this.ligne = ligne;
		this.suivant = suivant;
	}
	
	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	
	
}
