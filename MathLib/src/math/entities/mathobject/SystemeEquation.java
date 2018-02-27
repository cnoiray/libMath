package math.entities.mathobject;

import java.lang.reflect.InvocationTargetException;

import math.controler.Operation;
import math.exception.MatrixExceptionControler;
import math.exception.item.DiagonalMatriceErrorException;
import math.exception.item.DivisionByZeroException;
import math.exception.item.LinearEquationException;
import math.exception.item.SquareMatriceErrorException;
import math.exception.item.TriangularMatriceErrorException;

public class SystemeEquation extends MathObject{
	/**
	 * nombre de ligne pour l'équation linéaire
	 */
	public int nbr_ligne;
	/**
	 * nombre de colonne pour la matrice de transformation
	 */
	public int nbr_inconnue;
	/**
	 * matrice colonne B contennant les constantes
	 */
	public Matrice constante;
	/**
	 * matrice de transformation A tel que A*X=B
	 */
	public Matrice transformation;
	
	/**
	 * Message erreur pour résolution de gauss
	 */
	private final String ERROR_GAUSS_FIRST = "Erreur lors de la triangularisation de la matrice (étape 1)";
	private final String ERROR_GAUSS_SECOND = "Erreur lors de la diagonalisation de la matrice (étape 2)";
	
	/**
	 * Constructeur par défaut d'une équation linéaire
	 */
	public SystemeEquation() {
		this.nbr_inconnue = 0;
		this.nbr_ligne = 0;
		this.constante = new Matrice();
		this.transformation = new Matrice();
	}
	
	/**
	 * Constructeur d'une équation linéaire à partir de la connaissance du nombre de ligne et de colonne
	 * 
	 * @param int nbr_ligne
	 * @param int nbr_inconnue
	 */
	public SystemeEquation(int nbr_ligne, int nbr_inconnue){
		this.nbr_inconnue = nbr_inconnue;
		this.nbr_ligne = nbr_ligne;
		this.constante = new Matrice(nbr_ligne, 1);
		this.transformation = new Matrice(nbr_ligne, nbr_inconnue);
		}
	
	/**
	 * Constructeur d'une équation linéaire à partir des matrices de transformation et de constante
	 * 
	 * @param Matrice transformation
	 * @param Matrice constante
	 */
	public SystemeEquation(Matrice transformation, Matrice constante){
		try {
			MatrixExceptionControler.controleSystemeEquationBuilder(transformation, constante);
			
			this.nbr_inconnue = transformation.nb_col;
			this.nbr_ligne = transformation.nb_col;
			this.constante = constante;
			this.transformation = transformation;
		} catch (LinearEquationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode de resolution du systeme
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Matrice resolutionEquationLineaire(){
		if(this.isHomogene() && 
				this.transformation.determinant().isNull()){
			return this.pivotGaussResolution();
		}else{
			return this.cramerResolution();
		}
	}
	
	/**
	 * Méthode permettant de déterminer s'il s'aggit d'une équation linéaire homogène
	 * système est homogène si la matrice de constante est une matrice vide
	 * 
	 * @return boolean resultat
	 */
	public boolean isHomogene(){
		int i;
		for (i = 0; i < this.constante.nb_ligne; i++) {
			if(!this.constante.getValue(i, 0).isNull())
				return false;
		}
		return true;
	}
	
	/**
	 * Méthode d'affichage d'une équation linéaire
	 * 
	 * @param SystemeEquation equationLineaire
	 */
	public void afficher(){
		Matrice transformation = this.transformation;
		Matrice constante = this.constante;
		transformation.arrondir();
		constante.arrondir();
		
		StringBuilder stringBuilder = new StringBuilder();
		int i, j;
		for (i = 0; i < transformation.nb_ligne; i++) {
			stringBuilder.append("| ");
			for (j = 0; j < transformation.nb_col; j++){
				stringBuilder.append(transformation.getValue(i, j).toString());
				stringBuilder.append(" ");
			}
			stringBuilder.append("| ");
			stringBuilder.append(constante.getValue(i, 0).toString());
			stringBuilder.append(" |");
			System.out.println(stringBuilder.toString());
			stringBuilder.delete(0, stringBuilder.toString().length());
		}
		System.out.println("");
	}
	
	//OPERATION ELEMENTAIRE SUR LES EQUATIONS LINEAIRES
	/**
	 * Méthode qui permet de multiplier une ligne par un scalaire
	 * 
	 * @param int numero ligne
	 * @param float valeur scalaire
	 * @return 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public void multiplyLineByScalaire(int ligne, MathObject scalaire){
		//pour la matrice de transformation
		this.transformation = this.transformation.multiplyLigneByScalaire(scalaire, ligne);
		//pour la matrice de constante
		this.constante = this.constante.multiplyLigneByScalaire(scalaire, ligne);
	}
	
	/**
	 * Méthode qui permet la permutation de de ligne dans le système d'équation
	 * 
	 * @param int ligne1 à permuter
	 * @param int ligne2 à permuter
	 */
	public void permutation(int ligne1, int ligne2){
		//pour la matrice de transformation
		Matrice matriceLigne1 = this.transformation.getLigne(ligne1);
		this.transformation.setLigne(ligne1, this.transformation.getLigne(ligne2));
		this.transformation.setLigne(ligne2, matriceLigne1);
		
		//pour la matrice de constante
		MathObject constante = this.constante.getValue(ligne1, 0);
		this.constante.setValue(ligne1, 0, this.constante.getValue(ligne2, 0));
		this.constante.setValue(ligne2, 0, constante);
	}
	
	/**
	 * Méthode qui permet d'ajouter une ligne à une autre multiplié à un scalaire
	 * (Li) <- (Li)+(Lj)*a
	 * 
	 * @param int ligne1 i
	 * @param int ligne2 j
	 * @param float scalaire a
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public void addLigneAndScalaire(int ligne1, int ligne2, MathObject polyme){
		int j;
		//pour la matrice de transformation
		for (j = 0; j < this.transformation.nb_col; j++)
			this.transformation.setValue(ligne1, j, 
					Operation.additionner(
							this.transformation.getValue(ligne1, j),
							Operation.multiplier(
									this.transformation.getValue(ligne2, j),
								polyme)));
		//pour la matrice de constante
		this.constante.setValue(ligne1, 0, 
				Operation.additionner(
						this.constante.getValue(ligne1, 0),
					Operation.multiplier(
							this.constante.getValue(ligne2, 0),
							polyme)));
	}
	
	//METHODE DE RESOLUTION DES SYSTEMES LINEAIRES
	/**
	 * Calcul de la solution de l'équation linéaire à travers la méthode de Cramer
	 * 
	 * @param SystemeEquation equationLineaire
	 * @return Matrice resultat
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Matrice cramerResolution(){
		try {
			MatrixExceptionControler.controleSquareMatrix(this.transformation);
			
			Matrice resultat = this.constante.copy();
			MathObject determinant = this.transformation.determinant();
			
			MatrixExceptionControler.controleNoZeroDivision(determinant);
			
			int i;
			for (i = 0; i < this.nbr_ligne; i++){
				//calcul det de A en remplacant le i ème colonne pour la colonne de constante
				Matrice matriceModif = this.transformation.copy();
				matriceModif.setColonne(i, this.constante);
				//calcul de la solution unique
				//ajout de la solution à la matrice retour
				resultat.setValue(i, 0, Operation.diviser(matriceModif.determinant(),determinant));
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
	 * @param SystemeEquation equationLineaire
	 * @return Matrice resultat
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public MathObject matrixInversionResolution(){
		return Operation.multiplier(
				this.transformation.inverse(), 
				this.constante);
	}
	
	/**
	 * Calcul de la solution de l'équation linéaire à travers la méthode du pivot de Gauss
	 * 
	 * @param SystemeEquation equationLineaire
	 * @return Matrice resultat
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Matrice pivotGaussResolution(){
		SystemeEquation equationLineaire = this.copy();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(equationLineaire.transformation);
			
			//triangularisation de la matrice
			int i, k;
			for (i = 1; i < equationLineaire.nbr_ligne; i++){
				for (k = i; k < equationLineaire.nbr_ligne; k++){
					equationLineaire.addLigneAndScalaire(k, i-1, 
							Operation.multiplier(
									equationLineaire.transformation.getValue(k, i-1),
									new Reel(-1)));
					if(i==k && !equationLineaire.transformation.getValue(k, k).isNull())
						equationLineaire.multiplyLineByScalaire(k, Operation.diviser(new Reel(1), equationLineaire.transformation.getValue(k, k)));
				}
			}
			
			MatrixExceptionControler.controleTriangularMatrix(equationLineaire.transformation, ERROR_GAUSS_FIRST);
			
			//on remonte pour arriver à une matrice diagonale
			for (i = equationLineaire.nbr_ligne-2; i >= 0; i--){
				for (k = i; k >= 0; k--){
					equationLineaire.addLigneAndScalaire(k, i+1,
							Operation.multiplier(
									equationLineaire.transformation.getValue(k, i+1),
									new Reel(-1)));
				}
			}
			
			MatrixExceptionControler.controleDiagonalMatrix(equationLineaire.transformation, ERROR_GAUSS_SECOND);
			
			return equationLineaire.constante;
		} catch (SquareMatriceErrorException | TriangularMatriceErrorException | DiagonalMatriceErrorException e) {
			e.printStackTrace();
		}
		return equationLineaire.transformation;
	}
	
	/**
	 * Permet d'effectuer une copy d'une équation linéaire
	 * 
	 * @param SystemeEquation equationLineaire
	 * @return SystemeEquation copy
	 */
	public SystemeEquation copy(){
		return new SystemeEquation(this.transformation.copy(), 
				this.constante.copy());
	}
	
	@Override
	public String toString() {
		Matrice transformation = this.transformation;
		Matrice constante = this.constante;
		transformation.arrondir();
		constante.arrondir();
		
		StringBuilder stringBuilder = new StringBuilder();
		int i, j;
		for (i = 0; i < transformation.nb_ligne; i++) {
			stringBuilder.append("| ");
			for (j = 0; j < transformation.nb_col; j++){
				stringBuilder.append(transformation.getValue(i, j).toString());
				stringBuilder.append(" ");
			}
			stringBuilder.append("| ");
			stringBuilder.append(constante.getValue(i, 0).toString());
			stringBuilder.append(" |");
		}
		return stringBuilder.toString();
	}
}
