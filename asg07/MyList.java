
public class MyList implements Item {

	private Node start;
	private Node end;
	
	public MyList() {
		start = null;
		end = null;
	}
	
	public void append(Item data) {
		Node node = new Node(data.clone(), null);
		if (start == null) {
			start = node;
			end = node;
		}
		else {
			end.next = node;
			end = node;
			end.next = null;
		}
	}
	
	public void appendList(MyList aL) {
		Node node = aL.start;
		while (node != null) {
			this.append(node.data.clone());
			node = node.next;
		}
	}
	
	public Item clone() {
		MyList list = new MyList();
		Node node = this.start;
		while (node != null) {
			list.append(node.data.clone());
			node = node.next;
		}
		return list;
	}
	
	public String toString() {
		String rsString = "(";
		Node node = this.start;
		while (node != end) {
			rsString = rsString + node.data.toString() + ", ";	
			node = node.next;
		}
		rsString = rsString + node.data.toString() + ")";
		return rsString;
	}
	
	public int length() {
		int length = 0;
		Node node = this.start;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
	
	public boolean equals(Item item) {
		return this.toString().equals(item.toString());
	}
	
	public Item find(Item key) {
		String keyString = key.toString();
		Node node = this.start;
		while ((node != null) && (node.data.toString().equals(keyString))) {
			node = node.next;
		}
		return node.data;
	}

	private void addInvert(Node head) {
	  if (head != null) {
	     addInvert(head.next);
		 append(head.data);
	  }
    }
	
	public void invert() {
	    Node head = start;
		start = end = null;
		addInvert(head);
	}
	
	public static void main(String args[]) {
	
		MyList l = new MyList();
		l.append(new NumeralItem(1)); 
		l.append(new NumeralItem(2));
		System.out.println(l); // (1, 2)
		MyList l2 = new MyList();
		l2.append(new StringItem("a")); 
		l2.append(new StringItem("b"));
		System.out.println(l2); // (a, b)
		l.append(l2);
		System.out.println(l + " length = " + l.length()); // (1, 2, (a, b))
		l.appendList(l2);
		
		System.out.println(l + " length = " + l.length()); // (1, 2, (a, b), a, b)
		l2.append(new NumeralItem(5));
		System.out.println(l2); // (a, b, 5)
		
		MyList l3= new MyList();
		l3.append(new StringItem("a")); 
		l3.append(new StringItem("b"));
		l3.append(new StringItem("4"));
		System.out.println(l3.length() + " lll " + l2.length()); 
		System.out.println(l3.equals(l2));
		
		System.out.println(l); // (1, 2, (a, b), a, b)
		l.invert();
		System.out.println(l); // (b, a, (a, b), 2, 1)
	}	
}


