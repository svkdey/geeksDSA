package LeetCode.InterviewPrep;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> max_pq = null;
	PriorityQueue<Integer> min_pq = null;

	public MedianFinder() {
		max_pq = new PriorityQueue<Integer>();
		min_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

	}

	public void addNum(int num) {
		min_pq.add(num);
		while (min_pq.size()- max_pq.size() > 1) {
			max_pq.add(min_pq.remove());
		}
	}

	public double findMedian() {
		System.out.println(max_pq);
		System.out.println(max_pq);
		if (min_pq.size() != max_pq.size())
			return max_pq.peek();
		else
			return (min_pq.peek() + max_pq.peek()) / 2;
	}
}
