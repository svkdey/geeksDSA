package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode377 {

	public static int combinationSum4(int[] nums, int target) {

		dp=new int[target+1]; 
		Arrays.fill(dp, -1);
		util(nums, target, nums.length,new ArrayList<Integer>());
		
		 return dp[target];
		
	}
	
	static int dp[]=null;
	public static int util(int[] nums, int target, int n,ArrayList<Integer> list) {
			if(target==0) {
			
				return 1;
			}
		if(dp[target]!=-1) {
			return dp[target];
		}
		int count=0;
		for(int i=0;i<n;i++) {
			if(target>=nums[i]) {
				list.add(nums[i]);
				count+=util(nums, target-nums[i], n, list);
				list.remove(list.size()-1);
			}
			

		}
		
		return dp[target]=count;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}
}
