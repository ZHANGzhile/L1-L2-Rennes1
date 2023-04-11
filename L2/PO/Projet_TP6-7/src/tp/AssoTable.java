package tp;
public abstract class AssoTable {
	

	/**
	 * Crée une association entre une clé et une valeur. 
	 * Si une association (clé, autre valeur) existe déjà , elle est écrasée. 
	 * 
	 * @param cle Clé de l'association, supposée non nulle
	 * @param valeur  Valeur de l'association, supposÃ©e non nulle
	 */
	public abstract void associe(String cle, String valeur) ;
	
	/**
	 * Supprime l'association (cle, valeur) si elle existe, sinon ne fait rien
	 * 
	 * @param cle Clé de l'association à supprimer
	 */
	public abstract void supprime(String cle) ;
	
	/**
	 * Renvoie la valeur associée à  la clé indiquée.
	 * 
	 * @param cle Clé recherchée
	 * @return Valeur associée à  cle, null sinon
	 */
	public abstract String get(String cle) ;
	
	
	
}
