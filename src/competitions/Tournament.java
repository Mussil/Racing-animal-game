package competitions;

import java.util.ArrayList;

import graphics.*;

public abstract class Tournament {

	protected TournamentThread tournamentThread;
	
	public Tournament(ArrayList<ArrayList<IAnimal>> arr)  {
		this.tournamentThread=null;
		setUp(arr);
		
	}
	
	public TournamentThread getTournamentThread() {
		return tournamentThread;
	}
	
	public abstract void setUp(ArrayList<ArrayList<IAnimal>> arr);
}
