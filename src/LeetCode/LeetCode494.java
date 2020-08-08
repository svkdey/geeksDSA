package LeetCode;

import java.util.Arrays;

public class LeetCode494 {
	 public int findTargetSumWays(int[] nums, int S) {
	        int sum=0;
	        for(int x:nums){
	            sum+=x;
	        }
	        
	        //s1+s2=sum
	        //s2-s1=diff or S
	        //2*s2=sum+diff
	        //s2=(sum+diff)/2
	        
	        if(S>sum)
	            return 0;
	        
	        if((sum+S)%2!=0)
	            return 0;
	        
	        int subsetSum=(S+sum)/2;
	        
	        return findSubsetSum(nums,subsetSum);
	    }
	     private static int findSubsetSum(int a[],int n){
	        
	        int dp[][]=new int[a.length+1][n+1];
	        
	        for(int i=0;i<a.length+1;i++){
	            for(int j=0;j<n+1;j++){
	                if(i==0)
	                    dp[i][j]=0;
	                if(j==0){
	                    if(i>0 && j>=a[i-1])
	                    dp[i][j]=dp[i-1][j]+dp[i-1][j-a[i-1]];
	                    else
	                     dp[i][j]=1;  
	                }
	                   
	            }
	        }
	         for(int i=0;i<a.length+1;i++){
				  System.out.println(Arrays.toString(dp[i]));
			  }
	        for(int i=1;i<a.length+1;i++){
	            for(int j=0;j<n+1;j++){
	                if(a[i-1]<= j){
	                     dp[i][j]=dp[i-1][j]+dp[i-1][j-a[i-1]];
	                }else{
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	        }
	        
	        return dp[a.length][n];
	        
	    }
}
