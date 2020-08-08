package DPrevised;

import java.util.Arrays;
import java.util.Stack;

public class LCS {
	static int memo[][] = null;

	public static int topDown(String a, String b, int m, int n) {

			if(m==0||n==0) return 0;
			if (memo[m][n] != -1) {
				return memo[m][n];
			} 

			if (a.charAt(m - 1) == b.charAt(n - 1)) {
				memo[m][n] = 1 + topDown(a, b, m - 1, n - 1);
				return memo[m][n];
			}

			memo[m][n] = Math.max(topDown(a, b, m - 1, n), topDown(a, b, m, n - 1));
			return memo[m][n];
		
	}
	static Stack<Character> s = new Stack<Character>();
	public static int solve(String a, String b, int m, int n) {
		if (m == 0 || n == 0)
			return 0;

		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			s.push(a.charAt(m - 1));
			return 1 + solve(a, b, m - 1, n - 1);
		}

		return Math.max(solve(a, b, m - 1, n), solve(a, b, m, n - 1));

	}

	public static void main(String[] args) {
		String s1 = "12321";
		String s2 = "32147";
		memo=new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<memo.length;i++) {
		Arrays.fill(memo[i], -1);
	}
//		for(int i=0;i<memo.length;i++) {
//			for(int j=0;j<memo[i].length;j++) {
//				if(i==0||j==0) {
//					memo[i][j]=0;
//				}else {
//					memo[i][j]=-1;
//				}
//			}
//		}
//		System.out.println(topDown(s1, s2, s1.length(), s2.length()));
		System.out.println(topDown(s1, s2, s1.length(), s2.length()));
		for(int i=0;i<memo.length;i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
		
	}
	
	
}
