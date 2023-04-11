public class ProduitDematerialise extends Produit{
	public ProduitDematerialise(String nom, int quantite, double prix){
		super(nom,quantite,prix);
	}

	public boolean estDisponible(Produit p, int quantite){
		return true;
	}
}