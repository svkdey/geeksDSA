package Algorithms.DynamicProblems;

import java.util.Arrays;

/**
 * res(n)=sum of res(i)*res(n-i-1); for( 0<i<n-1) and res(0)=1
 * 
 * 
 * res(1)=res(0)*res(0) res(2)=res(0)*res(1)+res(1)res(0);
 * res(3)=res(0)res(2)+res(1)*res(1)+res(2)res(0)
 * 
 **/

// space o(n^2) space=o(n)
public class CountBST {
	public static int countBST(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) { // i represents root
		
			for (int j = 0; j < i; j++) { // j represnts number of element on left side and i-j-1 represent right side
				dp[i] += dp[j] * dp[i-j - 1];
			}

		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	public static int countBSTRecusive(int n) {
		if (n == 0)
			return 1;
		int sum = 0;
		for (int i = 0; i <= n - 1; i++) {
			// i th value as root * rest on left
			int j = n - i;
			sum += countBSTRecusive(i) * countBSTRecusive(j - 1);
		}
//		System.out.println(sum);
		return sum;
	}

//	solution 2:

	// number of bst(n) =catalon number of(n)=(1/(n+1))* (2nCn)

//	best  solution
	public static int countBSTRecusiveFormulae(int n) {
		long bionaryCoeff = NcrImpl.coEfficient(2 * n, n);
		return (int) (bionaryCoeff / (n + 1));
	}

	public static void main(String[] args) {
		System.out.println(countBSTRecusive(6));
		System.out.println(countBST(6));
	}

}
