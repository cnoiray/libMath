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

public class Multiplication {
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
	public List<MathObject> multiplicationPolynome(List<MathObject> formeDeveloppeeA, List<MathObject> formeDeveloppeeB) {
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
}
