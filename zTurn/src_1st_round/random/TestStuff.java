package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TestStuff {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(0);
		for (int i : a) {
			System.out.println(i);
		}

		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(0);
		b.add(0);

		System.out.println(b);

		ArrayList<Character> c = new ArrayList<Character>();
		c.add('c');
		c.add('c');
		System.out.println(c.size());

		System.out.println("=======");
		System.out.println(".*".substring(2));

		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(0);
		d.add(0);
		d.add(1);

		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
		set.add(b);
		System.out.println(set.contains(d));

		System.out.println(d.remove(new Integer(1)));
		System.out.println(d);

		System.out.println("======================");
		int[] testA = { 1, 2, 3 };
		int[] testB = { 3, 2, 1 };
		testA = Arrays.copyOf(testB, testB.length);
		for (int i : testA) {
			System.out.print(i + " ");
		}
		System.out.println("======================");
		ArrayList<Object> testt = new ArrayList<>();
		testt.add(null);
		testt.add(null);
		System.out.println(testt.size());

		System.out.println("A man, a plan, a canal: Panama".toLowerCase());
	}
}
