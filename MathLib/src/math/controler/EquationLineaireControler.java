package math.controler;

import math.entities.EquationLineaire;
import math.entities.mathobject.Matrice;
import math.service.EquationLineaireService;

public class EquationLineaireControler {
	/**
	 * Classe qui permet de le fonctionnement d'un objet LinearEquation
	 * 
	 * @author clément
	 *
	 */
	public class ControlerLinearEquation {
		public Matrice resolutionEquationLineaire(EquationLineaire equationLineaire){
			EquationLineaireService service = new EquationLineaireService();
			
			if(service.isHomogene(equationLineaire) && 
					equationLineaire.getTransformation().determinant().isNull()){
				return service.pivotGaussResolution(equationLineaire);
			}else{
				return service.cramerResolution(equationLineaire);
//				ServiceLinearEquation.matrixInversionResolution(equationLineaire);
			}
		}
	}
}
