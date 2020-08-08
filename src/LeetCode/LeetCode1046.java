package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode1046 {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < stones.length; i++) {
			pq.add(stones[i]);
		}
		while(pq.size()>1) {
			int x=pq.remove();
			int y=pq.remove();
			System.out.println(x+"  "+y);
			if(x!=y) {
				pq.add(Math.abs(x-y));
			}
		}
		System.out.println(pq);
		return !pq.isEmpty()?pq.remove():0;
	}
	public static void main(String[] args) {
		int stones[]= {2,7,2,1,7,1};
		LeetCode1046 l=new LeetCode1046();
		System.out.println(l.lastStoneWeight(stones));
	}
}
