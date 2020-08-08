package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		 int n= nums.length;
		 int[] res= new int[n-k+ 1];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
				pq.add(nums[i]);	
		}
		int j=0;
		 res[j++] = pq.peek();
		for(int i=k;i<n;i++) {
			
			pq.remove(nums[i-k]);
			pq.add(nums[i]);
			res[j++]=pq.peek();
		}
		return res;
	}
}
