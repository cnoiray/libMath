package math.service;

public class MathObjectService {
	/**
	 * Permet de determiner si la valeur est un entier
	 * @param value
	 * @return
	 */
	public static boolean isEntier(float value){
		if(value == (int)value)
			return true;
		return false;
	}
}
