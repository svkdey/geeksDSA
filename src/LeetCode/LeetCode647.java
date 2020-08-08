package LeetCode;

import java.util.Arrays;

public class LeetCode647 {
	public static int countSubstrings(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		int totalPallindromes = 0;

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			totalPallindromes++;
		}

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				totalPallindromes++;
			}
		}

		for (int subLen = 2; subLen < n; subLen++) {

			for (int i = 0; i < n - subLen; i++) {

				int j = i + subLen;

				if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 1;
					totalPallindromes++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		//printing palindrome by this method
		int x = -1;
		int strLen = 1;
		String str = s.substring(0, strLen);
		System.out.println(str);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (dp[i][j] == 1) {
					x = j;
				}
			}
//			System.out.println(x);
			if (x != -1 && x+1 - i > strLen) {
				
				strLen = x - i;
				str = s.substring(i, x + 1);
				x = -1;

			}
			System.out.println(str);

		}
		return totalPallindromes;

	}
	public static void main(String[] args) {
		
	}
}
