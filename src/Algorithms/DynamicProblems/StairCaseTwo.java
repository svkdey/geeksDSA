package Algorithms.DynamicProblems;
/**
 There are N stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will be given.

Output:
For each testcase, in a new line, print number of possible ways to reach Nth stair. Answer your output % 10^9+7.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 105
1 <= N <= 105

Example:
Input:
3
4
10
24
Output:
5
89
75025
Explanation:
Testcase 1: You can reach 3rd stair in 5 ways.
 
 **/
public class StairCaseTwo {
	Long countWays(int m) {

		Long res[] = new Long[m + 1];
		res[0] = 1L;
		res[1] = 1L;
		for (int i = 2; i <= m; i++)
			res[i] = (res[i - 1] % 1000000007 + res[i - 2] % 1000000007) % 1000000007;

		return res[m];

	}

	int countWaysRecusive(int n) {

		if (n == 1 || n == 2) {
			return n;
		}
		return countWaysRecusive(n - 1) + countWaysRecusive(n - 2);
	}

}
