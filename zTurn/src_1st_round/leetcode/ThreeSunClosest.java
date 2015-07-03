package leetcode;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution. 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

public class ThreeSunClosest {

	public static int min = Integer.MAX_VALUE;
	public static int[] S = { -1, 2, 1, -4 };

	public static void main(String[] args) {
		System.out.println("Found closest result: " + findUtil(2));
	}

	public static int findUtil(int _target) {
		int result = -1;
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int j = i + 1;
			int k = S.length - 1;
			while (j < k) {
				int sum = S[i] + S[j] + S[k];
				int diff = Math.abs(sum - _target);
				if (diff < min) {
					min = diff;
					result = sum;
				} else if (_target > sum)
					k--;
				else
					j++;
			}
		}
		return result;
	}
	
}
