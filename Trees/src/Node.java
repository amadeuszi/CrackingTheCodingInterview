import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
	private int data;
	private Node left;
	private Node right;
	private boolean visited;
	
	public Node(int x) {
		left = null;
		right = null;
		visited = false;
		data = x;
	}
	
	public List<Node> children() {
		List<Node> list = new LinkedList<Node>();
		list.add(left);
		list.add(right);
		return list;
	}
	
	public Node(Node left, int x, Node right) {
		this.visited = false;
		this.left = left;
		this.right = right;
		this.data = x;
	}
	
	public int maxHeight() {
		return maxHeightHelper(this);
	}
	
	public int maxHeightHelper(Node head) {
		if (head == null) {
			return 0;
		}
		return Math.max(maxHeightHelper(head.left), maxHeightHelper(head.right)) + 1;
	}
	
	public int minHeight() {
		return minHeightHelper(this);
	}
	
	public List<List<Node>> nodes() {
		Queue<Pair> result = new LinkedList<Pair>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(this, 1));
		this.visited = true;
		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			Node u = pair.first();
			int level = pair.second();
			result.add(pair);
			for (Node v : u.children()) {
				if (v != null && !v.visited) {
						v.visited = true;
						queue.add(new Pair(v, level + 1));
				}
			}
		}
		List<List<Node>> result2 = new LinkedList<List<Node>>();
		List<Node> list = new LinkedList<Node>();
		list.add(result.remove().first());
		int lev = 1;
		result2.add(list);
		while (!result.isEmpty()) {
			Pair pair = result.remove();
			if (lev != pair.second()) {
				list = new LinkedList<Node>();
				lev++;
				result2.add(list);
			}
			list.add(pair.first());
		}
		return result2;
	}
	
	public int minHeightHelper(Node head) {
		if (head == null) {
			return 0;
		} 
		else {
			return Math.min(minHeightHelper(head.left), minHeightHelper(head.right)) + 1;
		}
	}
	
	public boolean isBalanced() {
		return Math.abs(minHeight() - maxHeight()) <= 1;
	}
	
	public int data() {
		return this.data;
	}
	
	public void add(int x) {
		if (x > data) {
			if (this.right == null) {
				this.right = new Node(x);
			}
			else {
				this.right.add(x);
			}
		}
		else {
			if (this.left == null) {
				this.left = new Node(x);
			}
			else {
				this.left.add(x);
			}
		}
	}
	
}
