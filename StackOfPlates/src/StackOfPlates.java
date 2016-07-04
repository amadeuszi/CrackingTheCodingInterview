import java.util.Stack;

public class StackOfPlates {
	private Stack<Stack<Integer>> list;
	int n;
	
	public StackOfPlates(int n) {
		if (n < 1) {
			throw new RuntimeException();
		}
		this.n = n;
		this.list = new Stack<Stack<Integer>>();
		Stack<Integer> s = new Stack<Integer>();
		list.add(s);
	}
	
	public void add(int x) {
		Stack<Integer> s = this.list.peek();
		s.add(x);
		if (s.size() == n) {
			this.list.add(new Stack<Integer>());
		}
	}
	
	public int remove() {
		if (list.isEmpty()) {
			throw new RuntimeException();
		}
		
		if (list.peek().isEmpty()) {
			list.pop();
		}
		return this.list.peek().pop();
	}
	
	public String toString() {
		return this.list.toString();
	}
	
	public static void main(String[] args) {
		StackOfPlates stack = new StackOfPlates(2);
		stack.add(1);
		stack.add(2);
		System.out.println(stack);
		stack.remove();
		System.out.println(stack);
	}
}
