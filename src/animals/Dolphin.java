
package animals;

import javax.swing.JPanel;

import graphics.ZooPanel;
import mobilty.Point;
import olympics.Medal;

public class Dolphin extends WaterAnimal {
	private Water waterType  ;
	
	
	public Dolphin() {
		super();
		this.waterType=Water.SEA;
	}
	public Dolphin(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _diveDept, Water _waterType,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_diveDept,_maxEnergy,_energyPerMeter,_pan);
		this.waterType=(_waterType!=null)?_waterType:Water.SEA;
	}
	public String toString() {
		return super.toString()+"\nWater Type "+waterType;
	}
	
	protected  String animalName() {
		return "dolphin";
	}


	
	protected String animalSound() {
		return "Click-click";
	}
	
}
