package math.entities.mathobject;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class MathObject implements IMathObject{

	public boolean isNull() {
		return true;
	}

	@Override
	public boolean equals(IMathObject value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MathObject arrondir() {
		return null;
	}

	@Override
	public boolean sup(IMathObject value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inf(IMathObject value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MathObject eval() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public MathObject calc(SimpleEntry<Inconnue, IMathObject>... value) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return this;
	}

}
