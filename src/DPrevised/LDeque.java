package DPrevised;

import java.util.Arrays;

public class LDeque {
	public static void solve(int arr[]) {
		int sum=0;
		int i=0;int j=arr.length-1;
		for(int x:arr) {
			sum+=x;
		}
		dp=new int[j+1][j+1];
		for(int k=0;k<j+1;k++) {
			Arrays.fill(dp[k], -1);
		}
		int player1=calculate(arr, i, j, sum);
		for(int k=0;k<j+1;k++) {
			System.out.println(Arrays.toString(dp[k]));
		}
		int player2=sum-player1;
		
		System.out.println(player1 -player2);
	}
	static int dp[][]=null;
	public static int calculate(int arr[],int i ,int j ,int sum) {
		if(i+1==j) {
			return Math.max(arr[i], arr[j]);
		}
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int op1=sum-calculate(arr, i+1, j, sum-arr[i]);
		int op2=sum-calculate(arr, i, j-1, sum-arr[j]);
		return dp[i][j]=Math.max(op1, op2);
	}
	public static void main(String[] args) {
		int arr[]= {10,80,90,30,30,20,60,70,55,122,56,67};
		solve(arr);
	}
	
}
