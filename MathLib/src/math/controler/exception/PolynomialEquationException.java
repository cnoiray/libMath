package math.controler.exception;

/**
 * Classe de gestion d'exception pour les polynomes
 * 
 * @author clément
 *
 */
public class PolynomialEquationException extends Exception {
	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 7L;

	/**
	 * Constructeur de la classe d'erreur
	 * 
	 * @param sizeMin
	 */
	public PolynomialEquationException(int sizeMin){
		super("Polynomial Equation Error: polynom size higher than " + sizeMin);
	}
	
	/**
	 * Constructeur de la classe d'erreur
	 * 
	 * @param message
	 */
	public PolynomialEquationException(String message){
		super(message);
	}
}
