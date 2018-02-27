package math.exception.item;

/**
 * Classe de gestion d'exception pour des méthodes nécessitant l'utilisation de matrice carrée
 * 
 * @author clément
 *
 */
public class SquareMatriceErrorException extends Exception {

	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Constructeur de la classe d'erreur de dimension
	 * Les dimensions entre deux matrices ne sont pas identiques
	 */
	public SquareMatriceErrorException(){
		super("Square Matrix Error");
	}
}
