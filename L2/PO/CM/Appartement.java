public class Appartement extends BienImmobilier{
	private int etage;

	Appartement(double prix, String description, String contact, int etage){
		super(prix,description,contact);
		this.etage = etage;
	}

	public String toString(){
		return "c'est l'Appartement et l'etage est " + etage + "\n" + super.toString();
	}

	public static void main(String[] args) {
		Appartement l = new Appartement(350,"null","null",3);
		System.out.println(l.toString());
	}
}