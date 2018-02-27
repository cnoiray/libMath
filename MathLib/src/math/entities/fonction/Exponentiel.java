package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.BinaryOperation;
import math.entities.Fonction;
import math.entities.MathObject;

public class Exponentiel extends Fonction{
	public Exponentiel() {
		super();
	}
	
	public Exponentiel(MathObject operation) {
		this.fonction_name = "exp";
		this.operation = operation;
	}
	
	public Exponentiel(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", operation.deriver(), this);
	}
}
