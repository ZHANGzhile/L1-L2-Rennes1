public class TestProduit{
	public static void main(String[] args) {
		Produit p = new ProduitDematerialise("nn",3,3.0);
		System.out.println(p.estDisponible(p,3));
	}
}
