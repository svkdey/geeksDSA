package LeetCode;

import java.util.Arrays;

public class LeetCode416 {
	  public static boolean canPartition(int[] arr) {
	        int sum=0;int n=arr.length;
	        for(int x:arr) {
	        	sum+=x;
	        }
	        if(sum%2!=0) {
	        	return false;
	        }
	        sum=sum/2;
	        
	        return util(arr, n, sum);
	    }
	 
	  public static  boolean util(int[] arr,int n,int target) {
		  boolean dp[][]=new boolean[n+1][target+1];
		  for(int i=0;i<=target;i++) {
			  dp[0][i]=false;
		  }
		  for(int i=0;i<=n;i++) {
			  dp[i][0]=true;
		  }
		 
		  for(int i=0;i<=n;i++){
              System.out.println(Arrays.toString(dp[i]));
          }
		  System.out.println();
		  for(int i=1;i<=n;i++) {
			  for(int w=1;w<=target;w++) {
				  
					  if(w>=arr[i-1]) {
						  dp[i][w]=dp[i-1][w-arr[i-1]]||dp[i-1][w];
					  }else {
						  dp[i][w]=dp[i-1][w];
					  }
				  }
		  }
		  for(int i=0;i<=n;i++){
              System.out.println(Arrays.toString(dp[i]));
          }
		  return dp[n][target];
		  
	  }
	  public static void main(String[] args) {
		int arr[]= {1, 2, 3, 6};
		System.out.println(canPartition(arr));
	}
}
