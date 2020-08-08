package LeetCode;

import java.util.HashSet;

import LeetCode.LeetCode876.ListNode;

public class LeetCode817 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			next = null;
		}
	}

	public int numComponents(ListNode head, int[] G) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int x : G) {
			s.add(x);
		}
			int ans=0;
		ListNode f = head;
	
		while (f != null) {
			if(!s.contains(f.val)) {
				f=f.next;
			}
			else {
				ans++;
				while(f!=null&&s.contains(f.val)) {
					f=f.next;
				}
			}

		}
		return ans;
		
	}
}
