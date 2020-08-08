package Sorting;

import java.util.Arrays;

public class SegrigateTwoTypeElements {
	/*
	 * this problem can be asked many ways
	 * 
	 * segrigate  +Ve and -Ve
	 * segrigate  odd  and even
	 * segrigate binary bits
	 * */
	static void segrigateTwoTypeElements(int arr[],int n) {
		int startIdx=-1;
		int endIdx=n;
		while(true) {
			//just change the condition to changed
			
			do {startIdx++;}while(arr[startIdx]<0);
			do {endIdx--;}while(arr[endIdx]>0);
			if(startIdx>=endIdx) return;
			swap(arr,startIdx,endIdx);
		}
	}
	static void BinaryPartition(int arr[],int n) {
		int startIdx=-1;
		int endIdx=n;
		while(true) {
			//just change the condition to changed
			
			do {startIdx++;}while(arr[startIdx]==0);
			do {endIdx--;}while(arr[endIdx]==1);
			if(startIdx>=endIdx) return;
			swap(arr,startIdx,endIdx);
		}
	}
//	 public static void swap(int nums[], int i, int j) {
//	        int temp = nums[i] ^ nums[j];
//	        nums[i] = temp ^ nums[i];
//	        nums[j] = temp ^ nums[j];
//	    }

	    public static void twoWayPartition(int nums[], int s, int e) {
	        int pivot = 1;
	        int i = s - 1;
	        for (int j = s; j <= e; j++) {
	            if (pivot > nums[j]) {
	                i++;
	                swap(nums, i, j);
	            }
	        }
	        System.out.println(Arrays.toString(nums));
	    }
	    public static void twoWayPartitionOddEven(int nums[], int s, int e) {
//	        int pivot = 1;
	        int i = s - 1;
	        for (int j = s; j <= e; j++) {
	            if (nums[j]%2==1) {
	                i++;
	                swap(nums, i, j);
	            }
	        }
	        System.out.println(Arrays.toString(nums));
	    }
	static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[]= {1,2,4,-3,6,-5,-6};
//		segrigateTwoTypeElements(arr,arr.length);
		int arr[]={1, 0, 1, 1, 1, 1, 1, 0, 0, 0};
		BinaryPartition(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
	}

}
