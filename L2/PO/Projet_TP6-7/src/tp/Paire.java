package tp;

public class Paire {
	
	private String cle;
	private String valeur;
	
	Paire(String cle, String valeur){
		this.cle = cle;
		this.valeur = valeur;
	}
	
	public String getCle() {
		return cle;
	}
	
	public void setCle(String cle) {
		this.cle = cle;
	}
	
	public String getValeur() {
		return valeur;
	}
	
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "Paire [cle=" + cle + ", valeur=" + valeur + "]";
	}
	
	
	
	
}
