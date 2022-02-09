package competitions;

import java.util.ArrayList;

import animals.Animal;
import animals.IAirAnimal;
import animals.ITerrestrialAnimals;
import animals.IWaterAnimal;
import graphics.IAnimal;
import graphics.Orientation;
import mobilty.Point;

public class CourierTournament extends Tournament{

	public CourierTournament(ArrayList<ArrayList<IAnimal>> arr) {
		super(arr);
	}

	@Override
	public void setUp(ArrayList<ArrayList<IAnimal>> arr) {
		BooleanClass startFlag= new BooleanClass();
		Scores scores=new Scores();
		
		double dis=0;
		
		
		String category="animal";
		
		
		for (int i=0;i< arr.size();i++) {
			int n=arr.get(i).size();
			BooleanClass [] flags=new BooleanClass[n];
			
			if (((Animal) arr.get(i).get(0)) instanceof IAirAnimal) {
				category="AirAnimal";
				dis=1030-45;
			}
			else if (((Animal) arr.get(i).get(0)) instanceof IWaterAnimal) {
				category="WaterAnimal";
				dis=945-100;
			}
			else if( ((Animal) arr.get(i).get(0)) instanceof ITerrestrialAnimals) {
				category="TerrestrialAnimals";
				dis=(1030-45)+ (750-10)+ (1030-45)+(750-10)  ;
			}
			
			
			for (int j=0;j<n;j++) {
				flags[j]=new BooleanClass();
			}
			
			if(arr.get(i).get(0) instanceof Animal) {
				new Thread(new AnimalThread((Animal)arr.get(i).get(0),dis/n,startFlag,flags[0])).start();
			}
			for (int j=1;j<n;j++) {
				if(arr.get(i).get(j) instanceof Animal) {
					change(arr.get(i).get(j),j,dis/n);
					new Thread(new AnimalThread((Animal)arr.get(i).get(j),dis/n,flags[j-1],flags[j])).start();
					
				}				
			}
			
			new Thread(new Referee(category, scores,flags[n-1])).start();

		}
		tournamentThread=new TournamentThread(scores,startFlag,arr.size());
		Thread t=new Thread(tournamentThread);
		t.start();
			
	}

	
	private void change(IAnimal a, int index,double partlydis) {
		Point p =null;
		int x=((Animal) a).getLocation().getX();
		int y=((Animal) a).getLocation().getY();
		if (a instanceof IAirAnimal || a instanceof IWaterAnimal) {
			p=new Point((int) (x+index*partlydis),y);
			((Animal) a).changeStart(p);
		}

		else if( a instanceof ITerrestrialAnimals) {
			double start=index*partlydis;
			if(start<=985) {
				p=new Point((int) (x+index*partlydis),y);
			}
			else if(start<=1725) {
				x=1100;
				p=new Point(x,(int) (y+start-985));
				((Animal) a).setOrien(Orientation.SOUTH);
			}
			else if(start<=2710) {
				y=750;
				p=new Point((int) (1030-(start-985-740)),y);
				((Animal) a).setOrien(Orientation.WEST);
			}			
			else if(start<=3450) {
				x=45;
				p=new Point(x,(int) (750-(start-985-740-985)));
				((Animal) a).setOrien(Orientation.NORTH);
			}			
			((Animal) a).changeStart(p);
		}
		
		
		
		
	}
}
