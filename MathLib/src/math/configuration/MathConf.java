package math.configuration;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Classe de chargement des configurations du logiciel pour l'aspect mathématique
 * A PASSER EN SINGLETON
 * 
 * @author clément
 *
 */
public final class MathConf {
	/**
	 * gestion de precision des résultats à 10^-n
	 */
	private static DecimalFormat df = new DecimalFormat();
	private static int nombreDecimal = 4;
	private static Locale local = Locale.FRANCE;
	private static int nbrMaxIterationNewtonMethodePolynome = 100;
	private static float precisionNewtonMethodePolynome = (float)0.0000001;
	
	public static long NBR_POINT_COURBE = 1000;
	public static int X_MIN = 0;
	public static int X_MAX = 1;
	
	public MathConf() {
		MathConf.df.setMaximumFractionDigits(nombreDecimal);
		MathConf.df.setMinimumFractionDigits(nombreDecimal);
	}

	/**
	 * @return the df
	 */
	public static DecimalFormat getDf() {
		return df;
	}

	/**
	 * @return the nombreDecimal
	 */
	public static int getNombreDecimal() {
		return nombreDecimal;
	}

	/**
	 * @return the local
	 */
	public static Locale getLocal() {
		return local;
	}

	/**
	 * @return the nbrMaxIterationNewtonMethodePolynome
	 */
	public static int getNbrMaxIterationNewtonMethodePolynome() {
		return nbrMaxIterationNewtonMethodePolynome;
	}

	/**
	 * @return the precisionNewtonMethodePolynome
	 */
	public static float getPrecisionNewtonMethodePolynome() {
		return precisionNewtonMethodePolynome;
	}
}
