package math.entities.mathobject;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import math.controler.Operation;
import math.entities.fonction.PuissanceN;
import math.fonction.analyse.semantique.FonctionParser.Reel_opContext;
import math.service.operation.Multiplication;

import org.antlr.v4.runtime.Token;

public class Polynome extends MathObject{
	//Forme principale
	public List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
	//Forme secondaire
	public List< List<MathObject>> formeFactorisee = new ArrayList<List<MathObject>>();
	
	private static Multiplication multiplicationService = new Multiplication();
	
	private Inconnue x = new Inconnue("x");
	
	public Polynome() {}
	
	/**
	 * Builder d'un polynome
	 * 
	 * @param List<Float> formeDeveloppee
	 * @param List< List<Float>> formeFactorisee
	 * @return Polynome polynome
	 */
	public Polynome(List<MathObject> formeDeveloppee, List< List<MathObject>> formeFactorisee){
		this.formeDeveloppee = formeDeveloppee;
		this.formeFactorisee = formeFactorisee;
	}
	
	/**
	 * Builder d'un polynome � partir d'un float
	 * @param value
	 * @return
	 */
	public Polynome(float value){
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		formeDeveloppee.add(new Reel(value));
		this.formeDeveloppee = formeDeveloppee;
	}
	
	/**
	 * Builder d'un polynome � partir d'un float
	 * @param value
	 * @return
	 */
	public Polynome(MathObject value){
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		formeDeveloppee.add(value);
		this.formeDeveloppee = formeDeveloppee;
	}
	
	/**
	 * Builder d'un polynome � partir de la forme developp�e
	 * 
	 * @param List<Float> formeDeveloppee
	 * @return Polynome polynome
	 */
	public Polynome(List<MathObject> formeDeveloppee){
		this.formeDeveloppee = formeDeveloppee;
		this.formeFactorisee = factoriser(formeDeveloppee);
	}

	public Polynome(List<Reel_opContext> valMath, List<Token> val, boolean ok) {
		int i = 0;
		for (Reel_opContext token : valMath) {
			char puissance = val.get(i).getInputStream().toString().charAt(val.get(i).getTokenIndex());
			this.formeDeveloppee.add(token.reel);
			
			i++;
		}
	}

	/**
	 * Builder d'un polynome � partir de la forme factoris�e
	 * 
	 * @param List< List<Float>> formeFactorisee
	 * @return Polynome polynome
	 */
	public Polynome buildPolynomeFromFactoriseForm(List< List<MathObject>> formeFactorisee){
		this.formeDeveloppee = developperNaif(formeFactorisee);
		this.formeFactorisee = formeFactorisee;
		return this;
	}
	
	/**
	 * M�thode de developpement de la forme factoris�e d'un polynome
	 * utilise la m�thode de multiplication de polynome naif (cf ServicePolynome.multiplication)
	 * 
	 * @param List<List<Float>> formeFactorisee
	 * @return List<Float> forme developp�e
	 */
	private List<MathObject> developperNaif(List<List<MathObject>> formeFactorisee){
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		for(List<MathObject> facteur: formeFactorisee){
			if(formeDeveloppee.size() == 0){
				formeDeveloppee = facteur;
			}else{
				try {
					formeDeveloppee = multiplicationService.multiplicationPolynome(facteur, formeDeveloppee);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return formeDeveloppee;
	}
	
	/**
	 * M�thode de factorisation de la forme developp�e d'un polynome
	 * 
	 * @param List<Float> formeDeveloppee
	 * @return List<List<Float>> forme factoris�e
	 */
	private List<List<MathObject>> factoriser(List<MathObject> formeDeveloppee2) {
		return new ArrayList<List<MathObject>>();
	}
	
	/**
	 * Copy un polynome pour un autre
	 * 
	 * @param polynomeB
	 * @return new polynome
	 */
	public void set(Polynome polynomeB){
		this.formeDeveloppee = polynomeB.formeDeveloppee;
		this.formeFactorisee = polynomeB.formeFactorisee;
	}
	
	/**
	 * R�cup�ration de la constante
	 * 
	 * @return constante
	 */
	public MathObject getConstant(){
		return this.formeDeveloppee.get(0);
	}
	
	/**
	 * Permet de determiner sur le polynome est nul
	 * 
	 * @return
	 */
	public boolean isNull(){
		return (this.getDegres()== 0)&&(((MathObject)this.formeDeveloppee.get(0)).isNull());
	}
	
	/**
	 * Permet de determiner si le polynome est �gal � un float
	 * 
	 * @param value
	 * @return
	 */
	public boolean isEqualsToReel(final Reel value){
		return (this.getDegres()== 0)&&(this.formeDeveloppee.get(0).equals(value));
	}
	
	/**
	 * Permet de determiner si deux polynomes sont �gaux
	 * 
	 * @param polynome
	 * @return
	 */
	public boolean isEqualsTo(final Polynome polynomeB){
		if(this.getDegres() != polynomeB.getDegres())
			return false;
		for (int i = 0; i < this.formeDeveloppee.size(); i++) {
			if(!this.formeDeveloppee.get(i).equals(polynomeB.formeDeveloppee.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * Permet de determiner si le polynome est �gal � un type float
	 * @param value
	 * @return
	 */
	public boolean isEqualsToReel() {
		if(getDegres() != 0)
			return false;
		return true;
	}
	
	/**
	 * M�thode retournant le degr�s d'un polynome
	 * 
	 * @return int degr�s
	 */
	public int getDegres(){
		return this.formeDeveloppee.size()-1;
	}
	
	public String toString(){
		String result = "";
		int i;
		for(i = 0; i < this.formeDeveloppee.size(); i++){
			if(this.formeDeveloppee.get(i).getClass()==Reel.class && ((Reel)this.formeDeveloppee.get(i)).reel > 0){
				result += "+"+this.formeDeveloppee.get(i)+"*x^"+i+" ";
			}else if(this.formeDeveloppee.get(i).getClass()==Reel.class && ((Reel)this.formeDeveloppee.get(i)).reel == 0){
				result += "+0*x^"+i+" ";
			}else{
				if(i!=0)result += "+";
				result += "("+this.formeDeveloppee.get(i)+")*x^"+i+" ";
			}
		}
		return result;
	}
	
	/**
	 * M�thode d'affichage d'une fonction polynomiale
	 */
	public void afficher(){
		afficherDeveloppeForm();
		afficherFactoriseForm();
		System.out.println("-------------------------------------");
	}
	
	/**
	 * M�thode d'affichage de la forme developp�e d'une fonction polynomiale
	 */
	public void afficherDeveloppeForm(){
		System.out.println("Forme developp�e: ");
		System.out.println(this.toString());
		System.out.println("");
	}
	
	/**
	 * M�thode d'affichage de la forme factoris�e d'une fonction polynomiale
	 */
	public void afficherFactoriseForm(){
		int i;
		System.out.println("Forme factoris�e: ");
		for(List<MathObject> factorisation: this.formeFactorisee){
			System.out.print("(");
			for(i = 0; i < factorisation.size(); i++){
				if(factorisation.get(i).getClass()==Reel.class && ((Reel)factorisation.get(i)).reel > 0){
					System.out.print("+"+factorisation.get(i)+"*x^"+i+" ");
				}else if(factorisation.get(i).getClass()==Reel.class && ((Reel)factorisation.get(i)).reel == 0){
					System.out.print("+0*x^"+i+" ");
				}else{
					System.out.print(factorisation.get(i)+"*x^"+i+" ");
				}
			}
			System.out.print(")");
		}
		System.out.println();
	}
	
	public boolean equals(IMathObject value) {
		if(value.getClass()!=Polynome.class){
			return false;
		}
		if(this==value){
			return true;
		}
		if(this.formeDeveloppee.size()!=((Polynome)value).formeDeveloppee.size()){
			return false;
		}
		int i = 0;
		for(MathObject mathObject : formeDeveloppee) {
			if(!mathObject.equals(((Polynome)value).formeDeveloppee.get(i))){
				return false;
			}
			i++;
		}
		return true;
	}

	public Polynome arrondir() {
		for (MathObject mathObject : formeDeveloppee) {
			mathObject.arrondir();
		}
		return this;
	}
	
	/**
	 * M�thode de d�rivation d'une fonction polynomiale
	 * 
	 * @return PolynomialEquation d�riv�e
	 */
	public Polynome deriver(){
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		int i;
		for (i = 1; i < this.formeDeveloppee.size(); i++) {
			formeDeveloppee.add(Operation.multiplier(new Reel(i), this.formeDeveloppee.get(i)));
		}
		return new Polynome(formeDeveloppee);
	}
	
	/**
	 * M�thode de d�rivation n i�me d'une fonction 
	 * 
	 * @param degres int
	 * @return PolynomialEquation d�riv�e ni�me
	 */
	public Polynome calculDeriveeN(int degres){
		List<MathObject> formeDeveloppee = new ArrayList<MathObject>();
		int i, j;
		int facteur;
		for (i = degres; i < this.formeDeveloppee.size(); i++) {
			facteur = 1;
			for (j = 0; j < degres; j++)
				facteur *= (i-j);
			formeDeveloppee.add(Operation.multiplier(new Reel(facteur), this.formeDeveloppee.get(i)));
		}
		return new Polynome(formeDeveloppee);
	}
	
	/**
	 * Methode de calcul de la valeur du polynome
	 * 
	 * @param valeur x
	 * @return float result
	 */
	@Override
	public MathObject calc(SimpleEntry<Inconnue, IMathObject>... val) {
		MathObject resultat = new Reel();
		int i;
		for (i = 0; i < this.formeDeveloppee.size(); i++) {
			resultat = Operation.additionner(resultat, Operation.multiplier(this.formeDeveloppee.get(i), new PuissanceN(x.calc(val), new Reel(i)).calc()));
		}
		return resultat;
	}
	
	/**
	 * Methode de calcul de la valeur du polynome
	 * 
	 * @param valeur x
	 * @return float result
	 */
	public MathObject calc(MathObject val) {
		MathObject resultat = new Reel();
		int i;
		for (i = 0; i < this.formeDeveloppee.size(); i++) {
			resultat = Operation.additionner(resultat, Operation.multiplier(this.formeDeveloppee.get(i), new PuissanceN(val, new Reel(i)).calc()));
		}
		return resultat;
	}
}
