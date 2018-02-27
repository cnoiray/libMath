package math.entities;

import math.entities.mathobject.Matrice;

public class EquationLineaire {
	/**
	 * nombre de ligne pour l'équation linéaire
	 */
	private int nbr_ligne;
	/**
	 * nombre de colonne pour la matrice de transformation
	 */
	private int nbr_inconnue;
	/**
	 * matrice colonne B contennant les constantes
	 */
	private Matrice constante;
	/**
	 * matrice de transformation A tel que A*X=B
	 */
	private Matrice transformation;

	
	
	public EquationLineaire(Matrice transformation, Matrice constante) {
		this.constante = constante;
		this.transformation = transformation;
		
		nbr_ligne = constante.nb_ligne;
		nbr_inconnue = constante.nb_col;
	}

	public EquationLineaire() {
	}

	/**
	 * @return the nbr_ligne
	 */
	public int getNbr_ligne() {
		return nbr_ligne;
	}

	/**
	 * @param nbr_ligne the nbr_ligne to set
	 */
	public void setNbr_ligne(int nbr_ligne) {
		this.nbr_ligne = nbr_ligne;
	}

	/**
	 * @return the nbr_inconnue
	 */
	public int getNbr_inconnue() {
		return nbr_inconnue;
	}

	/**
	 * @param nbr_inconnue the nbr_inconnue to set
	 */
	public void setNbr_inconnue(int nbr_inconnue) {
		this.nbr_inconnue = nbr_inconnue;
	}

	/**
	 * @return the constante
	 */
	public Matrice getConstante() {
		return constante;
	}

	/**
	 * @param constante the constante to set
	 */
	public void setConstante(Matrice constante) {
		this.constante = constante;
	}

	/**
	 * @return the transformation
	 */
	public Matrice getTransformation() {
		return transformation;
	}

	/**
	 * @param transformation the transformation to set
	 */
	public void setTransformation(Matrice transformation) {
		this.transformation = transformation;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int i, j;
		for (i = 0; i < transformation.nb_ligne; i++) {
			stringBuilder.append("| ");
			for (j = 0; j < transformation.nb_col; j++){
				stringBuilder.append(transformation.getValue(i, j).toString());
				stringBuilder.append(" ");
			}
			stringBuilder.append("| ");
			stringBuilder.append(constante.getValue(i, 0).toString());
			stringBuilder.append(" |");
		}
		
		return stringBuilder.toString();
	}
	
	public EquationLineaire copy(){
		return new EquationLineaire(transformation.copy(), constante.copy());
	}
}
