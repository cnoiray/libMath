package math.entities.fonction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import math.controler.Operation;
import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class PuissanceN extends Fonction{
	public Reel n;
	
	public PuissanceN() {
		super();
	}
	
	public PuissanceN(MathObject operation) {
		this.fonction_name = "pow";
		this.operation = operation;
	}
	
	public PuissanceN(MathObject operation, Reel n) {
		this.fonction_name = "pow";
		this.n = n;
		this.operation = operation;
	}
	
	public PuissanceN(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	public PuissanceN(String fonction_name, MathObject operation, Reel n) {
		this.fonction_name = fonction_name;
		this.operation = operation;
		this.n = n;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new BinaryOperation("*", n, new BinaryOperation("*", operation.deriver(), new PuissanceN(this.operation, (Reel)Operation.soustraire(n, new Reel(1)))));
	}
	
	public MathObject calc(){
		if(operation instanceof Reel){
			return new Reel((float) Math.pow(((Reel)operation).reel, n.reel));
		}
		return new Reel();
	}
	
	@Override
	public MathObject eval() {
		if(this.operation instanceof Reel){
			return new Reel((float) Math.pow(((Reel)operation).reel, n.reel));
		}
		return new PuissanceN(this.fonction_name, this.operation.eval(), n);
	}
}
