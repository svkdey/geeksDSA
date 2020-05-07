package QueueDSA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	static Queue<Integer> reverseQueue(Queue<Integer> q) {
		Stack<Integer> s=new Stack<>();
		while(!q.isEmpty()) {
			s.push(q.remove());
		}
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		return q;
	}
	static void reverseQueueWithOneStack(Queue<Integer> q) {
		
		if(q.isEmpty()) {
			return ;
		}else {
			int temp=q.remove();
			reverseQueue(q);
			q.add(temp);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		for (int i=0; i<5; i++) 
		     q.add(i); 
		System.out.println(q);  
		reverseQueueWithOneStack(q);
		System.out.println(q);
	}

}
