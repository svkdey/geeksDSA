package LeetCode;

import java.util.HashSet;

public class LeetCode268 {
	class Range {
		int x = Integer.MAX_VALUE, y = Integer.MIN_VALUE;

		public Range() {
		};
	}

	public int missingNumber(int[] nums) {
		HashSet<Integer> s = new HashSet<Integer>();
		Range r = new Range();
		for (int x : nums) {
			r.x = Math.min(r.x, x);
			r.y = Math.max(r.y, x);
			s.add(x);
		}
		for (int i = r.x; i <= r.y; i++) {
			if (!s.contains(i)) {
				return i;
			}
		}
		return -1;
	}
}
