import java.util.Stack;

public class MyQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public MyQueue() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
	
	public void add(int x) {
		stack1.add(x);
	}
	
	public void change() {
		while(!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
	}
	
	public int remove() {
		if (stack2.isEmpty()) {
			change();
		}
		if (stack2.isEmpty()) {
			throw new RuntimeException();
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.add(23);
		queue.add(57);
		queue.add(42);
		System.out.println(queue.remove());
		queue.remove();
		queue.add(17);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
	}
}
