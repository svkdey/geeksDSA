package Arrayproblems;
/*
 * Subarray with given sum
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

User Task:
The task is to complete the function subarraySum() which finds starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else -1 is printed. The driver code automatically appends a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= Ai <= 1010

Example:
Input:
3
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
4 15
5 7 1 2
Output:
2 4
1 5
1 4

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12.
Testcase2: sum of elements from 1st position to 5th position is 15.
Testcase 3: Sum of elements from 1st to 4th position is 15.

** For More Input/Output Examples Use 'Expected Output' option ***/

class SubArraySum {

	// Function to find sub array with given sum
	static void subarraySum(int n, int s, int[] arr) {

		// Your code here
		int sum = 0;
		boolean notFound = true;
		int l = 0, r = -1;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			r++;
			while (sum > s) {
				sum -= arr[l];
				l++;
			}
			if (sum == s) {
				notFound = false;
				System.out.print((l + 1) + " " + (r + 1));
				break;
			}
		}
		if (notFound) {
			System.out.print(-1);
		}

	}
}