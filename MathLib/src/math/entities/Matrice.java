package math.entities;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import math.controler.MatrixExceptionControler;
import math.controler.Operation;
import math.controler.exception.DimensionErrorException;
import math.controler.exception.PropertyValueErrorException;
import math.controler.exception.SquareMatriceErrorException;
import math.service.MathObjectService;
import math.service.PolynomeService;

/**
 * class Matrice: objet mathématique représentant une matrice
 * les matrices sont défini en ligne puis colonne
 * 
 * @author clément
 *
 */
public class Matrice extends MathObject{
	/**
	 * contenu de la matrice
	 */
	public MathObject[][] matrice;
	
	/**
	 * nombre de ligne de la matrice
	 */
	public int nb_ligne;
	
	/**
	 * nombre de colonne dela matrice
	 */
	public int nb_col;
	
	/**
	 * Constructeur matrice complète
	 * 
	 * @param fTab
	 * @return new Matrice
	 */
	
	public Matrice(MathObject[][] fTab) {
		this.nb_ligne = fTab.length;
		this.nb_col = fTab[0].length;
		set(fTab);
	}

	/**
	 * Constructeur matrice null
	 * dimension [0,0]
	 * 
	 * @return new Matrice
	 */
	public Matrice() {
		this.nb_ligne = 0;
		this.nb_col = 0;
		this.matrice = new MathObject[0][0];
	}
	
	/**
	 * Constructeur matrice de dimension fixe
	 * 
	 * @param nb_ligne
	 * @param nb_col
	 * @return new Matrice
	 */
	public Matrice(int nb_ligne, int nb_col) {
		int i, j;
		this.nb_ligne = nb_ligne;
		this.nb_col = nb_col;
		MathObject[][] tab = new MathObject[nb_ligne][nb_col];
		for (i = 0; i < nb_ligne; i++) {
			for (j = 0; j < nb_col; j++)
				tab[i][j] = new Reel();
		}
		this.matrice = tab;
	}
	
	/**
	 * Construction matrice unitaire
	 * @param nb_ligne
	 * @param nb_col
	 * @return
	 */
	public Matrice buildMatriceUnitaire(int nb_ligne, int nb_col) {
		Matrice matrice = new Matrice(nb_ligne, nb_col);
		MathObject polynome1 = new Reel(1);
		MathObject polynome2 = new Reel(0);
		for (int i = 0; i < matrice.nb_ligne; i++) {
			for (int j = 0; j < matrice.nb_col; j++) {
				if(i == j){
					matrice.setValue(i, j, polynome1);
				}else{
					matrice.setValue(i, j, polynome2);
				}
			}
		}
		return matrice;
	}
	
	/**
	 * Construction d'une matrice à partir d'un tableau dynamique
	 * @param List<List<MathObject>> tableau
	 * @return
	 */
	public Matrice(List<List<MathObject>> tableau) {
		int nb_ligne = tableau.size(),
				nb_col = tableau.get(0).size(),i,j;
		this.nb_ligne = nb_ligne;
		this.nb_col = nb_col;
		MathObject[][] tab = new MathObject[this.nb_ligne][this.nb_col];
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++){
				tab[i][j] = tableau.get(i).get(j);
			}
		}
		this.matrice = tab;
	}
	
	public Matrice(float[][] tableau) {
		int nb_ligne = tableau.length,
				nb_col = tableau[0].length,i,j;
		this.nb_ligne = nb_ligne;
		this.nb_col = nb_col;
		MathObject[][] tab = new MathObject[this.nb_ligne][this.nb_col];
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++){
				tab[i][j] = new Reel(tableau[i][j]);
			}
		}
		this.matrice = tab;
	}
	
	/**
	 * Methode de modification des valeurs de la matrice
	 * les matrices doivent avoir des dimensions egales
	 * 
	 * @param matrice
	 * @param newValeurMatrice
	 */
	public void set(MathObject[][] newTab){
		int i, j;
		try {
			MatrixExceptionControler.controleDimentionMatriceLigne(this, newTab[0].length);
			MatrixExceptionControler.controleDimentionMatriceColonne(this, newTab.length);
			MathObject[][] tab = new MathObject[this.nb_ligne][this.nb_col];
			for (i = 0; i < this.nb_ligne; i++) {
				for (j = 0; j < this.nb_col; j++){
					tab[i][j] = newTab[i][j];
				}
			}
			this.matrice = tab;
		} catch (DimensionErrorException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode de modification d'une valeur de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeLigne
	 * @param coordonneCol
	 * @param value
	 */
	public void setValue(int coordonneeLigne, int coordonneCol, float value){
		this.matrice[coordonneeLigne][coordonneCol] = new Reel(value);
	}
	
	/**
	 * Méthode de modification d'une valeur de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeLigne
	 * @param coordonneCol
	 * @param value
	 */
	public void setValue(int coordonneeLigne, int coordonneCol, MathObject value){
		this.matrice[coordonneeLigne][coordonneCol] = value;
	}
	
	/**
	 * Méthode de modification d'une ligne de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeLigne
	 * @param ligne
	 */
	public void setLigne(int coordonneeLigne, MathObject[] ligne){
		int j;
		
		try {
			MatrixExceptionControler.controleDimentionMatriceLigne(this, ligne);
			for (j = 0; j < this.nb_col; j++)
				this.matrice[coordonneeLigne][j] = ligne[j];
		} catch (DimensionErrorException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode de modification d'une ligne de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeLigne
	 * @param ligne
	 */
	public void setLigne(int coordonneeLigne, Matrice ligne){
		int j;
		
		try {
			MatrixExceptionControler.controleDimentionMatriceLigne(this, ligne);
			for (j = 0; j < this.nb_col; j++)
				this.matrice[coordonneeLigne][j] = ligne.getValue(0, j);
		} catch (DimensionErrorException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode de modification d'une colonne de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeColonne
	 * @param colonne
	 */
	public void setColonne(int coordonneeColonne, MathObject[] colonne){
		int i;
		
		try {
			MatrixExceptionControler.controleDimentionMatriceColonne(this, colonne);
			for (i = 0; i < this.nb_ligne; i++)
				this.matrice[i][coordonneeColonne] = colonne[i];
		} catch (DimensionErrorException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode de modification d'une colonne de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeColonne
	 * @param colonne
	 */
	public void setColonne(int coordonneeColonne, Matrice colonne) {
		int i;
		
		try {
			MatrixExceptionControler.controleDimentionMatriceColonne(this, colonne.nb_ligne);
			for (i = 0; i < this.nb_ligne; i++)
				this.matrice[i][coordonneeColonne] = colonne.getValue(i, 0);
		} catch (DimensionErrorException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode de récupération d'une valeur de la matrice
	 * 
	 * @param matrice
	 * @param coordonneeLigne
	 * @param coordonneCol
	 * @return value
	 */
	public MathObject getValue(int coordonneeLigne, int coordonneCol){
		MathObject[][] tab = this.matrice;
		return tab[coordonneeLigne][coordonneCol];
	}
	
	/**
	 * Méthode de récupération d'une ligne de la matrice
	 * 
	 * @param matrice
	 * @param int coordonneeLigne
	 * @return Matrice matrice ligne [1, n]
	 */
	public Matrice getLigne(int coordonneeLigne){
		int j;
		Matrice matriceLigne = new Matrice(1, this.nb_col);
		for (j = 0; j < this.nb_col; j++)
			matriceLigne.setValue(0, j, this.matrice[coordonneeLigne][j]);
		return matriceLigne;
	}
	
	/**
	 * Methode qui permet de vérifier si l'on est dans le cas de matrice carrée
	 * 
	 * @return boolean resultat
	 */
	public boolean isSquareMatrice(){
		if(this.nb_ligne==this.nb_col)
			return true;
		return false;
	}
	
	/**
	 * Methode qui permet de vérifier si l'on est dans le cas particulier de matrice diagonale
	 * 
	 * @return boolean resultat
	 */
	public boolean isDiagonalMatrice(){
		this.arrondir();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			return this.isTriangularLowerMatrice() && this.isTriangularUpperMatrice();
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Methode qui permet de vérifier si l'on est dans le cas particulier de matrice triangulaire
	 * 
	 * @return boolean resultat
	 */
	public boolean isTriangularMatrice(){
		this.arrondir();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			return this.isTriangularLowerMatrice() || this.isTriangularUpperMatrice();
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Methode qui permet de vérifier si l'on est dans le cas particulier de matrice triangulaire inférieure
	 * 
	 * @return boolean resultat
	 */
	public boolean isTriangularUpperMatrice(){
		this.arrondir();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			int i,j;
			for (j = 0; j < this.nb_col; j++) {
				for (i = 0; i < j; i++)
					if(!this.getValue(i, j).isNull())
						return false;
			}
			return true;
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Methode qui permet de vérifier si l'on est dans le cas particulier de matrice triangulaire supérieure
	 * 
	 * @return boolean resultat
	 */
	public boolean isTriangularLowerMatrice(){
		this.arrondir();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			int i,j;
			for (i = 0; i < this.nb_ligne; i++) {
				for (j = 0; j < i; j++)
					if(!this.getValue(i, j).isNull())
						return false;
			}
			return true;
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	/**
//	 * Methode qui permet de vérifier qu'il s'agit bien d'une matrice positive
//	 * 
//	 * @return boolean resultat
//	 */
//	public boolean isPositiveMatrice(){
//		this.arrondir();
//		
//		int i,j;
//		for (i = 0; i < this.nb_ligne; i++) {
//			for (j = 0; j < this.nb_col; j++){
//				MathObject mathObject = this.getValue(i, j);
//				if(polynome.getFormeDeveloppee().get(0) < 0)
//					return false;
//			}
//		}
//		return true;
//	}
	
	/**
	 * Méthode qui permet de déterminer si la matrice est symétrique
	 * 
	 * @return boolean resultat
	 */
	public boolean isSymetricMatrice(){
		this.arrondir();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			int i,j;
			for (i = 0; i < this.nb_ligne; i++) {
				for (j = 0; j < i; j++)
					if(!this.getValue(i, j).equals(this.getValue(j, i)))
						return false;
			}
			return true;
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Methode qui permet de déterminer si il s'aggit d'une matrice unitaire (I)
	 * 
	 * @return boolean resultat
	 */
	public boolean isUnitaireMatrice(){
		this.arrondir();
		
		int i,j;
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++)
				if((i==j && !this.getValue(i, j).equals(new Reel(1)) 
						|| (i!=j && !this.getValue(i, j).equals(new Reel(0)))))
					return false;
		}
		return true;
	}
	
	/**
	 * Methode qui permet de déterminer si il s'aggit d'une matrice composée uniquement de type float
	 * @param matrice
	 * @return
	 */
	public boolean isFloatMatrice(){
		this.arrondir();
		int i,j;
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++){
				if(!this.getValue(i, j).getClass().equals(Reel.class)){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Méthode de simplification d'une matrice
	 * @param matrice
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Matrice simplificationMatrice(){
		Matrice result = this.copy();
		
		Float minValue = this.getMinValue();
		if(minValue<0){
			minValue=-minValue;
		}
		if(minValue!=0){
			for (int i = 0; i < this.nb_ligne; i++) {
				for (int j = 0; j < this.nb_col; j++) {
//					Field field = this.getValue(i, j).getClass().getDeclaredField("reel");
//					field.setAccessible(true);
//					float fValue = ((float)field.get(this.getValue(i, j))) / minValue;
					
					float fValue = ((Reel)this.getValue(i, j)).reel / minValue;
					if(!MathObjectService.isEntier(fValue))
						return this;
					result.setValue(i, j, new Reel(fValue));
				}
			}
		}
		return result;
	}

	/**
	 * Retourne la valeur mini hors 0 présent dans une matrice
	 * @param matrice
	 * @return
	 */
	private float getMinValue() {
		float minValue = 1000000f;
		try {
			for (int i = 0; i < this.nb_ligne; i++) {
				for (int j = 0; j < this.nb_col; j++) {
					if(((Reel)this.getValue(i, j)).reel != 0 
							&& minValue > ((Reel)this.getValue(i, j)).reel)
						minValue = ((Reel)this.getValue(i, j)).reel;
				}
			}
			return minValue;
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Méthode de transposition d'une matrice
	 * 
	 * @param Matrice matrice
	 * @return Matrice matrice transposée
	 */
	public Matrice transpose(){
		Matrice matriceRetour = new Matrice(this.nb_col, this.nb_ligne);
		int i,j;
		for (i = 0; i < matriceRetour.nb_ligne; i++) {
			for (j = 0; j < matriceRetour.nb_col; j++)
				matriceRetour.setValue(i, j, this.getValue(j, i));
		}
		return matriceRetour;
	}
	
	/**
	 * Méthode d'affichage de la matrice en console
	 */
	public void affiche() {
		this.arrondir();
		
		int i, j;
		for (i = 0; i < this.nb_ligne; i++) {
			System.out.print("| ");
			for (j = 0; j < this.nb_col; j++){
				System.out.print(this.getValue(i, j).toString());
				System.out.print(" ");
				}
			System.out.println("|");
		}
		System.out.println("");
	}
	
	@Override
	//REPENSER LE STRING DE SORTIE
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int i, j;
		for (i = 0; i < this.nb_ligne; i++) {
			builder.append("| ");
			for (j = 0; j < this.nb_col; j++){
				builder.append(this.getValue(i, j).toString());
				builder.append(" ");
				}
			builder.append("|");
		}
		builder.append("");
		return builder.toString();
	}
	
	/**
	 * Methode permettant d'arrondir les valeurs présentes dans la matrice
	 * @param matrice
	 */
	public Matrice arrondir(){
		int i,j;
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++)
				this.setValue(i, j, this.getValue(i, j).arrondir());
		}
		return this;
	}
	
	/**
	 * Méthode de copie d'une matrice
	 * 
	 * @param Matrice matrice
	 * @return Matrice copie
	 */
	public Matrice copy() {
		Matrice copy = new Matrice(this.nb_ligne, this.nb_col);
		
		int i,j;
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++)
				copy.setValue(i, j, this.getValue(i, j));
		}
		return copy;
	}
	
	/**
	 * Surcharge de la méthode equals dans le cadre d'un objet de type matrice
	 * 
	 * @param Matrice matrice
	 * @return Boolean equals
	 */
	public boolean equals(MathObject value){
		if(value.getClass()!=Matrice.class){
			return false;
		}
		Matrice matriceB = (Matrice) value;
		if(this==matriceB)
			return true;
		//pour le nombre de ligne
		if(this.nb_ligne == 0)
			return false;
		if(matriceB.nb_ligne == 0)
			return false;
		if(this.nb_ligne != matriceB.nb_ligne)
			return false;
		//pour le nombre de colonne
			if(this.nb_col == 0)
				return false;
			if(matriceB.nb_col == 0)
				return false;
			if(this.nb_col != matriceB.nb_col)
				return false;
		//pour le contenu de la matrice
		int i,j;
		for (i = 0; i < this.nb_ligne; i++) {
			for (j = 0; j < this.nb_col; j++)
				if(!this.getValue(i, j).equals(matriceB.getValue(i, j)))
					return false;
		}
		
		return true;
	}
	
	/**
	 * Methode de calcul du déterminant d'une matrice
	 * 
	 * @param Matrice matrice
	 * @return float resultat det
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public MathObject determinant() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		MathObject resultat = new Reel();
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			int i;
			//on vérifie que la matrice n'est pas triangulaire pour simplifier les calculs
			if(this.isTriangularMatrice()){
				resultat=this.getValue(0, 0);
				for(i = 1; i < this.nb_col; i++)
					 resultat=
							 Operation.multiplier(
						 	resultat,
						 	this.getValue(i, i));
			}else{
				//on effectue un développement suivant la première ligne
				for(i = 0; i < this.nb_col; i++)
					resultat=
						Operation.additionner(
							resultat,
							Operation.multiplier(
									this.getValue(0, i),
									this.calculCofacteur(0, i)));
			}
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	/**
	 * Méthode de suppression de la ligne et de la colonne choisies
	 * Calcul le determinant à partir de cette nouvelle matrice diminuée
	 * 
	 * @param int deleteLigne
	 * @param int deleteColonne
	 * @param Matrice matrice
	 * @return float resultat det nouvelle matrice
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private MathObject calculMineur(int deleteLigne, int deleteColonne) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			//si la matrice est de taille 1, sa valeur est celle de son det
			if(this.nb_ligne==1){
				return this.getValue(0, 0);
			//sinon on diminue la taille de la matrice pour arriver à une taille 1
			}else{
				Matrice matriceRetour = new Matrice(this.nb_ligne-1, this.nb_col-1);
				int i,j,k=0,l=0;
				for (i = 0; i < this.nb_ligne; i++) {
					l=0;
					for (j = 0; j < this.nb_col; j++){
						if(i!=deleteLigne && j!=deleteColonne)
							matriceRetour.setValue(k, l, this.getValue(i, j));
						if(j!=deleteColonne)
								l++;
					}
					if(i!=deleteLigne)
						k++;
				}
				return matriceRetour.determinant();
			}
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		return new Reel();
	}
	
	/**
	 * Methode de calcul d'une partie du det avec le mineur affecté du signe +/- en fonction de la position
	 * 
	 * @param int deleteLigne
	 * @param int deleteColonne
	 * @param Matrice matrice
	 * @return calcul mineur associé du cofacteur
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private MathObject calculCofacteur(int deleteLigne, int deleteColonne) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return Operation.multiplier(
				this.calculMineur(deleteLigne, deleteColonne),
				new Reel((float) Math.pow(-1, deleteLigne+deleteColonne)));
	}
	
	/**
	 * Methode permettant de calculer la comatrice d'une matrice A
	 * 
	 * @param Matrice matrice
	 * @return Matrice comatrice
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private Matrice calculComatrice() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			Matrice matriceRetour = new Matrice(this.nb_ligne, this.nb_col);
			int i,j;
			for (i = 0; i < matriceRetour.nb_ligne; i++) {
				for (j = 0; j < matriceRetour.nb_col; j++)
					matriceRetour.setValue(i, j, calculCofacteur(i, j));
			}
			return matriceRetour;
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
			return new Matrice();
		}
	}
	
	/**
	 * Méthode d'inversion d'une matrice
	 * 
	 * @param Matrice A
	 * @return Matrice inverse A
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public MathObject inverse() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			return Operation.multiplier(this.calculComatrice().transpose(),
					new Reel(1/((Reel)this.determinant()).reel));
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
			return new Matrice();
		}
	}
	
	/**
	 * Méthode récuperant les valeurs propres d'une matrice
	 * 
	 * @param matrice
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public List<MathObject> valeurPropre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> result = new ArrayList<MathObject>();
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			Matrice matriceUnitaire = new Matrice().buildMatriceUnitaire(this.nb_ligne, this.nb_ligne);
			
			List<MathObject> formeDeveloppee1 = new ArrayList<MathObject>();
			formeDeveloppee1.add(new Reel(0));
			formeDeveloppee1.add(new Reel(-1));
			Polynome polynome1 = new Polynome(formeDeveloppee1);
			
			matriceUnitaire = (Matrice) Operation.multiplier(matriceUnitaire, polynome1);
			
			Matrice matriceModifiee = (Matrice) Operation.additionner(this, matriceUnitaire);
			
			MathObject polynome = matriceModifiee.determinant();
			
			result = PolynomeService.resolutionPolynome((Polynome) polynome);
		} catch (SquareMatriceErrorException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Matrice> vecteurPropre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<Matrice> resultat = new ArrayList<Matrice>();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			List<MathObject> valeurPropreList = this.valeurPropre();
			
			MatrixExceptionControler.controleValeurPropre(valeurPropreList, this);
			
			for (MathObject valeurPropre : valeurPropreList) {
				//calcul de la matrice modifiée avec une valeur propre X = A-lI
				Matrice matriceUnitaire = new Matrice().buildMatriceUnitaire(this.nb_ligne, this.nb_col);
				Matrice matriceModifiee = (Matrice) Operation.multiplier(matriceUnitaire, Operation.multiplier(new Reel(-1),valeurPropre));
				matriceModifiee = (Matrice) Operation.additionner(matriceModifiee, this);
				
				//récupération du vecteur propre
				Matrice ligne = matriceModifiee.getLigne(0);
				
				//résolution de ligne=0
				if(ligne.nb_col==2){
					ligne.setValue(0, 1, 
							Operation.multiplier(ligne.getValue(0, 1),new Reel(-1)));
				}
				
				ligne = ligne.transpose();
				
				//tentative de simplification du vecteur propre
				ligne = ligne.simplificationMatrice();
				
				resultat.add(ligne);
			}
			
		} catch (SquareMatriceErrorException | PropertyValueErrorException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	public List<Matrice> vecteurPropreNewGen() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<Matrice> resultat = new ArrayList<Matrice>();
		
		try {
			MatrixExceptionControler.controleSquareMatrix(this);
			
			List<MathObject> valeurPropreList = this.valeurPropre();
			
			MatrixExceptionControler.controleValeurPropre(valeurPropreList, this);
			
			for (MathObject valeurPropre : valeurPropreList) {
				//calcul de la matrice modifiée avec une valeur propre X = A-lI
				Matrice matriceUnitaire = new Matrice().buildMatriceUnitaire(this.nb_ligne, this.nb_col);
				Matrice matriceModifiee = (Matrice) Operation.multiplier(matriceUnitaire, Operation.multiplier(new Reel(-1),valeurPropre));
				matriceModifiee = (Matrice) Operation.additionner(matriceModifiee, this);
				
				Matrice matriceNul = new Matrice(matriceModifiee.nb_ligne, 1);
				
				//création du système d'équation
				SystemeEquation systeme = new SystemeEquation(matriceModifiee, matriceNul);
				Matrice ligne = systeme.resolutionEquationLineaire();
				
				//tentative de simplification du vecteur propre
				ligne = ligne.simplificationMatrice();
				
				resultat.add(ligne);
			}
			
		} catch (SquareMatriceErrorException | PropertyValueErrorException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	/**
	 * Method de multiplication d'une ligne d'une matrice par un scalaire
	 * @param constante
	 * @param scalaire
	 * @param ligne
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Matrice multiplyLigneByScalaire(MathObject scalaire, int ligne) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Matrice matriceRetour = new Matrice(this.nb_ligne, this.nb_col);
		matriceRetour.matrice = this.matrice;
		int j;
		for (j = 0; j < this.nb_col; j++)
			matriceRetour.setValue(ligne, j, Operation.multiplier(this.getValue(ligne, j), scalaire));
		
		return matriceRetour;
	}
}
