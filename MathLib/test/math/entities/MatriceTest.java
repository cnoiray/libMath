package math.entities;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import math.controler.Operation;
import math.entities.mathobject.Complexe;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

public class MatriceTest {
	private float[][] matriceFloat = {
			{1, 2, -5},
			{4, 5, 10},
			{-2, 3, 17}};
	
	private float[][] tabLigne1 = {
			{3},
			{-3}};
	private float[][] tabLigne2 = {
			{6},
			{3}};
	
	private float[][] lSolutionA = {
			{1},
			{-1}};
	private float[][] lSolutionB = {
			{2},
			{1}};
	
	private Matrice matriceLigne1;
	private Matrice matriceLigne2;
	private Matrice matrixSolutionA;
	private Matrice matrixSolutionB;
	Matrice matriceRectangle;
	Matrice matriceCarree;
	Matrice matriceDiagonal;
	Matrice matriceTriangulaireSup;
	Matrice matriceTriangulaireInf;
	Matrice matricePositive;
	Matrice matriceNegative;
	Matrice matriceSymetric;
	Matrice matriceUnitaire;
	
	private Matrice matriceA;
	private Matrice solution;
	
	private Matrice matrice1;
	private Matrice matrice2;
	private Matrice matrice3;
	private Matrice matrice4;
	private Matrice matrice5;
	private Matrice matriceOppenClassrom;
	private Matrice matriceUnivParis13;
	private float fSolution1;
	private float fSolution2;
	private Polynome pSolution;
	private Matrice mSolution;
	private List<MathObject> lSolution = new ArrayList<MathObject>();
	private List<MathObject> lSolutionOppenClassroom = new ArrayList<MathObject>();
	private List<MathObject> lSolutionUnivParis13 = new ArrayList<MathObject>();
	private List<MathObject> lSolution2 = new ArrayList<MathObject>();
	private List<Matrice> matrixSolution = new ArrayList<Matrice>();
	private List<Matrice> matrixSolution2 = new ArrayList<Matrice>();
	
	@Before
	public void setUp() throws Exception {
		matriceLigne1 = new Matrice(tabLigne1);
		matriceLigne2 = new Matrice(tabLigne2);
		matrixSolutionA = new Matrice(lSolutionA);
		matrixSolutionB = new Matrice(lSolutionB);
		
		float[][] matriceRectangle = {
				{1, 4, -2},
				{2, 7, 3}};
		float[][] matriceCarree = {
				{1, 4},
				{2, -7}};
		float[][] matriceDiagonal = {
				{1, 0, 0},
				{0, 12, 0},
				{0, 0, 5}};
		float[][] matriceTriangulaireSup = {
				{1, 0, 0},
				{0, 12, 0},
				{4, 0, 5}};
		float[][] matriceTriangulaireInf = {
				{1, 0, 4},
				{0, 12, 0},
				{0, 0, 5}};
		float[][] matricePositive = {
				{1, 0, 6},
				{0, 12, 0},
				{4, 0, 5}};;
		float[][] matriceNegative = {
				{-1, -4, -2},
				{-2, -7, -3}};
		float[][] matriceSymetric = {
				{1, 4, -2},
				{4, 5, 3},
				{-2, 3, 17}};
		float[][] matriceUnitaire = {
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1}};
		
		this.matriceRectangle = new Matrice(matriceRectangle);
		this.matriceCarree = new Matrice(matriceCarree);
		this.matriceDiagonal = new Matrice(matriceDiagonal);
		this.matriceTriangulaireSup = new Matrice(matriceTriangulaireSup);
		this.matriceTriangulaireInf = new Matrice(matriceTriangulaireInf);
		this.matricePositive = new Matrice(matricePositive);
		this.matriceNegative = new Matrice(matriceNegative);
		this.matriceSymetric = new Matrice(matriceSymetric);
		this.matriceUnitaire = new Matrice(matriceUnitaire);
		
		//définition valeur matrice
		float[][] valeurA = {
				{2, 0, 1, -3},
				{-1, 4, -7, 2},
				{0, 3, 5, 0},
				{-2, 1, 0, 6}};
		
		float[][] valeurB = {
				{1, 2, 3},
				{0, 1, 2},
				{-1, -4, -1}};
		
		float[][] valeurD = {
				{5, -3},
				{6, -4}};
		
		float[][] valeurE = {
				{0, -1, 0},
				{-1, 0, 0},
				{1, 1, 1}};
		
		float[][] valeurSolution = {
				{7, -10, 1},
				{-2, 2, -2},
				{1, 2, 1}};
		
		List<MathObject> formeDeveloppee1 = new ArrayList<MathObject>();
			formeDeveloppee1.add(new Reel((float) 5));
			formeDeveloppee1.add(new Reel((float) -1));
			Polynome polynome1 = new Polynome(formeDeveloppee1);
		List<MathObject> formeDeveloppee2 = new ArrayList<MathObject>();
			formeDeveloppee2.add(new Reel((float) -3));
			Polynome polynome2 = new Polynome(formeDeveloppee2);
		List<MathObject> formeDeveloppee3 = new ArrayList<MathObject>();
			formeDeveloppee3.add(new Reel((float) 6));
			Polynome polynome3 = new Polynome(formeDeveloppee3);
		List<MathObject> formeDeveloppee4 = new ArrayList<MathObject>();
			formeDeveloppee4.add(new Reel((float) -4));
			formeDeveloppee4.add(new Reel((float) -1));
			Polynome polynome4 = new Polynome(formeDeveloppee4);
		
		matrice1 = new Matrice(valeurA);
		matrice2 = new Matrice(valeurB);
		mSolution = new Matrice(valeurSolution);
		matrice3 = new Matrice(2, 2);
		matrice3.setValue(0, 0, polynome1);
		matrice3.setValue(0, 1, polynome2);
		matrice3.setValue(1, 0, polynome3);
		matrice3.setValue(1, 1, polynome4);
		matrice4 = new Matrice(valeurD);
		matrice5 = new Matrice(valeurE);
		
		fSolution1 = 235;
		fSolution2 = 6;
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel((float) -2));
		formeDeveloppeeSolution.add(new Reel((float) -1));
		formeDeveloppeeSolution.add(new Reel((float) 1));
		pSolution = new Polynome(formeDeveloppeeSolution);
		lSolution.add(new Reel(-1));
		lSolution.add(new Reel(2));
		lSolution2.add(new Reel(-1));
		lSolution2.add(new Reel(1));
		lSolution2.add(new Reel(1));
		lSolutionOppenClassroom.add(new Reel(1));
		lSolutionOppenClassroom.add(new Reel(2));
		lSolutionOppenClassroom.add(new Reel(-4));
		lSolutionUnivParis13.add(new Reel(1));
		lSolutionUnivParis13.add(new Reel(2));
		lSolutionUnivParis13.add(new Reel(2));
		float[][] matrixSolutionA = {
				{2},
				{1}};
		float[][] matrixSolutionB = {
				{1},
				{1}};
		matrixSolution.add(new Matrice(matrixSolutionA));
		matrixSolution.add(new Matrice(matrixSolutionB));
		
		float[][] matrixSolutionAA = {
				{-1},
				{1},
				{0}};
		float[][] matrixSolutionAB = {
				{0},
				{0},
				{1}};
		float[][] matrixSolutionAC = {
				{1},
				{1},
				{-1}};
		matrixSolution2.add(new Matrice(matrixSolutionAA));
		matrixSolution2.add(new Matrice(matrixSolutionAB));
		matrixSolution2.add(new Matrice(matrixSolutionAC));
		
		float[][] valeurABis = {
				{1, 4, -2},
				{2, 7, 3}};
		
		matriceA = new Matrice(valeurABis);
		
		float[][] valeurOppenClassroom = {
				{0, 2, -1},
				{3, -2, 0},
				{-2, 2, 1}};
		
		matriceOppenClassrom = new Matrice(valeurOppenClassroom);
		
		float[][] valeurUnivParis13 = {
				{1, 0, 1},
				{-1, 2, 1},
				{0, 0, 2}};
		
		matriceUnivParis13 = new Matrice(valeurUnivParis13);
	}

	@Test
	public void testBuildEmptyMatrice() {
		Matrice matrice = new Matrice();
		assertTrue(matrice.nb_ligne == 0);
		assertTrue(matrice.nb_col == 0);
		MathObject[][] tab = matrice.matrice;
		assertTrue(tab.length == 0);
	}

	@Test
	public void testConstructeurFromTab(){
		Matrice matrice = new Matrice(matriceFloat);
		assertTrue(matrice.nb_ligne == 3);
		assertTrue(matrice.nb_col == 3);
		MathObject[][] tab = matrice.matrice;
		assertTrue(tab.length == 3);
		assertTrue(tab[0].length == 3);

		assertTrue(tab[0][0].equals(new Reel(1)));
		assertTrue(tab[0][1].equals(new Reel(2f)));
		assertTrue(tab[0][2].equals(new Reel(-5)));
		
		assertTrue(tab[1][0].equals(new Reel(4)));
		assertTrue(tab[1][1].equals(new Reel(5)));
		assertTrue(tab[1][2].equals(new Reel(10)));
		
		assertTrue(tab[2][0].equals(new Reel(-2)));
		assertTrue(tab[2][1].equals(new Reel(3)));
		assertTrue(tab[2][2].equals(new Reel(17)));
	}
	
	@Test
	public void testBuildMatriceFromDimension() {
		Matrice matrice = new Matrice(3, 3);
		assertTrue(matrice.nb_ligne == 3);
		assertTrue(matrice.nb_col == 3);
		MathObject[][] tab = matrice.matrice;
		assertTrue(tab.length == 3);
		assertTrue(tab[0].length == 3);

		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(0)));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testBuildMatriceUnitaire() {
		Matrice matrice = new Matrice().buildMatriceUnitaire(3, 3);
		assertTrue(matrice.nb_ligne == 3);
		assertTrue(matrice.nb_col == 3);
		MathObject[][] tab = matrice.matrice;
		assertTrue(tab.length == 3);
		assertTrue(tab[0].length == 3);

		assertTrue(tab[0][0].equals(new Reel(1)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(1)));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(1)));
	}

	@Test
	public void testBuildMatriceFromList() {
		List<List<MathObject>> list = new ArrayList<>();
		List<MathObject> ligne = new ArrayList<>();
		ligne.add(new Reel(12));
		ligne.add(new Reel(12));
		ligne.add(new Reel(12));
		list.add(ligne);
		
		List<MathObject> ligne1 = new ArrayList<>();
		ligne1.add(new Reel(22));
		ligne1.add(new Reel(22));
		ligne1.add(new Reel(22));
		list.add(ligne1);
		
		List<MathObject> ligne2 = new ArrayList<>();
		ligne2.add(new Reel(32));
		ligne2.add(new Reel(32));
		ligne2.add(new Reel(32));
		list.add(ligne2);
		
		Matrice matrice = new Matrice(list);
		assertTrue(matrice.nb_ligne == 3);
		assertTrue(matrice.nb_col == 3);
		MathObject[][] tab = matrice.matrice;
		assertTrue(tab.length == 3);
		assertTrue(tab[0].length == 3);

		assertTrue(tab[0][0].equals(new Reel(12)));
		assertTrue(tab[0][1].equals(new Reel(12)));
		assertTrue(tab[0][2].equals(new Reel(12)));
		
		assertTrue(tab[1][0].equals(new Reel(22)));
		assertTrue(tab[1][1].equals(new Reel(22)));
		assertTrue(tab[1][2].equals(new Reel(22)));
		
		assertTrue(tab[2][0].equals(new Reel(32)));
		assertTrue(tab[2][1].equals(new Reel(32)));
		assertTrue(tab[2][2].equals(new Reel(32)));
	}

	@Test
	public void testSet() {
		Matrice matrice = new Matrice(matriceFloat);
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(1)));
		assertTrue(tab[0][1].equals(new Reel(2)));
		assertTrue(tab[0][2].equals(new Reel(-5)));
		
		assertTrue(tab[1][0].equals(new Reel(4)));
		assertTrue(tab[1][1].equals(new Reel(5)));
		assertTrue(tab[1][2].equals(new Reel(10)));
		
		assertTrue(tab[2][0].equals(new Reel(-2)));
		assertTrue(tab[2][1].equals(new Reel(3)));
		assertTrue(tab[2][2].equals(new Reel(17)));
	}

	@Test
	public void testSetValueIntIntFloat() {
		Matrice matrice = new Matrice(3, 3);
		matrice.setValue(1, 1, 42);
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(42)));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testSetValueIntIntMathObject() {
		Matrice matrice = new Matrice(3, 3);
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		formeDeveloppee.add(new Reel(10));
		formeDeveloppee.add(new Reel(42));
		formeDeveloppee.add(new Reel(110));
		Polynome polynome = new Polynome(formeDeveloppee);
		Polynome polynomeTest = new Polynome(formeDeveloppee);
		matrice.setValue(1, 1, polynome);
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(polynomeTest));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testSetLigneIntMathObjectArray() {
		Matrice matrice = new Matrice(3, 3);
		MathObject[] ligne = {new Reel(100), new Reel(100), new Reel(100)};
		matrice.setLigne(0, ligne);
		
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(100)));
		assertTrue(tab[0][1].equals(new Reel(100)));
		assertTrue(tab[0][2].equals(new Reel(100)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(0)));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testSetLigneIntMatrice() {
		Matrice matrice = new Matrice(3, 3);
		float[][] matriceLigneFloat = {
				{1000, 2000, 3000}};
		Matrice matriceLigne = new Matrice(matriceLigneFloat);
		
		matrice.setLigne(1, matriceLigne);
		
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(1000)));
		assertTrue(tab[1][1].equals(new Reel(2000)));
		assertTrue(tab[1][2].equals(new Reel(3000)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testSetColonneIntMathObjectArray() {
		Matrice matrice = new Matrice(3, 3);
		MathObject[] colonne = {new Reel(100), new Reel(100), new Reel(100)};
		
		matrice.setColonne(2, colonne);
		
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(0)));
		assertTrue(tab[0][2].equals(new Reel(100)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(0)));
		assertTrue(tab[1][2].equals(new Reel(100)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(0)));
		assertTrue(tab[2][2].equals(new Reel(100)));
	}

	@Test
	public void testSetColonneIntMatrice() {
		Matrice matrice = new Matrice(3, 3);
		float[][] matriceColFloat = {
				{1000}, 
				{2000}, 
				{3000}};
		Matrice matriceCol = new Matrice(matriceColFloat);
		
		matrice.setColonne(1, matriceCol);
		
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(1000)));
		assertTrue(tab[0][2].equals(new Reel(0)));
		
		assertTrue(tab[1][0].equals(new Reel(0)));
		assertTrue(tab[1][1].equals(new Reel(2000)));
		assertTrue(tab[1][2].equals(new Reel(0)));
		
		assertTrue(tab[2][0].equals(new Reel(0)));
		assertTrue(tab[2][1].equals(new Reel(3000)));
		assertTrue(tab[2][2].equals(new Reel(0)));
	}

	@Test
	public void testGetValue() {
Matrice matrice = new Matrice(matriceFloat);
		
		MathObject polynome00 = matrice.getValue(0, 0);
		MathObject polynome01 = matrice.getValue(0, 1);
		MathObject polynome02 = matrice.getValue(0, 2);
		
		MathObject polynome10 = matrice.getValue(1, 0);
		MathObject polynome11 = matrice.getValue(1, 1);
		MathObject polynome12 = matrice.getValue(1, 2);
		
		MathObject polynome20 = matrice.getValue(2, 0);
		MathObject polynome21 = matrice.getValue(2, 1);
		MathObject polynome22 = matrice.getValue(2, 2);
		
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(polynome00));
		assertTrue(tab[0][1].equals(polynome01));
		assertTrue(tab[0][2].equals(polynome02));
		
		assertTrue(tab[1][0].equals(polynome10));
		assertTrue(tab[1][1].equals(polynome11));
		assertTrue(tab[1][2].equals(polynome12));
		
		assertTrue(tab[2][0].equals(polynome20));
		assertTrue(tab[2][1].equals(polynome21));
		assertTrue(tab[2][2].equals(polynome22));
	}

	@Test
	public void testGetLigne() {
Matrice matrice = new Matrice(matriceFloat);
		
		Matrice ligne0 = matrice.getLigne(0);
		Matrice ligne1 = matrice.getLigne(1);
		Matrice ligne2 = matrice.getLigne(2);
		
		MathObject[][] tab = matrice.matrice;
		MathObject[][] tab0 = ligne0.matrice;
		MathObject[][] tab1 = ligne1.matrice;
		MathObject[][] tab2 = ligne2.matrice;
		
		assertTrue(tab[0][0].equals(tab0[0][0]));
		assertTrue(tab[0][1].equals(tab0[0][1]));
		assertTrue(tab[0][2].equals(tab0[0][2]));
		
		assertTrue(tab[1][0].equals(tab1[0][0]));
		assertTrue(tab[1][1].equals(tab1[0][1]));
		assertTrue(tab[1][2].equals(tab1[0][2]));
		
		assertTrue(tab[2][0].equals(tab2[0][0]));
		assertTrue(tab[2][1].equals(tab2[0][1]));
		assertTrue(tab[2][2].equals(tab2[0][2]));
	}

	@Test
	public void testIsSquareMatrice() {
		assertTrue(!matriceRectangle.isSquareMatrice());
		assertTrue(matriceCarree.isSquareMatrice());
		assertTrue(matriceDiagonal.isSquareMatrice());
		assertTrue(matriceTriangulaireSup.isSquareMatrice());
		assertTrue(matriceTriangulaireInf.isSquareMatrice());
		assertTrue(matricePositive.isSquareMatrice());
		assertTrue(!matriceNegative.isSquareMatrice());
		assertTrue(matriceSymetric.isSquareMatrice());
		assertTrue(matriceUnitaire.isSquareMatrice());
	}

	@Test
	public void testIsDiagonalMatrice() {
		assertTrue(!matriceRectangle.isDiagonalMatrice());
		assertTrue(!matriceCarree.isDiagonalMatrice());
		assertTrue(matriceDiagonal.isDiagonalMatrice());
		assertTrue(!matriceTriangulaireSup.isDiagonalMatrice());
		assertTrue(!matriceTriangulaireInf.isDiagonalMatrice());
		assertTrue(!matricePositive.isDiagonalMatrice());
		assertTrue(!matriceNegative.isDiagonalMatrice());
		assertTrue(!matriceSymetric.isDiagonalMatrice());
		assertTrue(matriceUnitaire.isDiagonalMatrice());
	}

	@Test
	public void testIsTriangularMatrice() {
		assertTrue(!matriceRectangle.isTriangularMatrice());
		assertTrue(!matriceCarree.isTriangularMatrice());
		assertTrue(matriceDiagonal.isTriangularMatrice());
		assertTrue(matriceTriangulaireSup.isTriangularMatrice());
		assertTrue(matriceTriangulaireInf.isTriangularMatrice());
		assertTrue(!matricePositive.isTriangularMatrice());
		assertTrue(!matriceNegative.isTriangularMatrice());
		assertTrue(!matriceSymetric.isTriangularMatrice());
		assertTrue(matriceUnitaire.isTriangularMatrice());
	}

	@Test
	public void testIsTriangularUpperMatrice() {
		assertTrue(!matriceRectangle.isTriangularUpperMatrice());
		assertTrue(!matriceCarree.isTriangularUpperMatrice());
		assertTrue(matriceDiagonal.isTriangularUpperMatrice());
		assertTrue(matriceTriangulaireSup.isTriangularUpperMatrice());
		assertTrue(!matriceTriangulaireInf.isTriangularUpperMatrice());
		assertTrue(!matricePositive.isTriangularUpperMatrice());
		assertTrue(!matriceNegative.isTriangularUpperMatrice());
		assertTrue(!matriceSymetric.isTriangularUpperMatrice());
		assertTrue(matriceUnitaire.isTriangularUpperMatrice());
	}

	@Test
	public void testIsTriangularLowerMatrice() {
		assertTrue(!matriceRectangle.isTriangularLowerMatrice());
		assertTrue(!matriceCarree.isTriangularLowerMatrice());
		assertTrue(matriceDiagonal.isTriangularLowerMatrice());
		assertTrue(!matriceTriangulaireSup.isTriangularLowerMatrice());
		assertTrue(matriceTriangulaireInf.isTriangularLowerMatrice());
		assertTrue(!matricePositive.isTriangularLowerMatrice());
		assertTrue(!matriceNegative.isTriangularLowerMatrice());
		assertTrue(!matriceSymetric.isTriangularLowerMatrice());
		assertTrue(matriceUnitaire.isTriangularLowerMatrice());
	}

	@Test
	public void testIsSymetricMatrice() {
		assertTrue(!matriceRectangle.isSymetricMatrice());
		assertTrue(!matriceCarree.isSymetricMatrice());
		assertTrue(matriceDiagonal.isSymetricMatrice());
		assertTrue(!matriceTriangulaireSup.isSymetricMatrice());
		assertTrue(!matriceTriangulaireInf.isSymetricMatrice());
		assertTrue(!matricePositive.isSymetricMatrice());
		assertTrue(!matriceNegative.isSymetricMatrice());
		assertTrue(matriceSymetric.isSymetricMatrice());
		assertTrue(matriceUnitaire.isSymetricMatrice());
	}

	@Test
	public void testIsUnitaireMatrice() {
		assertTrue(!matriceRectangle.isUnitaireMatrice());
		assertTrue(!matriceCarree.isUnitaireMatrice());
		assertTrue(!matriceDiagonal.isUnitaireMatrice());
		assertTrue(!matriceTriangulaireSup.isUnitaireMatrice());
		assertTrue(!matriceTriangulaireInf.isUnitaireMatrice());
		assertTrue(!matricePositive.isUnitaireMatrice());
		assertTrue(!matriceNegative.isUnitaireMatrice());
		assertTrue(!matriceSymetric.isUnitaireMatrice());
		assertTrue(matriceUnitaire.isUnitaireMatrice());
	}

	@Test
	public void testIsFloatMatrice() {
		assertTrue(matriceRectangle.isFloatMatrice());
		assertTrue(matriceCarree.isFloatMatrice());
		assertTrue(matriceDiagonal.isFloatMatrice());
		assertTrue(matriceTriangulaireSup.isFloatMatrice());
		assertTrue(matriceTriangulaireInf.isFloatMatrice());
		assertTrue(matricePositive.isFloatMatrice());
		assertTrue(matriceNegative.isFloatMatrice());
		assertTrue(matriceSymetric.isFloatMatrice());
		assertTrue(matriceUnitaire.isFloatMatrice());
	}

	@Test
	public void testSimplificationMatrice() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Matrice mResultA = matriceLigne1.simplificationMatrice();
		Matrice mResultB = matriceLigne2.simplificationMatrice();
		
		assertTrue(matrixSolutionA.equals(mResultA));
		assertTrue(matrixSolutionB.equals(mResultB));
		
		MathObject[][] tabLocal = {
				{new Reel(3)},
				{new Complexe(3, -3)}};
		MathObject[][] lSolutionLocal = {
				{new Reel(1)},
				{new Complexe(1, -1)}};
		
		Matrice matriceLigne1Local = new Matrice(tabLocal);
		Matrice matrixSolutionALocal = new Matrice(lSolutionLocal);

		assertTrue(!matriceLigne1Local.simplificationMatrice().equals(matrixSolutionALocal));
	}

	@Test
	public void testTranspose() {
		solution = new Matrice(3, 2);
		MathObject[][] valeurSolution = {
				{new Reel(1), new Reel(2)},
				{new Reel(4), new Reel(7)},
				{new Reel(-2), new Reel(3)}};
		solution.set(valeurSolution);
		
		Matrice result = matriceA.transpose();
		assertTrue(solution.equals(result));
	}
	
	@Test
	public void testArrondir() {
		MathObject[][] fTab = {
				{new Reel(0.00003f), new Reel(3.000006f)},
				{new Complexe(1.000002f, 0.3f), new Reel(7.000006f)}};
		
		Matrice matrice = new Matrice(fTab );
		
		matrice.arrondir();
		MathObject[][] tab = matrice.matrice;
		
		assertTrue(tab[0][0].equals(new Reel(0)));
		assertTrue(tab[0][1].equals(new Reel(3)));
		
		assertTrue(tab[1][0].equals(new Complexe(1, 0)));
		assertTrue(tab[1][1].equals(new Reel(7)));
	}

	@Test
	public void testCopy() {
		MathObject[][] fTab = {
				{new Reel(0.00003f), new Reel(3.000006f)},
				{new Complexe(1.000002f, 0.3f), new Reel(7.000006f)}};
		
		Matrice matrice1 = new Matrice(fTab);
		Matrice matrice2 = matrice1.copy();
		
		matrice2.setValue(1, 1, new Reel(100));
		
		assertTrue(!matrice1.equals(matrice2));
	}

	@Test
	public void testEqualsMatrice() {
		MathObject[][] fTab = {
				{new Reel(3f), new Reel(36f)},
				{new Complexe(12f, 3f), new Reel(76f)}};
		MathObject[][] fTabDif = {
				{new Reel(3f), new Reel(37f)},
				{new Complexe(12f, 3f), new Reel(76f)}};
		MathObject[][] fTabligne = {
				{},
				{}};
		MathObject[][] fTabligne2 = {
				{new Reel(3f)},
				{new Reel(3f)}};
		MathObject[][] fTabColonne = {
				{new Reel(3f), new Reel(3f)},
				{new Reel(3f), new Reel(3f)},
				{new Reel(3f), new Reel(3f)}};
		Matrice matrice1 = new Matrice(fTab);
		Matrice matrice11 = new Matrice(fTab);
		Matrice matrice12 = new Matrice(fTabDif);
		Matrice matrice2 = new Matrice(fTabligne);
		Matrice vide = new Matrice();
		
		//différence de class
		assertTrue(!matrice1.equals(new Reel(1)));
		
		//les mm
		assertTrue(matrice1.equals(matrice1));
		
		//pour le nombre de colonne
		assertTrue(!matrice1.equals(vide));
		assertTrue(!vide.equals(matrice1));
		assertTrue(!matrice1.equals(fTabligne2));
		
		//pour le nombre de ligne
		assertTrue(!matrice1.equals(matrice2));
		assertTrue(!matrice2.equals(matrice1));
		assertTrue(!matrice1.equals(fTabColonne));
		
		//pour le contenu de la matrice
		assertTrue(matrice1.equals(matrice11));
		assertTrue(!matrice1.equals(matrice12));
	}

	@Test
	public void testDeterminant() {
		MathObject determinantA = matrice1.determinant();
		MathObject determinantB = matrice2.determinant();
		assertTrue(new Reel(fSolution1).equals(determinantA));
		assertTrue(new Reel(fSolution2).equals(determinantB));
		
		MathObject determinant = matrice3.determinant();
		assertTrue(determinant.equals(pSolution));
	}

	@Test
	public void testInverse() {
		MathObject result = matrice2.inverse();
		result = Operation.multiplier(result, new Reel(6));
		result.arrondir();
		assertTrue(mSolution.equals(result));
	}

	@Test
	public void testValeurPropre() {
		List<MathObject> result = matrice4.valeurPropre();
		boolean flag = false;
		
		assertEquals(lSolution.size(), result.size());
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < lSolution.size(); j++) {
				if(result.get(i).equals(lSolution.get(j)))
					flag= true;
			}
			assertTrue(flag);
			flag = false;
		}
		
		result = matrice5.valeurPropre();
		assertTrue(result.size() == lSolution2.size());
		flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < lSolution2.size(); j++) {
				if(result.get(i).equals(lSolution2.get(j)))
					flag= true;
			}
			assertTrue(flag);
			flag = false;
		}
		
		result = matriceOppenClassrom.valeurPropre();
		assertTrue(result.size() == lSolutionOppenClassroom.size());
		flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < lSolutionOppenClassroom.size(); j++) {
				if(result.get(i).equals(lSolutionOppenClassroom.get(j)))
					flag= true;
			}
			assertTrue(flag);
			flag = false;
		}
		
		result = matriceUnivParis13.valeurPropre();
		assertTrue(result.size() == lSolutionUnivParis13.size());
		flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < lSolutionUnivParis13.size(); j++) {
				if(result.get(i).equals(lSolutionUnivParis13.get(j)))
					flag= true;
			}
			assertTrue(flag);
			flag = false;
		}
	}

	@Test
	public void testVecteurPropre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, InstantiationException {
		{
//		List<Matrice> result = matrice4.vecteurPropre();
//		boolean flag = false;
//		for (int i = 0; i < result.size(); i++) {
//			for (int j = 0; j < matrixSolution.size(); j++) {
//				if(result.get(i).equals(matrixSolution.get(j))){
//					flag= true;
//				}
//			}
//			assertTrue(flag);
//			flag = false;
//		}
		}
		{
		List<Matrice> result = matrice5.vecteurPropre();
		boolean flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < matrixSolution2.size(); j++) {
				if(result.get(i).equals(matrixSolution2.get(j))){
					flag= true;
				}
			}
			assertTrue(flag);
			flag = false;
		}
		}
	}
	
	@Test
	public void testVecteurPropreNewGen() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, InstantiationException {
		{
		List<Matrice> result = matrice4.vecteurPropreNewGen();
		boolean flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < matrixSolution.size(); j++) {
				if(result.get(i).equals(matrixSolution.get(j))){
					flag= true;
				}
			}
			assertTrue(flag);
			flag = false;
		}
		}
		{
		List<Matrice> result = matrice5.vecteurPropreNewGen();
		boolean flag = false;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < matrixSolution2.size(); j++) {
				if(result.get(i).equals(matrixSolution2.get(j))){
					flag= true;
				}
			}
			assertTrue(flag);
			flag = false;
		}
		}
	}

}
