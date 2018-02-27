package math.service.operation;

import math.entities.mathobject.BinaryOperation;
import math.entities.mathobject.Complexe;
import math.entities.mathobject.MathObject;
import math.entities.mathobject.Reel;

public class Division {
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
}
