package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 

 */

public class CombinationSum {

	public static int[] set = { 2, 3, 6, 7 };
	public static int target = 7;
	public static int sum = 0;

	public static void main(String[] args) {
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
		Arrays.sort(set);
		HashSet<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < set.length; i++) {
			sum = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (set[i] <= target)
				temp = rec(set[i], temp);
			if (null != temp && temp.size() > 0) {
				Collections.sort(temp);
				results.add(temp);
			}
		}
		return results;
	}

	public static ArrayList<Integer> rec(int curVal, ArrayList<Integer> temp) {
		if (sum + curVal > target)
			return temp;
		else if (sum + curVal == target) {
			sum = sum + curVal;
			temp.add(curVal);
			return temp;
		} else {
			sum = sum + curVal;
			temp.add(curVal);
			for (int i = 0; i < set.length; i++) {
				temp = rec(set[i], temp);
			}
			if (sum == target)
				return temp;
			else {
				sum = sum - curVal;
				temp.remove(temp.size() - 1);
				return temp;
			}
		}
	}


}
