import java.util.List;

public class Tests {
	public static void main(String[] args) {
		Node tree = new Node(10);
		tree.add(3);
		tree.add(8);
		tree.add(21);
		System.out.println(tree.maxHeight());
		System.out.println(tree.minHeight());
		System.out.println(tree.isBalanced());
		System.out.println("\nLevels: \n");
		for (List<Node> l : tree.nodes()) {
			for (Node n : l) {
				System.out.println(n.data());
			}
			System.out.println("----------");
		}
	}
}
