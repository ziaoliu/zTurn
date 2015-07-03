package cc150;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an 
 * algorithm to create a binary search tree with minimal height.
 */

public class Chapter04Q03 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Tree tree = new Tree(array[array.length / 2]);
		tree.binarySort(array);
		tree.DFS();
	}
	
}
