package LeetCode;

import java.util.Arrays;
import java.util.List;

public class LeetCode139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String subSTr = s.substring(j, i);
				if (dp[j] && wordDict.contains(subSTr)) {
					System.out.println(subSTr);
					dp[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(dp));

		return dp[s.length()];
	}
}
