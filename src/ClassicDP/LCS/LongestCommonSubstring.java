package ClassicDP.LCS;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static int LongestCommonSubstring(String s1,String s2) {
			int memo[][] = new int[s1.length() + 1][s2.length() + 1];
			for (int i = 1; i <=s1.length(); i++) {
				for (int j = 1; j <=s2.length();j++) {
					if (s1.charAt(i-1) == s2.charAt(j-1)) {
						memo[i][j] = 1 + memo[i - 1][j - 1];

					} else {
						memo[i][j] = 0;
					}
				}
			}
			for (int i = 0; i <= s1.length(); i++) {
				System.out.println(Arrays.toString(memo[i]));
			}
			return memo[s1.length()][s2.length()];
		
	}
	public static void main(String[] args) {
		String s1 = "12321";
		String s2 = "32147";

		System.out.println(LongestCommonSubstring(s1, s2));

	}
}
