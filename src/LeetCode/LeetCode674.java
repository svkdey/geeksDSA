package LeetCode;

import java.util.Arrays;

public class LeetCode674 {
	 public int findLengthOfLCIS(int[] nums) {
         if (nums.length == 0)
			return 0;
		int dp[] = new int[nums.length];
		dp[0] = 1;
		int ans = dp[0];

		for (int i = 1; i<nums.length; i++) {
			if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
            ans=Math.max(ans,dp[i]);
		}
        System.out.println(Arrays.toString(dp));
		return ans;
    }
}
