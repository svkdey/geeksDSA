package LeetCode;

public class LeetCode328 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			next = null;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode a = new ListNode(-99);
		ListNode p = a;
		ListNode b = new ListNode(-999);
		ListNode q = b;
		ListNode curr = head;
		int i=0;
		while (curr != null) {
			i++;
			if (i% 2 != 0) {
				a.next = new ListNode(curr.val);
				a = a.next;
			} else {
				b.next = new ListNode(curr.val);
				b = b.next;
			}
			curr = curr.next;

		}

		a.next = q.next;
		return p.next;

	}
}
