package leetcode;

/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 http://blog.csdn.net/linhuanmars/article/details/19905515
 http://yucoding.blogspot.com/2013/01/leetcode-question-50-median-of-two.html
 */
public class Q004_MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Q004_MedianOfTwoSortedArrays solution = new Q004_MedianOfTwoSortedArrays();
		SolutionEasyWay s = solution.new SolutionEasyWay();
		int[] array1 = {};
		int[] array2 = { 1 };
		System.out.println(s.findMedianSortedArrays(array1, array2));
	}

	public class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int m = nums1.length;
			int n = nums2.length;

			if ((m + n) % 2 == 1)
				return findKth(nums1, 0, m - 1, nums2, 0, n - 1,
						(m + n) / 2 + 1);
			else
				return (findKth(nums1, 0, m - 1, nums2, 0, n - 1,
						(m + n) / 2) + findKth(nums1, 0, m - 1, nums2, 0,
						n - 1, (m + n) / 2 + 1)) / 2.0;
		}

		private double findKth(int[] nums1, int i, int i2, int[] nums2, int j,
				int j2, int k) {

			int nums1Len = i2 - i + 1;
			int nums2Len = j2 - j + 1;

			if (nums1Len > nums2Len)
				return findKth(nums2, j, j2, nums1, i, i2, k);
			if (nums1Len == 0)
				return nums2[j + k - 1];
			if (k == 1)
				return Math.min(nums1[i], nums2[j]);

			int a = Math.min(k / 2, nums1Len);
			int b = k - a;

			if (nums1[i + a - 1] > nums2[j + b - 1])
				return findKth(nums1, i, i + a - 1, nums2, j + b, j2, k - b);
			else if (nums1[i + a - 1] < nums2[j + b - 1])
				return findKth(nums1, i + a, i2, nums2, j, j + b - 1, k - a);
			else
				return nums1[i + a - 1];
		}
	}

	public class SolutionEasyWay {
		// O(m + n)
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			if (nums1 == null && nums2 == null || nums1.length == 0
					&& nums2.length == 0)
				return 0;

			int[] array = new int[nums1.length + nums2.length];

			int i = 0;
			int index1 = 0;
			int index2 = 0;

			while (i <= nums1.length + nums2.length - 1) {
				int num1 = Integer.MAX_VALUE;
				int num2 = Integer.MAX_VALUE;
				if (index1 < nums1.length)
					num1 = nums1[index1];
				if (index2 < nums2.length)
					num2 = nums2[index2];

				int temp = 0;
				if (num1 < num2) {
					index1++;
					temp = num1;
				} else {
					index2++;
					temp = num2;
				}

				array[i] = temp;
				i++;
			}
			if (array.length == 1)
				return array[0];
			if (array.length % 2 == 0)
				return (array[array.length / 2] + array[array.length / 2 - 1])
						/ (double) 2;
			else
				return array[array.length / 2];
		}
	}
}
