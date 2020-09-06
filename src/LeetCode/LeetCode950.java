package LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode950 {
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i=deck.length-1;i>=0;i--) {
			int card=deck[i];
			if(dq.isEmpty()) {
				dq.addFirst(card);
			}else {
				int tmp=dq.removeLast();
				dq.addFirst(tmp);
				dq.addFirst(card);
			}
		}
		System.out.println(dq);
		int i=0;
		while(!dq.isEmpty()) {
			deck[i++]=dq.removeFirst();
		}
		return deck;
	}
}
