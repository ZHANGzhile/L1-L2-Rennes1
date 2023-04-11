public class Pile {

	private class Element {
		public int valeur;
		public Element suivant;
		
		public Element(int valeur) {
			this.valeur = valeur;
			this.suivant = null;
		}
		
		public Element(int valeur, Element suivant) {
			this.valeur = valeur;
			this.suivant = suivant;
		}
	}
	
	private Element top;
	
	public Pile() {
		top = null;
	}
	
	public void push(int x) {
		top = new Element(x, top);
	}
	
	public int pop() {
		int resultat = -1;
		if (top != null) {
			resultat = top.valeur;
			top = top.suivant;
		}
		return resultat;
	}
	
	public static void main(String[] args) {
		Pile p = new Pile();
		p.push(1);
		//System.out.println("********** "+p.pop());
		p.push(2);
		//System.out.println("**********"+p.pop());
		p.push(3);
		System.out.println(p.pop() + "\n" + p.pop() + "\n" + p.pop());
		System.out.println(p.pop());
	}
	
}
