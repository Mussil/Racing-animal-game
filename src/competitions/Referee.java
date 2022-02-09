package competitions;

import java.util.Date;
import java.util.Map;

public class Referee implements Runnable {

	private Scores scores;
	private String name;
	private BooleanClass finalFlag;
	
	public Referee(String name,Scores scores,BooleanClass finalFlag) {
		this.scores=scores;
		this.name=name;
		this.finalFlag=finalFlag;
	}
	
	@Override
	public void run() {
		
		while(finalFlag.isFalse()) {
			try {
				synchronized(finalFlag){
					finalFlag.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		scores.add(name);
		
	}

}



