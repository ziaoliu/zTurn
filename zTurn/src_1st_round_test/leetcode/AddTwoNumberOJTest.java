package leetcode;

import static org.junit.Assert.*;
import leetcode.AddTwoNumberOJ.Solution;

import org.junit.Test;

public class AddTwoNumberOJTest {

	@Test
	public void test() {
		AddTwoNumberOJ solution = new AddTwoNumberOJ();
		Solution testCase = solution.new Solution();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		ListNode ll1 = new ListNode(5);
		ListNode ll2 = new ListNode(6);
		ListNode ll3 = new ListNode(6); 
		ListNode ll4 = new ListNode(9);
		ll1.next = ll2;
		ll2.next = ll3;
		ll3.next = ll4;
		
		ListNode result = testCase.addTwoNumbers(l1, ll1);
		
		while(result != null ){
			
			System.out.print(result.val + "->");
			result = result.next;
		}
		
	}

}
