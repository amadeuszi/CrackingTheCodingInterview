
public class Node {
	Node next = null;
	int data;
	
	public Node(int x) {
		this.next = null;
		this.data = x;
	}
	
	public Node(int x, Node next) {
		this.next = next;
		this.data = x;
	}
}
