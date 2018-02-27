package math.service;

import java.util.function.BiFunction;

import math.controler.Operation;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

import org.junit.Test;

public class EquaDiffSolverTest {
	
	@Test
	public void test() {
		EquaDiffSolver solver = new EquaDiffSolver();
		
		MathObject dt = new Reel(0.1f);
		MathObject[] t_arr = new MathObject[101];
		MathObject[] y_arr = new MathObject[101];
        
		for (int i = 0; i < t_arr.length; i++) {
			t_arr[i] = new Reel();
			y_arr[i] = new Reel();
		}
		
		y_arr[0] = new Reel(1f);
		
		BiFunction<MathObject, MathObject, MathObject> function = (t, y) -> {return Operation.multiplier(t, Operation.sqrt(y));};
 
        solver.rungeKutta(function, t_arr, y_arr, dt);
		
        for (int i = 0; i < t_arr.length; i++){
            if (i % 10 == 0){
                System.out.println("y("+val(t_arr[i])+") = "+val(y_arr[i])+" Error: "+val(calcError(t_arr[i], y_arr[i])));
            }
        }
    }
	
	private MathObject calcError(MathObject t, MathObject calc){
	    MathObject actual = Operation.diviser(Operation.pow(Operation.additionner(Operation.pow(t, new Reel(2.0f)), new Reel(4f)), new Reel(2f)), new Reel(16));
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
}
