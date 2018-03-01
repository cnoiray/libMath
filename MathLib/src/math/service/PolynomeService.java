package math.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import math.configuration.MathConf;
import math.controler.Operation;
import math.entities.fonction.Puissance2;
import math.entities.fonction.Racine;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Polynome;
import math.entities.mathobject.Reel;
import math.exception.PolynomialEquationExceptionControler;
import math.exception.item.DivisionByZeroException;
import math.exception.item.PolynomialEquationException;

public class PolynomeService {
	
	/**
	 * M�thode utilisant la m�thode de Newton afin de trouver les valeurs nuls du polynome
	 * 
	 * @param Polynome polynome
	 * @param float value: valeur proche de la valeur de d�rivation
	 * @param float precission
	 * @param int nbrMaxIteration
	 * @return float resultat pour f(x)=0
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static MathObject resolutionNewton(Polynome polynome, MathObject value){
		Polynome derivee = polynome.deriver();
		try {
			if(derivee.calc(value).isNull())
				return value;
			PolynomialEquationExceptionControler.controleNonZeroDivision(derivee);
			int it = 0;
			MathObject evalFonction = new Reel(1);
			while(Operation.abs(evalFonction).sup(new Reel(MathConf.getPrecisionNewtonMethodePolynome())) && it < MathConf.getNbrMaxIterationNewtonMethodePolynome()){
				evalFonction = Operation.diviser(polynome.calc(value), derivee.calc(value));
				value = Operation.soustraire(value, evalFonction);
				it++;
			}
		} catch (DivisionByZeroException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * M�thode de r�solution d'un polynome de degr�s 2
	 * 
	 * @param Polynome polynome
	 * @return float determinant
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static List<MathObject> resolutionDegres2(final Polynome polynome){
		List<MathObject> resultat = new ArrayList<>();
		MathObject discriminant = new Reel(0);
		MathObject a = polynome.formeDeveloppee.get(2);
		MathObject b = polynome.formeDeveloppee.get(1);
		MathObject c = polynome.formeDeveloppee.get(0);
		try {
			PolynomialEquationExceptionControler.controleNbrDegres(polynome, 2);
			
			discriminant = Operation.soustraire(
					new Puissance2(b).eval()
					,Operation.multiplier(Operation.multiplier(new Reel(4), a), c));
			
			PolynomialEquationExceptionControler.controleDiscriminant(discriminant);
			
			if(discriminant.sup(new Reel(0))){
				MathObject x = Operation.diviser(Operation.soustraire(new Racine(discriminant).eval(), b), Operation.multiplier(new Reel(2), a));
				MathObject y = Operation.diviser(Operation.soustraire(Operation.multiplier(new Reel(-1), new Racine(discriminant).eval()), b), Operation.multiplier(new Reel(2), a));
				
				resultat.add(x);
				resultat.add(y);
			}else if(discriminant.equals(0)){
				MathObject x = Operation.multiplier(new Reel(-1), Operation.diviser(b, Operation.multiplier(new Reel(2), a)));
				resultat.add(x);
				resultat.add(x);
			}
		} catch (PolynomialEquationException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	/**
	 * M�thode qui permet d'obtenir la liste des valeurs pour lesquelles la fonction polynomiale est nulle
	 * 
	 * @param polynome
	 * @param precission
	 * @param nbrMaxIteration
	 * @return liste des valeurs pour lesquelles la d�riv�e du polynome s'annule
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static List<MathObject> resolutionPolynome(Polynome polynome){
		List<MathObject> resultat = new ArrayList<MathObject>();
		List<MathObject> solutionDerivee = new ArrayList<MathObject>();
		int degres = polynome.getDegres();
		//On remonte � la d�riv�e ni�me pour laquelle le polynome d�riv�e est de degr�s 2
		if(degres > 2){
			Polynome deriverDegresI = polynome.calculDeriveeN(degres-2);
		
			//On cherche les valeurs nul de ce polynome
			solutionDerivee = trierCroissant(resolutionDegres2(deriverDegresI));
			
			//On �tudie la suite de d�riv�e avec la m�thode de Newton
			int i;
			for(i=3; i<degres; i++){
				//r�cup�ration d�riv�e
				deriverDegresI = polynome.calculDeriveeN(degres-i);
				solutionDerivee = analyseNewton(deriverDegresI, solutionDerivee);
			}
			
			//On �tudie la fonction
			resultat = analyseNewton(polynome, solutionDerivee);
		}else{
			resultat = resolutionDegres2(polynome);
		}
		return resultat;
	}
	
	private static List<MathObject> trierCroissant(List<MathObject> resolutionDegres2) {
		return resolutionDegres2;
	}

	/**
	 * M�thode 
	 * @param polynome
	 * @param solutionDerivee
	 * @param precission
	 * @param nbrMaxIteration
	 * @return liste des valeurs issues de l'application de la m�thode de Newton
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private static List<MathObject> analyseNewton(Polynome polynome, List<MathObject> solutionDerivee) {
		List<MathObject> valPolynomeDontDeriveeNul = new ArrayList<MathObject>();
		List<MathObject> valPourAnalyseNewton = new ArrayList<>();
		
		//r�cup�ration des diff�rentes valeurs max de ce polynome
		valPolynomeDontDeriveeNul = analysePolynome(polynome, solutionDerivee);
		
		//r�cup�ration des valeurs proches des valeurs nulles de ce polynome � partir des valeurs nulles de sa d�riv�e
		valPourAnalyseNewton.clear();
		int j;
		for(j=0; j < valPolynomeDontDeriveeNul.size()-1; j++){
			MathObject val1 = valPolynomeDontDeriveeNul.get(j);
			MathObject val2 = valPolynomeDontDeriveeNul.get(j+1);
			
			// /!\ ne pas ajouter y mais bien x � valPourAnalyseNewton
			if(val1.equals(new Reel(0))){
				valPourAnalyseNewton.add(solutionDerivee.get(j-1));
			}
			if(val2.equals(new Reel(0))){
				valPourAnalyseNewton.add(solutionDerivee.get(j));
			}
			if(isDiffSign(val1, val2)){
				if(j!=0 && j!=valPolynomeDontDeriveeNul.size()-2){
					valPourAnalyseNewton.add(
							(Operation.diviser(Operation.additionner(solutionDerivee.get(j-1), solutionDerivee.get(j)),new Reel(2))));
				}else if(j==0){
					if(val1.sup(new Reel(0))){
						valPourAnalyseNewton.add(
								Operation.soustraire(solutionDerivee.get(j), val1));
					}else{
						valPourAnalyseNewton.add(
								Operation.soustraire(val1, solutionDerivee.get(j)));
					}
				}else{
					if(val2.sup(new Reel(0))){
						valPourAnalyseNewton.add(
								Operation.soustraire(val2, solutionDerivee.get(j-1)));
					}else{
						valPourAnalyseNewton.add(
								Operation.soustraire(solutionDerivee.get(j-1), val2));
					}
				}
			}
		}
		
		//r�cup�ration des valeurs exactes pour lesquelles le polynome est nul
		solutionDerivee.clear();
		for(j=0; j < valPourAnalyseNewton.size(); j++){
			solutionDerivee.add(resolutionNewton(polynome,valPourAnalyseNewton.get(j)));
		}
		
		return solutionDerivee;
	}
	
	/**
	 * M�thode qui permet de savoir si deux float sont de signes diff�rents
	 * @param float1
	 * @param float2
	 * @return
	 */
	private static boolean isDiffSign(MathObject float1, MathObject float2) {
		return ((float1.sup(new Reel(0)) && float2.inf(new Reel(0))) || (float1.inf(new Reel(0)) && float2.sup(new Reel(0))));
	}

	/**
	 * M�thode qui permet d'analyser la d�river d'un polynome
	 * 
	 * @param polynome
	 * @return List<Float> des valeurs nuls du polynome
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static List<MathObject> analyseDerivee(final Polynome polynome, List<MathObject> valDeriveeNul) {
		List<MathObject> etude = new ArrayList<MathObject>();
		Polynome derivee = polynome.deriver();
		etude.add(limiteInfini(derivee, -1));
		for(MathObject val : valDeriveeNul){
			etude.add(derivee.calc(val));
		}
		etude.add(limiteInfini(derivee, 1));
		
		return etude;
	}
	
	/**
	 * M�thode qui permet d'analyser un polynome
	 * 
	 * @param polynome
	 * @return List<Float> des valeurs pour lesquelles la d�riv�e du polynome est nul
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static List<MathObject> analysePolynome(final Polynome polynome, List<MathObject> valDeriveeNul){
		List<MathObject> resulat = new ArrayList<MathObject>();
		resulat.add(limiteInfini(polynome, -1));
		for(MathObject val : valDeriveeNul){
			resulat.add(polynome.calc(val));
		}
		resulat.add(limiteInfini(polynome, 1));
		
		return resulat;
	}

	/**
	 * Renvoie la limite en l'infini
	 * 
	 * @param polynome
	 * @param signeInfinie
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private static MathObject limiteInfini(final Polynome polynome,int signeInfinie) {
		int degresMax = polynome.getDegres();
		if(degresMax % 2 == 0){
			return polynome.formeDeveloppee.get(degresMax);
		}else{
			if(signeInfinie > 0){
				return polynome.formeDeveloppee.get(degresMax);
			}else{
				return Operation.multiplier(polynome.formeDeveloppee.get(degresMax), new Reel(-1));
			}
		}
	}
	
	public static Polynome arrondirPolynome(Polynome polynome){
		int i;
		for(i = 0; i < polynome.formeDeveloppee.size(); i++){
			polynome.formeDeveloppee.set(i, 
					polynome.formeDeveloppee.get(i).arrondir());
		}
		return polynome;
	}
}
