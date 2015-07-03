package leetcode;

/*
 You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 
 Note: Return the head of the list instead of the last node in calculation
 
 */

public class AddTwoNumbers {
	public static void main(String[] args) {
		AddTwoNumbers solution = new AddTwoNumbers();
		Solution a = solution.new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		ListNode result = a.addTwoNumbers(l1, l2);
		System.out.println(result.next.val);
	}

	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if(l1 == null && l2 == null) return null;
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        
	        ListNode head = null;
	        ListNode result = null;
	        
	        
	        int carryOver = 0;
	        
	        while(l1 != null || l2 != null){
	            int sum = 0;
	            if(l1 != null){
	                sum = sum + l1.val;
	                l1 = l1.next;
	            }    
	            if(l2 != null){
	                sum = sum + l2.val;
	                l2 = l2.next;                
	            }
	            
	            sum = sum + carryOver;
	            
	            if(sum >= 10){
	                carryOver = 1;
	                sum = sum - 10;
	            }else
	                carryOver = 0;
	            
	            if(result == null){
	                head = new ListNode(sum);
	                result = head;
	            }else{
	                result.next = new ListNode(sum);
	                result = result.next;
	            }
	            
	        }
	        
	        if(carryOver == 1)
	            result.next = new ListNode(carryOver);
	        
	        return head;
	    }
	}

	public class Solution2 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;

			ListNode head = new ListNode(0);
			ListNode result = head;

			int carryOver = 0;

			while (l1 != null || l2 != null) {
				int sum = 0;
				if (l1 != null) {
					sum = sum + l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					sum = sum + l2.val;
					l2 = l2.next;
				}

				sum = sum + carryOver;

				if (sum >= 10) {
					carryOver = 1;
					sum = sum - 10;
				} else
					carryOver = 0;

				result.next = new ListNode(sum);
				result = result.next;

			}

			if (carryOver == 1)
				result.next = new ListNode(carryOver);

			return head.next;
		}
}
}

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}
