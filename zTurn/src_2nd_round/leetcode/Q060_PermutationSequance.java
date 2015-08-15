package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 The set [1,2,3,бн,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 
 http://blog.csdn.net/linhuanmars/article/details/22028697
 http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
 */
public class Q060_PermutationSequance {
	public static void main(String[] args) {
		Q060_PermutationSequance test = new Q060_PermutationSequance();
		Solution s = test.new Solution();
		System.out.println(s.getPermutation(4, 2));
	}

	public class Solution {
		public String getPermutation(int n, int k) {
			if (n <= 0 || k <= 0)
				return "";
			k--;
			int total = 1;

			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i < n + 1; i++) {
				total = total * i;
				list.add(Integer.toString(i));
			}
			if (k > total)
				return "";
			StringBuilder sb = new StringBuilder();
			for (; n >= 0; n--) {
				if (n != 0)
					total = total / n;
				else
					break;
				int group = k / total;
				int sub = k % total;

				sb.append(list.get(group));
				list.remove(group);
				k = sub;
			}

			return sb.toString();
		}
	}
}
