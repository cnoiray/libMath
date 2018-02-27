package math.controler.exception;

/**
 * Classe de gestion d'exception pour des méthodes nécessitant l'utilisation de matrice triangulaire
 * 
 * @author clément
 *
 */
public class TriangularMatriceErrorException extends Exception {
	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Constructeur de la classe d'erreur
	 */
	public TriangularMatriceErrorException(){
		super("Triangule Matrix Error");
	}
	
	/**
	 * Constructeur de la classe d'erreur
	 * 
	 * @param String message
	 */
	public TriangularMatriceErrorException(String message){
		super("Triangule Matrix Error: "+message);
	}
}
