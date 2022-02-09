
package animals;

import javax.swing.JPanel;

import graphics.ZooPanel;
import mobilty.Point;
import olympics.Medal;

public class Dog extends TerrestrialAnimals {
	
	private String breed;
	
	public Dog() {
		super();
		this.breed="poodle";
	}
	
	
	public Dog(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position, int _noLegs,String _breed,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_noLegs,_maxEnergy,_energyPerMeter,_pan);
		this.breed=(_breed!=null)?_breed:"poodle";
	}
	
	public String toString(){
		return super.toString()+"\nbreed: "+breed;
	}
	
	protected  String animalName() {
		return "dog";
	}


	
	protected String animalSound() {
		return "Woof Woof";
	}
}
