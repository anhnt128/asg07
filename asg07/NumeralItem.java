
public class NumeralItem implements Item {

	private int value;
	
	public NumeralItem(int value) {
		this.value = value;
	}
	
	public Item clone() {
		return new NumeralItem(value);
	}
	
	public String toString() {
		return Integer.toString(value);
	}
	
	public boolean equals(Item item) {
		return this.toString().equals(item.toString());
	}
}