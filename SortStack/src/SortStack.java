import java.util.Stack;

public class SortStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public SortStack(Stack<Integer> unsorted) {
		if (unsorted == null) {
			throw new RuntimeException();
		}
		stack1 = unsorted;
		stack2 = new Stack<Integer>();
		sort();
	}
	
	private void sort() {
		if (stack1.isEmpty()) {
			return;
		}
		while(!stack1.isEmpty()) {
			int adding = stack1.pop();
			
			if (stack2.isEmpty()) {
				stack2.add(adding);
				continue;
			}
			
			while (!stack2.isEmpty() && adding < stack2.peek()) {
				stack1.add(stack2.pop());
			}
			
			stack2.add(adding);
		}
	}
	
	public Stack<Integer> sorted() {
		return stack2;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(5);
		stack.add(7);
		stack.add(1);
		stack.add(0);
		
		System.out.println((new SortStack(stack)).sorted().toString());
	}
}
