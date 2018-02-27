package math.service.operation;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class ValeurAbsolue {
	public MathObject absReel(MathObject a){
		return new Reel((float) Math.abs(((Reel)a).reel));
	}
}
