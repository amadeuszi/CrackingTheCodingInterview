
public class List {
	private Node head;
	private int length;
	
	public List() {
		this.head = null;
		this.length = 0;
	}
	
	public void add(int x) {
		this.length++;
		this.head = new Node(x, this.head);
	}
	
	public void addEnd(int x) {
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
			this.length--;
			return;
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
			this.length--;
		}
	}
	
	public int get(int n) {
		if (n < 0 ||  this.length <= n) {
			throw new RuntimeException();
		}
		int index = 0;
		Node iterator = this.head;
		while (iterator != null) {
			if (index == n) {
				break;
			}
			index++;
			iterator = iterator.next;
		}
		return iterator.data;
	}
	
	public int remove() {
		if (this.head == null) {
			throw new RuntimeException();
		}
		int d = this.head.data;
		this.head = this.head.next;
		this.length--;
		return d;
		
	}
	
	private List helper(int last, List first, List second, List result) {
		if (first.length() == 0 && second.length == 0) {
			return result;
		}
		else {
			int x1 = first.length() == 0 ? 0 : first.remove();
			int x2 = second.length() == 0 ? 0 : second.remove();
			result.add((x1 + x2 + last) % 10);
			return helper((x1 + x2 + last) / 10, first, second, result);
		}
	}
	
	public List addInteger(List l) {
		return helper(0, this, l, new List()).reverse();
	}
	
	public List reverse() {
		List result = new List();
		while (this.length > 0) {
			result.add(this.remove());
		}
		return result;
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
