
public class Node {

	public Item data;
	public Node next; //refers to the next item in the list
	
	Node (Item data, Node next) {
		this.next = next;
		this.data = data.clone(); // deep copy
	}
}
