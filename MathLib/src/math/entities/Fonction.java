package math.entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Fonction extends MathObject{
	public String fonction_name;
	
	public MathObject operation;
	
	public Fonction() {
		fonction_name="";
	}

	public Fonction(String fonction_name, MathObject operation) {
		this.fonction_name = fonction_name;
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return fonction_name+"("+operation.toString()+")";
	}
	
	@Override
	public MathObject eval() {
		return new Fonction(this.fonction_name, this.operation.eval());
	}
	
	@Override
	public MathObject calc(IMathObject val) {
		try {
			Method method = Math.class.getMethod(this.fonction_name, double.class);
			return new Reel(((Double)method.invoke(Math.class, ((Reel)this.operation.calc(val)).reel)).floatValue());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return new Fonction(this.fonction_name, this.operation.calc(val));
	}
}
