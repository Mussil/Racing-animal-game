
package competitions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class Scores {

	private Map<String, Date> scores;
	
	public Scores() {
		scores=Collections.synchronizedMap(new HashMap());
	}
	
	public void add(String name) {
		synchronized(scores){
			scores.put(name,new Date());
		}
	}
	
	public Map<String, Date> getAll(){
		return scores;
	}
	
	
}