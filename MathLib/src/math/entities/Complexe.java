package math.entities;

import java.text.NumberFormat;
import java.text.ParseException;

import math.configuration.MathConf;

public class Complexe extends Reel{
	public float imaginaire;
	
	public Complexe() {
		super();
		this.imaginaire = 0;
	}

	public Complexe(float imaginaire) {
		super();
		this.imaginaire = imaginaire;
	}
	
	public Complexe(float reel, float imaginaire) {
		super(reel);
		this.imaginaire = imaginaire;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(reel!=0)
			builder.append(Float.toString(reel));
		if(imaginaire!=0){
			if(imaginaire>0 && reel!=0)
				builder.append("+");
			builder.append(Float.toString(imaginaire));
			builder.append("*i");
		}
		return builder.toString();
	}
	
	public boolean isNull(){
		return (reel==0) && (imaginaire==0);
	}
	
	public boolean equals(IMathObject value) {
		if(value.getClass()!=Complexe.class){
			return false;
		}
		if(this==value){
			return true;
		}
		if(this.reel == ((Complexe)value).reel){
			return true;
		}
		if(this.imaginaire == ((Complexe)value).imaginaire){
			return true;
		}
		return false;
	}

	public Complexe arrondir() {
		NumberFormat nf = NumberFormat.getInstance(MathConf.getLocal());
		try {
			float retourReel = nf.parse(MathConf.getDf().format(reel)).floatValue();
			if(retourReel == -0)
				retourReel = 0;
			reel = retourReel;
			
			float retourComplexe = nf.parse(MathConf.getDf().format(imaginaire)).floatValue();
			if(retourComplexe == -0)
				retourComplexe = 0;
			imaginaire = retourComplexe;
		} catch (ParseException e) {
			e.printStackTrace();
			reel = -100;
			imaginaire = -100;
		}
		return this;
	}
	
	@Override
	public MathObject eval() {
		if(imaginaire==0)
			return new Reel(reel);
		return this;
	}
}
