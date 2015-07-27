package leetcode;

// how to reverse a list given pre and end elements
public class Q025_ReverseNodesInKGroup_Plus_ReverseList {
	private ListNode reverse(ListNode pre, ListNode end) {
		ListNode start = pre.next;
		ListNode next = start.next;

		while (next != end) {
			ListNode dup = next.next;
			next.next = pre.next;
			pre.next = next;
			next = dup;
		}
		start.next = end;
		return start;
	}
}
