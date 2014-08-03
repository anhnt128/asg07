
public class StringItem implements Item {
	
	private String value;
	
	public StringItem(String value) {
		this.value = value;
	}
	
	public Item clone() {
		return new StringItem(value);
	}
	
	public String toString() {
		return value;
	}
	
	public boolean equals(Item item) {
		return this.toString().equals(item.toString());
	}
}
