package leetcode;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution. 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

public class ThreeSumClosestOJ {
	public class Solution {
		public int threeSumClosest1(int[] num, int target) {
			int result = Integer.MAX_VALUE;
			int min = result;
			if (num == null || num.length < 3)
				return result;

			Arrays.sort(num);

			for (int i = 0; i < num.length; i++) {
				int j = num.length - 1;
				int k = i + 1;
				while (k < j) {
					int temp = num[i] + num[j] + num[k];
					if (temp == target) {
						return temp;
					} else {
						if (Math.abs(temp - target) < min) {
							min = Math.abs(temp - target);
							result = temp;
						}
						if (temp < target)
							k++;
						else
							j--;
					}
				}

			}

			return result;
		}

		public int threeSumClosest(int[] num, int target) {
			int min = Integer.MIN_VALUE;
			int diff = Integer.MAX_VALUE;

			if (num == null || num.length < 3)
				return min;

			if (num.length == 3)
				return num[0] + num[1] + num[2];

			Arrays.sort(num);

			for (int i = 0; i < num.length - 2; i++) {
				int a = num[i];
				int bIndex = i + 1;
				int cIndex = num.length - 1;
				while (bIndex < cIndex) {
					int sum = a + num[bIndex] + num[cIndex];

					if (diff > Math.abs(target - sum)) {
						diff = Math.abs(target - sum);
						min = sum;
					}

					if (sum > target) {
						cIndex--;
					} else if (sum < target) {
						bIndex++;
					} else {
						return sum;
					}
				}
			}

			return min;
		}
	}
}
