package mobilty;

public abstract class Mobile implements ILocatable {
	private Point location;
	private double totalDistance;
	
	
	public Mobile(){
		//Because Point is immutable
		this.location=defPosition();
		this.totalDistance=0;
	}
	

	public Mobile(Point _location){
		//Because Point is immutable
		this.location=(_location!=null) ? _location : new Point(0,0);
		this.totalDistance=0;
	}
	
	/**
	 * 
	 * @param dis
	 * increases totalDistance after movement
	 */
	private boolean addTotalDistance(double dis) {
		if (dis<0)
			return false;
		totalDistance+=dis;
		return true;
	}
	
	public String toString() {
		return "location: "+location+" total distance: "+totalDistance;
	}
	/**
	 * 
	 * @param p , point
	 * @return distance between object to the point 
	 */
	private double calcDistance(Point p) {
		if (p==null){
			return 0;
		}
		int a=p.getX()-this.getLocation().getX();
		int b=p.getY()-this.getLocation().getY();
		return Math.sqrt(Math.pow(a,2)+Math.pow(b, 2));
	}
	

	
	@Override
	public Point getLocation() {
		//Because Point is immutable
		return location;
	}
	public double getTotalDistance() {
		return totalDistance;
	}


	@Override
	public boolean setLocation(Point p) {
		if (p==null){
			return false;
		}
		double a=this.calcDistance(p);
		this.addTotalDistance(a);
		//Because Point is immutable
		this.location=p;
		return true;
	}
	/**
	 * 
	 * @param p, change location to p
	 * @return totalDistance after the change 
	 */
	public double move(Point p) {
		double dis=calcDistance(p);
		this.setLocation(p);
		return dis;
	}

	
	public void changeStart(Point p) {
		try {
			this.location=(Point) p.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * virtual method that will be overridden and return the position of default
	 */
	protected Point defPosition() {
		return new Point(0,0);
	}
}
