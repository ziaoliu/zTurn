package leetcode;

import static org.junit.Assert.*;
import leetcode.MedianOfTwoSortedArraysOJ.Solution;

import org.junit.Test;

public class MedianOfTwoSortedArraysOJTest {

	@Test
	public void test() {
		MedianOfTwoSortedArraysOJ solution = new MedianOfTwoSortedArraysOJ();
		Solution testCase = solution.new Solution();
		int[] a = { 1, 2, 3, 5 };
		int[] b = { 4 };
		System.out.println(testCase.findMedianSortedArrays(a, b));

	}

	@Test
	public void testMedian() {
		MedianOfTwoSortedArraysOJ solution = new MedianOfTwoSortedArraysOJ();
		Solution testCase = solution.new Solution();
		int[] a = { 1, 2, 3, 4 };
		int[] b = { 1 };
		System.out.println(testCase.median(b, 0, b.length - 1));

	}

}
