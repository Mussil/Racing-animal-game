
package mobilty;

public interface ILocatable {
	public Point getLocation();
	/**
	 * 
	 * @param p , change location to p and increase the totalDistance
	 * @return true if p!=null
	 */
	public boolean setLocation(Point p);
}
