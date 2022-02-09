
package competitions;


public class BooleanClass {

	private boolean value;
	
	public BooleanClass() {
		value=false;
	}
	public BooleanClass(boolean bol) {
		value=bol;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean bol) {
		value=bol;
	}
	
	
	public boolean isFalse() {
		return this.value==false;
	}
	public boolean equals(Object obj) {
		if (obj==null)
			return false;
		if (obj instanceof BooleanClass) {
			return ((BooleanClass) obj).getValue()==this.getValue();
		}

		return false;
	}

	public String toString() {
		return String.valueOf(value); 
	}
	
}