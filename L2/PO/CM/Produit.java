public abstract class Produit{
	private String nom;
	private int quantite;
	private double prix;

	public Produit(String nom, int quantite, double prix){
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
	}

	//public boolean estDisponible(Produit p, int quantite){};

	public double getPrix(){
		return this.prix;
	}
}

