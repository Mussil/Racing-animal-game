package animals;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import competitions.BooleanClass;
import graphics.CompetitionFrame;
import graphics.Orientation;
import graphics.ZooPanel;
import mobilty.Point;
import olympics.Medal;



public class WaterAnimal extends Animal implements IWaterAnimal{
	
	
	

	private static final int MAX_DIVE=-800;
	private double diveDept;
	protected BufferedImage  img3;
	
	
	public WaterAnimal() {
		super();
		dive(0);
	}
	
	public WaterAnimal(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position,double _diveDept,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,(_position!=null)?_position:new Point(50,0),_maxEnergy,_energyPerMeter,_pan);
		dive(_diveDept);
	}
	public String toString() {
		return super.toString()+"\ndiveDept: "+diveDept;
	}
	
	/**
	 * 
	 * @param _diveDept 
	 * @return true if the diveDept is above MAX_DIVE, and changes the diveDept
	 */
	private boolean dive(double _diveDept) {
		if (_diveDept<MAX_DIVE) {
			this.diveDept=MAX_DIVE;
			return false;
		}
		if (_diveDept>0) {
			this.diveDept=0;
			return false;
		}
		this.diveDept=_diveDept;
		return true;

	}
	
	protected  String animalName() {
		return "Water Animal";
	}
	
	protected Point defPosition() {
		return new Point(50,0);
	}
	
	
	

	public void drawObject (Graphics g)
	{
		if(orien==Orientation.EAST) // animal move to the east side
			g.drawImage(img1, getLocation().getX(), getLocation().getY()-size/10, size*2, size,pan);
		else if(orien==Orientation.WEST) // animal move to the west side
			g.drawImage(img3, getLocation().getX(), getLocation().getY()-size/10, size*2, size,pan);

	}
	
	
	

	
	public  void movement(BooleanClass finshFlag,double dis) {
	
		

		int x_end=(int) (getLocation().getX()+dis);
		int y_end=getLocation().getY();

		//while(getLocation().getX()!=x_end) {
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
					return;
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
