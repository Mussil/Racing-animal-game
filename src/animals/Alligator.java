
package animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import graphics.ZooPanel;
import mobilty.Point;
import olympics.Medal;

public class Alligator extends WaterAnimal implements IReptile, ITerrestrialAnimals,IWaterAnimal {
	private TerrestrialAnimals base_te;
	//private WaterAnimal base_wa;
	
	private String areaOfLiving  ;
	public Alligator() {
		super();
		base_te=new TerrestrialAnimals();
		this.areaOfLiving="south";
	}

	public Alligator(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _diveDept, String _areaOfLiving,int _noLegs,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_diveDept,_maxEnergy,_energyPerMeter,_pan);
		base_te=new TerrestrialAnimals(_name,_gender,_weight,_speed,_arrMedal,_position,_noLegs,_maxEnergy,_energyPerMeter,_pan);
		this.areaOfLiving=(_areaOfLiving!=null)?_areaOfLiving:"south";
	}
	public String toString() {
		return super.toString()+"\nArea Of Living: "+areaOfLiving+"\nnumber of legs: "+base_te.getNoLegs();
	}
	
	protected  String animalName() {
		return "alligator";
	}


	
	protected String animalSound() {
		return "Roar";
	}
	
	
	public boolean speedUp(int s) {
		double sum=s+getSpeed();
		if (sum>MAX_SPEED) {
			return false;
		}
		
		return setSpeed(sum);
	}
	
	

}
