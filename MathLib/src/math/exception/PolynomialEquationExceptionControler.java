package math.exception;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;
import math.exception.item.DivisionByZeroException;
import math.exception.item.PolynomialEquationException;

public class PolynomialEquationExceptionControler {
	
	/**
	 * M�thode de controle pour une division
	 * 
	 * @param polynome
	 * @throws DivisionByZeroException
	 */
	public static void controleNonZeroDivision(Polynome polynome) throws DivisionByZeroException{
		if(polynome.formeDeveloppee.size() == 0)
			throw new DivisionByZeroException();
	}
	
	/**
	 * M�thode de controle du degr�s d'un polynome
	 * 
	 * @param polynome
	 * @param degresMini
	 * @throws PolynomeException
	 */
	public static void controleNbrDegres(Polynome polynome, int degresMini) throws PolynomialEquationException{
		if(polynome.formeDeveloppee.size() < degresMini)
			throw new PolynomialEquationException(degresMini);
	}

	/**
	 * M�thode de controle de l'�tat du discriminant
	 * Permet de determiner si les r�sultats seront dans le domaine r�el
	 * 
	 * @param discriminant
	 * @throws PolynomeException
	 */
	public static void controleDiscriminant(MathObject discriminant) throws PolynomialEquationException {
		if(((Reel)discriminant).reel < 0)
			throw new PolynomialEquationException("Le discriminant est nul. Le calcul ne peut pas �tre terminer dans le domaine des r�els.");
	}
}
