
package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import competitions.BooleanClass;
import graphics.*;
import mobilty.Mobile;
import mobilty.Point;
import olympics.Medal;

public abstract class Animal extends Mobile  implements Cloneable,IAnimal ,IDrawable{
	private String name;
	private Gender gender;
	private double weight;
	private double speed;
	private Medal [] arrMedal;
	//private Point position;
	
	//HW2
	protected final int size=65;
	protected Orientation orien=Orientation.EAST;
	protected int maxEnergy;
	protected int energyPerMeter;
	protected ZooPanel pan;
	protected BufferedImage img1;
	
	protected int energyAmount;
	private int energyConsumption;

	
	protected static int sleep=200;
	
	public Animal() {
		super();
		this.name="Natural";
		this.gender=Gender.FEMALE;
		this.weight=1;
		this.speed=1;
		arrMedal=new Medal[0];

			
	}
	
	/**
	 * 
	 * @param _name , the name of the animal
	 * @param _gender 
	 * @param _weight 
	 * @param _speed
	 * @param _arrMedal
	 * @param _position , the current location
	 */
	public Animal(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_position);
        Random rand = new Random(); 
        int rand_int1 = rand.nextInt(100); 

		this.name=(_name!=null)?_name:"Natural"+String.valueOf(rand_int1);
		this.gender=(_gender!=null)?_gender:Gender.FEMALE;
		this.weight=(_weight>0)?_weight:1;
		this.speed=(_speed>0)?_speed:1;
		if (_arrMedal==null)
			_arrMedal=new Medal[0];
		arrMedal=new Medal[_arrMedal.length];
		for (int i=0; i<arrMedal.length;i++) {
			//Because Medal class is immutable
			arrMedal[i]=_arrMedal[i];
		}

		this.maxEnergy=(_maxEnergy>0)?_maxEnergy:10000;
		this.energyPerMeter=(_energyPerMeter>0)?_energyPerMeter:1;
		
		this.energyAmount=0;
		this.energyConsumption=0;
		
		
		this.pan=_pan;
		
		loadImages(name);
		
		
		
	}
	public void makeSound() {
		System.out.println("Animal "+animalName()+" says "+animalSound());
	}
	public String toString() {
		String x="name: "+name+"\ngender: "+gender+"\nweight: "+weight+"\nspeed: "+speed+"\narr Medal:\n";
		for (int i=0;i<arrMedal.length;i++) {
			x+=arrMedal[i].toString()+"\n";
		}
		x+="position: "+super.toString();
		return x;
	}
	
	protected abstract String animalName();
	
	public String getAnimalName() {
		return name;
	}
	
	
	
	protected String animalSound() {
		return "sound of animal";
	}
	
	public double getSpeed() {
		return speed;
	}
	protected boolean setSpeed(double s) {
		if (s>0) {
			this.speed=s;
			return true;
		}
		this.speed=0;
		return false;
	}
	
	//HW2
    public Object clone()throws CloneNotSupportedException{  
        return (Animal)super.clone();  
    }
    
    /**
     * get energy and feed the animal if it less than maxEnergy 
     */
	public boolean eat(int energy) {
		if (energy+energyAmount<=maxEnergy) {

			energyAmount+=energy;
			energyConsumption+=energy;

			return true;
		}
		energyAmount=maxEnergy;
		energyConsumption+=maxEnergy;

		return false;
	}

	/**
	 * 
	 * @return the animal file name for the picture
	 * use this method when the user input name is not correct
	 */
	public String deafultImages() {
		return animalName()+"1";
	}
	
	
	public void loadImages(String nm) {
		try { img1 = ImageIO.read(new File(nm+"E.png")); }
		catch (IOException e) { 
			System.out.println("Cannot load user image");			
			
			//deafult= if user input is not correct
			try { img1 = ImageIO.read(new File(deafultImages()+"E.png")); }
			catch (IOException e2) { 
				System.out.println("Cannot load image");
			}
		}
		
	}
	
	
	public void drawObject (Graphics g)
	{
		if(orien==Orientation.EAST) // animal move to the east side
			g.drawImage(img1, getLocation().getX(), getLocation().getY()-size/10, size*2, size,pan);

	}
    
	
	
	/**
	 * 
	 * @return an array of String, that will be used in the information table
	 */
	public String[][] makeTableInfo(){
		String category;
		if (this instanceof IAirAnimal) {
			category="AirAnimal";
		}
		else if (this instanceof IWaterAnimal) {
			category="WaterAnimal";
		}
		else if( this instanceof ITerrestrialAnimals) {
			category="TerrestrialAnimals";

		}
		else
			category="Unknown";
		
		
		String[][] entries = {{this.getAnimalName(),category,animalName(),
			String.valueOf(getSpeed()),String.valueOf(energyAmount),String.valueOf(getTotalDistance()),String.valueOf(energyConsumption)}, }; 
		return entries;
	}
	
	
	public abstract void movement(BooleanClass finshFlag, double dis);


	public int getEnergyAmount() {
		return energyAmount;
	}

	public static void setSleep(int time) {
		sleep=time;
	}
	
	
	public void setOrien(Orientation orien) {
		this.orien=orien;
	}
}
