package competitions;

import java.util.ArrayList;

import animals.*;
import graphics.IAnimal;

public class RegularTournament extends Tournament {

	public RegularTournament(ArrayList<ArrayList<IAnimal>> arr) {
		super(arr);
	}



	@Override
	public void setUp(ArrayList<ArrayList<IAnimal>> arr) {
		BooleanClass startFlag= new BooleanClass();
		Scores scores=new Scores();
		int dis=0;
		String category="animal";
		
		
		for (int i=0;i< arr.size();i++) {
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
				dis=(1030-0)+ (750-10)+ (1030)+(750-10)  ;
			}
			BooleanClass finalFlag= new BooleanClass();
			
			if(arr.get(i).get(0) instanceof Animal) {
				new Thread(new AnimalThread((Animal)arr.get(i).get(0),dis,startFlag,finalFlag)).start();
			}
			new Thread(new Referee(category, scores,finalFlag)).start();
			
		}
		tournamentThread=new TournamentThread(scores,startFlag,arr.size());
		Thread t=new Thread(tournamentThread);
		t.start();
		
	}

}
