package animals;

public enum Water {
	SEA,
	SWEET;
	
	
    public static Water fromInteger(int x) {
        switch(x) {
        case 0:
            return SEA;
        case 1:
            return SWEET;
        }
        return null;
    }
}
