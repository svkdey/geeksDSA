package LeetCode.InterviewPrep;

public class RevList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode temp=null;
		while(head!=null) {
			ListNode nxt=head.next;
			head.next=temp;
			temp=head;
			head=nxt;
			
		}
		return temp;
	}
}
