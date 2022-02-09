package animals;
import javax.swing.JPanel;

import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class Whale extends WaterAnimal {
	
	private String foodType  ;
	
	public Whale() {
		super();
		this.foodType="south";
	}
	
	public Whale(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _diveDept, String _foodType,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_diveDept,_maxEnergy,_energyPerMeter,_pan);
		this.foodType=(_foodType!=null)?_foodType:"south";
	}
	public String toString() {
		return super.toString()+"\nfood Type: "+foodType;
	}
	
	protected  String animalName() {
		return "whale";
	}
	

	
	protected String animalSound() {
		return "Splash";
	}
	public String deafultImages() {
		return animalName();
	}

}
