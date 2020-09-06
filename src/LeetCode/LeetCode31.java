package LeetCode;

public class LeetCode31 {
//	https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia
	 public void nextPermutation(int[] nums) {
	        int n=nums.length,pivot=-1,pivotValue=0;
	        for(int i=n-2;i>=0;i--) {
	        	if(nums[i+1]>nums[i]) {
	        		pivot=i;
	        		pivotValue=nums[i];
	        		break;
	        	}
	        }
	        if(pivot==-1) {
	        	reverse(nums,0,n-1);
	        	return;
	        }
	        for(int i=n-1;i>=0;i--) {
	        	if(nums[i]>pivotValue) {
	        		swap(nums, pivot, i);
	        		break;
	        	}
	        }
	        reverse(nums, pivot+1, n-1);
	   }
	 public void reverse(int[] nums,int i,int j) {
		 while(j>i) {
			 swap(nums, i, j);
			 i++;j--;
		 }
	 }
	 private static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
