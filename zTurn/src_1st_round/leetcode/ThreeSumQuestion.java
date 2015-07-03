package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */

/*
 * Thought process: 
 * a. sort array, so the result triplets are ordered
 * b. start by picking a target element, and go from two end of the rest of the array (two pointers one from head one from tail)
 * 
 */

public class ThreeSumQuestion {
	public static int[] S = { -1, 0, 1, 2, -1,-1, -4 };
	public static Set set = new HashSet<ArrayList<Integer>>();

	public static void main(String[] args) {
		Arrays.sort(S);
		System.out.println("try first method");
		// find1();
		System.out.println("try second method");
		find2();

	}

	// first method
	public static void find1() {
		for (int i = 0; i < S.length; i++) {
			for (int j = i + 1; j < S.length; j++) {
				// System.out.println("print pairs: [ " + S[i] + " , " + S[j] +
				// " ]" );
				find1Util(i, j);
			}
		}
	}

	public static void find1Util(int aInd, int bInd) {
		int sum = S[aInd] + S[bInd];

		for (int i = 0; i < S.length; i++) {
			if (i != aInd && i != bInd)
				if (sum == 0 - S[i]) {
					int[] temp = { S[aInd], S[bInd], S[i] };
					Arrays.sort(temp);
					ArrayList newTemp = new ArrayList();
					set.add(newTemp);
					System.out.println("found triplets: [" + S[aInd] + " , "
							+ S[bInd] + " , " + S[i] + "]");

				}
		}
	}

	// second approach
	public static HashSet<ArrayList<Integer>> find2() {
		if (S.length < 3)
			return null;

		HashSet<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();

		for (int i = 0; i < S.length; i++) {
			int target = -S[i];
			int j = i + 1;
			int k = S.length - 1;
			while (j < k) {
				if (target == S[j] + S[k]) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(S[i]);
					temp.add(S[j]);
					temp.add(S[k]);

					results.add(temp);

					for (int tt : temp) {
						System.out.print(tt + " ");
					}
					System.out.println("<======");

					k--;
					j++;
				} else if (S[j] + S[k] > target)
					k--;
				else
					j++;
			}
		}
		System.out.println(results.size());
		return results;
	}

}
