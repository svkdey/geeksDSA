package LeetCode;

import java.util.*;

public class LeetCode556 {
	public static int nextGreaterElement(int n) {
		if (n < 1)
			return -1;
		char cArr[] = Integer.toString(n).toCharArray();
		int arr[]=new int[cArr.length];
		for(int i=0;i<cArr.length;i++) {
			arr[i]=Integer.parseInt(Character.toString(cArr[i]));
		}
		
		nextPermutation(arr);
		int ans=0;
		int k=arr.length-1;
		for(int i=arr.length-1;i>=0;i--) {
			ans+=(arr[i]*Math.pow(10, k-i));
		}
		if(ans==Integer.MAX_VALUE) return -1;
		return ans>n?ans:-1;
	}
	public static void nextPermutation(int[] nums) {
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
 public static void reverse(int[] nums,int i,int j) {
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
	public static void main(String[] args) {
		LeetCode556 solve = new LeetCode556();
		System.out.println(solve.nextGreaterElement(230241));
		;
	}
}
