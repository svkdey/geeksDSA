package LeetCode;



public class LeetCode1413 {
	static class Range {
		int x = -1, y = -1;

		@Override
		public String toString() {
			return "Range [x=" + x + ", y=" + y + "]";
		}

		public Range() {

		}

		public Range(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	public static int solve(int nums[]) {
		Range r = new Range();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				if (r.x == -1) {
					r.x = i;
					r.y = i;
				} else  {
					r.y = i;
				}
			}
		}
		if(r.x==-1) return nums[0];
		int lsum=0;
		for(int i=0;i<r.x;i++) {
			lsum+=nums[i];
		}
		int msum=0;
		for(int i=r.x;i<=r.y;i++) {
			msum+=nums[i];
		}
		int ans =lsum+msum;
		System.out.println(Math.abs(ans));
		return Math.abs(ans)+1;
	}
	public static void main(String[] args) {
		int nums[]= {1,-2,-3};
		System.out.println(solve(nums));
	}
}
