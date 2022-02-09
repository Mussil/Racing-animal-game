
package animals;

import javax.swing.JPanel;

import graphics.ZooPanel;
import mobilty.Point;
import olympics.Medal;

public class Cat extends TerrestrialAnimals {
	private boolean Castrated;
	public Cat() {
		super();
	}
	
	
	public Cat(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position, int _noLegs,boolean _Castrated,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_noLegs,_maxEnergy,_energyPerMeter,_pan);
	}
	
	public String toString(){
		return super.toString()+"\nCastrated: "+Castrated;
	}
	
	protected  String animalName() {
		return "cat";
	}
	

	
	protected String animalSound() {
		return "Meow";
	}
}
