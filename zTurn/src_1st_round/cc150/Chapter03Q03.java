package cc150;

/*
 * Imagine a (literal) stack of plates If the stack gets too high, 
 * it might topple. Therefore, in real life, we would likely start a new 
 * stack when the previous stack exceeds some threshold. Implement a data 
 * structure SetOfStacks that mimics this. SetOfStacks should be composed 
 * of several stacks, and should create a new stack once the previous one 
 * exceeds capacity SetOfStacks push() and SetOfStacks pop() should behave 
 * identically to a single stack (that is, pop() should return the same 
 * values as it would if there were just a single stack). 
 * FOLLOW UP Implement a function popAt(int index) 
 * which performs a pop operation on a specific sub-stack.
 */

public class Chapter03Q03 {
	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks(3, 4);
		set.push(0);
		set.push(0);
		set.push(0);
		set.push(1);
		set.push(1);
		set.push(1);
		set.push(2);
		set.push(2);
		set.push(2);
		set.push(3);
		set.push(3);
		set.push(3);

		set.print();
		set.popAt(0);
		System.out.println("======after=====");
		set.print();
	}

}

class SetOfStacks {
	int head = 0;
	int singleLength;
	int numOfStacks;
	Stack[] set;

	public SetOfStacks() {
		singleLength = 4;
		numOfStacks = 3;
		set = new Stack[numOfStacks];
		for (int i = 0; i < numOfStacks; i++) {
			set[i] = new Stack(singleLength);
		}
	}

	public SetOfStacks(int singleLength, int numOfStacks) {
		this.singleLength = singleLength;
		this.numOfStacks = numOfStacks;
		set = new Stack[numOfStacks];
		for (int i = 0; i < numOfStacks; i++) {
			set[i] = new Stack(singleLength);
		}
	}

	public int peek() {
		int stackNum = head / singleLength;
		return (int) set[stackNum].peek();
	}

	public int pop() {
		int stackNum = head / singleLength;
		head--;
		return (int) set[stackNum].pop();
	}

	public boolean push(int a) {

		if (head + 1 <= singleLength * numOfStacks) {
			int stackNum = head / singleLength;
			set[stackNum].push(a);
			head++;
			return true;
		}

		System.out.println("reached maxium length in the stack already");

		return false;
	}

	// follow up: pop a sub stack
	public int popAt(int stackNum) {
		int stackNumLatest = head / singleLength - 1;
		if (stackNum == stackNumLatest) {
			return (int) set[stackNum].pop();
		} else if (stackNum > stackNumLatest) {
			return Integer.MAX_VALUE;
		} else { // stackNum < stackNumLatest, stack in the middle, needs
					// shifting op
			int pop = (int) set[stackNum].pop();

			for (int i = stackNum; i < stackNumLatest; i++) {
				if (i + 1 <= stackNumLatest) {
					int push = (int) set[i + 1].remove(0);
					set[i].push(push);
				}
			}

			return pop;
		}
	}

	public void print() {
		int stackNum = head / singleLength;
		for (int i = 0; i < stackNum; i++) {
			set[i].print();
			System.out.println("|===Bottom=======Top=====>");
		}
	}

}
