package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode719 {
	static class Pair {
		int x, y;

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public int smallestDistancePair(int[] nums, int p) {
//		 Comparator<Integer> rule=(a,b)->{
//			 return a-b;
//		 };
//		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(rule);
//	        for(int i=0;i<nums.length;i++) {
//	        	for(int j=i+1;j<nums.length;j++) {
//	        		System.out.println(nums[i]+"   "+nums[j]);
//	        		pq.add(Math.abs(nums[i]-nums[j]));
//	        	}
//	        }
//	        System.out.println(pq);
//	        int ans=-1;
//	        while(!pq.isEmpty()&&k!=0) {
//	        	ans=pq.remove();k--;
//	        }
//	        return ans;

		int arr[] = new int[1000000];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				int diff = Math.abs(nums[i] - nums[j]);
				arr[diff]++;
			}
		}
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			if (sum + arr[i] > p) {
				return i;
			}
		}
		return 0;

	}

}
