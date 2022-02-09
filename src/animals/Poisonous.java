package animals;

public enum Poisonous {
	LOW,MEDIUM,HIGH;
	
    public static Poisonous fromInteger(int x) {
        switch(x) {
        case 0:
            return LOW;
        case 1:
            return MEDIUM;
        case 2:
        	return HIGH;
        }
        return null;
    }
}
