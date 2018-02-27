package math.entities.mathobject;

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
	public MathObject calc(IMathObject val) {
		return (MathObject) val;
	}
	
	public MathObject deriver(){
		return new Reel(1);
	}
}
