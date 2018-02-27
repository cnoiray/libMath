package math.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import math.configuration.MathConf;
import math.controler.Operation;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

public class PolynomeServiceTest {

	private Polynome polynomeA;
	private Polynome polynomeB;
	private Polynome polynomeNewton;
	private Polynome pSolution;
	private Polynome polynomeArrondir;
	private List<MathObject> valeurA;
	private List<MathObject> valeurB;
	private List<MathObject> valeurNewton;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		valeurA = new ArrayList<MathObject>();
		valeurA.add(new Reel(-1f));
		valeurA.add(new Reel(1f));
		valeurA.add(new Reel(1f));
		valeurA.add(new Reel(-1f));
		
		valeurB = new ArrayList<MathObject>();
		valeurB.add(new Reel(3f));
		valeurB.add(new Reel(1f));
		
		valeurNewton = new ArrayList<MathObject>();
		valeurNewton.add(new Reel(-5f));
		valeurNewton.add(new Reel(-2f));
		valeurNewton.add(new Reel(0f));
		valeurNewton.add(new Reel(1f));
		
		float valeur_a_arrondir = (float)(Math.pow(10, -MathConf.getNombreDecimal()-1) * 1f);
		List<MathObject> lValeur_a_arrondir = new ArrayList<MathObject>();
		lValeur_a_arrondir.add(new Reel(2+valeur_a_arrondir));
		lValeur_a_arrondir.add(new Reel(10-valeur_a_arrondir));
		lValeur_a_arrondir.add(new Reel(42f));
		
		polynomeA = new Polynome(valeurA);
		polynomeB = new Polynome(valeurB);
		polynomeNewton = new Polynome(valeurNewton);
		polynomeArrondir = new Polynome(lValeur_a_arrondir);
	}

	@Test
	public void testResolutionNewton() {
		MathObject solution = PolynomeService.resolutionNewton(polynomeNewton, new Reel(2));
		
		assertTrue(solution.sup(new Reel(2.094f)));
		assertTrue(solution.inf(new Reel(2.095f)));
		
		solution = PolynomeService.resolutionNewton(polynomeNewton, new Reel(3));
		
		assertTrue(solution.sup(new Reel(2.094f)));
		assertTrue(solution.inf(new Reel(2.095f)));
	}

	@Test
	public void testResolutionDegres2() {
		List<MathObject> listResult = PolynomeService.resolutionDegres2(polynomeA.deriver());
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel((float)-1/3));
		formeDeveloppeeSolution.add(new Reel(1));
		
		assertEquals(formeDeveloppeeSolution.size(), listResult.size());
		
		int i = 0;
		for (MathObject mathObject : formeDeveloppeeSolution) {
			assertTrue(mathObject.equals(listResult.get(i)));
			i++;
		}
	}

	@Test
	public void testResolutionPolynome() {
		{
		List<MathObject> listResult =  PolynomeService.resolutionPolynome(polynomeNewton);
		assertTrue(listResult.size() == 1 && listResult.get(0).sup(new Reel(2.094f)) && listResult.get(0).inf(new Reel(2.095f)));
		}
		{
		List<MathObject> listResult =  PolynomeService.resolutionPolynome(polynomeA);
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel(-1));
		formeDeveloppeeSolution.add(new Reel(1));
		formeDeveloppeeSolution.add(new Reel(1));
		
		assertEquals(formeDeveloppeeSolution.size(), listResult.size());
		
		int i = 0;
		for (MathObject mathObject : formeDeveloppeeSolution) {
			assertTrue(mathObject.equals(listResult.get(i)));
			i++;
		}
		}
	}

	@Test
	public void testAnalyseDerivee() {
		List<MathObject> listDeriveeNul = new ArrayList<MathObject>();
		listDeriveeNul.add(new Reel((float)-Math.sqrt((double)2/3)));
		listDeriveeNul.add(new Reel((float)Math.sqrt((double)2/3)));
		List<MathObject> result = PolynomeService.analyseDerivee(polynomeNewton, listDeriveeNul);
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel(3));
		formeDeveloppeeSolution.add(new Reel(0));
		formeDeveloppeeSolution.add(new Reel(0));
		formeDeveloppeeSolution.add(new Reel(3));
		
		testResult(result, formeDeveloppeeSolution);
	}

	@Test
	public void testAnalysePolynome() {
		List<MathObject> listDeriveeNul = new ArrayList<MathObject>();
		listDeriveeNul.add(new Reel((float)-Math.sqrt((double)2/3)));
		listDeriveeNul.add(new Reel((float)Math.sqrt((double)2/3)));
		List<MathObject> result = PolynomeService.analysePolynome(polynomeNewton, listDeriveeNul);
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel(-1));
		formeDeveloppeeSolution.add(new Reel(-3.911f));
		formeDeveloppeeSolution.add(new Reel(-6.089f));
		formeDeveloppeeSolution.add(new Reel(1));
		
		testResult(result, formeDeveloppeeSolution);
	}

	private void testResult(List<MathObject> result, List<MathObject> formeDeveloppeeSolution) {
		assertEquals(formeDeveloppeeSolution.size(), result.size());
		assertTrue(formeDeveloppeeSolution.get(0).equals(result.get(0)));
		assertTrue(Operation.additionner(formeDeveloppeeSolution.get(1), new Reel(0.001f)).sup(result.get(1)) 
				&& Operation.soustraire(formeDeveloppeeSolution.get(1), new Reel(0.001f)).inf(result.get(1)));
		assertTrue(Operation.additionner(formeDeveloppeeSolution.get(2), new Reel(0.001f)).sup(result.get(2)) 
				&& Operation.soustraire(formeDeveloppeeSolution.get(2), new Reel(0.001f)).inf(result.get(2)));
		assertTrue(formeDeveloppeeSolution.get(3).equals(result.get(3)));
	}

	@Test
	public void testArrondirPolynome() {
		Polynome pSolutionTest = PolynomeService.arrondirPolynome(polynomeArrondir);
		
		List<MathObject> formeDeveloppeeSolution = new ArrayList<MathObject>();
		formeDeveloppeeSolution.add(new Reel(2));
		formeDeveloppeeSolution.add(new Reel(10));
		formeDeveloppeeSolution.add(new Reel(42));
		pSolution = new Polynome(formeDeveloppeeSolution);
		
		assertTrue(pSolutionTest.equals(pSolution));
	}

}
