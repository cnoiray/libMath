package math.entities.mathobject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;

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
		if(this.operation instanceof Reel){
			try {
				Method method = Math.class.getMethod(this.fonction_name, double.class);
				return new Reel(((Double)method.invoke(Math.class, ((Reel)this.operation).reel)).floatValue());
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return new Fonction(this.fonction_name, this.operation.eval());
	}
	
	@Override
	public MathObject calc(SimpleEntry<Inconnue, IMathObject>... value) {
		try {
			Method method = Math.class.getMethod(this.fonction_name, double.class);
			return new Reel(((Double)method.invoke(Math.class, ((Reel)this.operation.calc(value)).reel)).floatValue());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return new Fonction(this.fonction_name, this.operation.calc(value));
	}
}
