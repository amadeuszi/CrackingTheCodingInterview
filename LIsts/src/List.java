
public class List {
	private Node head;
	private int length;
	
	public List() {
		this.head = null;
		this.length = 0;
	}
	
	public void add(int x) {
		this.length++;
		Node tmp = this.head;
		
		if (tmp == null) {
			this.head = new Node(x);
			return;
		}
		
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		
		tmp.next = new Node(x);
	}
	
	public void remove(int x) {
		if (this.head == null) {
			return;
		}
		
		if (this.head.data == x) {
			this.head = head.next;
		}
		
		Node iterator = this.head;
		
		while(iterator.next != null && iterator.next.data != x) {
			iterator = iterator.next;
		}
		
		if (iterator.next == null) {
			return;
		}
		
		if (iterator.next.data == x) {
			iterator.next = iterator.next.next;
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Node iterator = head;
		while(iterator != null) {
			builder.append(iterator.data);
			if (iterator.next != null) {
				builder.append(", ");
			}
			iterator = iterator.next;
		}
		builder.append("]");
		return builder.toString();
	}
	
	public int length() {
		return this.length;
	}
}
