package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class Racine extends Fonction{
	public Racine() {
		super();
	}
	
	public Racine(MathObject operation) {
		this.fonction_name = "sqrt";
		this.operation = operation;
	}
	
	public Racine(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("/", operation.deriver(),new BinaryOperation("*", new Reel(2), new Racine(this.operation)));
	}
}
