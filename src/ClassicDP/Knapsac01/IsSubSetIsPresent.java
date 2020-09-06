package ClassicDP.Knapsac01;

import java.util.Arrays;

public class IsSubSetIsPresent {
	public static boolean solve(int arr[],int target) {
		int sum=0;
		for(int x:arr) {
			sum+=x;
		}
		boolean dp[][]=new boolean[arr.length+1][sum+1];
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
	
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(j>=arr[i-1]) {
					dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[arr.length][target];
	}
	
	public static void main(String[] args) {
		int arr[]= {1, 5, 11, 5};
		System.out.println(solve(arr, 20));
	}
}
