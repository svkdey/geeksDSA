package Algorithms.DynamicProblems;
/**
 Count ways to N'th Stair(Order does not matter) 
There are N stairs, and a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will be given.

Output:
For each testcase, in a new line, print number of possible ways to reach Nth stair.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 1000
1 <= N <= 106

Example:
Input:
2
4
5
Output:
3
3

Explanation:
Testcase 1: There are 3 ways to reach 4th stair
 **/
public class StairCaseOne {
//non recusive
	 public static long CountStepOrderMattersSolveDP(int n){
			//base case 
		    return (n/2)+1;
		}
	    Long countWays(int m){
	        
	        // your code here
	        return CountStepOrderMattersSolveDP(m);
	    } 
	    
	    Long countWaysDP(int m){
	        
	        Long res[] = new Long[m+1];
	        res[0] = 1L; 
	        res[1] = 1L;
	        for (int i = 2; i <= m; i++)  
	            res[i] = (res[i-2] + 1);
	      
	        return res[m];
	        
	    }
	    
	    
}
