package LeetCode;

import LeetCode.LeetCode160.ListNode;

public class LeetCode1290 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			next = null;
		}
	}
	public int length(ListNode head) {
		int len=0;
		ListNode curr=head;
		while(curr!=null) {
			len++;
			curr=curr.next;
		}
		return len;
	}
	 public int getDecimalValue(ListNode head) {
	        if(head==null) return 0;
	        int ans=0;
	        int len=length(head);
	        ListNode curr=head;
	        while(curr!=null) {
	        	ans+=Math.pow(2, len-1)*curr.val;
	        	curr=curr.next;
	        	len--;
	        }
	        return ans;
	        
	    }
}
