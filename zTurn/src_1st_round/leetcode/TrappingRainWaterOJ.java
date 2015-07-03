package leetcode;

/* Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * http://www.lifeincode.net/programming/leetcode-trapping-rain-water-java/
 */
public class TrappingRainWaterOJ {
	public class Solution {
		public int trap(int[] A) {
			if (null == A)
				return 0;
			if (A.length <= 0)
				return 0;
			int[] maxLeft = new int[A.length];
			int[] maxRight = new int[A.length];

			int max = A[0];
			for (int i = 1; i < A.length - 1; i++) {
				maxLeft[i] = max;
				if (A[i] > max)
					max = A[i];
			}
			max = A[A.length - 1];
			for (int i = A.length - 2; i >= 0; i--) {
				maxRight[i] = max;
				if (A[i] > max)
					max = A[i];
			}

			int sum = 0;
			for (int i = 1; i < A.length - 1; i++) {
				int temp = Math.min(maxLeft[i], maxRight[i]) - A[i];
				if (temp > 0)
					sum = sum + temp;
			}
			return sum;
		}

		public int trapoOld(int[] A) {
			if (null == A)
				return 0;
			int start = -1;
			for (int i = 0; i < A.length; i++) {
				int current = A[i];
				if (current > 0) {
					start = i;
					break;
				}
			}

			if (start == -1 || start == A.length - 1)
				return 0;

			int sum = 0;
			int end = start + 1;
			for (int i = start + 1; i < A.length; i++) {
				if (end + 1 == A.length && A[end - 1] <= A[end]
						|| end + 1 != A.length && A[end + 1] < A[end]
						&& A[end - 1] <= A[end]) {
					int small = Math.min(A[start], A[end]);
					// System.out.println("start: " + start + " end: " + end);
					for (int j = start + 1; j < end; j++) {
						int units = small - A[j];
						if (units > 0)
							sum = sum + units;
					}
					start = i;
					end = start + 1;
				} else
					end++;
			}
			return sum;
		}

		public int trapOld(int[] A) {
			if (null == A)
				return 0;

			int start = -1;
			for (int i = 0; i < A.length; i++) {
				int current = A[i];
				if (current > 0) {
					start = i;
					break;
				}
			}

			if (start == -1 || start == A.length - 1)
				return 0;

			int sum = 0;
			int end = start + 1;
			for (int i = start + 1; i < A.length; i++) {
				int current = A[i];
				if (current >= A[start]) {
					int small = Math.min(A[start], A[end]);
					System.out.println("start: " + start + " end: " + end);
					for (int j = start + 1; j < end; j++) {
						int units = small - A[j];
						if (units > 0)
							sum = sum + units;
					}
					start = i;
					end = start + 1;
				} else {
					end++;
				}
			}

			if (end == A.length) {
				System.out.println("last: " + start + " " + end);
				int small = Math.min(A[start], A[end - 1]);
				for (int j = start + 1; j < end; j++) {
					int units = small - A[j];
					if (units > 0)
						sum = sum + units;
				}
			}
			return sum;
		}// end of solution
	}
}
