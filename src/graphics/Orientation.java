package graphics;


public enum Orientation {
	EAST,WEST,SOUTH,NORTH;
	
    public static Orientation fromInteger(int x) {
        switch(x) {
        case 0:
            return EAST;
        case 1:
            return WEST;
        case 2:
        	return SOUTH;
        
        case 3:
        	return NORTH;
        }
        return null;
    }
}
