package LeetCode;

import java.util.Arrays;

public class LeetCode312 {
	static int dp[][]=null;
	public static int maxCoins(int[] nums) {
		
		int end=nums.length;
		int start=0;
		int arr[]=new int[end+2];
		for(int i=1;i<arr.length-1;i++) {
			arr[i]=nums[i-1];
		}
		arr[0]=arr[arr.length-1]=1;
		dp=new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		

        return solve(arr, 1, arr.length-1);
    }
	
	public static int solve(int arr[],int start, int  end) {
		if(start>=end) return 0;
		
		if(dp[start][end]!=-1) {
			return dp[start][end];
		}
		
		int val=0;
		for(int i=start;i<end;i++) {
			int left=arr[start-1];
			int right=arr[end];
			int current=arr[i];

			int subAns=solve(arr, start, i)+solve(arr, i+1, end)+(left*current*right);

			val=Math.max(val, subAns);
		}
		return dp[start][end]=val;

	}
	public static void main(String[] args) {
		int points[]= {3,1,5,8};
		System.out.println(maxCoins(points));
	}
}
