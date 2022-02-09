package mobilty;


//Immutable class
public class Point implements Cloneable {
	private int x;
	private int y;
	
	
	public Point() {
		this.x=0;
		this.y=0;
	}
	public Point(int _x,int _y) {
		this.x=(_x>=0) ? _x :0;
		this.y=(_y>=0) ? _y :0;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	
    public Object clone()throws CloneNotSupportedException{  
        return (Point)super.clone();  
    }
    
    
    
    
    
    
    public boolean equals(Object anObject) {  
        if (this == anObject) {  
            return true;  
        }  
        if (anObject instanceof Point) {  
            Point another = (Point) anObject;  
            if(another.getX()==this.getX() && another.getY()==this.getY()) {
             	return true;  
            }  
        }  
        return false;  
    }  
    
}
