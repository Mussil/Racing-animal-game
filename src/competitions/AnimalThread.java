package competitions;

import animals.*;

public class AnimalThread implements Runnable{
	
	private Animal participant;
	private double neededDistance;

	private BooleanClass startFlag;
	private BooleanClass finshFlag;
	
	public AnimalThread(Animal participant, double neededDistance,BooleanClass startFlag,BooleanClass finshFlag) {
		this.participant=participant;
		this.neededDistance=neededDistance;
		
		this.startFlag=startFlag;
		this.finshFlag=finshFlag;
		
	}
	
	@Override
	public void run() {

		synchronized(startFlag) {
			while (startFlag.isFalse()) {

				try {
					startFlag.wait();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	
		synchronized(participant){
			participant.movement(finshFlag,neededDistance);
		}

		
	}

	
}