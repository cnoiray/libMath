/**
 * 
 */
package math.controler;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Complexe;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;

/**
 * @author cnoiray
 *
 */
public class OperationControlerTest {
	private List<MathObject> formeDeveloppee = new ArrayList<>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdditionReelEtReel() {
		Reel a = new Reel(3);
		Reel b = new Reel(2);
		Assert.assertEquals("5.0", val(Operation.additionner(a, b)));
		
		Reel a1 = new Reel(3);
		Reel b1 = new Reel(-2);
		
		Assert.assertEquals("1.0", val(Operation.additionner(a1, b1)));
	}
	
	@Test
	public void testAdditionReelEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Reel a = new Reel(3);
		Complexe b = new Complexe(2);
		Assert.assertEquals("3.0+2.0*i", val(Operation.additionner(a, b)));
		Assert.assertEquals("3.0+2.0*i", val(Operation.additionner(b, a)));
		
		Reel a1 = new Reel(3);
		Complexe b1 = new Complexe(-2);
		
		Assert.assertEquals("3.0-2.0*i", val(Operation.additionner(a1, b1)));
		Assert.assertEquals("3.0-2.0*i", val(Operation.additionner(b1, a1)));
		
		Reel a2 = new Reel(3);
		Complexe b2 = new Complexe(2, 1);
		Assert.assertEquals("5.0+1.0*i", val(Operation.additionner(a2, b2)));
		Assert.assertEquals("5.0+1.0*i", val(Operation.additionner(b2, a2)));
		
		Reel a3 = new Reel(3);
		Complexe b3 = new Complexe(-2, 1);
		Assert.assertEquals("1.0+1.0*i", val(Operation.additionner(a3, b3)));
		Assert.assertEquals("1.0+1.0*i", val(Operation.additionner(b3, a3)));
		
		Reel a4 = new Reel(3);
		Complexe b4 = new Complexe(-6, 2);
		Assert.assertEquals("-3.0+2.0*i", val(Operation.additionner(a4, b4)));
		Assert.assertEquals("-3.0+2.0*i", val(Operation.additionner(b4, a4)));
	}
	
	@Test
	public void testAdditionComplexeEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Complexe a = new Complexe(3, 2);
		Complexe b = new Complexe(2, 3);
		Assert.assertEquals("5.0+5.0*i", val(Operation.additionner(a, b)));
		Assert.assertEquals("5.0+5.0*i", val(Operation.additionner(b, a)));
		
		a = new Complexe(3, -1);
		b = new Complexe(2, 3);
		Assert.assertEquals("5.0+2.0*i", val(Operation.additionner(a, b)));
		Assert.assertEquals("5.0+2.0*i", val(Operation.additionner(b, a)));
	}
	
	@Test
	public void testAdditionReelEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Reel(5);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("+11.0*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("+11.0*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Reel(-10);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-4.0)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(-4.0)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Reel(5);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(11.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(11.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testAdditionComplexeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Complexe(5, -7);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(11.0-7.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(11.0-7.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Complexe(-10, 4);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-4.0+4.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(-4.0+4.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Complexe(5, 2);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(11.0+5.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(11.0+5.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testAdditionPolynomeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		Polynome a = (Polynome) new Polynome(formeDeveloppee2);
		
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("+7.0*x^0 +8.0*x^1 +9.0*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("+7.0*x^0 +8.0*x^1 +9.0*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		formeDeveloppee2.clear();
		formeDeveloppee2.add(new Complexe(1));
		formeDeveloppee2.add(new Complexe(2, 4));
		formeDeveloppee2.add(new Complexe(3, 7));
		a = (Polynome) new Polynome(formeDeveloppee2);
		
		Assert.assertEquals("(6.0+1.0*i)*x^0 +(8.0+4.0*i)*x^1 +(9.0+7.0*i)*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(6.0+1.0*i)*x^0 +(8.0+4.0*i)*x^1 +(9.0+7.0*i)*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(6.0+4.0*i)*x^0 +(8.0+4.0*i)*x^1 +(9.0+11.0*i)*x^2 ", val(Operation.additionner(a, b)));
		Assert.assertEquals("(6.0+4.0*i)*x^0 +(8.0+4.0*i)*x^1 +(9.0+11.0*i)*x^2 ", val(Operation.additionner(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testAdditionMatriceEtReel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Reel a;
		{//Matrice de réel
		a = new Reel(10);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 11.0 4.0 -2.0 || 2.0 17.0 3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 11.0 4.0 -2.0 || 2.0 17.0 3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Reel(2);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 3.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 9.0 3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 3.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 9.0 3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Reel(7);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 8.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 14.0 3.0*i |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 8.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 14.0 3.0*i |", val(Operation.additionner(b, a)));
		}
	}
	
	@Test
	public void testAdditionMatriceEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Complexe a;
		{//Matrice de réel
		a = new Complexe(10, 7);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 11.0+7.0*i 4.0 -2.0 || 2.0 17.0+7.0*i 3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 11.0+7.0*i 4.0 -2.0 || 2.0 17.0+7.0*i 3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Complexe(2, 6);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 3.0+6.0*i 4.0*i 1.0-2.0*i || 2.0+5.0*i 9.0+6.0*i 3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 3.0+6.0*i 4.0*i 1.0-2.0*i || 2.0+5.0*i 9.0+6.0*i 3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Complexe(7, 3);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 8.0+3.0*i 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 14.0+3.0*i 3.0*i |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 8.0+3.0*i 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 14.0+3.0*i 3.0*i |", val(Operation.additionner(b, a)));
		}
	}
	
	@Test
	public void testAdditionMatriceEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Polynome a;
		List<MathObject> formeDeveloppee = new ArrayList<>();
		formeDeveloppee.add(new Reel(1));
		formeDeveloppee.add(new Reel(2));
		formeDeveloppee.add(new Reel(3));

		{//Matrice de réel
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0 -2.0 || 2.0 +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0 -2.0 || 2.0 +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0*i 1.0-2.0*i || 2.0+5.0*i +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0*i 1.0-2.0*i || 2.0+5.0*i +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Polynome(formeDeveloppee);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0*i |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| +2.0*x^0 +2.0*x^1 +3.0*x^2  4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i +8.0*x^0 +2.0*x^1 +3.0*x^2  3.0*i |", val(Operation.additionner(b, a)));
		}
	}
	
	@Test
	public void testAdditionMatriceEtMatrice() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		MathObject[][] matrice2 = {
				{new Reel(6), new Complexe(8), new Complexe(3, -5)},
				{new Complexe(2, 9), new Reel(5), new Reel(4)}};
		Matrice a = new Matrice(matrice2);
		{//Matrice de réel
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 7.0 4.0+8.0*i 1.0-5.0*i || 4.0+9.0*i 12.0 7.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 7.0 4.0+8.0*i 1.0-5.0*i || 4.0+9.0*i 12.0 7.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Complexe
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 7.0 12.0*i 4.0-7.0*i || 4.0+14.0*i 12.0 7.0 |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 7.0 12.0*i 4.0-7.0*i || 4.0+14.0*i 12.0 7.0 |", val(Operation.additionner(b, a)));
		}
		
		{//Matrice de Polynome
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 7.0 4.0+8.0*i (4.0-5.0*i)*x^0 +2.0*x^1 +3.0*x^2  || 4.0+14.0*i 12.0 4.0+3.0*i |", val(Operation.additionner(a, b)));
		Assert.assertEquals("| 7.0 4.0+8.0*i (4.0-5.0*i)*x^0 +2.0*x^1 +3.0*x^2  || 4.0+14.0*i 12.0 4.0+3.0*i |", val(Operation.additionner(b, a)));
		}
	}
	
	@Test
	public void testAdditionFonctionEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Fonction a = new Fonction("cos", new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("cos(x)+4.0", Operation.additionner(a, b).toString());
			Assert.assertEquals("4.0+cos(x)", Operation.additionner(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("cos(x)+(2.0+4.0*i)", Operation.additionner(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)+cos(x)", Operation.additionner(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("cos(x)+(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.additionner(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )+cos(x)", Operation.additionner(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("cos(x)+| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.additionner(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |+cos(x)", Operation.additionner(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("cos(x)+sin(y)", Operation.additionner(a, b).toString());
			Assert.assertEquals("sin(y)+cos(x)", Operation.additionner(b, a).toString());
		}
	}
	
	@Test
	public void testAdditionInconnueEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Inconnue a = new Inconnue();
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("x+4.0", Operation.additionner(a, b).toString());
			Assert.assertEquals("4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("x+(2.0+4.0*i)", Operation.additionner(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)+x", Operation.additionner(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("x+(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.additionner(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )+x", Operation.additionner(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("x+| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.additionner(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |+x", Operation.additionner(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("x+sin(y)", Operation.additionner(a, b).toString());
			Assert.assertEquals("sin(y)+x", Operation.additionner(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("x+y", Operation.additionner(a, b).toString());
			Assert.assertEquals("y+x", Operation.additionner(b, a).toString());
		}
	}
	
	@Test
	public void testAdditionBinaryOperationEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		BinaryOperation a = new BinaryOperation("+", new Reel(4), new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("4.0+x+4.0", Operation.additionner(a, b).toString());
			Assert.assertEquals("4.0+4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("4.0+x+(2.0+4.0*i)", Operation.additionner(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)+4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("4.0+x+(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.additionner(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )+4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("4.0+x+| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.additionner(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |+4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("4.0+x+sin(y)", Operation.additionner(a, b).toString());
			Assert.assertEquals("sin(y)+4.0+x", Operation.additionner(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("4.0+x+y", Operation.additionner(a, b).toString());
			Assert.assertEquals("y+4.0+x", Operation.additionner(b, a).toString());
		}
	}
	
	@Test
	public void testSoustractionReelEtReel() {
		Reel a = new Reel(3);
		Reel b = new Reel(2);
		Assert.assertEquals("1.0", val(Operation.soustraire(a, b)));
		Assert.assertEquals("-1.0", val(Operation.soustraire(b, a)));
		
		Reel a1 = new Reel(3);
		Reel b1 = new Reel(-2);
		
		Assert.assertEquals("5.0", val(Operation.soustraire(a1, b1)));
	}
	
	@Test
	public void testSoustractionReelEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Reel a = new Reel(3);
		Complexe b = new Complexe(2);
		Assert.assertEquals("3.0-2.0*i", val(Operation.soustraire(a, b)));
		Assert.assertEquals("-3.0+2.0*i", val(Operation.soustraire(b, a)));
		
		Reel a1 = new Reel(3);
		Complexe b1 = new Complexe(-2);
		
		Assert.assertEquals("3.0+2.0*i", val(Operation.soustraire(a1, b1)));
		Assert.assertEquals("-3.0-2.0*i", val(Operation.soustraire(b1, a1)));
		
		Reel a2 = new Reel(3);
		Complexe b2 = new Complexe(2, 1);
		Assert.assertEquals("1.0-1.0*i", val(Operation.soustraire(a2, b2)));
		Assert.assertEquals("-1.0+1.0*i", val(Operation.soustraire(b2, a2)));
		
		Reel a3 = new Reel(3);
		Complexe b3 = new Complexe(-2, 1);
		Assert.assertEquals("5.0-1.0*i", val(Operation.soustraire(a3, b3)));
		Assert.assertEquals("-5.0+1.0*i", val(Operation.soustraire(b3, a3)));
		
		Reel a4 = new Reel(3);
		Complexe b4 = new Complexe(-6, 2);
		Assert.assertEquals("9.0-2.0*i", val(Operation.soustraire(a4, b4)));
		Assert.assertEquals("-9.0+2.0*i", val(Operation.soustraire(b4, a4)));
	}
	
	@Test
	public void testSoustractionComplexeEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Complexe a = new Complexe(3, 2);
		Complexe b = new Complexe(2, 3);
		Assert.assertEquals("1.0-1.0*i", val(Operation.soustraire(a, b)));
		Assert.assertEquals("-1.0+1.0*i", val(Operation.soustraire(b, a)));
		
		a = new Complexe(3, -1);
		b = new Complexe(2, 3);
		Assert.assertEquals("1.0-4.0*i", val(Operation.soustraire(a, b)));
		Assert.assertEquals("-1.0+4.0*i", val(Operation.soustraire(b, a)));
	}
	
	@Test
	public void testSoustractionReelEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Reel(5);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-1.0)*x^0 +(-6.0)*x^1 +(-6.0)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("+1.0*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Reel(-10);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-16.0)*x^0 +(-6.0)*x^1 +(-6.0)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("+16.0*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Reel(5);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-1.0-3.0*i)*x^0 +(-6.0)*x^1 +(-6.0-4.0*i)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(1.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testSoustractionComplexeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Complexe(5, -7);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-1.0-7.0*i)*x^0 +(-6.0)*x^1 +(-6.0)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(1.0+7.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Complexe(-10, 4);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-16.0+4.0*i)*x^0 +(-6.0)*x^1 +(-6.0)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(16.0-4.0*i)*x^0 +6.0*x^1 +6.0*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Complexe(5, 2);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-1.0-1.0*i)*x^0 +(-6.0)*x^1 +(-6.0-4.0*i)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(1.0+1.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testSoustractionPolynomeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		Polynome a = (Polynome) new Polynome(formeDeveloppee2);
		
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-5.0)*x^0 +(-4.0)*x^1 +(-3.0)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("+5.0*x^0 +4.0*x^1 +3.0*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		formeDeveloppee2.clear();
		formeDeveloppee2.add(new Complexe(1));
		formeDeveloppee2.add(new Complexe(2, 4));
		formeDeveloppee2.add(new Complexe(3, 7));
		a = (Polynome) new Polynome(formeDeveloppee2);
		
		Assert.assertEquals("(-6.0+1.0*i)*x^0 +(-4.0+4.0*i)*x^1 +(-3.0+7.0*i)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(6.0-1.0*i)*x^0 +(4.0-4.0*i)*x^1 +(3.0-7.0*i)*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-6.0-2.0*i)*x^0 +(-4.0+4.0*i)*x^1 +(-3.0+3.0*i)*x^2 ", val(Operation.soustraire(a, b)));
		Assert.assertEquals("(6.0+2.0*i)*x^0 +(4.0-4.0*i)*x^1 +(3.0-3.0*i)*x^2 ", val(Operation.soustraire(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testSoustractionMatriceEtReel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Reel a;
		{//Matrice de réel
		a = new Reel(10);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 9.0 -4.0 2.0 || -2.0 3.0 -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -9.0 4.0 -2.0 || 2.0 -3.0 3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Reel(2);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 1.0 -4.0*i -1.0+2.0*i || -2.0-5.0*i -5.0 -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 5.0 3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Reel(7);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 6.0 -4.0 (-1.0)*x^0 +(-2.0)*x^1 +(-3.0)*x^2  || -2.0-5.0*i 0.0 -3.0*i |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -6.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 0.0 3.0*i |", val(Operation.soustraire(b, a)));
		}
	}
	
	@Test
	public void testSoustractionMatriceEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Complexe a;
		{//Matrice de réel
		a = new Complexe(10, 7);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 9.0+7.0*i -4.0 2.0 || -2.0 3.0+7.0*i -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -9.0-7.0*i 4.0 -2.0 || 2.0 -3.0-7.0*i 3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Complexe(2, 6);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 1.0+6.0*i -4.0*i -1.0+2.0*i || -2.0-5.0*i -5.0+6.0*i -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -1.0-6.0*i 4.0*i 1.0-2.0*i || 2.0+5.0*i 5.0-6.0*i 3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Complexe(7, 3);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 6.0+3.0*i -4.0 (-1.0)*x^0 +(-2.0)*x^1 +(-3.0)*x^2  || -2.0-5.0*i 3.0*i -3.0*i |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -6.0-3.0*i 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i -3.0*i 3.0*i |", val(Operation.soustraire(b, a)));
		}
	}
	
	@Test
	public void testSoustractionMatriceEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Polynome a;
		List<MathObject> formeDeveloppee = new ArrayList<>();
		formeDeveloppee.add(new Reel(1));
		formeDeveloppee.add(new Reel(2));
		formeDeveloppee.add(new Reel(3));

		{//Matrice de réel
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +0*x^0 +2.0*x^1 +3.0*x^2  -4.0 2.0 || -2.0 (-6.0)*x^0 +2.0*x^1 +3.0*x^2  -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| +0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  4.0 -2.0 || 2.0 +6.0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +0*x^0 +2.0*x^1 +3.0*x^2  -4.0*i -1.0+2.0*i || -2.0-5.0*i (-6.0)*x^0 +2.0*x^1 +3.0*x^2  -3.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| +0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  4.0*i 1.0-2.0*i || 2.0+5.0*i +6.0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  3.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Polynome(formeDeveloppee);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +0*x^0 +2.0*x^1 +3.0*x^2  -4.0 (-1.0)*x^0 +(-2.0)*x^1 +(-3.0)*x^2  || -2.0-5.0*i (-6.0)*x^0 +2.0*x^1 +3.0*x^2  -3.0*i |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| +0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i +6.0*x^0 +(-2.0)*x^1 +(-3.0)*x^2  3.0*i |", val(Operation.soustraire(b, a)));
		}
	}
	
	@Test
	public void testSoustractionMatriceEtMatrice() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		MathObject[][] matrice2 = {
				{new Reel(6), new Complexe(8), new Complexe(3, -5)},
				{new Complexe(2, 9), new Reel(5), new Reel(4)}};
		Matrice a = new Matrice(matrice2);
		{//Matrice de réel
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 5.0 -4.0+8.0*i 5.0-5.0*i || 9.0*i -2.0 1.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -5.0 4.0-8.0*i -5.0+5.0*i || -9.0*i 2.0 -1.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Complexe
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 5.0 4.0*i 2.0-3.0*i || 4.0*i -2.0 1.0 |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -5.0 -4.0*i -2.0+3.0*i || -4.0*i 2.0 -1.0 |", val(Operation.soustraire(b, a)));
		}
		
		{//Matrice de Polynome
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 5.0 -4.0+8.0*i (2.0-5.0*i)*x^0 +(-2.0)*x^1 +(-3.0)*x^2  || 4.0*i -2.0 4.0-3.0*i |", val(Operation.soustraire(a, b)));
		Assert.assertEquals("| -5.0 4.0-8.0*i (-2.0+5.0*i)*x^0 +2.0*x^1 +3.0*x^2  || -4.0*i 2.0 -4.0+3.0*i |", val(Operation.soustraire(b, a)));
		}
	}
	
	@Test
	public void testSoustractionFonctionEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Fonction a = new Fonction("cos", new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("cos(x)-4.0", Operation.soustraire(a, b).toString());
			Assert.assertEquals("4.0-cos(x)", Operation.soustraire(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("cos(x)-(2.0+4.0*i)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)-cos(x)", Operation.soustraire(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("cos(x)-(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )-cos(x)", Operation.soustraire(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("cos(x)-| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.soustraire(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |-cos(x)", Operation.soustraire(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("cos(x)-sin(y)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("sin(y)-cos(x)", Operation.soustraire(b, a).toString());
		}
	}
	
	@Test
	public void testSoustraireInconnueEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Inconnue a = new Inconnue();
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("x-4.0", Operation.soustraire(a, b).toString());
			Assert.assertEquals("4.0-x", Operation.soustraire(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("x-(2.0+4.0*i)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)-x", Operation.soustraire(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("x-(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )-x", Operation.soustraire(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("x-| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.soustraire(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |-x", Operation.soustraire(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("x-sin(y)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("sin(y)-x", Operation.soustraire(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("x-y", Operation.soustraire(a, b).toString());
			Assert.assertEquals("y-x", Operation.soustraire(b, a).toString());
		}
	}
	
	@Test
	public void testSoustraireBinaryOperationEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		BinaryOperation a = new BinaryOperation("+", new Reel(4), new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("4.0+x-4.0", Operation.soustraire(a, b).toString());
			Assert.assertEquals("4.0-(4.0+x)", Operation.soustraire(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("4.0+x-(2.0+4.0*i)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)-(4.0+x)", Operation.soustraire(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("4.0+x-(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.soustraire(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )-(4.0+x)", Operation.soustraire(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("4.0+x-| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.soustraire(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |-(4.0+x)", Operation.soustraire(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("4.0+x-sin(y)", Operation.soustraire(a, b).toString());
			Assert.assertEquals("sin(y)-(4.0+x)", Operation.soustraire(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("4.0+x-y", Operation.soustraire(a, b).toString());
			Assert.assertEquals("y-(4.0+x)", Operation.soustraire(b, a).toString());
		}
	}
	
	@Test
	public void testMultiplicationReelEtReel() {
		Reel a = new Reel(3);
		Reel b = new Reel(2);
		Assert.assertEquals("6.0", val(Operation.multiplier(a, b)));
		
		Reel a1 = new Reel(3);
		Reel b1 = new Reel(-2);
		
		Assert.assertEquals("-6.0", val(Operation.multiplier(a1, b1)));
	}
	
	@Test
	public void testMultiplicationReelEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Reel a = new Reel(3);
		Complexe b = new Complexe(2);
		Assert.assertEquals("6.0*i", val(Operation.multiplier(a, b)));
		Assert.assertEquals("6.0*i", val(Operation.multiplier(b, a)));
		
		Reel a1 = new Reel(3);
		Complexe b1 = new Complexe(-2);
		
		Assert.assertEquals("-6.0*i", val(Operation.multiplier(a1, b1)));
		Assert.assertEquals("-6.0*i", val(Operation.multiplier(b1, a1)));
		
		Reel a2 = new Reel(3);
		Complexe b2 = new Complexe(2, 1);
		Assert.assertEquals("6.0+3.0*i", val(Operation.multiplier(a2, b2)));
		Assert.assertEquals("6.0+3.0*i", val(Operation.multiplier(b2, a2)));
		
		Reel a3 = new Reel(3);
		Complexe b3 = new Complexe(-2, 1);
		Assert.assertEquals("-6.0+3.0*i", val(Operation.multiplier(a3, b3)));
		Assert.assertEquals("-6.0+3.0*i", val(Operation.multiplier(b3, a3)));
		
		Reel a4 = new Reel(3);
		Complexe b4 = new Complexe(-6, 2);
		Assert.assertEquals("-18.0+6.0*i", val(Operation.multiplier(a4, b4)));
		Assert.assertEquals("-18.0+6.0*i", val(Operation.multiplier(b4, a4)));
	}
	
	@Test
	public void testMultiplicationComplexeEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Complexe a = new Complexe(3, 2);
		Complexe b = new Complexe(2, 3);
		Assert.assertEquals("13.0*i", val(Operation.multiplier(a, b)));
		Assert.assertEquals("13.0*i", val(Operation.multiplier(b, a)));
		
		a = new Complexe(3, -1);
		b = new Complexe(2, 3);
		Assert.assertEquals("9.0+7.0*i", val(Operation.multiplier(a, b)));
		Assert.assertEquals("9.0+7.0*i", val(Operation.multiplier(b, a)));
	}
	
	@Test
	public void testMultiplicationReelEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Reel(5);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("+30.0*x^0 +30.0*x^1 +30.0*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("+30.0*x^0 +30.0*x^1 +30.0*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Reel(-10);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-60.0)*x^0 +(-60.0)*x^1 +(-60.0)*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(-60.0)*x^0 +(-60.0)*x^1 +(-60.0)*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Reel(5);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(30.0+15.0*i)*x^0 +30.0*x^1 +(30.0+20.0*i)*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(30.0+15.0*i)*x^0 +30.0*x^1 +(30.0+20.0*i)*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testMultiplicationComplexeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Complexe(5, -7);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(30.0-42.0*i)*x^0 +(30.0-42.0*i)*x^1 +(30.0-42.0*i)*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(30.0-42.0*i)*x^0 +(30.0-42.0*i)*x^1 +(30.0-42.0*i)*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Complexe(-10, 4);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-60.0+24.0*i)*x^0 +(-60.0+24.0*i)*x^1 +(-60.0+24.0*i)*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(-60.0+24.0*i)*x^0 +(-60.0+24.0*i)*x^1 +(-60.0+24.0*i)*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Complexe(5, 2);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(24.0+27.0*i)*x^0 +(30.0+12.0*i)*x^1 +(22.0+32.0*i)*x^2 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(24.0+27.0*i)*x^0 +(30.0+12.0*i)*x^1 +(22.0+32.0*i)*x^2 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testMultiplicationPolynomeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		Polynome a = (Polynome) new Polynome(formeDeveloppee2);
		
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("+6.0*x^0 +18.0*x^1 +36.0*x^2 +30.0*x^3 +18.0*x^4 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("+6.0*x^0 +18.0*x^1 +36.0*x^2 +30.0*x^3 +18.0*x^4 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		formeDeveloppee2.clear();
		formeDeveloppee2.add(new Complexe(1));
		formeDeveloppee2.add(new Complexe(2, 4));
		formeDeveloppee2.add(new Complexe(3, 7));
		a = (Polynome) new Polynome(formeDeveloppee2);
		
		Assert.assertEquals("(6.0*i)*x^0 +(12.0+30.0*i)*x^1 +(30.0+72.0*i)*x^2 +(30.0+66.0*i)*x^3 +(18.0+42.0*i)*x^4 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(6.0*i)*x^0 +(12.0+30.0*i)*x^1 +(30.0+72.0*i)*x^2 +(30.0+66.0*i)*x^3 +(18.0+42.0*i)*x^4 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-3.0+6.0*i)*x^0 +(36.0*i)*x^1 +(5.0+81.0*i)*x^2 +(14.0+74.0*i)*x^3 +(-10.0+54.0*i)*x^4 ", val(Operation.multiplier(a, b)));
		Assert.assertEquals("(-3.0+6.0*i)*x^0 +(36.0*i)*x^1 +(5.0+81.0*i)*x^2 +(14.0+74.0*i)*x^3 +(-10.0+54.0*i)*x^4 ", val(Operation.multiplier(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testMultiplicationMatriceEtReel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Reel a;
		{//Matrice de réel
		a = new Reel(10);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 10.0 40.0 -20.0 || 20.0 70.0 30.0 |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 10.0 40.0 -20.0 || 20.0 70.0 30.0 |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Reel(2);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 2.0 8.0*i 2.0-4.0*i || 4.0+10.0*i 14.0 6.0 |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 2.0 8.0*i 2.0-4.0*i || 4.0+10.0*i 14.0 6.0 |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Reel(7);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 7.0 28.0 +7.0*x^0 +14.0*x^1 +21.0*x^2  || 14.0+35.0*i 49.0 21.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 7.0 28.0 +7.0*x^0 +14.0*x^1 +21.0*x^2  || 14.0+35.0*i 49.0 21.0*i |", val(Operation.multiplier(b, a)));
		}
	}
	
	@Test
	public void testMultiplicationMatriceEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Complexe a;
		{//Matrice de réel
		a = new Complexe(10, 7);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 10.0+7.0*i 40.0+28.0*i -20.0-14.0*i || 20.0+14.0*i 70.0+49.0*i 30.0+21.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 10.0+7.0*i 40.0+28.0*i -20.0-14.0*i || 20.0+14.0*i 70.0+49.0*i 30.0+21.0*i |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Complexe(2, 6);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 2.0+6.0*i -24.0+8.0*i 14.0+2.0*i || -26.0+22.0*i 14.0+42.0*i 6.0+18.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 2.0+6.0*i -24.0+8.0*i 14.0+2.0*i || -26.0+22.0*i 14.0+42.0*i 6.0+18.0*i |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Complexe(7, 3);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 7.0+3.0*i 28.0+12.0*i (7.0+3.0*i)*x^0 +(14.0+6.0*i)*x^1 +(21.0+9.0*i)*x^2  || -1.0+41.0*i 49.0+21.0*i -9.0+21.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 7.0+3.0*i 28.0+12.0*i (7.0+3.0*i)*x^0 +(14.0+6.0*i)*x^1 +(21.0+9.0*i)*x^2  || -1.0+41.0*i 49.0+21.0*i -9.0+21.0*i |", val(Operation.multiplier(b, a)));
		}
	}
	
	@Test
	public void testMultiplicationMatriceEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Polynome a;
		List<MathObject> formeDeveloppee = new ArrayList<>();
		formeDeveloppee.add(new Reel(1));
		formeDeveloppee.add(new Reel(2));
		formeDeveloppee.add(new Reel(3));

		{//Matrice de réel
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  +4.0*x^0 +8.0*x^1 +12.0*x^2  (-2.0)*x^0 +(-4.0)*x^1 +(-6.0)*x^2  || +2.0*x^0 +4.0*x^1 +6.0*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  +3.0*x^0 +6.0*x^1 +9.0*x^2  |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  +4.0*x^0 +8.0*x^1 +12.0*x^2  (-2.0)*x^0 +(-4.0)*x^1 +(-6.0)*x^2  || +2.0*x^0 +4.0*x^1 +6.0*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  +3.0*x^0 +6.0*x^1 +9.0*x^2  |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  (4.0*i)*x^0 +(8.0*i)*x^1 +(12.0*i)*x^2  (1.0-2.0*i)*x^0 +(2.0-4.0*i)*x^1 +(3.0-6.0*i)*x^2  || (2.0+5.0*i)*x^0 +(4.0+10.0*i)*x^1 +(6.0+15.0*i)*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  +3.0*x^0 +6.0*x^1 +9.0*x^2  |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  (4.0*i)*x^0 +(8.0*i)*x^1 +(12.0*i)*x^2  (1.0-2.0*i)*x^0 +(2.0-4.0*i)*x^1 +(3.0-6.0*i)*x^2  || (2.0+5.0*i)*x^0 +(4.0+10.0*i)*x^1 +(6.0+15.0*i)*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  +3.0*x^0 +6.0*x^1 +9.0*x^2  |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Polynome(formeDeveloppee);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  +4.0*x^0 +8.0*x^1 +12.0*x^2  +1.0*x^0 +4.0*x^1 +10.0*x^2 +12.0*x^3 +9.0*x^4  || (2.0+5.0*i)*x^0 +(4.0+10.0*i)*x^1 +(6.0+15.0*i)*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  (3.0*i)*x^0 +(6.0*i)*x^1 +(9.0*i)*x^2  |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| +1.0*x^0 +2.0*x^1 +3.0*x^2  +4.0*x^0 +8.0*x^1 +12.0*x^2  +1.0*x^0 +4.0*x^1 +10.0*x^2 +12.0*x^3 +9.0*x^4  || (2.0+5.0*i)*x^0 +(4.0+10.0*i)*x^1 +(6.0+15.0*i)*x^2  +7.0*x^0 +14.0*x^1 +21.0*x^2  (3.0*i)*x^0 +(6.0*i)*x^1 +(9.0*i)*x^2  |", val(Operation.multiplier(b, a)));
		}
	}
	
	@Test
	public void testMultiplicationMatriceEtMatrice() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		MathObject[][] valeurD = {
				{new Reel(1), new Reel(0)},
				{new Reel(-2), new Reel(3)}};
		Matrice d = new Matrice(valeurD);
		MathObject[][] valeurC = {
				{new Reel(0), new Reel(-1)},
				{new Reel(-3), new Reel(2)}};
		Matrice c = new Matrice(valeurC);
		MathObject[][] valeurSolution = {
				{new Reel(0), new Reel(-1)},
				{new Reel(-9), new Reel(8)}};
		Matrice sol = new Matrice(valeurSolution);
		Matrice result = (Matrice) Operation.multiplier(d, c);
		assertTrue(result.equals(sol));
		
		MathObject[][] matrice2 = {
				{new Reel(6), new Complexe(8), new Complexe(3, -5)},
				{new Complexe(2, 9), new Reel(5), new Reel(4)}};
		Matrice a = new Matrice(matrice2);
		{//Matrice de réel
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4)},
				{new Reel(2), new Reel(4)},
				{new Reel(2), new Reel(7)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 12.0+6.0*i 45.0-3.0*i || 20.0+9.0*i 56.0+36.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| 14.0+36.0*i 20.0+8.0*i 19.0-5.0*i || 20.0+36.0*i 20.0+16.0*i 22.0-10.0*i || 26.0+63.0*i 35.0+16.0*i 34.0-10.0*i |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Complexe
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4)},
				{new Reel(1), new Complexe(4, -6)},
				{new Complexe(2, 5), new Reel(7)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| 37.0+13.0*i 69.0+21.0*i || 15.0+29.0*i 12.0-22.0*i |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| -30.0+8.0*i 28.0*i 3.0+11.0*i || 68.0+24.0*i 20.0-22.0*i 19.0-29.0*i || 26.0+93.0*i -5.0+16.0*i 59.0+5.0*i |", val(Operation.multiplier(b, a)));
		}
		
		{//Matrice de Polynome
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Polynome(formeDeveloppee2)},
				{new Polynome(formeDeveloppee2), new Complexe(3)},
				{new Complexe(2, 5), new Reel(7)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("| (37.0+13.0*i)*x^0 +(16.0*i)*x^1 +(24.0*i)*x^2  (3.0-35.0*i)*x^0 +12.0*x^1 +18.0*x^2  || (15.0+29.0*i)*x^0 +10.0*x^1 +15.0*x^2  (30.0+24.0*i)*x^0 +(4.0+18.0*i)*x^1 +(6.0+27.0*i)*x^2  |", val(Operation.multiplier(a, b)));
		Assert.assertEquals("| (8.0+9.0*i)*x^0 +(4.0+18.0*i)*x^1 +(6.0+27.0*i)*x^2  (5.0+8.0*i)*x^0 +10.0*x^1 +15.0*x^2  (7.0-5.0*i)*x^0 +8.0*x^1 +12.0*x^2  || (-21.0+6.0*i)*x^0 +12.0*x^1 +18.0*x^2  (23.0*i)*x^0 +(16.0*i)*x^1 +(24.0*i)*x^2  (3.0+7.0*i)*x^0 +(6.0-10.0*i)*x^1 +(9.0-15.0*i)*x^2  || 26.0+93.0*i -5.0+16.0*i 59.0+5.0*i |", val(Operation.multiplier(b, a)));
		}
	}
	
	@Test
	public void testMultiplierFonctionEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Fonction a = new Fonction("cos", new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("cos(x)*4.0", Operation.multiplier(a, b).toString());
			Assert.assertEquals("4.0*cos(x)", Operation.multiplier(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("cos(x)*(2.0+4.0*i)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)*cos(x)", Operation.multiplier(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("cos(x)*(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )*cos(x)", Operation.multiplier(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("cos(x)*| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.multiplier(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |*cos(x)", Operation.multiplier(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("cos(x)*sin(y)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("sin(y)*cos(x)", Operation.multiplier(b, a).toString());
		}
	}
	
	@Test
	public void testMultiplicationInconnueEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Inconnue a = new Inconnue();
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("x*4.0", Operation.multiplier(a, b).toString());
			Assert.assertEquals("4.0*x", Operation.multiplier(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("x*(2.0+4.0*i)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)*x", Operation.multiplier(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("x*(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )*x", Operation.multiplier(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("x*| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.multiplier(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |*x", Operation.multiplier(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("x*sin(y)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("sin(y)*x", Operation.multiplier(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("x*y", Operation.multiplier(a, b).toString());
			Assert.assertEquals("y*x", Operation.multiplier(b, a).toString());
		}
	}
	
	@Test
	public void testMultiplicationBinaryOperationEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		BinaryOperation a = new BinaryOperation("+", new Reel(4), new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("(4.0+x)*4.0", Operation.multiplier(a, b).toString());
			Assert.assertEquals("4.0*(4.0+x)", Operation.multiplier(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("(4.0+x)*(2.0+4.0*i)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)*(4.0+x)", Operation.multiplier(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("(4.0+x)*(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.multiplier(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )*(4.0+x)", Operation.multiplier(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("(4.0+x)*| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |", Operation.multiplier(a, b).toString());
			Assert.assertEquals("| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |*(4.0+x)", Operation.multiplier(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("(4.0+x)*sin(y)", Operation.multiplier(a, b).toString());
			Assert.assertEquals("sin(y)*(4.0+x)", Operation.multiplier(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("(4.0+x)*y", Operation.multiplier(a, b).toString());
			Assert.assertEquals("y*(4.0+x)", Operation.multiplier(b, a).toString());
		}
	}
	
	@Test
	public void testDivisionReelEtReel() {
		Reel a = new Reel(3);
		Reel b = new Reel(2);
		Assert.assertEquals("1.5", val(Operation.diviser(a, b)));
		
		Reel a1 = new Reel(3);
		Reel b1 = new Reel(-2);
		
		Assert.assertEquals("-1.5", val(Operation.diviser(a1, b1)));
	}
	
	@Test
	public void testDivisionReelEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Reel a = new Reel(4);
		Complexe b = new Complexe(2);
		Assert.assertEquals("(4.0)/(2.0*i)", val(Operation.diviser(a, b)));
		Assert.assertEquals("0.5*i", val(Operation.diviser(b, a)));
		
		Reel a1 = new Reel(4);
		Complexe b1 = new Complexe(-2);
		
		Assert.assertEquals("(4.0)/(-2.0*i)", val(Operation.diviser(a1, b1)));
		Assert.assertEquals("-0.5*i", val(Operation.diviser(b1, a1)));
		
		Reel a2 = new Reel(3);
		Complexe b2 = new Complexe(9, 21);
		Assert.assertEquals("(3.0)/(9.0+21.0*i)", val(Operation.diviser(a2, b2)));
		Assert.assertEquals("3.0+7.0*i", val(Operation.diviser(b2, a2)));
		
		Reel a3 = new Reel(3);
		Complexe b3 = new Complexe(-18, 33);
		Assert.assertEquals("(3.0)/(-18.0+33.0*i)", val(Operation.diviser(a3, b3)));
		Assert.assertEquals("-6.0+11.0*i", val(Operation.diviser(b3, a3)));
		
		Reel a4 = new Reel(5);
		Complexe b4 = new Complexe(-90, 30);
		Assert.assertEquals("(5.0)/(-90.0+30.0*i)", val(Operation.diviser(a4, b4)));
		Assert.assertEquals("-18.0+6.0*i", val(Operation.diviser(b4, a4)));
	}
	
	@Test
	public void testDivisionComplexeEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Complexe a = new Complexe(3, 2);
		Complexe b = new Complexe(2, 3);
		Assert.assertEquals("(3.0+2.0*i)/(2.0+3.0*i)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(2.0+3.0*i)/(3.0+2.0*i)", val(Operation.diviser(b, a)));
		
		a = new Complexe(3, -1);
		b = new Complexe(2, 3);
		Assert.assertEquals("(3.0-1.0*i)/(2.0+3.0*i)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(2.0+3.0*i)/(3.0-1.0*i)", val(Operation.diviser(b, a)));
	}

	@Test
	public void testDivisionReelEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Reel(5);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(5.0)/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/(5.0)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Reel(-10);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-10.0)/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/(-10.0)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Reel(5);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(5.0)/((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )/(5.0)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testDivisionComplexeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Reel a = new Complexe(5, -7);
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(5.0-7.0*i)/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/(5.0-7.0*i)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		a = new Complexe(-10, 4);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(-10.0+4.0*i)/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/(-10.0+4.0*i)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		a = new Complexe(5, 2);
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(5.0+2.0*i)/((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )/(5.0+2.0*i)", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testDivisionPolynomeEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		Polynome a = (Polynome) new Polynome(formeDeveloppee2);
		
		//polynome de réel
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		Polynome b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("(+1.0*x^0 +2.0*x^1 +3.0*x^2 )/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/(+1.0*x^0 +2.0*x^1 +3.0*x^2 )", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Reel(6));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		formeDeveloppee2.clear();
		formeDeveloppee2.add(new Complexe(1));
		formeDeveloppee2.add(new Complexe(2, 4));
		formeDeveloppee2.add(new Complexe(3, 7));
		a = (Polynome) new Polynome(formeDeveloppee2);
		
		Assert.assertEquals("((1.0*i)*x^0 +(2.0+4.0*i)*x^1 +(3.0+7.0*i)*x^2 )/(+6.0*x^0 +6.0*x^1 +6.0*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("(+6.0*x^0 +6.0*x^1 +6.0*x^2 )/((1.0*i)*x^0 +(2.0+4.0*i)*x^1 +(3.0+7.0*i)*x^2 )", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
		
		//polynome de complexe
		formeDeveloppee.add(new Complexe(6, 3));
		formeDeveloppee.add(new Reel(6));
		formeDeveloppee.add(new Complexe(6, 4));
		b = (Polynome) new Polynome(formeDeveloppee);
	
		Assert.assertEquals("((1.0*i)*x^0 +(2.0+4.0*i)*x^1 +(3.0+7.0*i)*x^2 )/((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )", val(Operation.diviser(a, b)));
		Assert.assertEquals("((6.0+3.0*i)*x^0 +6.0*x^1 +(6.0+4.0*i)*x^2 )/((1.0*i)*x^0 +(2.0+4.0*i)*x^1 +(3.0+7.0*i)*x^2 )", val(Operation.diviser(b, a)));
		formeDeveloppee.clear();
	}
	
	@Test
	public void testDivisionMatriceEtReel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Reel a;
		{//Matrice de réel
		a = new Reel(10);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(10.0)/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(10.0)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Reel(2);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(2.0)/(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)/(2.0)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Reel(7);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(7.0)/(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)/(7.0)", val(Operation.diviser(b, a)));
		}
	}
	
	@Test
	public void testDivisionMatriceEtComplexe() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Complexe a;
		{//Matrice de réel
		a = new Complexe(10, 7);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(10.0+7.0*i)/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(10.0+7.0*i)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Complexe(2, 6);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(2.0+6.0*i)/(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)/(2.0+6.0*i)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Complexe(7, 3);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(7.0+3.0*i)/(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)/(7.0+3.0*i)", val(Operation.diviser(b, a)));
		}
	}
	
	@Test
	public void testDivisionMatriceEtPolynome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Polynome a;
		List<MathObject> formeDeveloppee = new ArrayList<>();
		formeDeveloppee.add(new Reel(1));
		formeDeveloppee.add(new Reel(2));
		formeDeveloppee.add(new Reel(3));

		{//Matrice de réel
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(+1.0*x^0 +2.0*x^1 +3.0*x^2 )/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(+1.0*x^0 +2.0*x^1 +3.0*x^2 )", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Complexe
		a = new Polynome(formeDeveloppee);
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(+1.0*x^0 +2.0*x^1 +3.0*x^2 )/(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)/(+1.0*x^0 +2.0*x^1 +3.0*x^2 )", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Polynome
		a = new Polynome(formeDeveloppee);
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(+1.0*x^0 +2.0*x^1 +3.0*x^2 )/(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)/(+1.0*x^0 +2.0*x^1 +3.0*x^2 )", val(Operation.diviser(b, a)));
		}
	}
	
	@Test
	public void testDivisionMatriceEtMatrice() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		MathObject[][] matrice2 = {
				{new Reel(6), new Complexe(8), new Complexe(3, -5)},
				{new Complexe(2, 9), new Reel(5), new Reel(4)}};
		Matrice a = new Matrice(matrice2);
		{//Matrice de réel
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Reel(-2)},
				{new Reel(2), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Complexe
		MathObject[][] matrice = {
				{new Reel(1), new Complexe(4), new Complexe(1, -2)},
				{new Complexe(2, 5), new Reel(7), new Reel(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)/(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0*i 1.0-2.0*i || 2.0+5.0*i 7.0 3.0 |)/(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)", val(Operation.diviser(b, a)));
		}
		
		{//Matrice de Polynome
		List<MathObject> formeDeveloppee2 = new ArrayList<>();
		formeDeveloppee2.add(new Reel(1));
		formeDeveloppee2.add(new Reel(2));
		formeDeveloppee2.add(new Reel(3));
		MathObject[][] matrice = {
				{new Reel(1), new Reel(4), new Polynome(formeDeveloppee2)},
				{new Complexe(2, 5), new Reel(7), new Complexe(3)}};
		Matrice b = new Matrice(matrice);
		
		Assert.assertEquals("(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)/(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)", val(Operation.diviser(a, b)));
		Assert.assertEquals("(| 1.0 4.0 +1.0*x^0 +2.0*x^1 +3.0*x^2  || 2.0+5.0*i 7.0 3.0*i |)/(| 6.0 8.0*i 3.0-5.0*i || 2.0+9.0*i 5.0 4.0 |)", val(Operation.diviser(b, a)));
		}
	}
	
	@Test
	public void testDivisionFonctionEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Fonction a = new Fonction("cos", new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("(cos(x))/(4.0)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(4.0)/(cos(x))", Operation.diviser(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("(cos(x))/(2.0+4.0*i)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)/(cos(x))", Operation.diviser(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("(cos(x))/(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.diviser(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )/(cos(x))", Operation.diviser(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("(cos(x))/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(cos(x))", Operation.diviser(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("(cos(x))/(sin(y))", Operation.diviser(a, b).toString());
			Assert.assertEquals("(sin(y))/(cos(x))", Operation.diviser(b, a).toString());
		}
	}
	
	@Test
	public void testDivisionInconnueEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Inconnue a = new Inconnue();
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("(x)/(4.0)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(4.0)/(x)", Operation.diviser(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("(x)/(2.0+4.0*i)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)/(x)", Operation.diviser(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("(x)/(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.diviser(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )/(x)", Operation.diviser(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("(x)/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(x)", Operation.diviser(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("(x)/(sin(y))", Operation.diviser(a, b).toString());
			Assert.assertEquals("(sin(y))/(x)", Operation.diviser(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("(x)/(y)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(y)/(x)", Operation.diviser(b, a).toString());
		}
	}
	
	@Test
	public void testDivisionBinaryOperationEtAutre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		BinaryOperation a = new BinaryOperation("+", new Reel(4), new Inconnue());
		//Reel
		{
			MathObject b = new Reel(4);
			Assert.assertEquals("(4.0+x)/(4.0)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(4.0)/(4.0+x)", Operation.diviser(b, a).toString());
		}
		
		//Complexe
		{
			MathObject b = new Complexe(2, 4);
			Assert.assertEquals("(4.0+x)/(2.0+4.0*i)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(2.0+4.0*i)/(4.0+x)", Operation.diviser(b, a).toString());
		}
		
		//Polynome
		{
			List<MathObject> list = new ArrayList<>();
			list.add(new Reel(3));
			list.add(new Complexe(2, 3));
			list.add(new Reel(5));
			MathObject b = new Polynome(list);
			Assert.assertEquals("(4.0+x)/(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )", Operation.diviser(a, b).toString());
			Assert.assertEquals("(+3.0*x^0 +(2.0+3.0*i)*x^1 +5.0*x^2 )/(4.0+x)", Operation.diviser(b, a).toString());
		}
		
		//Matrice
		{
			MathObject[][] matrice = {
					{new Reel(1), new Reel(4), new Reel(-2)},
					{new Reel(2), new Reel(7), new Reel(3)}};
			Matrice b = new Matrice(matrice);
			Assert.assertEquals("(4.0+x)/(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(| 1.0 4.0 -2.0 || 2.0 7.0 3.0 |)/(4.0+x)", Operation.diviser(b, a).toString());
		}
		
		//Fonction
		{
			MathObject b = new Fonction("sin", new Inconnue("y"));
			Assert.assertEquals("(4.0+x)/(sin(y))", Operation.diviser(a, b).toString());
			Assert.assertEquals("(sin(y))/(4.0+x)", Operation.diviser(b, a).toString());
		}
		
		//Inconnue
		{
			MathObject b = new Inconnue("y");
			Assert.assertEquals("(4.0+x)/(y)", Operation.diviser(a, b).toString());
			Assert.assertEquals("(y)/(4.0+x)", Operation.diviser(b, a).toString());
		}
	}
	
	public String val(MathObject result){
		if(result==null){
			return null;
		}else{
			try {
				return (String) result.getClass().getMethod("toString").invoke(result);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
