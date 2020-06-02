package Algorithms.DynamicProblems;

import java.util.Arrays;

public class SubsetSumProblems {
	//o(2^n)
	public static int SubsetSumProblemsImpl(int arr[], int n, int target) {
		if(n==0) {
			if(target==0) return 1;
			else return 0;
		} else {
//			process all set by taking the element by taking it and by not taking it
			return SubsetSumProblemsImpl(arr, n - 1, target - arr[n - 1]) + SubsetSumProblemsImpl(arr, n - 1, target);
		}
	}
	public static int SubsetSumProblemsImplDP(int arr[], int n, int target) {
		int dp[][]=new int[target+1][n+1];
		//if n==0 ie no element left
		for(int i=1;i<=target;i++) {
			dp[i][0]=0;
		}
		
		//for any n value  if target is zero then we can choose only not to pick that is one way
		
		for(int i=0;i<=n;i++) {
			dp[0][i]=1;
		}
		
			for(int i=1;i<=target;i++) {
			//neglecting -ve target value
				for(int j=1;j<=n;j++) {
				if(arr[j-1]>i) {
					dp[i][j]=dp[i][j-1];
				}else { 
					dp[i][j]=dp[i-arr[j-1]][j-1]+dp[i][j-1];
				}
			}
		}
			
//	for(int i=0;i<=target;i++) {
//			for(int j=0;j<=n;j++) {
//				System.out.print(dp[i][j]+" ");
//				
//			}
//			System.out.println();
//	}
		
		return dp[target][n];
	}

	public static void main(String[] args) {
		int arr[]= {10,5,2,3,6};
		System.out.println(SubsetSumProblemsImplDP(arr, arr.length, 8));
	}
}
