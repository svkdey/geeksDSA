package LeetCode;


public class LeetCode725 {
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
	  public ListNode[] splitListToParts(ListNode root, int k) {
	        int len=length(root);
	        int s=len%k;
	        int i=s+k;
	        ListNode res[]=new ListNode[k];
	        for(int p=0;p<k;p++) {
	        	res[p]=null;
	        }
	        
	        ListNode dummy=new ListNode(-99);
	        dummy.next=root;
	        ListNode curr=dummy;
	        int j=0;
	        while(dummy!=null) {
	        	while(dummy!=null&&i!=0) {
	        		dummy=dummy.next;i--;
	        	}
	        	ListNode nxt=dummy.next;
	        	dummy.next=null;
	        	res[j]=curr.next;
	        	dummy=new ListNode(-99);
	        	dummy.next=nxt;
	        	curr=dummy;
	        	i=k;
	        }
	        return res;
	    }
}
