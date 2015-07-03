package cc150;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

public class Chapter04Q02 {
	public static void main(String[] args) {
		Tree tree = new Tree(8);

		Tree.Node n1 = tree.createNode(7);
		tree.getRoot().addToLeft(n1);

		Tree.Node n2 = tree.createNode(9);
		tree.getRoot().addToRight(n2);

		Tree.Node n3 = tree.createNode(5);
		n1.addToLeft(n3);

		Tree.Node n4 = tree.createNode(6);
		n1.addToRight(n4);

		Tree.Node n5 = tree.createNode(1);
		n2.addToLeft(n5);

		Tree.Node n6 = tree.createNode(2);
		n2.addToRight(n6);

		Tree.Node n7 = tree.createNode(3);
		n3.addToLeft(n7);

		Tree.Node n8 = tree.createNode(4);
		n3.addToRight(n8);

		tree.DFS();

		System.out.println("==========");

		tree.search(n1, n7);

	}
}
