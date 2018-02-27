package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.BinaryOperation;
import math.entities.Fonction;
import math.entities.MathObject;

public class Cosinus extends Fonction{
	public Cosinus() {
		super();
	}
	
	public Cosinus(MathObject operation) {
		this.fonction_name = "cos";
		this.operation = operation;
	}
	
	public Cosinus(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", operation.deriver(), new Sinus(this.operation));
	}
}
