package math.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import math.draw.Coordonnee;
import math.entities.mathobject.Fonction;
import math.entities.mathobject.IMathObject;
import math.entities.mathobject.Inconnue;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;
import math.fonction.analyse.semantique.FonctionLexer;
import math.fonction.analyse.semantique.FonctionParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class MainService {
	public MathObject analyse(String val){
		ANTLRInputStream input = new ANTLRInputStream(val);
		FonctionLexer lexer = new FonctionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FonctionParser parser = new FonctionParser(tokens);
		MathObject tree = parser.fonction_statement().op;
		return tree;
	}
	
	public MathObject evaluer(MathObject tree){
		return tree.eval();
	}
	
	public MathObject calculer(MathObject tree, SimpleEntry<Inconnue, IMathObject>... val){
		return tree.calc(val);
	}
	
	public List<Coordonnee> draw(MathObject mathObject, float begin, float end, float nbPoint){
		List<Coordonnee> retourList = new ArrayList<>();
		float echelle = (end-begin)/nbPoint;
		for(float i=begin;i<end;i=i+echelle){
			Inconnue inconnue = new Inconnue("x");
			
			MathObject retour = mathObject.calc(new SimpleEntry<>(inconnue, new Reel(i)));
			if(retour.getClass()==Reel.class){
				retourList.add(new Coordonnee(i, ((Reel)retour).reel));
			}else{
				retourList.add(new Coordonnee(i, 0f));
			}
		}
		return retourList;
	}
}
