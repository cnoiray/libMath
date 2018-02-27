/**
 * 
 */
package math.entities.mathobject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import math.controler.Operation;

public class BinaryOperation extends MathObject {

	
	private String operand;

	private MathObject operateur1;
	
	private MathObject operateur2;
	
	/**
	 * 
	 */
	public BinaryOperation(String operand, MathObject operateur1, MathObject operateur2) {
		// TODO Auto-generated constructor stub
		this.operand = operand;
		this.operateur1 = operateur1;
		this.operateur2 = operateur2;
	}
	
	/**
	 * @return the operand
	 */
	public String getOperand() {
		return operand.toUpperCase();
	}

	/**
	 * @return the operateur1
	 */
	public MathObject getOperateur1() {
		return operateur1;
	}

	/**
	 * @return the operateur2
	 */
	public MathObject getOperateur2() {
		return operateur2;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(isMultiplierConditionPaenthese1() | operand.equals("/") | operateur1.getClass()==Complexe.class | operateur1.getClass()==Polynome.class){
			sb.append("(");
			sb.append(operateur1.toString());
			sb.append(")");
		}else{
			sb.append(operateur1.toString());
		}
		sb.append(operand);
		if(isMultiplierConditionPaenthese2() | isSoustraireConditionPaenthese2() | operand.equals("/") | operateur2.getClass()==Complexe.class | operateur2.getClass()==Polynome.class){
			sb.append("(");
			sb.append(operateur2.toString());
			sb.append(")");
		}else{
			sb.append(operateur2.toString());
		}
		return sb.toString();
	}
	
	private boolean isMultiplierConditionPaenthese1(){
		return operand.equals("*") && operateur1.getClass()!=Reel.class && operateur1.getClass()!=Fonction.class && operateur1.getClass()!=Matrice.class && operateur1.getClass()!=Inconnue.class;
	}
	
	private boolean isMultiplierConditionPaenthese2(){
		return operand.equals("*") && operateur2.getClass()!=Reel.class && operateur2.getClass()!=Fonction.class && operateur2.getClass()!=Matrice.class && operateur2.getClass()!=Inconnue.class;
	}
	
	private boolean isSoustraireConditionPaenthese2(){
		return operand.equals("-") && operateur2.getClass()!=Reel.class && operateur2.getClass()!=Fonction.class && operateur2.getClass()!=Matrice.class && operateur2.getClass()!=Inconnue.class;
	}
	
	@Override
	public MathObject eval() {
		String operationName ="";
		
		switch (this.operand) {
		case "+":
			operationName = "additionner";
			break;
		case "-":
			operationName = "soustraire";
			break;
		case "*":
			operationName = "multiplier";
			break;
		case "/":
			operationName = "diviser";
			break;
		}
		
		return calculAnalyse(operationName, this.operateur1.eval(), this.operateur2.eval());
	}

	@Override
	public MathObject calc(IMathObject val) {
		String operationName ="";
		
		switch (this.operand) {
		case "+":
			operationName = "additionner";
			break;
		case "-":
			operationName = "soustraire";
			break;
		case "*":
			operationName = "multiplier";
			break;
		case "/":
			operationName = "diviser";
			break;
		}
		
		return calculAnalyse(operationName, this.operateur1.calc(val), this.operateur2.calc(val));
	}
	
	private MathObject calculAnalyse(String operationName, MathObject a, MathObject b){
		try {
			Method method = Operation.class.getMethod(operationName, MathObject.class, MathObject.class);
			return (MathObject) method.invoke(Operation.class, a, b);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return a;
	}

	public MathObject deriver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		switch (this.operand) {
		case "+":
			return Operation.additionner(operateur1.deriver(), operateur2.deriver());
		case "-":
			return Operation.soustraire(operateur1.deriver(), operateur2.deriver());
		case "*":
			return Operation.additionner(
					Operation.multiplier(operateur1.deriver(), operateur2),
					Operation.multiplier(operateur1, operateur2.deriver()));
		case "/":
			return Operation.diviser(
					Operation.soustraire(
						Operation.multiplier(operateur1.deriver(), operateur2),
						Operation.multiplier(operateur1, operateur2.deriver())),
					Operation.pow(operateur2, new Reel(2)));
		}
		return new Reel();
	}
}
