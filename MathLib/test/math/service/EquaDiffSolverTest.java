package math.service;

import static org.junit.Assert.assertTrue;

import java.util.function.BiFunction;

import math.controler.Operation;
import math.entities.fonction.Puissance2;
import math.entities.fonction.Racine;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

import org.junit.Test;

public class EquaDiffSolverTest {
	
	@Test
	public void test() {
		EquaDiffSolver solver = new EquaDiffSolver();
		
		test1(solver);
		test2(solver);
		test3(solver);
		test4(solver);
		test5(solver);
		test6(solver);
    }
	
	private MathObject calcError(MathObject t, MathObject calc){
	    MathObject actual = Operation.diviser(new Puissance2(Operation.additionner(new Puissance2(t).calc(), new Reel(4f)).calc()), new Reel(16)).eval();
	    return Operation.abs(Operation.soustraire(actual, calc));
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
	
	private void test1(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		BiFunction<MathObject, MathObject, MathObject> function = (t, y) -> {return Operation.multiplier(t, new Racine(y));};
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	assertTrue(((Reel)calcError(t_arr[i], y_arr[i])).reel<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+val(calcError(t_arr[i], y_arr[i])));
            }
        }
	}
	
	private void test2(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		BiFunction<MathObject, MathObject, MathObject> function = (t, y) -> {return y;};
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	double error = (Math.exp(((Reel)t_arr[i]).reel)-((Reel)y_arr[i]).reel)/Math.max(Math.exp(((Reel)t_arr[i]).reel), ((Reel)y_arr[i]).reel);
            	assertTrue(error<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+error);
            }
        }
	}
	
	private void test3(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		BiFunction<MathObject, MathObject, MathObject> function = (t, y) -> {return Operation.multiplier(new Reel(3),y);};
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	double error = (Math.exp(3*((Reel)t_arr[i]).reel)-((Reel)y_arr[i]).reel)/Math.max(Math.exp(3*((Reel)t_arr[i]).reel), ((Reel)y_arr[i]).reel);
            	assertTrue(error<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+error);
            }
        }
	}
	

	
	private void test4(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		MathObject function = Operation.multiplier(new Inconnue("t"), new Racine(new Inconnue("y")));
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	assertTrue(((Reel)calcError(t_arr[i], y_arr[i])).reel<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+val(calcError(t_arr[i], y_arr[i])));
            }
        }
	}
	
	private void test5(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		MathObject function =  new Inconnue("y");
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	double error = (Math.exp(((Reel)t_arr[i]).reel)-((Reel)y_arr[i]).reel)/Math.max(Math.exp(((Reel)t_arr[i]).reel), ((Reel)y_arr[i]).reel);
            	assertTrue(error<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+error);
            }
        }
	}
	
	private void test6(EquaDiffSolver solver){
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		MathObject function = Operation.multiplier(new Reel(3),new Inconnue("y"));
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
            	double error = (Math.exp(3*((Reel)t_arr[i]).reel)-((Reel)y_arr[i]).reel)/Math.max(Math.exp(3*((Reel)t_arr[i]).reel), ((Reel)y_arr[i]).reel);
            	assertTrue(error<0.01);
            	System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+error);
            }
        }
	}
}
