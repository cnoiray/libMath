/**
 * 
 */
package math.entities;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Reel;
import math.entities.mathobject.SystemeEquation;

import org.junit.Before;
import org.junit.Test;

/**
 * @author cnoiray
 *
 */
public class SystemeEquationTest {

	private float[][] valeurA = {
			{1, 3, 4},
			{3, 5, -4},
			{4, 7, -2}};
	
	private float[][] valeurB = {
			{1, 1, 3},
			{-1, -1, 2},
			{2, 2, 3}};
	
	private float[][] valeurAA = {
			{2, 2},
			{3, 3}};
	
	private float[][] valeurAB = {
			{-3, 2},
			{3, -2}};
	
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
			{0, 0, 1}};
			
	private float[][] tabSolutionAA = {
			{-1},
			{1}};
	
	private float[][] tabSolutionAB = {
			{2/3},
			{1}};
	
	private SystemeEquation equationLineaireA;
	private SystemeEquation equationLineaireB;
	private SystemeEquation equationLineaireAA;
	private SystemeEquation equationLineaireAB;
	
	private Matrice mSolutionA;
	private Matrice mSolutionB;
	private Matrice mSolutionAA;
	private Matrice mSolutionAB;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Matrice transformeA = new Matrice(valeurA);
		Matrice constanteA = new Matrice(valeurC);
		equationLineaireA = new SystemeEquation(transformeA, constanteA);
	
		Matrice transformeB = new Matrice(valeurB);
		Matrice constanteB = new Matrice(valeurD);
		equationLineaireB = new SystemeEquation(transformeB, constanteB);
	
		Matrice transformeAA = new Matrice(valeurAA);
		Matrice constanteAA = new Matrice(2, 1);
		equationLineaireAA = new SystemeEquation(transformeAA, constanteAA);
		Matrice transformeAB = new Matrice(valeurAB);
		Matrice constanteAB = new Matrice(2, 1);
		equationLineaireAB = new SystemeEquation(transformeAB, constanteAB);
		
		mSolutionA = new Matrice(tabSolutionA);
		mSolutionB = new Matrice(tabSolutionB);
		
		mSolutionAA = new Matrice(tabSolutionAA);
		mSolutionAB = new Matrice(tabSolutionAB);
	}

	/**
	 * Test method for {@link math.entities.mathobject.SystemeEquation#isHomogene()}.
	 */
	@Test
	public void testIsHomogene() {
		assertTrue(!equationLineaireA.isHomogene());
		assertTrue(equationLineaireB.isHomogene());
	}

	/**
	 * Test method for {@link math.entities.mathobject.SystemeEquation#cramerResolution()}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testCramerResolution() {
		Matrice resultA = equationLineaireA.cramerResolution();
		assertTrue(resultA.equals(mSolutionA));
	}

	/**
	 * Test method for {@link math.entities.mathobject.SystemeEquation#matrixInversionResolution(math.entities.mathobject.SystemeEquation)}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testMatrixInversionResolution() {
		Matrice resultA = (Matrice) equationLineaireA.matrixInversionResolution();
		assertTrue(resultA.equals(mSolutionA));
	}

	/**
	 * Test method for {@link math.entities.mathobject.SystemeEquation#pivotGaussResolution()}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testPivotGaussResolution() {
		Matrice resultA = equationLineaireA.pivotGaussResolution();
		Matrice resultB = equationLineaireB.pivotGaussResolution();
		
		assertTrue(resultA.equals(mSolutionA));
		assertTrue(resultB.equals(mSolutionB));
	}
	
	/**
	 * Test method for {@link math.linear.equation.service.ServiceLinearEquation#multiplyLineByScalaire(math.linear.equation.entity.LinearEquation, int, float)}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testMultiplyLineByScalaire() {
		equationLineaireA.multiplyLineByScalaire(0, new Reel(2));
		equationLineaireB.multiplyLineByScalaire(1, new Reel(10));
		
		MathObject[][] tab = equationLineaireA.transformation.matrice;
		MathObject[][] tabC = equationLineaireA.constante.matrice;
		
		assertEquals(tabC[0][0].toString(), new Reel(100.0f).toString());
		assertEquals(tab[0][0].toString(), new Reel(2.0f).toString());
		assertEquals(tab[0][1].toString(), new Reel(6.0f).toString());
		assertEquals(tab[0][2].toString(), new Reel(8.0f).toString());
		
		tab = equationLineaireB.transformation.matrice;
		tabC = equationLineaireB.constante.matrice;
		
		assertEquals(tabC[1][0].toString(), new Reel(0.0f).toString());
		assertEquals(tab[1][0].toString(), new Reel(-10.0f).toString());
		assertEquals(tab[1][1].toString(), new Reel(-10.0f).toString());
		assertEquals(tab[1][2].toString(), new Reel(20.0f).toString());
	}

	/**
	 * Test method for {@link math.linear.equation.service.ServiceLinearEquation#permutation(math.linear.equation.entity.LinearEquation, int, int)}.
	 */
	@Test
	public void testPermutation() {
		equationLineaireA.permutation(0, 1);
		equationLineaireB.permutation(1, 2);
		
		MathObject[][] tab = equationLineaireA.transformation.matrice;
		MathObject[][] tabC = equationLineaireA.constante.matrice;
		
		assertEquals(tabC[0][0].toString(), new Reel(2.0f).toString());
		assertEquals(tab[0][0].toString(), new Reel(3.0f).toString());
		assertEquals(tab[0][1].toString(), new Reel(5.0f).toString());
		assertEquals(tab[0][2].toString(), new Reel(-4.0f).toString());
		
		assertEquals(tabC[1][0].toString(), new Reel(50.0f).toString());
		assertEquals(tab[1][0].toString(), new Reel(1.0f).toString());
		assertEquals(tab[1][1].toString(), new Reel(3.0f).toString());
		assertEquals(tab[1][2].toString(), new Reel(4.0f).toString());
		
		tab = equationLineaireB.transformation.matrice;
		tabC = equationLineaireB.constante.matrice;
		
		assertEquals(tabC[1][0].toString(), new Reel(0.0f).toString());
		assertEquals(tab[1][0].toString(), new Reel(2.0f).toString());
		assertEquals(tab[1][1].toString(), new Reel(2.0f).toString());
		assertEquals(tab[1][2].toString(), new Reel(3.0f).toString());
		
		assertEquals(tabC[2][0].toString(), new Reel(0.0f).toString());
		assertEquals(tab[2][0].toString(), new Reel(-1.0f).toString());
		assertEquals(tab[2][1].toString(), new Reel(-1.0f).toString());
		assertEquals(tab[2][2].toString(), new Reel(2.0f).toString());
	}

	/**
	 * Test method for {@link math.linear.equation.service.ServiceLinearEquation#addLigneAndScalaire(math.linear.equation.entity.LinearEquation, int, int, math.polynomial.equation.entity.PolynomialEquation)}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testAddLigneAndScalaire() {
		equationLineaireA.addLigneAndScalaire(0, 1, new Reel(2));
		equationLineaireB.addLigneAndScalaire(1, 2, new Reel(10));
		
		MathObject[][] tab = equationLineaireA.transformation.matrice;
		MathObject[][] tabC = equationLineaireA.constante.matrice;
		
		assertEquals(tabC[0][0].toString(), new Reel(54.0f).toString());
		assertEquals(tab[0][0].toString(), new Reel(7.0f).toString());
		assertEquals(tab[0][1].toString(), new Reel(13.0f).toString());
		assertEquals(tab[0][2].toString(), new Reel(-4.0f).toString());
		
		tab = equationLineaireB.transformation.matrice;
		tabC = equationLineaireB.constante.matrice;
		
		assertEquals(tabC[1][0].toString(), new Reel(0.0f).toString());
		assertEquals(tab[1][0].toString(), new Reel(19.0f).toString());
		assertEquals(tab[1][1].toString(), new Reel(19.0f).toString());
		assertEquals(tab[1][2].toString(), new Reel(32.0f).toString());
	}
	
	@Test
	public void testGeneraux() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Matrice resultAA = equationLineaireAA.resolutionEquationLineaire();
//		Matrice resultAB = equationLineaireAB.resolutionEquationLineaire();
		
//		assertEquals(mSolutionAA, resultAA);
//		assertEquals(mSolutionAB, resultAB);
	}
}
