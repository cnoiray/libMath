package math.exception.item;

/**
 * Classe de gestion d'exception pour les �quations lin�aires
 * 
 * @author cl�ment
 *
 */
public class LinearEquationException  extends Exception {

	/**
	 * numero de version
	 */
	private static final long serialVersionUID = 3L;
	
	/**
	 * Constructeur de la classe d'erreur de dimension
	 * Les dimensions entre deux matrices ne sont pas compatibles avec une �quation lin�aire
	 */
	public LinearEquationException(){
		super("Linear Equation Error: dimension of A lign and B lign are not equals or dim col B is not equal at 1");
	}

}
