package math.entities;

import java.lang.reflect.InvocationTargetException;

import math.controler.Operation;
import math.entities.fonction.Exponentiel;

/**
 * Equation différentielle de la forme a*x"+b*x'+c*x+d=0
 * @author cnoiray
 *
 */
public class EquationDifferentielle {
	public MathObject a;
	public MathObject b;
	public MathObject c;
	public MathObject d;
	
	public EquationDifferentielle() {
	}

	public EquationDifferentielle(MathObject a, MathObject b, MathObject c, MathObject d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Override
	public String toString() {
		return a.toString()+"*x"+b.toString()+"*x'"+c.toString()+"*x"+d.toString();
	}
	
	public void resolve(){
		
	}
	
	//equation homogène d=0
	//Cas coefficients constants
	public MathObject resolveHomogeneCoefConstant() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		MathObject resultat = new MathObject();
		
		//il faut se ramener à a=1
		a=Operation.diviser(a, a);
		b=Operation.diviser(b, a);
		c=Operation.diviser(c, a);
		
		//equation caracteristique ax²+bx+c=0
		//calcul du discriminant et distinction 3 cas
		MathObject discriminant = Operation.soustraire(
				Operation.pow(b, new Reel(2))
				,Operation.multiplier(Operation.multiplier(new Reel(4), a), c));
		
		if(discriminant.sup(new Reel(0))){
			MathObject x = Operation.diviser(Operation.soustraire(Operation.sqrt(discriminant), b), Operation.multiplier(new Reel(2), a));
			MathObject y = Operation.diviser(Operation.soustraire(Operation.multiplier(new Reel(-1), Operation.sqrt(discriminant)), b), Operation.multiplier(new Reel(2), a));
			
			MathObject f1 = new Exponentiel(new BinaryOperation("*", x, new Inconnue()));
			MathObject f2 = new Exponentiel(new BinaryOperation("*", y, new Inconnue()));
			
			//conditions initiales
			MathObject C1 = new Reel(0);
			MathObject C2 = new Reel(0);
			
			resultat = new BinaryOperation("+", new BinaryOperation("*", C1, f1), new BinaryOperation("*", C2, f2));
		}else if(discriminant.equals(0)){
			MathObject x = Operation.multiplier(new Reel(-1), Operation.diviser(b, Operation.multiplier(new Reel(2), a)));
			
			MathObject f1 = new Exponentiel(new BinaryOperation("*", x, new Inconnue()));
			
			//conditions initiales
			MathObject A = new Reel(0);
			MathObject B = new Reel(0);
			
			resultat = new BinaryOperation("*", new BinaryOperation("+", new BinaryOperation("*", A, new Inconnue()), B), f1);
		}else{//discriminant.inf(O)
			
		}
		return resultat;
	}
}
