package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.BinaryOperation;
import math.entities.Fonction;
import math.entities.MathObject;

public class TangenteHyperbolique extends Fonction{
	public TangenteHyperbolique() {
		super();
	}
	
	public TangenteHyperbolique(MathObject operation) {
		this.fonction_name = "tanh";
		this.operation = operation;
	}
	
	public TangenteHyperbolique(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", operation.deriver(), this);
	}
}
