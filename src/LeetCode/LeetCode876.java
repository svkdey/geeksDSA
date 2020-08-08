package LeetCode;

import LeetCode.LeetCode1019.ListNode;

public class LeetCode876 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			next = null;
		}
	}
	 public ListNode middleNode(ListNode head) {
	       if(head==null||head.next==null) return head;
	       ListNode f=head;
	       ListNode s=head;
	       while(f!=null&&f.next!=null) {
	    	   f=f.next.next;
	    	   s=s.next;
	    	   
	       }
	       return s;
	    }
}
