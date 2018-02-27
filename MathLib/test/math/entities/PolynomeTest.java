package math.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import math.configuration.MathConf;
import math.entities.mathobject.Complexe;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

public class PolynomeTest {
	List<MathObject> formeDeveloppee = new ArrayList<>();
	List<List<MathObject>> formeFactorisee = new ArrayList<List<MathObject>>();
	
	private Polynome polynomeA;
	private Polynome polynomeB;
	private Polynome polynomeC;
	private Polynome polynomeD;
	private Polynome polynomeE;
	private Polynome polynomeF;
	private Polynome polynomeArrondir;
	private Polynome pSolution;
	
	@Before
	public void setUp() throws Exception {
		List<MathObject> formeFactoriseeVal1 = new ArrayList<MathObject>();
		formeFactoriseeVal1.add(new Reel(2));
		formeFactoriseeVal1.add(new Reel(10));
		List<MathObject> formeFactoriseeVal2 = new ArrayList<MathObject>();
		formeFactoriseeVal2.add(new Reel(3));
		formeFactoriseeVal2.add(new Reel(4));
		formeFactorisee.add(formeFactoriseeVal1);
		formeFactorisee.add(formeFactoriseeVal2);
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(38));
		formeDeveloppee.add(new Reel(40));
		
		List<MathObject> formeDeveloppeeA = new ArrayList<MathObject>();
		List<MathObject> formeDeveloppeeB = new ArrayList<MathObject>();
		List<MathObject> formeDeveloppeeC = new ArrayList<MathObject>();
		List<MathObject> formeDeveloppeeD = new ArrayList<MathObject>();
		List<MathObject> formeDeveloppeeE = new ArrayList<MathObject>();
		formeDeveloppeeA.add(new Reel(0f));
		formeDeveloppeeB.add(new Reel(12f));
		formeDeveloppeeC.add(new Reel(12f));
		formeDeveloppeeD.add(new Reel(15f));
		formeDeveloppeeD.add(new Reel(-3f));
		formeDeveloppeeD.add(new Reel(0.003f));
		formeDeveloppeeE.add(new Reel(15f));
		formeDeveloppeeE.add(new Reel(-3f));
		formeDeveloppeeE.add(new Reel(0.003f));
		polynomeA = new Polynome(formeDeveloppeeA);
		polynomeB = new Polynome(formeDeveloppeeB);
		polynomeC = new Polynome(formeDeveloppeeC);
		polynomeD = new Polynome(formeDeveloppeeD);
		polynomeE = new Polynome(formeDeveloppeeE);
		
		List<MathObject> valeurF = new ArrayList<MathObject>();
		valeurF.add(new Reel(-1f));
		valeurF.add(new Reel(1f));
		valeurF.add(new Reel(1f));
		valeurF.add(new Reel(-1f));
		polynomeF = new Polynome(valeurF);
		
		float valeur_a_arrondir = (float) (Math.pow(10, -MathConf.getNombreDecimal()-1) * 1f);
		List<MathObject> lValeur_a_arrondir = new ArrayList<MathObject>();
		lValeur_a_arrondir.add(new Reel(2+valeur_a_arrondir));
		lValeur_a_arrondir.add(new Reel(10-valeur_a_arrondir));
		lValeur_a_arrondir.add(new Reel(42f));
		
		polynomeArrondir = new Polynome(lValeur_a_arrondir);
	}

	@Test
	public void testIsNull() {
		assertTrue(polynomeA.isNull());
		assertTrue(!polynomeB.isNull());
		assertTrue(!polynomeE.isNull());
	}

	@Test
	public void testEqualsIMathObject() {
		assertTrue(!polynomeE.equals(new Reel(2)));
		assertTrue(polynomeE.equals(polynomeE));
		assertTrue(!polynomeE.equals(polynomeA));
		
		List<MathObject> formeDeveloppeeE = new ArrayList<MathObject>();
		formeDeveloppeeE.add(new Reel(15f));
		formeDeveloppeeE.add(new Reel(-3f));
		formeDeveloppeeE.add(new Reel(0.003f));
		Polynome polynomeE = new Polynome(formeDeveloppeeE);
		
		assertTrue(polynomeE.equals(this.polynomeE));
	}

	@Test
	public void testBuildPolynome() {
		Polynome polynome = new Polynome(formeDeveloppee, formeFactorisee);
		
		//pour la forme factorisée
		testFactoriseForm(polynome);
		
		//pour la forme developpée
		testDeveloppeForm(polynome);
	}

	@Test
	public void testBuildPolynomeFromFloat() {
		Polynome polynome = new Polynome(10);
		
		assertTrue(polynome.getDegres() == 0);
		assertTrue(polynome.formeDeveloppee.get(0).equals(new Reel(10)));
	}

	@Test
	public void testBuildPolynomeFromMathObject() {
		Polynome polynome = new Polynome(new Complexe(2, 1));
		
		assertEquals("(2.0+1.0*i)*x^0 ", polynome.toString());
	}

	@Test
	public void testBuildPolynomeFromDeveloppeForm() {
		Polynome polynome = new Polynome(formeDeveloppee);
		
		testDeveloppeForm(polynome);
	}

	@Test
	public void testBuildPolynomeFromFactoriseForm() {
		Polynome polynome = new Polynome().buildPolynomeFromFactoriseForm(formeFactorisee);
		
		testFactoriseForm(polynome);
		testDeveloppeForm(polynome);
	}

	@Test
	public void testSet() {
		List<List<MathObject>> formeFactoriseeTest = new ArrayList<List<MathObject>>();
		Polynome polynome = new Polynome().buildPolynomeFromFactoriseForm(formeFactoriseeTest);
		Polynome polynomeB = new Polynome(formeDeveloppee, formeFactorisee);
		polynome.set(polynomeB);
		
		assertTrue(polynome.equals(polynomeB));
		assertTrue(polynome.equals(polynomeB));
	}

	@Test
	public void testGetConstant() {
		Polynome polynome = new Polynome(formeDeveloppee, formeFactorisee);
		MathObject value = polynome.getConstant();
		
		assertTrue(value.equals(new Reel(6)));
	}

	@Test
	public void testIsEqualsToReelReel() {
		assertTrue(polynomeA.isEqualsToReel(new Reel(0)));
		assertTrue(polynomeB.isEqualsToReel(new Reel(12)));
		assertTrue(!polynomeC.isEqualsToReel(new Reel(15)));
		assertTrue(!polynomeE.isEqualsToReel(new Reel(12)));
	}

	@Test
	public void testIsEqualsTo() {
		assertTrue(polynomeA.isEqualsTo(polynomeA));
		assertTrue(polynomeB.isEqualsTo(polynomeC));
		assertTrue(polynomeD.isEqualsTo(polynomeE));
		assertTrue(!polynomeE.isEqualsTo(polynomeA));
	}

	@Test
	public void testIsEqualsToReel() {
		assertTrue(polynomeA.isEqualsToReel());
		assertTrue(polynomeB.isEqualsToReel());
		assertTrue(polynomeC.isEqualsToReel());
		assertTrue(!polynomeE.isEqualsToReel());
	}

	@Test
	public void testGetDegres() {
		assertEquals(0, polynomeA.getDegres());
		assertEquals(0, polynomeB.getDegres());
		assertEquals(2, polynomeArrondir.getDegres());
		assertEquals(2, polynomeE.getDegres());
	}

	@Test
	public void testArrondir() {
		Polynome pSolutionTest = polynomeArrondir.arrondir();
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel(2));
		formeDeveloppeeSolution.add(new Reel(10));
		formeDeveloppeeSolution.add(new Reel(42));
		pSolution = new Polynome(formeDeveloppeeSolution);
		
		assertTrue(pSolutionTest.isEqualsTo(pSolution));
	}

	private void testDeveloppeForm(Polynome polynome){
		List<MathObject> formeDeveloppeeTest = polynome.formeDeveloppee;
		assertTrue(formeDeveloppeeTest.size() == this.formeDeveloppee.size());
		for (int k = 0; k < formeDeveloppeeTest.size(); k++) {
			assertTrue(formeDeveloppeeTest.get(k).equals(this.formeDeveloppee.get(k)));
		}
	}
	
	private void testFactoriseForm(Polynome polynome){
		List<List<MathObject>> formeFactoriseeTest = polynome.formeFactorisee;
		assertTrue(formeFactoriseeTest.size() == this.formeFactorisee.size());
		for (int i = 0; i < formeFactoriseeTest.size(); i++) {
			assertTrue(formeFactoriseeTest.get(i).size() == this.formeFactorisee.get(i).size());
			for (int j = 0; j < formeFactoriseeTest.get(i).size(); j++) {
				assertTrue(formeFactoriseeTest.get(i).get(j) == this.formeFactorisee.get(i).get(j));
			}
		}
	}
	
	/**
	 * Test method for {@link math.polynomial.equation.service.ServicePolynomialEquation#calculDeriver(math.polynomial.equation.entity.PolynomialEquation)}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testCalculDeriver() {
		Polynome pSolutionTest = polynomeF.deriver();
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(0, new Reel(-3));
		formeDeveloppeeSolution.add(0, new Reel(2));
		formeDeveloppeeSolution.add(0, new Reel(1));
		pSolution = new Polynome(formeDeveloppeeSolution);
		
		assertTrue(pSolutionTest.equals(pSolution));
	}

	/**
	 * Test method for {@link math.polynomial.equation.service.ServicePolynomialEquation#calculDeriveeN(math.polynomial.equation.entity.PolynomialEquation, int)}.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testCalculDeriveeN() {
		Polynome pSolutionTest = polynomeF.calculDeriveeN(2);
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(0, new Reel(-6));
		formeDeveloppeeSolution.add(0, new Reel(2));
		pSolution = new Polynome(formeDeveloppeeSolution);
		
		assertTrue(pSolutionTest.equals(pSolution));
	}
	
	@Test
	public void testAfficher(){
		polynomeC.afficher();
		polynomeE.afficher();
	}
}
