package math.entities.mathobject;

import java.text.NumberFormat;
import java.text.ParseException;

import math.configuration.MathConf;

public class Reel extends MathObject{
	public float reel;

	public Reel() {this.reel = 0;}
	
	public Reel(float reel) {
		super();
		this.reel = reel;
	}
	
	public Reel(String reel) {
		super();
		this.reel = Float.parseFloat(reel);
	}
	
	@Override
	public String toString() {
		return Float.toString(reel);
	}
	
	public boolean isNull(){
		return reel==0;
	}
	
	public boolean equals(IMathObject value) {
		if(value.getClass()!=Reel.class){
			return false;
		}
		if(this==value){
			return true;
		}
		if(this.reel == ((Reel)value).reel){
			return true;
		}
		return false;
	}
	
	public boolean inf(IMathObject value) {
		if(value.getClass()!=Reel.class){
			return false;
		}
		
		if(this.reel < ((Reel)value).reel){
			return true;
		}
		return false;
	}
	
	public boolean sup(IMathObject value) {
		if(value.getClass()!=Reel.class){
			return false;
		}
		if(this.reel > ((Reel)value).reel){
			return true;
		}
		return false;
	}
	
	public boolean equals(float value) {
		if(this.reel == value){
			return true;
		}
		return false;
	}

	public Reel arrondir() {
		NumberFormat nf = NumberFormat.getInstance(MathConf.getLocal());
		try {
			float retour = nf.parse(MathConf.getDf().format(reel)).floatValue();
			if(retour == -0)
				retour = 0;
			reel = retour;
		} catch (ParseException e) {
			e.printStackTrace();
			reel = -100;
		}
		return this;
	}
	
	public MathObject deriver(){
		return new Reel();
	}
}
