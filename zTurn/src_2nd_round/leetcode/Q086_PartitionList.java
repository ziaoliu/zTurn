package leetcode;

/*
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 http://www.jiuzhang.com/solutions/partition-list/ 
 http://fisherlei.blogspot.com/2012/12/leetcode-partition-list.html

 http://blog.unieagle.net/2012/10/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Apartition-list/
 */
public class Q086_PartitionList {
	public static void main(String[] args) {
		Q086_PartitionList test = new Q086_PartitionList();
		Solution s = test.new Solution();
		ListNode orig = new ListNode(-1);
		ListNode one = new ListNode(1);
		orig.next = one;
		ListNode two = new ListNode(4);
		one.next = two;
		ListNode thr = new ListNode(3);
		two.next = thr;
		ListNode fr = new ListNode(2);
		thr.next = fr;
		ListNode fiv = new ListNode(2);
		fr.next = fiv;
		System.out.println(s.partition(orig.next, 3));

	}

	public class Solution {
		public ListNode partition(ListNode head, int x) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = orig;
			ListNode first = orig;
			while (head != null) {
				if (head.val < x) {
					if (first.next != head) { // if not the very first element
						pre.next = head.next;
						head.next = first.next;
						first.next = head;
					}
					first = first.next;
				}
				pre = head;
				head = head.next;
			}
			return orig.next;
		}
	}

	public class SolutionTwoLists {
		public ListNode partition(ListNode head, int x) {
			if (head == null)
				return head;
			ListNode one = new ListNode(-1);
			ListNode oneCopy = one;
			ListNode two = new ListNode(-1);
			ListNode twoCopy = two;
			ListNode first = null;

			while (head != null) {
				if (head.val < x) {
					one.next = head;
					first = head;
					one = one.next;
				} else {
					two.next = head;
					two = two.next;
				}
				head = head.next;
			}
			two.next = null;

			/**
			 * 因为如果不置为null的话，它其实是指向这个链表中的某一项（很有可能，除非它本来就是最后一个），这种情况下，
			 * 从链表开头一直取下一个下一个的话，就进入死循环了。 一来无法简单的判断是不是遍历了所有的node；
			 * 二来，leetcode在进行结果的正确新判断的时候，就进入死循环了，所以必然会超时。 —————————
			 * 这里最后一个node，是处理完之后的最后一个node，它很可能是原来链表中间的一项，所以其next值不一定是NULL
			 */

			if (first != null) {
				first.next = twoCopy.next;
				return oneCopy.next;
			}
			return twoCopy.next;
		}
	}
}
