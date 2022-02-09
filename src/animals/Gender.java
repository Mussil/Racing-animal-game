package animals;

public enum Gender {

	MALE,
	FEMALE,
	HERMAPHRODITE;
	

    public static Gender fromInteger(int x) {
        switch(x) {
        case 0:
            return MALE;
        case 1:
            return FEMALE;
        case 2:
        	return HERMAPHRODITE;
        }
        return null;
    }
}
