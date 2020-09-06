package LeetCode;

import java.util.Arrays;

public class LeetCode91 {
	public int numDecodings(String s) {
		int dp[] = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			String s1 = s.substring(i - 1,i);
			String s2 = s.substring(i - 2,i);
			if (Integer.parseInt(s1)>0) {
				dp[i] += dp[i - 1];
			}
			if (Integer.parseInt(s2) >= 10 && Integer.parseInt(s2) <= 26) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];

	}
}
