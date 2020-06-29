package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;
//it can done in log(n) time by quick select nmethod at nums.length-k position
public class LeetCode215 {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int x:nums) {
			pq.add(x);
		
		}
		System.out.println(pq);
		int ans=0;
		while(!pq.isEmpty()&&k!=0) {
			ans=pq.remove();k--;
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {3,2,1,5,6,4};int  k = 2;
		System.out.println(findKthLargest(a,k));
	}

}
