package animals;
import javax.swing.JPanel;

import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class Pigeon extends AirAnimal {
	private String family;

	
	public Pigeon() {
		super();
		this.family="pige";
		}
	
	public Pigeon(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _wingspan, String  _family,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_wingspan,_maxEnergy,_energyPerMeter,_pan);
		this.family=(_family!=null)?_family:"pige";
		}
	

	public String toString() {
		return super.toString()+"\nfamily: "+family;
	}
	protected  String animalName() {
		return "pigeon";
	}

	
	protected String animalSound() {
		return "Arr-rar-rar-rar-raah";
	}
	
	public String deafultImages() {
		return animalName();
	}

}
