
public class Stacks {
	private int[] starts;
	private int[] ends;
	private int[] stacks;
	
	public Stacks(int n) {
		if (n < 2) {
			throw new RuntimeException();
		}
		this.stacks = new int[3 * n];
		this.starts = new int[]{0, n, 2 * n};
		this.ends = new int[]{-1, n - 1, 2 * n - 1};
	}
	
	public void add(int stack, int data) {
		this.ends[stack]++;
		for (int i = 0; i < 3; i++) {
			if (i == stack) {
				continue;
			}
			if (starts[i] == ends[stack] || (stack == ends.length - 1 && ends[stack] == stacks.length)) {
				this.ends[stack]--;
				this.enlargeStack();
				add(stack, data);
				return;
			}
		}
		this.stacks[ends[stack]] = data;
	}
	
	private void enlargeStack() {
		int newLength = 2 * this.stacks.length;
		int[] newStacks = new int[newLength];
		int n = starts.length;
		
		if (n < 1) {
			throw new RuntimeException();
		}
		
		int elements = 0;
		int[] howMany = new int[n];
		for (int i = 0; i < n; i++) {
			elements += ends[i] + 1;
			howMany[i] += ends[i] + 1;
		}
		for (int i = 0; i < 3; i++) {
			elements -= starts[i];
			howMany[i] -= starts[i];
		}
		
		int empty = (newLength - elements) / 3;
		
		int[] newStarts = new int[n];
		newStarts[0] = 0;
		int acu = 0;
		for (int i = 1; i < n; i++) {
			acu += howMany[i - 1];
			newStarts[i] = acu + i * empty;
		}
		
		int[] newEnds  = new int[n];
		for (int i = 0; i < n; i++) {
			newEnds[i] = newStarts[i] + howMany[i] - 1;
		}
		
		for (int i = 0; i < n; i++) {
			copyArray(newStacks, stacks, newStarts[i], newEnds[i], starts[i], ends[i]);
		}
		stacks = newStacks;
		starts = newStarts;
		ends = newEnds;
	}
	private static void copyArray(int[] array1, int[] array2, int x, int y, int a, int b) {
		if (y - x != b - a) {
			throw new RuntimeException();
		}
		if (x > y) {
			return;
		}
		int length = y - x + 1;
		for (int i = 0; i < length; i++) {
			array1[x + i] = array2[a + i];
		}
	}
	public String toString() {
		StringBuilder builder = new StringBuilder(stacks.length * 3 + 5);
		builder.append("[");
		for (int i = 0; i < stacks.length - 1; i++) {
			builder.append(stacks[i] + ", ");
		}
		builder.append(stacks[stacks.length - 1]);
		builder.append("]");
		return builder.toString();
	}
	public static void main(String[] args) {
		Stacks stack = new Stacks(2);
		stack.add(0, 1);
		System.out.println(stack);
		stack.add(2, 3);
		System.out.println(stack);
		stack.add(2, 3);
		System.out.println(stack);
		stack.add(2, 3);
		System.out.println(stack);
		stack.add(2, 3);
		System.out.println(stack);
		stack.add(0, 4);
		System.out.println(stack);
		stack.add(0, 5);
		System.out.println(stack);
		stack.add(0, 11);
		System.out.println(stack);
		stack.add(0, 29);
		System.out.println(stack);
		stack.add(0, 42);
		System.out.println(stack);
		stack.add(0, 1);
		System.out.println(stack);
		stack.add(0, 4);
		System.out.println(stack);
		stack.add(0, 5);
		System.out.println(stack);
		stack.add(0, 11);
		System.out.println(stack);
		stack.add(0, 29);
		System.out.println(stack);
		stack.add(1, 19600771);
		System.out.println(stack);
		stack.add(1, 2);
		System.out.println(stack);
		stack.add(1, 2);
		System.out.println(stack);
		stack.add(1, 1);
		System.out.println(stack);
		stack.add(1, 2);
		System.out.println(stack);
		stack.add(1, 2);
		System.out.println(stack);
		stack.add(1, 4);
		System.out.println(stack);
		stack.add(1, 4);
		System.out.println(stack);
		stack.add(1, 4);
		System.out.println(stack);
		stack.add(0, 42);
		System.out.println(stack);
	}
}
