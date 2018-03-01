package math.entities.mathobject;

import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class Inconnue extends MathObject{
	public String inconnue;
	
	public Inconnue() {
		inconnue ="x";
	}

	public Inconnue(String inconnue) {
		this.inconnue = inconnue;
	}
	
	@Override
	public String toString() {
		return inconnue;
	}
	
	@Override
	public MathObject calc(SimpleEntry<Inconnue, IMathObject>... value) {
		for (SimpleEntry<Inconnue, IMathObject> item : value) {
			if(inconnue.equals(item.getKey().inconnue)){
				return (MathObject) item.getValue();
			}
		}
		
		return this;
	}
	
	public MathObject deriver(){
		return new Reel(1);
	}
}
