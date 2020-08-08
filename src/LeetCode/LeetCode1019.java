package LeetCode;

import java.util.ArrayList;
import java.util.Stack;



public class LeetCode1019 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			next = null;
		}
	}

	public int[] nextLargerNodes(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode curr = head;
		while (curr != null) {
			list.add(curr.val);
			curr = curr.next;
		}
		System.out.println(list);
		int nextElement[]=new int[list.size()];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=list.size()-1;i>=0;i--) {
			while(!s.isEmpty()&&list.get(i)>list.get(s.peek())) {
				s.pop();
			}
			nextElement[i]=s.isEmpty()?0:s.peek();
			s.add(i);
		}
		
		return nextElement;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
