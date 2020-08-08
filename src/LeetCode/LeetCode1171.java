package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class LeetCode1171 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val=x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}


	public static ListNode removeZeroSumSublists(ListNode head) {
		  Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
	        ListNode dummy = new ListNode(0),p;
	        dummy.next = head;
	        p = dummy;
	        int sum = 0;
	        while(p!=null){
	            sum+=p.val;
	            map.put(sum,p);
	            p = p.next;
	        }
	        System.out.println(map);
	        sum = 0;
	        p = dummy;
	        while(p!=null){
	            sum+=p.val;
	            if(map.containsKey(sum)){
	                ListNode tmp = map.get(sum);
	                if(tmp!=p){
	                    p.next = tmp.next;
	                }
	            }
	            p = p.next;
	        }
	        return dummy.next;
	    
	
		
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode head1=new ListNode(2);
		ListNode head2=new ListNode(3);
		ListNode head3=new ListNode(-3);
		ListNode head4=new ListNode(1);
		head.next=head1;
		head1.next=head2;
		
		head2.next=head3;
		head3.next=head4;
		System.out.println(head);
		System.out.println(removeZeroSumSublists(head));
		
	}
}
