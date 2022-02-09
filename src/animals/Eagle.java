package animals;
import javax.swing.JPanel;

import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class Eagle extends AirAnimal {
	private double altitudeOfFlight;
	private static final int MAX_ALTITUDE =1000;
	
	public Eagle() {
		super();
		altitude(0);
	}
	public Eagle(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _wingspan, double _altitudeOfFlight,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,_position,_wingspan,_maxEnergy,_energyPerMeter,_pan);
		altitude(_altitudeOfFlight);
	}
	
	private boolean altitude(double _altitudeOfFlight) {
		if (_altitudeOfFlight>MAX_ALTITUDE) {
			this.altitudeOfFlight=MAX_ALTITUDE;
			return false;
		}
		if (_altitudeOfFlight<0) {
			this.altitudeOfFlight=0;
			return false;
		}
		this.altitudeOfFlight=_altitudeOfFlight;
		return true;
	}
	public String toString() {
		return super.toString()+"\nAltitude Of Flight: "+altitudeOfFlight;
	}
	
	
	protected  String animalName() {
		return "eagle";
	}
	

	
	protected String animalSound() {
		return "Clack-wack-chack";
	}
	


	
	
	
}
