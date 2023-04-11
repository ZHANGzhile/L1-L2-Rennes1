package CM3;

public class TestMineCraft {
	// compte minceCraft est prive donc affich il a pas d'acces aux variables.
	/*
	public static void affichCompte (CompteMineCraft cm) {
		System.out.println("Login: "+cm.login);
		System.out.println("Enchanting lvl: "+cm.enchantingLevel);
		System.out.println(cm.isPremium?"Premium Customer":"F2P");
	}
	*/

	
	public static void main(String[] args) {
		/*
		CompteMineCraft compteEloise = new CompteMineCraft();
		compteEloise.login = "lol'loise";
		compteEloise.enchantingLevel = 32;
		compteEloise.isPremium = false;
		compteEloise.hitPoints = 10;
		
		System.out.println("Login: "+compteEloise.login);
		System.out.println("Enchanting lvl: "+compteEloise.enchantingLevel);
		System.out.println(compteEloise.isPremium?"Premium Customer":"F2P");
		
		System.out.println();
		
		affichCompte(compteEloise); // les codes sont plus propre comme ca
		*/
		CompteMineCraft compteEloise = new CompteMineCraft("lol'loise",32,false);
		// affichCompte(compteEloise);
		compteEloise.affichCompte();
		System.out.println();
		
		CompteMineCraft compteGwendaz = new CompteMineCraft("darksasuke",8,true);
		
		// affichCompte(compteGwendaz);
		compteGwendaz.affichCompte();
		}

}
