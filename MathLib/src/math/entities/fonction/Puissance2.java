package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;

import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class Puissance2 extends Fonction{
	public Puissance2() {
		super();
	}
	
	public Puissance2(MathObject operation) {
		this.fonction_name = "pow";
		this.operation = operation;
	}
	
	public Puissance2(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", new Reel(2),new BinaryOperation("*", operation.deriver(), this.operation));
	}
	
	public MathObject calc(){
		if(operation instanceof Reel){
			return new Reel((float) Math.pow(((Reel)operation).reel, 2));
		}
		return new Reel();
	}
	
	@Override
	public MathObject eval() {
		if(this.operation instanceof Reel){
			return new Reel((float) Math.pow(((Reel)operation).reel, 2));
		}
		return new Puissance2(this.fonction_name, this.operation.eval());
	}
}
