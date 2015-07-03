package cc150;

import java.util.Stack;

/*
 * will be addressed if have the chance to look back
 */

/*
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * in ascending order of size from top to bottom (i.e., each disk sits on top of an
 * even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */

public class Chapter03Q04 {
	public static void main(String[] args) {
		HanoiTower t = new HanoiTower(5);
		t.printStatus();
		HanoiTowerSolver(t);
	}

	public static void HanoiTowerSolver(HanoiTower ht) {

	}

}

class HanoiTower {
	java.util.Stack<Integer> source;
	java.util.Stack<Integer> temp;
	java.util.Stack<Integer> target;

	int size = 3;

	public HanoiTower() {
		init(size);
	}

	public HanoiTower(int size) {
		this.size = size;
		init(size);
	}

	private void init(int size) {
		source = new Stack<Integer>();
		temp = new Stack<Integer>();
		target = new Stack<Integer>();

		for (int i = 0; i < size; i++) {
			source.push(2 * (size - i) - 1);
		}
	}

	public int size() {
		return this.size;
	}

	public void printStatus() {
		Object[] sourceArray = source.toArray();
		Object[] tempArray = temp.toArray();
		Object[] targetArray = target.toArray();

		int[][] snapshot = new int[size][3];

		for (int i = sourceArray.length - 1; i >= 0; i--) {
			snapshot[4 - i][0] = (int) sourceArray[i];
		}
		for (int i = tempArray.length - 1; i >= 0; i--) {
			snapshot[4 - i][1] = (int) tempArray[i];
		}
		for (int i = targetArray.length - 1; i >= 0; i--) {
			snapshot[4 - i][2] = (int) targetArray[i];
		}
		
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < 3; j++){
				System.out.print(snapshot[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("=================");
	}
}
