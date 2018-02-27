package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.BinaryOperation;
import math.entities.Fonction;
import math.entities.MathObject;

public class LogarithmeN extends Fonction{
	public LogarithmeN() {
		super();
	}
	
	public LogarithmeN(MathObject operation) {
		this.fonction_name = "log10";
		this.operation = operation;
	}
	
	public LogarithmeN(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", operation.deriver(), this);
	}
}
