package animals;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import competitions.BooleanClass;
import graphics.Orientation;
import graphics.ZooPanel;
/**
 * Chaya levin 211397757
 */
import mobilty.Point;
import olympics.Medal;

public class TerrestrialAnimals extends Animal implements ITerrestrialAnimals {
	private int noLegs;
	protected BufferedImage  img2, img3, img4;

	public TerrestrialAnimals() {
		super();
		this.noLegs=2;
	}
	
	public TerrestrialAnimals(String _name, Gender _gender, double _weight, double _speed, Medal [] _arrMedal, Point _position, int _noLegs,int _maxEnergy, int _energyPerMeter,ZooPanel _pan) {
		super(_name,_gender,_weight,_speed,_arrMedal,(_position!=null)?_position:new Point(0,20),_maxEnergy,_energyPerMeter,_pan);
		this.noLegs=(_noLegs>=0)?_noLegs:2;
	}
	
	public String toString() {
		return super.toString()+"\nnumber of legs: "+noLegs;
	}
	/**
	 * this is a virtual method
	 * when a default constructor will call d-ctor of mobile,
	 * it will call defPostion method and the this one will work
	 */
	protected Point defPosition() {
		return new Point(0,20);
	}
	
	protected  String animalName() {
		return "Terrestrial Animals";
	}
	
	public int getNoLegs() {
		return noLegs;
	}
	


	/**
	 * override of the method because ter animal has 4 images  
	 */
	public void loadImages(String nm) {
		super.loadImages(nm+"E.png");
		try { img2 = ImageIO.read(new File(nm+"S.png")); }
		catch (IOException e) { 
			System.out.println("Cannot load user image");
			//deafult
			try { img2 = ImageIO.read(new File(deafultImages()+"S.png")); }
			catch (IOException e2) { 
				System.out.println("Cannot load image");
			}
		}
		try { img3 = ImageIO.read(new File(nm+"W.png")); }
		catch (IOException e) {
			System.out.println("Cannot load user image");
			//deafult
			try { img3 = ImageIO.read(new File(deafultImages()+"W.png")); }
			catch (IOException e2) { 
				System.out.println("Cannot load image");
			}
		}
		try { img4 = ImageIO.read(new File(nm+"N.png")); }
		catch (IOException e) { 
			System.out.println("Cannot load user image");
			//deafult
			try { img4 = ImageIO.read(new File(deafultImages()+"N.png")); }
			catch (IOException e2) { 
				System.out.println("Cannot load image");
			}
		}
		
		
	}
	

	
	public void drawObject (Graphics g)
	{
		if(orien==Orientation.EAST) // animal move to the east side
			g.drawImage(img1, getLocation().getX(), getLocation().getY()-size/10, size*2, size,pan);
		else if(orien==Orientation.SOUTH) // animal move to the south side
			g.drawImage(img2,getLocation().getX(), getLocation().getY()-size/10, size, size,pan);
		else if(orien==Orientation.WEST) // animal move to the west side
			g.drawImage(img3, getLocation().getX(), getLocation().getY()-size/10, size*2, size,pan);
		else if(orien==Orientation.NORTH) // animal move to the north side
			g.drawImage(img4, getLocation().getX()-size/2, getLocation().getY()-size/10, size,size*2, pan);
	}
	
	
	
	

public  void movement(BooleanClass finshFlag, double dis) {
	
		
		double[] mutable = {dis};
		
		int x_end=45;
		int y_end=10;

	    Timer timer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		int x=getLocation().getX();
	    		int y=getLocation().getY();
	    		Point p = null;
	    		int speed;
	    		
	    		//boolean flag=true;

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

				
				if(mutable[0]<=0) {
					synchronized(finshFlag) {
						finshFlag.setValue(true);
						finshFlag.notifyAll();
					}
					((Timer)e.getSource()).stop();
					return;
				}
				
				if (speed>0) {
					x=getLocation().getX();
					y=getLocation().getY();
					mutable[0]-=speed;
					if(orien==Orientation.EAST && x<1030) {
						p=new Point((x+speed),y); 
						if(x+speed>=1030) {
							orien=Orientation.SOUTH;
							p=new Point(1100,y); 
						}
						
					}
					else if(orien==Orientation.SOUTH && y<750) {
						p=new Point(x,y+speed); 
						if(y+speed>=750) {
							orien=Orientation.WEST;
							p=new Point(x,750); 

						}

					}
					else if(orien==Orientation.WEST && x>x_end) {
						p=new Point(x-speed,y); 
						if(x-speed<=x_end) {
							orien=Orientation.NORTH;
							p=new Point(50,y); 

						}
					}
					else if(orien==Orientation.NORTH && y>y_end-speed) {
						p=new Point(x,y-speed);
						if(y<=y_end+100) {
							p=new Point(x_end,10); 
							move(p);
							energyAmount-=energyPerMeter*getSpeed();
							//flag=false;
							synchronized(finshFlag) {
								finshFlag.setValue(true);
								finshFlag.notifyAll();
							}
							((Timer)e.getSource()).stop();
							return;
						}
					}

				move(p);
				energyAmount-=energyPerMeter*getSpeed();
			}
			
				
				
		
	        	
	        	
	          pan.repaint();
	        }
	      });
	      timer.start();
		
	}

	
	
	
	
//
//public  void movement(BooleanClass finshFlag) {
//	
//		
//
//		int x_end=getLocation().getX();
//		int y_end=getLocation().getY();
//
//	    Timer timer = new Timer(100, new ActionListener() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	    		int x=getLocation().getX();
//	    		int y=getLocation().getY();
//	    		Point p = null;
//	    		int speed;
//
//	    		boolean flag=true;
//
//	    		while(energyAmount<=0) {
//					try {
//							this.wait();
//						
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//	    		}
//	    		//else {
//				if (energyAmount>=energyPerMeter*getSpeed()) {
//					speed=(int) getSpeed();
//				}
//				else {
//
//					speed=energyAmount-energyPerMeter;
//				}
//
//
//				
//				if (flag &&speed>0) {
//					x=getLocation().getX();
//					y=getLocation().getY();
//					if(orien==Orientation.EAST && x<1030) {
//						p=new Point((x+speed),y); 
//						if(x+speed>=1030) {
//							orien=Orientation.SOUTH;
//							p=new Point(1100,y); 
//						}
//					}
//					else if(orien==Orientation.SOUTH && y<750) {
//						p=new Point(x,y+speed); 
//						if(y+speed>=750) {
//							orien=Orientation.WEST;
//							p=new Point(x,750); 
//
//						}
//
//					}
//					else if(orien==Orientation.WEST && x>x_end) {
//						p=new Point(x-speed,y); 
//						if(x-speed<=x_end) {
//							orien=Orientation.NORTH;
//							p=new Point(50,y); 
//
//						}
//					}
//					else if(orien==Orientation.NORTH ) {
//						if(y>y_end) {
//							p=new Point(x,y-speed);
//
//
//						}
//
//						if(y<=y_end) {
//
//						
//							flag=false;
//							synchronized(finshFlag) {
//								finshFlag.setValue(true);
//								finshFlag.notifyAll();
//							}
//							((Timer)e.getSource()).stop();
//							return;
//						}
//
//					}
//
//
//				move(p);
//				energyAmount-=energyPerMeter*getSpeed();
//				}
//			
//			
//				
//				
//		
//	        	
//	        	
//	          pan.repaint();
//	        }
//	      });
//	      timer.start();
//		
//	}



	
}
