package LeetCode;

import java.util.Arrays;

public class LeetCode303 {
	class NumArray {
		int dp[]=null;
	    public NumArray(int[] nums) {
	        dp=new int[nums.length];
	        dp[0]=nums[0];
	        for(int i=0;i<nums.length;i++) {
	        	dp[i]=dp[i-1]+nums[i];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	    	System.out.println(Arrays.toString(dp));
	        //out of range
	    	if(i>dp.length||j<0||j>i) return 0;
	    	if(i==0) return dp[j];
	    	else return dp[j]-dp[i];
	    }
	}
}
