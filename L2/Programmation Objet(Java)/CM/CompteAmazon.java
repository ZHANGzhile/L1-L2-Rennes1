public class CompteAmazon{

	private class Produit{
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
	
	private class ElemProd{
		Produit p;
		ElemProd suivant;

		ElemProd(Produit p, ElemProd suivant){
			this.p = p;
			this.suivant = suivant;
		}

		ElemProd(Produit p){
			this.p = p;
			this.suivant = null;
		}
	}

	private class ElemCmd{
		ElemProd commande;
		ElemCmd suivant;

		ElemCmd(ElemProd commande, ElemCmd suivant){
			this.commande = commande;
			this.suivant = suivant;
		}
		ElemCmd(ElemProd commande){
			this.commande = commande;
			this.suivant = null;
		}
	}

	private ElemCmd permiereCmd;

	public ElemCmd getPremiereCmd(){
		return this.permiereCmd;
	}

	CompteAmazon(){
		this.permiereCmd = null;
	}

	public double getTotal(){
		double total = 0;
		ElemCmd pointeurCmd = permiereCmd;
		ElemProd pointeurProd = permiereCmd.commande;

		while(pointeurCmd != null ){
			while(pointeurProd != null){
				total += pointeurProd.p.prix;
				pointeurProd = pointeurProd.suivant;
			}
			pointeurCmd = pointeurCmd.suivant;
			pointeurProd = pointeurCmd.commande;
		}

		return total;
	}
}