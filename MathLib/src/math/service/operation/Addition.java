package math.service.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import math.controler.Operation;
import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Complexe;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Matrice;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;
import math.exception.MatrixExceptionControler;
import math.exception.item.DimensionErrorException;

public class Addition {
	public MathObject additionnerReelEtReel(MathObject a, MathObject b){
		return new Reel( ((Reel)a).reel+((Reel)b).reel );
	}
	
	public MathObject additionnerReelEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Reel)a).reel+((Complexe)b).reel, ((Complexe)b).imaginaire);
	}
	
	public MathObject additionnerComplexeEtReel(MathObject a, MathObject b){
		return additionnerReelEtComplexe(b, a);
	}
	
	public MathObject additionnerComplexeEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Complexe)a).reel+((Complexe)b).reel, ((Complexe)a).imaginaire+((Complexe)b).imaginaire);
	}
	
	public MathObject additionnerReelEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>(((Polynome)b).formeDeveloppee);
		formeDeveloppee.set(0, Operation.additionner(a, formeDeveloppee.get(0)));
		return new Polynome(formeDeveloppee);
	}
	
	public MathObject additionnerPolynomeEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtPolynome(b,a);
	}
	
	public MathObject additionnerComplexeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtPolynome(a,b);
	}
	
	public MathObject additionnerPolynomeEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtPolynome(b,a);
	}
	
	public MathObject additionnerPolynomeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> developpeeRetour = new ArrayList<MathObject>();
		int sizeMin = Math.min(((Polynome)a).formeDeveloppee.size(), ((Polynome)b).formeDeveloppee.size());
		int sizeMax = Math.max(((Polynome)a).formeDeveloppee.size(), ((Polynome)b).formeDeveloppee.size());
		
		int i;
		for(i = 0; i < sizeMax; i++){
			if(i < sizeMin){
				developpeeRetour.add(Operation.additionner(((Polynome)a).formeDeveloppee.get(i), ((Polynome)b).formeDeveloppee.get(i)));
			}else{
				if(((Polynome)a).formeDeveloppee.size() == sizeMax){
					developpeeRetour.add(((Polynome)a).formeDeveloppee.get(i));
				}else{
					developpeeRetour.add(((Polynome)b).formeDeveloppee.get(i));
				}
			}
		}
		
		return new Polynome(developpeeRetour);
	}
	
	public MathObject additionnerReelEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Matrice matriceRetour = new Matrice(((Matrice) b).nb_ligne, ((Matrice) b).nb_col);
		int i,j;
		//prendre x=x*I pour le transformer en matrice: erreur de dimension?
		for (i = 0; i < ((Matrice) b).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) b).nb_col; j++){
				if(i==j){
					matriceRetour.setValue(i, j, Operation.additionner(a,((Matrice) b).getValue(i, j)));
				}else{
					matriceRetour.setValue(i, j, ((Matrice) b).getValue(i, j));
				}
			}
		}
		return matriceRetour;
	}
	
	public MathObject additionnerMatriceEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtMatrice(b, a);
	}
	
	public MathObject additionnerComplexeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtMatrice(a, b);
	}
	
	public MathObject additionnerMatriceEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerComplexeEtMatrice(b, a);
	}
	
	public MathObject additionnerPolynomeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerReelEtMatrice(a, b);
	}
	
	public MathObject additionnerMatriceEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return additionnerPolynomeEtMatrice(b, a);
	}
	
	public MathObject additionnerMatriceEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, DimensionErrorException{
		MatrixExceptionControler.controleDimentionMatrices((Matrice)a, (Matrice)b);
			
		Matrice matriceRetour = new Matrice(((Matrice) b).nb_ligne, ((Matrice) b).nb_col);
		int i,j;
		for (i = 0; i < ((Matrice) b).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) b).nb_col; j++)
				matriceRetour.setValue(i, j, Operation.additionner(((Matrice) a).getValue(i, j), ((Matrice) b).getValue(i, j)));
		}
		return matriceRetour;
	}
	
	public MathObject additionnerFonctionEtReel(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerReelEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerComplexeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerPolynomeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerMatriceEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtReel(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerReelEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerComplexeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerPolynomeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerMatriceEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtReel(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerReelEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerComplexeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerPolynomeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerMatriceEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerFonctionEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerInconnueEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
	
	public MathObject additionnerBinaryOperationEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("+", a, b);
	}
}
