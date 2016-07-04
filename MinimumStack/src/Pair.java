
public class Pair {
	int x1;
	int x2;
	
	public Pair(int x1, int x2) {
		this.x1 = x1;
		this.x2 = x2;
	}
	
	public int first() {
		return this.x1;
	}
	
	public int second() {
		return this.x2;
	}
	
	public String toString() {
		return "(" + x1 + ", " + x2 + ")";
	}
}
