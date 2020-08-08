package LeetCode;

import java.util.LinkedList;

public class LeetCode160 {
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

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA=length(headA);
		int lenB=length(headB);
		ListNode p=null;ListNode q=null;
		int k=0;
		if(lenA>lenB) {
			p=headA;q=headB;k=lenA-lenB;
		}else {
			p=headB;q=headA;k=lenB-lenA;
		}
		
		while(p!=null&&k!=0) {
			p=p.next;
			k--;
		}
		while(p!=null) {
			if(p==q) {
				return p;
			}
			p=p.next;
			q=q.next;
		}
		return null;
		
	}
}
