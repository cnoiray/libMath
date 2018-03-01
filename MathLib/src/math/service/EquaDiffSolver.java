package math.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.function.BiFunction;

import math.controler.Operation;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class EquaDiffSolver {
	public void rungeKutta(BiFunction<MathObject, MathObject, MathObject> function, MathObject[] t,
			MathObject[] y, MathObject dt) {
		Reel deux = new Reel(2);
		Reel six = new Reel(6);
		
		//y' = f(t, y)
		//y(t0) = y0
		
        for (int n = 0; n < t.length - 1; n++) {
        	//k1 = dt * f(tk, yk)
        	MathObject k1 = Operation.multiplier(dt, function.apply(t[n], y[n])).eval();
        	//k2 = dt * f(tk + dt/2, yk+ dt/2 * k1)
        	MathObject k2 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], Operation.diviser(dt, deux)), 
        			Operation.additionner(y[n], Operation.diviser(k1, deux)))).eval();
        	//k3 = dt * f(tk + dt/2, yk+ dt/2 * k2)
        	MathObject k3 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], Operation.diviser(dt, deux)), 
        			Operation.additionner(y[n], Operation.diviser(k2, deux)))).eval();
        	//k4 = dt * f(tk + dt, yk + dt * k3)
        	MathObject k4 = Operation.multiplier(dt, function.apply(
        			Operation.additionner(t[n], dt), 
        			Operation.additionner(y[n], k3))).eval();
            t[n + 1] = Operation.additionner(t[n], dt).eval();
            //y(n+1) = yn + (k1 + 2k2 + 2k3 + k4) / 6
            y[n + 1] = Operation.additionner(y[n], Operation.diviser(Operation.additionner(k1, Operation.additionner(Operation.multiplier(deux, Operation.additionner(k2, k3)), k4)), six)).eval();
        }
    }
	
	public void rungeKutta(MathObject function, MathObject[] t,
			MathObject[] y, MathObject dt) {
		Reel deux = new Reel(2);
		Reel six = new Reel(6);
		
		Inconnue tinc = new Inconnue("t");
		Inconnue yinc = new Inconnue("y");
		
		//y' = f(t, y)
		//y(t0) = y0
		
        for (int n = 0; n < t.length - 1; n++) {
        	//k1 = dt * f(tk, yk)
        	MathObject k1 = Operation.multiplier(dt, function.calc(new SimpleEntry<>(tinc ,t[n]), new SimpleEntry<>(yinc ,y[n])));
        	//k2 = dt * f(tk + dt/2, yk+ dt/2 * k1)
        	MathObject k2 = Operation.multiplier(dt, function.calc(
        			new SimpleEntry<>(tinc ,Operation.additionner(t[n], Operation.diviser(dt, deux))), 
        			new SimpleEntry<>(yinc ,Operation.additionner(y[n], Operation.diviser(k1, deux)))));
        	//k3 = dt * f(tk + dt/2, yk+ dt/2 * k2)
        	MathObject k3 = Operation.multiplier(dt, function.calc(
        			new SimpleEntry<>(tinc ,Operation.additionner(t[n], Operation.diviser(dt, deux))), 
        			new SimpleEntry<>(yinc ,Operation.additionner(y[n], Operation.diviser(k2, deux)))));
        	//k4 = dt * f(tk + dt, yk + dt * k3)
        	MathObject k4 = Operation.multiplier(dt, function.calc(
        			new SimpleEntry<>(tinc ,Operation.additionner(t[n], dt)), 
        			new SimpleEntry<>(yinc ,Operation.additionner(y[n], k3))));
            t[n + 1] = Operation.additionner(t[n], dt);
            //y(n+1) = yn + (k1 + 2k2 + 2k3 + k4) / 6
            y[n + 1] = Operation.additionner(y[n], Operation.diviser(Operation.additionner(k1, Operation.additionner(Operation.multiplier(deux, Operation.additionner(k2, k3)), k4)), six));
        }
    }
}
