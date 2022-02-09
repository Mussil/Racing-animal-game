package olympics;

//Immutable class
public class Medal {
	private TypeMedal type;
	private String tournament;
	private int year;
	
	
	public Medal() {
		this.type=TypeMedal.BRONZE;
		this.tournament="General";
		this.year=2020;
	}
	
	/** 
	 * @param _type ,bronze, silver, gold
	 * @param _tournament ,the tournament he won
	 * @param _year ,the year he won the medal
	 */
	public Medal(TypeMedal _type, String _tournament,int _year){
		this.type=(_type!=null)?_type:TypeMedal.BRONZE;
		this.tournament=(_tournament!=null)?_tournament:"General";
		this.year=(_year>2000) ? _year: 2020;
	}
	
	public String toString() {
		
		return "tournament: "+this.tournament+"\ntype: "+this.type+"\nyear: "+this.year;
	}
}
