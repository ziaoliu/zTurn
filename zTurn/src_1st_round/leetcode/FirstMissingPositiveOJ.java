package leetcode;

/* First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-first-missing-positive.html
 * http://yucoding.blogspot.com/2013/01/leetcode-question-28-first-missing.html
 */
public class FirstMissingPositiveOJ {
	public class Solution {
		public int firstMissingPositive(int[] A) {
			if (null == A || A.length <= 0)
				return 1;
			int n = A.length;
			
			// step 1: in place setup the array
			int i = 0;
			while( i < n){
				if(i != A[i] - 1 && A[i] > 0 && A[i] <= n && A[A[i]-1] != A[i]){
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;
				}else
					i++;
			}
			
			// step 2: go thru the array against the index
			for(i = 0; i < n; i++){
				if(i != A[i] - 1) return i + 1;
			}
			return n + 1;
		}
	}
}
