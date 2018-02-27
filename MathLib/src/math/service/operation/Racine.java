package math.service.operation;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class Racine {
	public MathObject sqrtReel(MathObject a){
		return new Reel((float) Math.sqrt(((Reel)a).reel));
	}
}
