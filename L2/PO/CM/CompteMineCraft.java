package CM3;

public class CompteMineCraft {

	private String login ; // nom 
	private int enchantingLevel;
	private int hitPoints;
	private double coordX, coordY, coordZ;
	private String idMonde;
	private boolean isPremium;
	
	//inventaire
	// controles
	// skin
	
	
	public CompteMineCraft(String login, int enchantingLevel, boolean isPremium) {
		this.login = login;
		this.enchantingLevel = enchantingLevel;
		this.isPremium = isPremium;
	}
	
	public void affichCompte () {
		System.out.println("Login: "+ this.login);
		System.out.println("Enchanting lvl: "+this.enchantingLevel);
		System.out.println(this.isPremium?"Premium Customer":"F2P");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
