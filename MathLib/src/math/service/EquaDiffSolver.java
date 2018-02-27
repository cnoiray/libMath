package math.service;

import java.util.function.BiFunction;

import math.controler.Operation;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class EquaDiffSolver {
	public void rungeKutta(BiFunction<MathObject, MathObject, MathObject> function, MathObject[] t,
			MathObject[] y, MathObject dt) {
		Reel deux = new Reel(2);
		Reel six = new Reel(6);
		
        for (int n = 0; n < t.length - 1; n++) {
        	MathObject dy1 = Operation.multiplier(dt, function.apply(t[n], y[n]));
        	MathObject dy2 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], Operation.diviser(dt, deux)), 
        			Operation.additionner(y[n], Operation.diviser(dy1, deux))));
        	MathObject dy3 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], Operation.diviser(dt, deux)), 
        			Operation.additionner(y[n], Operation.diviser(dy2, deux))));
        	MathObject dy4 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], dt), 
        			Operation.additionner(y[n], dy3)));
            t[n + 1] = Operation.additionner(t[n], dt);
            y[n + 1] = Operation.additionner(y[n], Operation.diviser(Operation.additionner(dy1, Operation.additionner(Operation.multiplier(deux, Operation.additionner(dy2, dy3)), dy4)), six));
        }
    }
}
