package math.exception;

import java.util.List;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.exception.item.DiagonalMatriceErrorException;
import math.exception.item.DimensionErrorException;
import math.exception.item.DivisionByZeroException;
import math.exception.item.LinearEquationException;
import math.exception.item.PropertyValueErrorException;
import math.exception.item.SquareMatriceErrorException;
import math.exception.item.TriangularMatriceErrorException;

public class MatrixExceptionControler {
	/**
	 * Methode de controle des dimensions de deux matrices
	 * 
	 * @param Matrice matriceA
	 * @param Matrice matriceB
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatrices(Matrice matriceA, Matrice matriceB) throws DimensionErrorException {
		if(matriceA.nb_ligne!=matriceB.nb_ligne || 
				matriceA.nb_col != matriceB.nb_col)
			throw new DimensionErrorException();
	}
	
	/**
	 * Methode de controle des dimensions d'une matrice et d'une ligne
	 * 
	 * @param Matrice matriceA
	 * @param float[] ligne
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatriceLigne(Matrice matriceA, MathObject[] ligne) throws DimensionErrorException {
		if(matriceA.nb_col!=ligne.length)
			throw new DimensionErrorException();
	}
	
	/**
	 * Methode de controle des dimensions d'une matrice et d'une ligne
	 * 
	 * @param Matrice matriceA
	 * @param float[] colonne
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatriceColonne(Matrice matriceA, MathObject[] colonne) throws DimensionErrorException {
		if(matriceA.nb_ligne!=colonne.length)
			throw new DimensionErrorException();
	}
	
	/**
	 * Methode de controle des dimensions d'une matrice et d'une ligne
	 * 
	 * @param Matrice matriceA
	 * @param int dimLigne
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatriceLigne(Matrice matriceA, int dimLigne) throws DimensionErrorException {
		if(matriceA.nb_col!=dimLigne)
			throw new DimensionErrorException(matriceA.nb_col, dimLigne);
	}
	
	/**
	 * Methode de controle des dimensions d'une matrice et d'une matrice ligne
	 * 
	 * @param Matrice matriceA
	 * @param Matrice ligne
	 * @throws DimensionErrorException 
	 */
	public static void controleDimentionMatriceLigne(Matrice matriceA,
			Matrice ligne) throws DimensionErrorException {
		if(matriceA.nb_col!=ligne.nb_col || ligne.nb_ligne!=1)
			throw new DimensionErrorException(matriceA.nb_col, ligne.nb_col);
	}
	
	/**
	 * Methode de controle des dimensions d'une matrice et d'une colonne
	 * 
	 * @param Matrice matriceA
	 * @param int dimColonne
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatriceColonne(Matrice matriceA, int dimColonne) throws DimensionErrorException {
		if(matriceA.nb_ligne!=dimColonne)
			throw new DimensionErrorException();
	}

	/**
	 * Méthode de controle des dimensions d'une matrice pour une multiplication
	 * 
	 * @param Matrice matriceA
	 * @param Matrice matriceB
	 * @throws DimensionErrorException
	 */
	public static void controleDimentionMatricesForMultiplication(
			Matrice matriceA, Matrice matriceB) throws DimensionErrorException {
		if(matriceA.nb_col!=matriceB.nb_ligne)
			throw new DimensionErrorException(matriceA.nb_col, matriceB.nb_ligne);
		
	}
	
	/**
	 * Méthode de controle des dimensions pour correspondre à une matrice carrée
	 * 
	 * @param Matrice matrice à tester
	 * @throws SquareMatriceErrorException
	 */
	public static void controleSquareMatrix(Matrice matrice) throws SquareMatriceErrorException{
		if(matrice.nb_ligne!=matrice.nb_col)
			throw new SquareMatriceErrorException();
	}
	
	/**
	 * Méthode de controle des dimensions pour correspondre à une équation linéaire
	 * 
	 * @param Matrice transformation à tester
	 * @param Matrice constante à tester
	 * @throws LinearEquationException
	 */
	public static void controleSystemeEquationBuilder(Matrice transformation, Matrice constante) throws LinearEquationException{
		if(transformation.nb_ligne != constante.nb_ligne && constante.nb_col!=1)
			throw new LinearEquationException();
	}

	/**
	 * Méthode de controle pour une division
	 * 
	 * @param float value
	 * @throws DivisionByZeroException
	 */
	public static void controleNoZeroDivision(float value) throws DivisionByZeroException {
		if(value==0)
			throw new DivisionByZeroException();
	}
	
	public static void controleNoZeroDivision(MathObject value) throws DivisionByZeroException {
		if(value.isNull())
			throw new DivisionByZeroException();
	}

	/**
	 * Méthode de controle d'une matrice triangulaire
	 * 
	 * @param Matrice matrice 
	 * @param String message
	 * @throws TriangularMatriceErrorException 
	 */
	public static void controleTriangularMatrix(Matrice matrice, String message) throws TriangularMatriceErrorException {
		if(!matrice.isTriangularMatrice())
			throw new TriangularMatriceErrorException(message);
	}

	/**
	 * Méthode de controle d'une matrice diagonale
	 * 
	 * @param Matrice matrice
	 * @param String message
	 * @throws DiagonalMatriceErrorException
	 */
	public static void controleDiagonalMatrix(Matrice matrice,
			String message) throws DiagonalMatriceErrorException {
		if(!matrice.isDiagonalMatrice())
			throw new DiagonalMatriceErrorException(message);
	}

	/**
	 * Méthode de controle du bon nombre de valeur propre obtenue
	 * @param valeurPropreList
	 * @param matrice
	 * @throws PropertyValueErrorException
	 */
	public static void controleValeurPropre(List<MathObject> valeurPropreList,
			Matrice matrice) throws PropertyValueErrorException {
		if(valeurPropreList.size() != matrice.nb_ligne)
			throw new PropertyValueErrorException();
	}

	/**
	 * Méthode de controle du bon résultat pour le calcul d'un vecteur propre
	 * @param matrice
	 * @throws PropertyValueErrorException
	 */
	public static void controleVecteurPropre(Matrice matrice) throws PropertyValueErrorException {
		int i;
		Matrice ligne0 = matrice.getLigne(0);
		Matrice ligne;
		for (i = 0; i < matrice.nb_ligne; i++) {
			ligne = matrice.getLigne(i);
			if(ligne0.equals(ligne))
				throw new PropertyValueErrorException();
		}
	}
}
