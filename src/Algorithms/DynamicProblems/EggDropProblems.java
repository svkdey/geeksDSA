package Algorithms.DynamicProblems;

import Utility.Utils;

public class EggDropProblems {
	
	
	public static int solveRecusive(int floor, int egg) {

		// if we have 1 egg then we have to 1,2,3,4,...Floor n to check if it is breaks or not
		if (egg == 1)
			return floor;

		// if we infy eggs but have only 1/0 floor number of attempt will be 1 or zero
		if (floor == 1 || floor == 0)
			return floor;
		// lets result is infinite attempt
		int result = Integer.MAX_VALUE;

		for (int i = 1; i <= floor; i++) {
			//1. if egg breaks then we will search in below height i with left eggs 
			//2. if egg does not break. we will search int left floor -i floors
			int temp = Math.max(solveRecusive(i - 1, egg - 1), solveRecusive(floor - i, egg));
			result = Math.min(result, temp);
		}
		return result+1;
	}
	public static int solveDP(int floor, int egg) {

		int dp[][]=new int[egg+1][floor+1];
//		for(int i=0;i<dp.length;i++) {
//			Arrays.fill(dp[i], Integer.MAX_VALUE);
//		}
		
		for(int i=1;i<dp.length;i++) {
			dp[i][1]=1;
			dp[i][0]=0;
		}
		
		for(int i=1;i<=floor;i++) {
			dp[1][i]=i;
		}
		Utils.p2Darray(dp);
		
		for(int i=2;i<=egg;i++) {
			
			for(int j=2;j<=floor;j++) {
				int temp=Integer.MIN_VALUE;
				dp[i][j]=Integer.MAX_VALUE;
				//we are trying like for i=3,j=2 value ,dp[3][2] will be
				for(int x=1;x<=j;x++) {
					temp=1+Math.max(dp[i-1][x-1],dp[i][j-x]);
					dp[i][j]=Math.min(temp, dp[i][j]);
				}
			}
			
		}
		Utils.p2Darray(dp);
		
		return dp[egg][floor];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveDP(19, 2));
	}

}
