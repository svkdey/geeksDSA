package StackDSA;

import java.util.Stack;

/*
 * Given an integer array A[] of size N. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to n.

Input:
The first line contains an integer T denoting the total number of test cases. In each test cases, the first line contains an integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
In each seperate line, print the array of numbers of size N for each of the considered window size 1, 2 , ..., N respectively.

User Task:
The task is to complete the function printMaxOfMin() which finds the maximum of minimum of every window size.

Constraints:
1 <= T <= 50
1 <= N <= 105
1 <= A[i] <= 106

Example:
Input: 
2
7
10 20 30 50 10 70 30
3
10 20 30
Output: 
70 30 20 10 10 10 10 
30 20 10

Explaination:
Testcase 1:
First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10}, {70} and {30}. Maximum of these minimums is 70.
Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10}, and {30}. Maximum of these minimums is 30.
Third element in output indicates maximum of minimums of all windows of size 3. Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}. Maximum of these minimums is 20.
Similarly other elements of output are computed.
Testcase 2: First element in output indicates maximum of minimums of all windows of size 1.Minimums of windows of size 1 are {10} , {20} , {30}. Maximum of these minimums are 30 and similarly other outputs can be computed. */

public class MaxOfMins {
	// brute force
	
	/* make window size k= 1 to n-1
	 * tarverser window 0->k, 1->k+1 till n-k<n;
	 * {find min of 1 to k
	 * }
	 * find max of all the window
	 * 
	 * */
	static void printMaxOfMinBruteForce(int arr[],int n) {
		// Consider all windows of different sizes starting
		// from size 1
		for (int k = 1; k <= n; k++) {
			// Initialize max of min for current window size k
			int maxOfMin = Integer.MIN_VALUE;

			// Traverse through all windows of current size k
			for (int i = 0; i <= n - k; i++) {
				// Find minimum of current window
				int min = arr[i];
				for (int j = 1; j < k; j++) {
					if (arr[i + j] < min)
						min = arr[i + j];
				}

				// Update maxOfMin if required
				if (min > maxOfMin)
					maxOfMin = min;
			}

			// Print max of min for current window size
			System.out.print(maxOfMin + " ");
		}
	}
	//recommended to watch https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
	
	static void printMaxOfMinEffeciveApproach(int[] arr, int n) {
        
	       Stack<Integer> s = new Stack<>(); 
	       
	       
	        int left[] = new int[n+1];   
	        int right[]  = new int[n+1];  
	       
	       
	        for (int i=0; i<n; i++) 
	        { 
	            left[i] = -1; 
	            right[i] = n; 
	        } 
	       
	        for (int i=0; i<n; i++) 
	        { 
	            while (!s.empty() && arr[s.peek()] >= arr[i]) 
	                s.pop(); 
	       
	            if (!s.empty()) 
	                left[i] = s.peek(); 
	       
	            s.push(i); 
	        } 
	       
	    
	        while (!s.empty()) 
	            s.pop(); 
	       
	        
	        for (int i = n-1 ; i>=0 ; i-- ) 
	        { 
	            while (!s.empty() && arr[s.peek()] >= arr[i]) 
	                s.pop(); 
	       
	            if(!s.empty()) 
	                right[i] = s.peek(); 
	       
	            s.push(i); 
	        } 
	  
	        int ans[] = new int[n+1]; 
	        for (int i=0; i<=n; i++) 
	            ans[i] = 0; 
	      
	        for (int i=0; i<n; i++) 
	        { 
	            
	            int len = right[i] - left[i] - 1; 
	       
	            ans[len] = Math.max(ans[len], arr[i]); 
	        } 
	       
	       
	        for (int i=n-1; i>=1; i--) 
	            ans[i] = Math.max(ans[i], ans[i+1]); 
	       
	       StringBuilder str 
	            = new StringBuilder(); 
	        for (int i=1; i<=n; i++) 
	            str.append(ans[i] + " "); 
	        
	        System.out.println(str); 
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
