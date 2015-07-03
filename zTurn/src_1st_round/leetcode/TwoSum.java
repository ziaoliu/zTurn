package leetcode;

import java.util.HashMap;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2 

 */

public class TwoSum {
	public class Solution {
		public int[] twoSum1(int[] numbers, int target) {
			if (numbers == null || numbers.length < 2) {
				return null;
			}

			int[] results = new int[2];

			for (int i = 0; i < numbers.length; i++) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[i] + numbers[j] == target) {
						results[0] = i + 1;
						results[1] = j + 1;
						return results;
					}

				}
			}
			return null;
		}

		// O(n) solution
		public int[] twoSum2(int[] numbers, int target) {
			if (numbers == null || numbers.length < 2) {
				return null;
			}

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int[] result = new int[2];

			for (int i = 0; i < numbers.length; i++) {
				if (map.containsKey(numbers[i])) {
					int index = map.get(numbers[i]);
					result[0] = index + 1;
					result[1] = i + 1;
					break;
				} else
					map.put(target - numbers[i], i);
			}

			return result;
		}

		public int[] twoSum(int[] numbers, int target) {

			int[] result = { 0, 0 };

			if (numbers.length < 2)
				return result;

			// building hashmap <remainder(key), index(value)>
			HashMap<Integer, Integer> map = new HashMap();

			for (int i = 0; i < numbers.length; i++) {
				int remainder = target - numbers[i];
				if (!map.containsKey(numbers[i]))
					map.put(remainder, i);
				else {
					int key = map.get(numbers[i]);
					result[0] = key + 1;
					result[1] = i + 1;
					break;
				}
			}

			return result;
		}
	}
}
