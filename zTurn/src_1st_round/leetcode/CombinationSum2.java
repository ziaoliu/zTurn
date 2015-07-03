package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6] 
 */

public class CombinationSum2 {

	public static int[] set = { 10, 1, 2, 7, 6, 1, 5 };
	public static int target = 8;
	public static int sum = 0;

	public static int[] counts = new int[target + 1];
	public static int[] theDouble = counts;
	
	public static void main(String[] args) {
		Arrays.sort(set);

		for (int i = 0; i < set.length; i++) {
			if (set[i] < target) {
				counts[set[i]]++;
			}
		}
		
		theDouble = counts.clone();

		HashSet<ArrayList<Integer>> res = find();
		System.out.println("results size: " + res.size());
		for (ArrayList<Integer> al : res) {
			if (al.size() == 1)
				System.out.println("size : " + al.size() + " has " + al.get(0));
			else {
				System.out.print("size : " + al.size() + " has ");
				for (int i = 0; i < al.size(); i++) {
					System.out.print(" " + al.get(i));
				}
				System.out.println();
			}
		}
	}

	public static HashSet<ArrayList<Integer>> find() {
		HashSet<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < set.length; i++) {
			sum = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (set[i] <= target && counts[set[i]] > 0)
				temp = rec(set[i], temp);
			if (null != temp && temp.size() > 0) {
				Collections.sort(temp);
				results.add(temp);
			}
			counts = theDouble;
		}
		return results;
	}

	public static ArrayList<Integer> rec(int curVal, ArrayList<Integer> temp) {
		if (curVal > target)
			return temp; 
		if (sum + curVal > target)
			return temp;
		else if (sum + curVal == target) {
			sum = sum + curVal;
			counts[curVal]--;
			temp.add(curVal);
			return temp;
		} else {
			sum = sum + curVal;
			counts[curVal]--;
			temp.add(curVal);
			for (int i = 0; i < set.length; i++) {
				if (set[i] <= target && counts[set[i]] > 0)
					temp = rec(set[i], temp);
			}
			if (sum == target)
				return temp;
			else {
				sum = sum - curVal;
				counts[curVal]++;
				temp.remove(temp.size() - 1);
				return temp;
			}
		}
	}
}
