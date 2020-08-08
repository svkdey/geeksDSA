package LeetCode;

import java.util.Arrays;

public class LeetCode1524 {
	 public static int numOfSubarrays(int[] arr) {
		 	int n=arr.length;
	        int dp[]=new int[n+1];
	        
	        if(arr[0]%2!=0) {
	        	dp[0]=1;
	        }
	        
	        int ans=dp[0];
	        
	        for(int i=1;i<n;i++) {
	        	if(arr[i]%2==0) {
	        		dp[i]=dp[i-1];
	        	}else {
	        		dp[i]=i+1-dp[i-1];
	        	}
	        	ans=(ans+dp[i])%1000000007;
	        }
	        
	        return ans;
	    }
	 public static void main(String[] args) {
		int arr[]= {100,100,99,99};
		numOfSubarrays(arr);
	}
	 
}
