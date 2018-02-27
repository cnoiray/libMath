package math.exception.item;

/**
 * Classe de gestion d'exception pour des méthodes nécessitant l'utilisation de matrice diagonale
 * 
 * @author clément
 *
 */
public class DiagonalMatriceErrorException extends Exception {
	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 6L;

	/**
	 * Constructeur de la classe d'erreur
	 */
	public DiagonalMatriceErrorException(){
		super("Diagonal Matrix Error");
	}
	
	/**
	 * Constructeur de la classe d'erreur
	 * 
	 * @param String message
	 */
	public DiagonalMatriceErrorException(String message){
		super("Diagonal Matrix Error: "+message);
	}
}
