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

public class Soustraction {
	public MathObject soustraireReelEtReel(MathObject a, MathObject b){
		return new Reel( ((Reel)a).reel-((Reel)b).reel );
	}
	
	public MathObject soustraireReelEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Reel)a).reel-((Complexe)b).reel, -((Complexe)b).imaginaire);
	}
	
	public MathObject soustraireComplexeEtReel(MathObject a, MathObject b){
		return new Complexe( ((Complexe)a).reel-((Reel)b).reel, ((Complexe)a).imaginaire);
	}
	
	public MathObject soustraireComplexeEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Complexe)a).reel-((Complexe)b).reel, ((Complexe)a).imaginaire-((Complexe)b).imaginaire);
	}
	
	public MathObject soustraireReelEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>(((Polynome)b).formeDeveloppee);
		for(int i=0;i<formeDeveloppee.size();i++){
			if(i==0){
				formeDeveloppee.set(i, Operation.soustraire(a, formeDeveloppee.get(i)));
			}else{
				formeDeveloppee.set(i, Operation.soustraire(new Reel(0), formeDeveloppee.get(i)));
			}
		}
		return new Polynome(formeDeveloppee);
	}
	
	public MathObject soustrairePolynomeEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>(((Polynome)a).formeDeveloppee);
		for(int i=0;i<formeDeveloppee.size();i++){
			if(i==0){
				formeDeveloppee.set(i, Operation.soustraire(formeDeveloppee.get(i), b));
			}else{
				formeDeveloppee.set(i, Operation.soustraire(formeDeveloppee.get(i), new Reel(0)));
			}
		}
		return new Polynome(formeDeveloppee);
	}
	
	public MathObject soustraireComplexeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustraireReelEtPolynome(a, b);
	}
	
	public MathObject soustrairePolynomeEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustrairePolynomeEtReel(a, b);
	}
	
	public MathObject soustrairePolynomeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> developpeeRetour = new ArrayList<MathObject>();
		int sizeMin = Math.min(((Polynome)a).formeDeveloppee.size(), ((Polynome)b).formeDeveloppee.size());
		int sizeMax = Math.max(((Polynome)a).formeDeveloppee.size(), ((Polynome)b).formeDeveloppee.size());
		
		int i;
		for(i = 0; i < sizeMax; i++){
			if(i < sizeMin){
				developpeeRetour.add(Operation.soustraire(((Polynome)a).formeDeveloppee.get(i), ((Polynome)b).formeDeveloppee.get(i)));
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
	
	public MathObject soustraireReelEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Matrice matriceRetour = new Matrice(((Matrice) b).nb_ligne, ((Matrice) b).nb_col);
		int i,j;
		//prendre x=x*I pour le transformer en matrice: erreur de dimension?
		for (i = 0; i < ((Matrice) b).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) b).nb_col; j++){
				if(i==j){
					matriceRetour.setValue(i, j, Operation.soustraire(a, ((Matrice) b).getValue(i, j)));
				}else{
					matriceRetour.setValue(i, j, Operation.soustraire(new Reel(), ((Matrice) b).getValue(i, j)));
				}
			}
		}
		return matriceRetour;
	}
	
	public MathObject soustraireMatriceEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Matrice matriceRetour = new Matrice(((Matrice) a).nb_ligne, ((Matrice) a).nb_col);
		int i,j;
		//prendre x=x*I pour le transformer en matrice: erreur de dimension?
		for (i = 0; i < ((Matrice) a).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) a).nb_col; j++){
				if(i==j){
					matriceRetour.setValue(i, j, Operation.soustraire(((Matrice) a).getValue(i, j), b));
				}else{
					matriceRetour.setValue(i, j, ((Matrice) a).getValue(i, j));
				}
			}
		}
		return matriceRetour;
	}
	
	public MathObject soustraireComplexeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustraireReelEtMatrice(a, b);
	}
	
	public MathObject soustraireMatriceEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustraireMatriceEtReel(a, b);
	}
	
	public MathObject soustrairePolynomeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustraireReelEtMatrice(a, b);
	}
	
	public MathObject soustraireMatriceEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return soustraireMatriceEtReel(a, b);
	}
	
	public MathObject soustraireMatriceEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, DimensionErrorException{
		MatrixExceptionControler.controleDimentionMatrices((Matrice)a, (Matrice)b);
		
		Matrice matriceRetour = new Matrice(((Matrice) b).nb_ligne, ((Matrice) b).nb_col);
		int i,j;
		for (i = 0; i < ((Matrice) b).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) b).nb_col; j++)
				matriceRetour.setValue(i, j, Operation.soustraire(((Matrice) a).getValue(i, j), ((Matrice) b).getValue(i, j)));
		}
		return matriceRetour;
	}
	
	public MathObject soustraireFonctionEtReel(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireReelEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireComplexeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustrairePolynomeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireMatriceEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtReel(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireReelEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireComplexeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustrairePolynomeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireMatriceEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtReel(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireReelEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireComplexeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustrairePolynomeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireMatriceEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireFonctionEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireInconnueEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
	
	public MathObject soustraireBinaryOperationEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("-", a, b);
	}
}
