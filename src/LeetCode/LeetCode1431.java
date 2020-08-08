package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		for (int x : candies) {
			max = Math.max(x, max);
		}
		List<Boolean> ans = new ArrayList<Boolean>();
		for (int i = 0; i < candies.length; i++) {
			ans.add((candies[i] + extraCandies >= max));

		}
		return ans;
	}
}
