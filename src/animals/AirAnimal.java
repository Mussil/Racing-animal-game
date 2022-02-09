package animals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import competitions.BooleanClass;
import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class AirAnimal extends Animal implements IAirAnimal {

	private double wingspan; 
	
	
	public AirAnimal() {
		super();
		this.wingspan=0;
	}
	
	
	public AirAnimal(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position, double _wingspan,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,(_position!=null)?_position:new Point(0,100),_maxEnergy,_energyPerMeter,_pan);
		this.wingspan=(_wingspan>0)?_wingspan:0;
	}
	
	public String toString() {
		return super.toString()+"\nwingspan: "+wingspan;
	}
	protected  String animalName() {
		return "AirAnimal";
	}

	protected Point defPosition() {
		return new Point(0,100);
	}


	

	
	public void loadImages(String nm) {
		try { img1 = ImageIO.read(new File(nm+".png")); }
		catch (IOException e) { 
			System.out.println("Cannot load user image");			
			
			//deafult
			try { img1 = ImageIO.read(new File(deafultImages()+".png")); }
			catch (IOException e2) { 
				System.out.println("Cannot load image");
			}
		}
		
	}
	
	

	public  void movement(BooleanClass finshFlag,double dis) {
	
		

		int x_end=(int) (getLocation().getX()+dis);
		int y_end=getLocation().getY();

	    Timer timer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		int x=getLocation().getX();
	    		int y=getLocation().getY();
	    		Point p;

	    		
	    		int speed;
	    		
	    		
	    		if(energyAmount<=0) {
					try {
						Thread.sleep(sleep);
						System.out.println(getAnimalName()+" is sleeping");

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	    			//return;
	    		}
				if (energyAmount>=energyPerMeter*getSpeed()) {
					speed=(int) getSpeed();
				}
				else {
					speed=energyAmount-energyPerMeter;
				}
				
	        	if(x<x_end) {
				
	        		if (x+speed>=x_end) {
	        			speed=x_end-x;
	        		}
	        		
					p=new Point(x+speed,y); 
					move(p);
					energyAmount-=energyPerMeter*speed;
	        	}
	        	if(x==x_end) {
	        		synchronized(finshFlag) {
	        			finshFlag.setValue(true);
	        			finshFlag.notifyAll();
	        		}
	                ((Timer)e.getSource()).stop();
	        		return;
	        	}
	        	
	          pan.repaint();
	        }
	      });
	      timer.start();
		
	}






    
}
