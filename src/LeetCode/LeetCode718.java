package LeetCode;

import java.util.Arrays;

public class LeetCode718 {
	public String arrToString(int arr[]) {
		String a="";
		for(int x:arr) {
			a+=x;
		}
		return a;
	}
	 public int findLength(int[] A, int[] B) {
	        String s1=arrToString(A);
	        String s2=arrToString(B);
	        int n=s1.length();
	        int m=s2.length();
	        memo=new int[n+1][m+1];
	        for(int i=0;i<=n;i++){
	            Arrays.fill(memo[i],-1);
	        }
	        return topDown(s1, s2, n, m);
	    }
	 
	 static int memo[][] = null;

		public static int topDown(String a, String b, int m, int n) {
			if (memo[m][n] != -1) {
				return memo[m][n];
			} else {
				if (m == 0 || n == 0)
					return memo[m][n];

				if (a.charAt(m - 1) == b.charAt(n - 1)) {
					memo[m][n] = 1 + topDown(a, b, m - 1, n - 1);
					return memo[m][n];
				}

				memo[m][n] = Math.max(topDown(a, b, m - 1, n), topDown(a, b, m, n - 1));
				return memo[m][n];
			}
		}
}
