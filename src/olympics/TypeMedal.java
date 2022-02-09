package olympics;


public enum TypeMedal {
	BRONZE,
	SILVER,
	GOLD;
	
	
    public static TypeMedal fromInteger(int x) {
        switch(x) {
        case 0:
            return BRONZE;
        case 1:
            return SILVER;
        case 2:
        	return GOLD;
        }
        return null;
    }
}
