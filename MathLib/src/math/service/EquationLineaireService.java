package math.service;

import math.controler.Operation;
import math.entities.EquationLineaire;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;
import math.exception.MatrixExceptionControler;
import math.exception.item.DiagonalMatriceErrorException;
import math.exception.item.DivisionByZeroException;
import math.exception.item.SquareMatriceErrorException;
import math.exception.item.TriangularMatriceErrorException;

/**
 * Classe de regroupant les méthodes de traitement des équations linéaires
 * 
 * @author clément
 *
 */
public class EquationLineaireService {
	private static final String ERROR_GAUSS_FIRST = "Erreur lors de la triangularisation de la matrice (étape 1)";
	private static final String ERROR_GAUSS_SECOND = "Erreur lors de la diagonalisation de la matrice (étape 2)";
	
	/**
	 * Méthode permettant de déterminer s'il s'aggit d'une équation linéaire homogène
	 * système est homogène si la matrice de constante est une matrice vide
	 * 
	 * @return boolean resultat
	 */
	public boolean isHomogene(EquationLineaire equationLineaire){
		int i;
		for (i = 0; i < equationLineaire.getConstante().nb_ligne; i++) {
			if(!equationLineaire.getConstante().getValue(i, 0).isNull())
				return false;
		}
		return true;
	}
	
	//OPERATION ELEMENTAIRE SUR LES EQUATIONS LINEAIRES
	/**
	 * Méthode qui permet de multiplier une ligne par un scalaire
	 * 
	 * @param int numero ligne
	 * @param MathObject valeur scalaire
	 * @return 
	 */
	public void multiplyLineByScalaire(EquationLineaire equationLineaire, int ligne, MathObject scalaire){
		//pour la matrice de transformation
		equationLineaire.setTransformation(equationLineaire.getTransformation().multiplyLigneByScalaire(scalaire, ligne));
		//pour la matrice de constante
		equationLineaire.setConstante(equationLineaire.getConstante().multiplyLigneByScalaire(scalaire, ligne));
	}
	
	/**
	 * Méthode qui permet la permutation de de ligne dans le système d'équation
	 * 
	 * @param int ligne1 à permuter
	 * @param int ligne2 à permuter
	 */
	public void permutation(EquationLineaire equationLineaire, int ligne1, int ligne2){
		//pour la matrice de transformation
		Matrice matriceLigne1 = equationLineaire.getTransformation().getLigne(ligne1);
		equationLineaire.getTransformation().setLigne(ligne1, equationLineaire.getTransformation().getLigne(ligne2));
		equationLineaire.getTransformation().setLigne(ligne2, matriceLigne1);
		
		//pour la matrice de constante
		MathObject constante = equationLineaire.getConstante().getValue(ligne1, 0);
		equationLineaire.getConstante().setValue(ligne1, 0, equationLineaire.getConstante().getValue(ligne2, 0));
		equationLineaire.getConstante().setValue(ligne2, 0, constante);
	}
	
	/**
	 * Méthode qui permet d'ajouter une ligne à une autre multiplié à un scalaire
	 * (Li) <- (Li)+(Lj)*a
	 * 
	 * @param int ligne1 i
	 * @param int ligne2 j
	 * @param MathObject scalaire a
	 */
	public void addLigneAndScalaire(EquationLineaire equationLineaire, int ligne1, int ligne2, MathObject polyme){
		int j;
		//pour la matrice de transformation
		for (j = 0; j < equationLineaire.getTransformation().nb_col; j++)
			equationLineaire.getTransformation().setValue(ligne1, j, 
					Operation.additionner(
							equationLineaire.getTransformation().getValue(ligne1, j),
							Operation.multiplier(
								equationLineaire.getTransformation().getValue(ligne2, j),
								polyme)));
		//pour la matrice de constante
		equationLineaire.getConstante().setValue(ligne1, 0, 
				Operation.additionner(
					equationLineaire.getConstante().getValue(ligne1, 0),
					Operation.multiplier(
							equationLineaire.getConstante().getValue(ligne2, 0),
							polyme)));
	}
	
	//METHODE DE RESOLUTION DES SYSTEMES LINEAIRES
	/**
	 * Calcul de la solution de l'équation linéaire à travers la méthode de Cramer
	 * 
	 * @param EquationLineaire equationLineaire
	 * @return Matrice resultat
	 */
	public Matrice cramerResolution(EquationLineaire equationLineaire){
		try {
			MatrixExceptionControler.controleSquareMatrix(equationLineaire.getTransformation());
			
			Matrice resultat = equationLineaire.getConstante().copy();
			MathObject determinant = equationLineaire.getTransformation().determinant();
			
			MatrixExceptionControler.controleNoZeroDivision(determinant);
			
			int i;
			for (i = 0; i < equationLineaire.getNbr_ligne(); i++){
				//calcul det de A en remplacant le i ème colonne pour la colonne de constante
				Matrice matriceModif = equationLineaire.getTransformation().copy();
				matriceModif.setColonne(i, equationLineaire.getConstante());
				//calcul de la solution unique
				//ajout de la solution à la matrice retour
				resultat.setValue(i, 0, Operation.diviser(matriceModif.determinant(), determinant));
			}
			
			return resultat;
		} catch (SquareMatriceErrorException | DivisionByZeroException e) {
			e.printStackTrace();
			return new Matrice();
		}
	}
	
	/**
	 * Calcul de la solution de l'équation linéaire à travers la méthode de l'inversion matricielle
	 * 
	 * @param EquationLineaire equationLineaire
	 * @return Matrice resultat
	 */
	public Matrice matrixInversionResolution(EquationLineaire equationLineaire){
		return (Matrice) Operation.multiplier(
				equationLineaire.getTransformation().inverse(), 
				equationLineaire.getConstante());
	}
	
	/**
	 * Calcul de la solution de l'équation linéaire à travers la méthode du pivot de Gauss
	 * 
	 * @param EquationLineaire equationLineaire
	 * @return Matrice resultat
	 */
	public Matrice pivotGaussResolution(EquationLineaire equationLineaireParam){
		EquationLineaire equationLineaire = equationLineaireParam.copy();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(equationLineaire.getTransformation());
			
			//triangularisation de la matrice
			int i, k;
			for (i = 1; i < equationLineaire.getNbr_ligne(); i++){
				for (k = i; k < equationLineaire.getNbr_ligne(); k++){
					addLigneAndScalaire(equationLineaire, k, i-1, 
							Operation.multiplier(
									equationLineaire.getTransformation().getValue(k, i-1),
									new Reel(-1)));
					if(i==k && !equationLineaire.getTransformation().getValue(k, k).isNull())
						multiplyLineByScalaire(equationLineaire, k, Operation.diviser(new Reel(1), equationLineaire.getTransformation().getValue(k, k)));
				}
			}
			
			MatrixExceptionControler.controleTriangularMatrix(equationLineaire.getTransformation(), ERROR_GAUSS_FIRST);
			
			//on remonte pour arriver à une matrice diagonale
			for (i = equationLineaire.getNbr_ligne()-2; i >= 0; i--){
				for (k = i; k >= 0; k--){
					addLigneAndScalaire(equationLineaire, k, i+1,
							Operation.multiplier(
									equationLineaire.getTransformation().getValue(k, i+1),
									new Reel(-1)));
				}
			}
			
			MatrixExceptionControler.controleDiagonalMatrix(equationLineaire.getTransformation(), ERROR_GAUSS_SECOND);
			
			return equationLineaire.getConstante();
		} catch (SquareMatriceErrorException | TriangularMatriceErrorException | DiagonalMatriceErrorException e) {
			e.printStackTrace();
		}
		return equationLineaire.getTransformation();
	}
}
