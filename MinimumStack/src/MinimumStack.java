import java.util.Stack;

public class MinimumStack {
	private Stack<Pair> stack;
	
	public MinimumStack() {
		this.stack = new Stack<Pair>();
	}
	
	public void add(int x) {
		if (stack.isEmpty()) {
			stack.add(new Pair(x, x));
			return;
		}
		Pair atStack = stack.peek();
		
		int min = atStack.second();
		
		stack.add(new Pair(x, Math.min(x, min)));
	}
	
	public int pop() {
		if (stack.isEmpty()) {
			throw new RuntimeException();
		}
		return this.stack.pop().first();
	}
	
	public int min() {
		if (stack.isEmpty()) {
			throw new RuntimeException();
		}
		return this.stack.peek().second();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public static void main(String[] args) {
		MinimumStack stack = new MinimumStack();
		stack.add(2);
		System.out.println(stack);
		stack.add(3);
		System.out.println(stack);
		stack.add(5);
		System.out.println(stack);
		stack.add(1);
		System.out.println(stack);
		System.out.println("Minimum: " + stack.min());
		System.out.println(stack);
		System.out.println("Popping: " + stack.pop());
		System.out.println(stack);
	}
}
