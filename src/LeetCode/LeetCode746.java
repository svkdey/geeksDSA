package LeetCode;

import java.util.Arrays;

public class LeetCode746 {
	static int dp[]=null;
	public static int minCostClimbingStairsUtil(int[] cost, int n) {
		if(n==1||n==0) {
			return 0;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int op1=cost[n-1]+minCostClimbingStairsUtil(cost, n-1);
		int op2=cost[n-2]+minCostClimbingStairsUtil(cost, n-2);
		return dp[n]=Math.min(op1, op2);
	}
	
	public static void main(String[] args) {
		
		int cost[]= {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		dp=new int[cost.length+1];
		Arrays.fill(dp, -1);
		int at0=minCostClimbingStairsUtil(cost, cost.length);
		System.out.println(Arrays.toString(dp));
		System.out.println(at0);
	
	}
	
	public static int minCostClimbingStairsBottomUP(int[] cost, int n) {
		
	}
}