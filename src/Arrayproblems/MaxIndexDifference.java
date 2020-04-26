package Arrayproblems;

import Data.ArrayData;

public class MaxIndexDifference {
	/*
	 * Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
	Example:
	Input:
	2
	2
	1 10
	9
	34 8 10 3 2 80 30 33 1
	
	Output:
	1
	6
	 * */
	 static int maxIndexDiff(int arr[], int n) { 
	        
	        // Your code here;
		/*traverse right to left make rmax array that hold the values right hand side max values
		 * then take arrIdx=0 and rmaxIdx=0; maxDiffer=0;
		 * while(rmaxIdx<n&&j<arrIdx){
		 * 	if(rmax[rmaxInx]>=arr[arrIdx]) maxDiffer=Max(k-j,maxDiffer) and rmaxIdx++ bcz u need find max index diffence
		 * 	else arrIndex++ 
		 * }
		 * return maxDiff;
		 * */
		 
		 int rmax[] = new int[n];

	        rmax[n-1] = arr[n-1];
	        
	        for(int i=n-2;i >= 0; i--)
	        {
	            rmax[i] = Math.max(arr[i], rmax[i+1]);
	        }
	        
	        int arrIdx =0, rmaxIdx=0, maxdiff = 0;
	        
	        while(arrIdx <n && rmaxIdx < n)
	        {
	            if(arr[arrIdx] <= rmax[rmaxIdx])
	            {
	                maxdiff = Math.max(maxdiff, rmaxIdx-arrIdx);
	                rmaxIdx++;
	                
	            }
	            else
	            {
	            	arrIdx++;
	            }
	        }
	        
	        return maxdiff;
		
	    
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(maxIndexDiff(ArrayData.maxIndexDiff1, ArrayData.maxIndexDiff1.length));
	}

}
