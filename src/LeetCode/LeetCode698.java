package LeetCode;

import java.util.Arrays;

public class LeetCode698 {
	  public boolean canPartitionKSubsets(int[] nums, int k) {
		  	int sum=0;
		  	for(int i=0;i<nums.length;i++) {
		  		sum+=nums[i];
		  	}
		  	return countOfsubsetSum(nums,sum/k)==k;
	    }
	  
	  public int countOfsubsetSum(int nums[],int target) {
		  int n=nums.length;
		  int t[][]=new int[n+1][target+1];
		  for(int i=0;i<target+1;i++) {
			  t[0][i]=0;
		  }
		  for(int i=0;i<n+1;i++) {
			  t[i][0]=1;
		  }
		  
		  for(int i=1;i<=n;i++) {
			  for(int j=1;j<=target;j++) {
				  if(j>=nums[i-1]) {
					  t[i][j]=t[i-1][j]+t[i-1][j-nums[i-1]]; 
				  }else {
					  t[i][j]=t[i-1][j];
				  }
			  }
		  }
		
		  return t[n][target];
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
