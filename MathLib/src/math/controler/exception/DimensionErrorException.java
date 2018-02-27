package math.controler.exception;

/**
 * Classe de gestion d'exception de diff�rence de dimension
 * 
 * @author cl�ment
 *
 */
public class DimensionErrorException extends Exception {
	/**
	 *  numero de version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe d'erreur de dimension
	 * Les dimensions entre deux matrices ne sont pas identiques
	 */
	public DimensionErrorException(){
		super("Dimension Error");
	}

	/**
	 * Contructeur de la classe d'erreur de dimension
	 * Les dimensions entre deux matrices ne sont pas identiques
	 * 
	 * @param int dim1
	 * @param int dim2
	 */
	public DimensionErrorException(int dim1, int dim2) {
		super("Dimension Error: diff�rence de dim entre matrice de dim "+dim1+" et dim de "+dim2);
	}
}
