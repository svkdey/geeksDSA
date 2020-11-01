package LeetCode.InterviewPrep;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	 public static int[] maxSlidingWindow(int[] nums, int k) {
		 /*
		  * idea is  to keep the max element at top of queue
		  * 
		  * */
		 int n=nums.length;
	        int ans[]=new int[nums.length-k+1];
	       Deque<Integer> dq=new LinkedList<Integer>();
	       for(int i=0;i<n;i++) {
	    	   if(!dq.isEmpty()&&(i-k+1>dq.peek())) {
	    		   dq.poll();
	    	   }
	    	   
	    	   while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()]) {
	    		   dq.pollLast();
	    	   }
	    	   
	    	   
	    	   
	    	   
	    	   dq.add(i);
	    	   if(i-k+1>=0) {
	    		   ans[i-k+1]=nums[dq.peek()];
	    	   }
	       }
	       return ans;
	    }
	public static void main(String[] args) {
		int nums[] = {1,3,-1,-3,5,3,6,7};int k=2;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}
}
