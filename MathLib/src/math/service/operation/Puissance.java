package math.service.operation;

import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class Puissance {
	public MathObject powReelEtReel(MathObject a, MathObject b){
		return new Reel((float) Math.pow(((Reel)a).reel, ((Reel)b).reel));
	}
}
