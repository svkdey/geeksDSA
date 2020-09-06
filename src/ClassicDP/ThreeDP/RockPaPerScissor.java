package ClassicDP.ThreeDP;

import java.util.Arrays;

public class RockPaPerScissor {
	static double dp[][][] = null;

	static double rockServival(int r, int s, int p) {
		if (r == 0 || s == 0) {
			return 0;
		}
		if (p == 0) {
			return 1;
		}
		if (dp[r][s][p] != -1) {
			return dp[r][s][p];
		}
		double total = r * s + r * p + s * p;
		double ret = 0;
		ret += rockServival(r - 1, s, p) * ((r * p) / total);
		ret += rockServival(r, s - 1, p) * ((r * s) / total);
		ret += rockServival(r, s, p - 1) * ((s * p) / total);
		return dp[r][s][p] = ret;
	}

	static double paperServival(int r, int s, int p) {
		if (r == 0 || p == 0) {
			return 0;
		}
		if (s == 0) {
			return 1;
		}
		if (dp[r][s][p] != -1) {
			return dp[r][s][p];
		}
		double total = r * s + r * p + s * p;
		double ret = 0;
		ret += paperServival(r - 1, s, p) * ((r * p) / total);
		ret += paperServival(r, s - 1, p) * ((r * s) / total);
		ret += paperServival(r, s, p - 1) * ((s * p) / total);
		return dp[r][s][p] = ret;
	}

	static double scissorServival(int r, int s, int p) {
		if (s == 0 || p == 0) {
			return 0;
		}
		if (r == 0) {
			return 1;
		}
		if (dp[r][s][p] != -1) {
			return dp[r][s][p];
		}
		double total = r * s + r * p + s * p;
		double ret = 0;
		ret += scissorServival(r - 1, s, p) * ((r * p) / total);
		ret += scissorServival(r, s - 1, p) * ((r * s) / total);
		ret += scissorServival(r, s, p - 1) * ((s * p) / total);
		return dp[r][s][p] = ret;
	}
	public static void setDp(int r, int s, int p) {
		for(int i=0;i<=r;i++) {
			for(int j=0;j<=s;j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
	}
	static void rockPaPerScissor(int r, int s, int p) {
		dp = new double[r + 1][s + 1][p + 1];
		setDp(r,s,p);
		System.out.println(rockServival(r, s, p));
	
		
		dp = new double[r + 1][s + 1][p + 1];
		setDp(r,s,p);
		System.out.println(scissorServival(r, s, p));
		
		
		dp = new double[r + 1][s + 1][p + 1];
		setDp(r,s,p);
		System.out.println(paperServival(r, s, p));
	}
	public static void main(String[] args) {
		rockPaPerScissor(2,1,2);
	}
}
