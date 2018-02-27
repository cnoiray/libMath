package math.controler.exception;

public class PropertyValueErrorException extends Exception {
	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 8L;

	/**
	 * Constructeur de la classe d'erreur de dimension
	 * Les dimensions entre deux matrices ne sont pas identiques
	 */
	public PropertyValueErrorException(){
		super("Valeur Propre Error");
	}
}
