package math.controler;

import math.entities.mathobject.Fonction;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;
import math.service.operation.Addition;
import math.service.operation.Division;
import math.service.operation.Multiplication;
import math.service.operation.Soustraction;
import math.service.operation.ValeurAbsolue;

public class Operation {
	public static MathObject additionner(MathObject a, MathObject b){
		Addition service = new Addition();
		MathObject result = new MathObject();
		
		StringBuilder methodName = new StringBuilder("additionner");
		methodName.append(getClassName(a));
		methodName.append("Et");
		methodName.append(getClassName(b));
		
		try {
			result = (MathObject) service.getClass().getMethod(methodName.toString(), MathObject.class, MathObject.class).invoke(service, a, b);
		} catch (Exception e) {
			e.printStackTrace();
			result =new Reel();
		}
		
		return result ;
	}
	
	public static MathObject soustraire(MathObject a, MathObject b) {
		Soustraction service = new Soustraction();
		MathObject result = new MathObject();
		
		StringBuilder methodName = new StringBuilder("soustraire");
		methodName.append(getClassName(a));
		methodName.append("Et");
		methodName.append(getClassName(b));
		
		try {
			result = (MathObject) service.getClass().getMethod(methodName.toString(), MathObject.class, MathObject.class).invoke(service, a, b);
		} catch (Exception e) {
			e.printStackTrace();
			result =new Reel();
		}
		
		return result ;
	}
	
	public static MathObject multiplier(MathObject a, MathObject b){
		Multiplication service = new Multiplication();
		MathObject result = new MathObject();
		
		StringBuilder methodName = new StringBuilder("multiplier");
		methodName.append(getClassName(a));
		methodName.append("Et");
		methodName.append(getClassName(b));
		
		try {
			result = (MathObject) service.getClass().getMethod(methodName.toString(), MathObject.class, MathObject.class).invoke(service, a, b);
		} catch (Exception e) {
			e.printStackTrace();
			result =new Reel();
		}
		
		return result ;
	}
	
	public static MathObject diviser(MathObject a, MathObject b){
		Division service = new Division();
		MathObject result = new MathObject();
		
		StringBuilder methodName = new StringBuilder("diviser");
		methodName.append(getClassName(a));
		methodName.append("Et");
		methodName.append(getClassName(b));
		
		try {
			result = (MathObject) service.getClass().getMethod(methodName.toString(), MathObject.class, MathObject.class).invoke(service, a, b);
		} catch (Exception e) {
			e.printStackTrace();
			result =new Reel();
		}
		
		return result ;
	}
	
	public static MathObject abs(MathObject a) {
		ValeurAbsolue service = new ValeurAbsolue();
		MathObject result = new MathObject();
		
		StringBuilder methodName = new StringBuilder("abs");
		methodName.append(a.getClass().toString().replace("class math.entities.mathobject.", ""));
		
		try {
			result = (MathObject) service.getClass().getMethod(methodName.toString(), MathObject.class).invoke(service, a);
		} catch (Exception e) {
			e.printStackTrace();
			result =new Reel();
		}
		
		return result ;
	}
	
	private static String getClassName(MathObject a){
		if(a instanceof Fonction){
			return "Fonction";
		}
		return a.getClass().toString().replace("class math.entities.mathobject.", "");
	}
}
