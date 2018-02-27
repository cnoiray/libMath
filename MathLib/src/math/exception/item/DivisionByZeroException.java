package math.exception.item;

/**
 * Classe de gestion d'exception pour le cas d'une division par zéro
 * 
 * @author clément
 *
 */
public class DivisionByZeroException extends Exception {
	
	/**
	 * numero de l'exception
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * Constructeur de la classe d'erreur d'une tentative de division par zero
	 */
	public DivisionByZeroException(){
		super("Division by zero");
	}
}
