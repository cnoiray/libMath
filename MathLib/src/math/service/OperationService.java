package math.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import math.controler.MatrixExceptionControler;
import math.controler.Operation;
import math.controler.exception.DimensionErrorException;
import math.entities.BinaryOperation;
import math.entities.Complexe;
import math.entities.MathObject;
import math.entities.Matrice;
import math.entities.Polynome;
import math.entities.Reel;

public class OperationService {
	//------- ADDITION -------//
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
	
	//------- SOUSTRACTION -------//
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
	
	//------- MULTIPLICATION -------//
	public MathObject multiplierReelEtReel(MathObject a, MathObject b){
		return new Reel( ((Reel)a).reel*((Reel)b).reel );
	}
	
	public MathObject multiplierReelEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Reel)a).reel*((Complexe)b).reel, ((Complexe)b).imaginaire*((Reel)a).reel);
	}
	
	public MathObject multiplierComplexeEtReel(MathObject a, MathObject b){
		return multiplierReelEtComplexe(b, a);
	}
	
	public MathObject multiplierComplexeEtComplexe(MathObject a, MathObject b){
		return new Complexe( ((Complexe)a).reel*((Complexe)b).reel-((Complexe)a).imaginaire*((Complexe)b).imaginaire,
				((Complexe)a).imaginaire*((Complexe)b).reel+((Complexe)a).reel*((Complexe)b).imaginaire);
	}
	
	public MathObject multiplierReelEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<MathObject> developpeeRetour = new ArrayList<MathObject>();
		int i, size = ((Polynome)b).formeDeveloppee.size();
		for(i = 0; i < size; i++){
			developpeeRetour.add( Operation.multiplier(a, ((Polynome)b).formeDeveloppee.get(i)));
		}
		return new Polynome(developpeeRetour);
	}
	
	public MathObject multiplierPolynomeEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierReelEtPolynome(b, a);
	}
	
	public MathObject multiplierComplexeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierReelEtPolynome(a, b);
	}
	
	public MathObject multiplierPolynomeEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierComplexeEtPolynome(b, a);
	}
	
	public MathObject multiplierPolynomeEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return new Polynome(
				multiplicationPolynome(((Polynome)a).formeDeveloppee,
						((Polynome)b).formeDeveloppee));
	}
	
	/**
	 * Méthode de multiplication des listes représentant la forme developpée des polynomes
	 * 
	 * @param List<MathObject> formeDeveloppeeA
	 * @param List<MathObject> formeDeveloppeeB
	 * @return List<MathObject> resultat
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public List<MathObject> multiplicationPolynome(List<MathObject> formeDeveloppeeA, List<MathObject> formeDeveloppeeB) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<MathObject> developpeeRetour = new ArrayList<MathObject>();
		int sizeMin = Math.min(formeDeveloppeeA.size(), formeDeveloppeeB.size());
		int sizeMax = Math.max(formeDeveloppeeA.size(), formeDeveloppeeB.size());
		
		int i, j, k;
		for(i = 0; i <= sizeMax+sizeMin-2; i++){
			MathObject valeur = new Reel();
			j = 0;
			while( j <= i && j < sizeMin){
				k = i- j;
				if(k < sizeMax)	{
					if(formeDeveloppeeA.size() > formeDeveloppeeB.size()){
						valeur = Operation.additionner(valeur, Operation.multiplier(formeDeveloppeeA.get(k), formeDeveloppeeB.get(j)));
					}else{
						valeur = Operation.additionner(valeur, Operation.multiplier(formeDeveloppeeA.get(j), formeDeveloppeeB.get(k)));
					}
				}
				j++;
			}
			developpeeRetour.add(valeur);
		}
		return developpeeRetour;
	}
	
	public MathObject multiplierReelEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Matrice matriceRetour = new Matrice(((Matrice) b).nb_ligne, ((Matrice) b).nb_col);
		int i,j;
		for (i = 0; i < ((Matrice) b).nb_ligne; i++) {
			for (j = 0; j < ((Matrice) b).nb_col; j++){
				matriceRetour.setValue(i, j, Operation.multiplier(a,((Matrice) b).getValue(i, j)));
			}
		}
		return matriceRetour;
	}
	
	public MathObject multiplierMatriceEtReel(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierReelEtMatrice(b, a);
	}
	
	public MathObject multiplierComplexeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierReelEtMatrice(a, b);
	}
	
	public MathObject multiplierMatriceEtComplexe(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierComplexeEtMatrice(b, a);
	}
	
	public MathObject multiplierPolynomeEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierReelEtMatrice(a, b);
	}
	
	public MathObject multiplierMatriceEtPolynome(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return multiplierPolynomeEtMatrice(b, a);
	}
	
	public MathObject multiplierMatriceEtMatrice(MathObject a, MathObject b) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, DimensionErrorException{
		MatrixExceptionControler.controleDimentionMatricesForMultiplication((Matrice) a, (Matrice) b);
		
		Matrice matriceRetour = new Matrice(((Matrice) a).nb_ligne, ((Matrice) b).nb_col);
		int i,j,k;
		MathObject value;
		for (i = 0; i < matriceRetour.nb_ligne; i++) {
			for (j = 0; j < matriceRetour.nb_col; j++){
				value= new Reel();
				for(k = 0; k < ((Matrice) a).nb_col; k++){
					value= Operation.additionner(
							value,
							Operation.multiplier(
								((Matrice) a).getValue(i, k),
								((Matrice) b).getValue(k, j)));
				}
				matriceRetour.setValue(i, j, value);
			}
		}
		return matriceRetour;
	}
	
	public MathObject multiplierFonctionEtReel(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierReelEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierComplexeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierPolynomeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierMatriceEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtReel(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierReelEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierComplexeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierPolynomeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierMatriceEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtReel(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierReelEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierComplexeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierPolynomeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierMatriceEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierFonctionEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierInconnueEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}
	
	public MathObject multiplierBinaryOperationEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("*", a, b);
	}

	//------- DIVISION -------//
	public MathObject diviserReelEtReel(MathObject a, MathObject b){
		return new Reel( ((Reel)a).reel/((Reel)b).reel );
	}
	
	public MathObject diviserReelEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtReel(MathObject a, MathObject b){
		return new Complexe( ((Complexe)a).reel/((Reel)b).reel, ((Complexe)a).imaginaire/((Reel)b).reel);
	}
	
	public MathObject diviserComplexeEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserReelEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtReel(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserReelEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtReel(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtReel(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserReelEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtReel(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserReelEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtReel(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserReelEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtComplexe(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserComplexeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtPolynome(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserPolynomeEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtMatrice(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserMatriceEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtFonction(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserFonctionEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtInconnue(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserInconnueEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	public MathObject diviserBinaryOperationEtBinaryOperation(MathObject a, MathObject b){
		return new BinaryOperation("/", a, b);
	}
	
	//------- PUISSANCE -------//
	public MathObject powReelEtReel(MathObject a, MathObject b){
		return new Reel((float) Math.pow(((Reel)a).reel, ((Reel)b).reel));
	}
	
	//------- VALEUR ABSOLUE -------//
	public MathObject absReel(MathObject a){
		return new Reel((float) Math.abs(((Reel)a).reel));
	}
	
	//------- RACINE CARREE -------//
	public MathObject sqrtReel(MathObject a){
		return new Reel((float) Math.sqrt(((Reel)a).reel));
	}
}
