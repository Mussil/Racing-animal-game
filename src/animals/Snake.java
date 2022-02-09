package animals;
import javax.swing.JPanel;

import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class Snake extends TerrestrialAnimals implements IReptile{
	private Poisonous poisonous ;
	private double length;
	
	
	public Snake() {
		super();
		this.length=0;
		this.poisonous=Poisonous.LOW;
	}
	public Snake(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position, int _noLegs,Poisonous _poisonous, double _length,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_noLegs,_maxEnergy,_energyPerMeter,_pan);
		this.length=(_length>0)?_length:0;
		this.poisonous=(_poisonous!=null)?_poisonous:Poisonous.LOW;
	}
	
	public String toString(){
		return super.toString()+"\npoisonous: "+poisonous+"\nlength: "+length;
	}
	
	protected  String animalName() {
		return "snake";
	}
	

	
	protected String animalSound() {
		return "ssssssss";
	}
	
	
	public boolean speedUp(int s) {
		double sum=s+getSpeed();
		if (sum>MAX_SPEED) {
			return false;
		}
		
		return setSpeed(sum);
	}

}

