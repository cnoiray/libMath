package math.main;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainServiceTest {

	MainService mainService;
	List<String> listeTest = new ArrayList<String>();
	List<String> listeSol = new ArrayList<String>();
	
	List<String> listeTestCalc = new ArrayList<String>();
	List<String> listTestVal = new ArrayList<String>();
	List<String> listeCalcSol = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		mainService = new MainService();
		
		listeTest.add("2+7");
		listeTest.add("2*4+3");
		listeTest.add("2+4*3");
		listeTest.add("(2+4)*3");
		listeTest.add("(2+4)*3-8");
		listeTest.add("(2+4)*3-2*4");
		listeTest.add("(2+4)*3-2*2*2");
		listeTest.add("2+2+2+(-3)");
		listeTest.add("sin(2+7)");
		listeTest.add("sin(2+7*cos(4*12+3*x)/4)");
		listeTest.add("2+3+x");
		
		listeSol.add("9.0");
		listeSol.add("11.0");
		listeSol.add("14.0");
		listeSol.add("18.0");
		listeSol.add("10.0");
		listeSol.add("10.0");
		listeSol.add("10.0");
		listeSol.add("3.0");
		listeSol.add("sin(9.0)");
		listeSol.add("sin(2.0+(7.0*cos(48.0+3.0*x))/(4.0))");
		listeSol.add("5.0+x");
		
		listeTestCalc.add("2+x");
		listeTestCalc.add("2*x+3");
		listeTestCalc.add("2+4*x");
		listeTestCalc.add("2+x");
		listeTestCalc.add("2+sin(x)");
		listeTestCalc.add("2+sin(x)");
		listeTestCalc.add("2+sin(x)");
		
		listTestVal.add("4");
		listTestVal.add("5");
		listTestVal.add("3");
		listTestVal.add("3+x");
		listTestVal.add("1");
		listTestVal.add("0.2");
		listTestVal.add("0.5");
		
		listeCalcSol.add("6.0");
		listeCalcSol.add("13.0");
		listeCalcSol.add("14.0");
		listeCalcSol.add("2.0+3.0+x");
		listeCalcSol.add("2.841471");
		listeCalcSol.add("2.1986694");
		listeCalcSol.add("2.4794254");
	}

	@Test
	public void testEvaluer() {
		for (int i = 0; i < listeTest.size(); i++) {
			MathObject object = mainService.evaluer(mainService.analyse(listeTest.get(i)));
			Assert.assertEquals(listeSol.get(i), object.toString());
		}
	}

	@Test
	public void testCalculer() {
		Inconnue inconnue = new Inconnue("x");
		for (int i = 0; i < listeTestCalc.size(); i++) {
			MathObject object = mainService.calculer(mainService.analyse(listeTestCalc.get(i)), new SimpleEntry<>(inconnue ,mainService.analyse(listTestVal.get(i))));
			Assert.assertEquals(listeCalcSol.get(i), object.toString());
		}
	}
}
