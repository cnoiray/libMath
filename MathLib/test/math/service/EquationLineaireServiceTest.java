package math.service;

import static org.junit.Assert.assertTrue;
import math.entities.EquationLineaire;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

import org.junit.Before;
import org.junit.Test;

public class EquationLineaireServiceTest {
	private float[][] valeurA = {
			{1, 3, 4},
			{3, 5, -4},
			{4, 7, -2}};
	
	private float[][] valeurB = {
			{1, 1, 3},
			{-1, -1, 2},
			{2, 2, 3}};
	
	private float[][] valeurC = {
			{50},
			{2},
			{31}};
	
	private float[][] valeurD = {
			{0},
			{0},
			{0}};
	
	private float[][] tabSolutionA = {
			{3},
			{5},
			{8}};
	
	private float[][] tabSolutionB = {
			{1, 1, 0},
			{0, 0, 0},
			{0, 0, 1}};;
	
	private EquationLineaire equationLineaireA;
	private EquationLineaire equationLineaireB;
	
	private Matrice mSolutionA;
	private Matrice mSolutionB;
	
	private EquationLineaireService service;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Matrice transformeA = new Matrice(valeurA);
		Matrice constanteA = new Matrice(valeurC);
		equationLineaireA = new EquationLineaire(transformeA, constanteA);
	
		Matrice transformeB = new Matrice(valeurB);
		Matrice constanteB = new Matrice(valeurD);
		equationLineaireB = new EquationLineaire(transformeB, constanteB);
	
		mSolutionA = new Matrice(tabSolutionA);
		mSolutionB = new Matrice(tabSolutionB);
		
		service = new EquationLineaireService();
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#isHomogene(math.linear.equation.entity.EquationLineaire)}.
	 */
	@Test
	public void testIsHomogene() {
		assertTrue(!service.isHomogene(equationLineaireA));
		assertTrue(service.isHomogene(equationLineaireB));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#multiplyLineByScalaire(math.linear.equation.entity.EquationLineaire, int, float)}.
	 */
	@Test
	public void testMultiplyLineByScalaire() {
		service.multiplyLineByScalaire(equationLineaireA, 0, new Reel(2));
		service.multiplyLineByScalaire(equationLineaireB, 1, new Reel(10));
		
		MathObject[][] tab = equationLineaireA.getTransformation().matrice;
		MathObject[][] tabC = equationLineaireA.getConstante().matrice;
		
		assertTrue(tabC[0][0].equals(new Reel(100)));
		assertTrue(tab[0][0].equals(new Reel(2)));
		assertTrue(tab[0][1].equals(new Reel(6)));
		assertTrue(tab[0][2].equals(new Reel(8)));
		
		tab = equationLineaireB.getTransformation().matrice;
		tabC = equationLineaireB.getConstante().matrice;
		
		assertTrue( tabC[1][0].equals(new Reel(0)));
		assertTrue( tab[1][0].equals(new Reel(-10)));
		assertTrue( tab[1][1].equals(new Reel(-10)));
		assertTrue( tab[1][2].equals(new Reel(20)));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#permutation(math.linear.equation.entity.EquationLineaire, int, int)}.
	 */
	@Test
	public void testPermutation() {
		service.permutation(equationLineaireA, 0, 1);
		service.permutation(equationLineaireB, 1, 2);
		
		MathObject[][] tab = equationLineaireA.getTransformation().matrice;
		MathObject[][] tabC = equationLineaireA.getConstante().matrice;
		
		assertTrue( tabC[0][0].equals(new Reel(2)));
		assertTrue( tab[0][0].equals(new Reel(3)));
		assertTrue( tab[0][1].equals(new Reel(5)));
		assertTrue( tab[0][2].equals(new Reel(-4)));
		
		assertTrue( tabC[1][0].equals(new Reel(50)));
		assertTrue( tab[1][0].equals(new Reel(1)));
		assertTrue( tab[1][1].equals(new Reel(3)));
		assertTrue( tab[1][2].equals(new Reel(4)));
		
		tab = equationLineaireB.getTransformation().matrice;
		tabC = equationLineaireB.getConstante().matrice;
		
		assertTrue( tabC[1][0].equals(new Reel(0)));
		assertTrue( tab[1][0].equals(new Reel(2)));
		assertTrue( tab[1][1].equals(new Reel(2)));
		assertTrue( tab[1][2].equals(new Reel(3)));
		
		assertTrue( tabC[2][0].equals(new Reel(0)));
		assertTrue( tab[2][0].equals(new Reel(-1)));
		assertTrue( tab[2][1].equals(new Reel(-1)));
		assertTrue( tab[2][2].equals(new Reel(2)));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#addLigneAndScalaire(math.linear.equation.entity.EquationLineaire, int, int, math.polynomial.equation.entity.PolynomialEquation)}.
	 */
	@Test
	public void testAddLigneAndScalaire() {
		service.addLigneAndScalaire(
				equationLineaireA, 
				0, 
				1, 
				new Polynome(2f));
		service.addLigneAndScalaire(
				equationLineaireB, 
				1,
				2,
				new Polynome(10f));
		
		MathObject[][] tab = equationLineaireA.getTransformation().matrice;
		MathObject[][] tabC = equationLineaireA.getConstante().matrice;
		
		assertTrue( tabC[0][0].equals(new Polynome(54)));
		assertTrue( tab[0][0].equals(new Polynome(7)));
		assertTrue( tab[0][1].equals(new Polynome(13)));
		assertTrue( tab[0][2].equals(new Polynome(-4)));
		
		tab = equationLineaireB.getTransformation().matrice;
		tabC = equationLineaireB.getConstante().matrice;
		
		assertTrue( tabC[1][0].equals(new Polynome(0)));
		assertTrue( tab[1][0].equals(new Polynome(19)));
		assertTrue( tab[1][1].equals(new Polynome(19)));
		assertTrue( tab[1][2].equals(new Polynome(32)));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#cramerResolution(math.linear.equation.entity.EquationLineaire)}.
	 */
	@Test
	public void testCramerResolution() {
		Matrice resultA = service.cramerResolution(equationLineaireA);
		assertTrue(resultA.equals(mSolutionA));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#matrixInversionResolution(math.linear.equation.entity.EquationLineaire)}.
	 */
	@Test
	public void testMatrixInversionResolution() {
		Matrice resultA = service.matrixInversionResolution(equationLineaireA);
		assertTrue(resultA.equals(mSolutionA));
	}

	/**
	 * Test method for {@link math.linear.equation.service.service#pivotGaussResolution(math.linear.equation.entity.EquationLineaire)}.
	 */
	@Test
	public void testPivotGaussResolution() {
		Matrice resultA = service.pivotGaussResolution(equationLineaireA);
		Matrice resultB = service.pivotGaussResolution(equationLineaireB);
		
		assertTrue(resultA.equals(mSolutionA));
		assertTrue(resultB.equals(mSolutionB));
	}
}
