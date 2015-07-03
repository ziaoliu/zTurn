package cc150;

/*
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should 
 * all operate in O(1) time.
 */

public class Chapter03Q02 {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(7);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		System.out.println("Peeking: " + s.peek());

		System.out.println("size: " + s.size());

		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());

		System.out.println("size: " + s.size());
		System.out.println("min: " + s.min());

		System.out.println("popping: " + s.pop());
		System.out.println("popping: " + s.pop());

		System.out.println("min: " + s.min());
		System.out.println("popping: " + s.pop());
		System.out.println("min: " + s.min());
		System.out.println("popping: " + s.pop());

		System.out.println("size: " + s.size());
	}

}
