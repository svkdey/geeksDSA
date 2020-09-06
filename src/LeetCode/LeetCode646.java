package LeetCode;

import java.util.Arrays;

public class LeetCode646 {
	 public static int findLongestChain(int[][] pairs) {
	        int dp[]=new int[pairs.length];
	        int ans=1;
	        dp[0]=1;
	        for(int i=1;i<pairs.length;i++) {
	        	dp[i]=1;
	        	for(int j=i-1;j>=0;j--) {
	        		if(pairs[i][0]>pairs[j][1]) {
	        			dp[i]=Math.max(dp[j]+1, dp[i]);
	        		}
	        	}
	        	ans=Math.max(dp[i], ans);
	        }
	        System.out.println(Arrays.toString(dp));
	        return ans;
	    }
	 public static void main(String[] args) {
		int paris[][]= {{1,2},{2,3},{3,4}};
		System.out.println(findLongestChain(paris));
	}
}
