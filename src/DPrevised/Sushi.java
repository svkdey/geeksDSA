package DPrevised;

public class Sushi {
	static double dp[][][]=null;
	public static double solve(int x,int y,int z,int n) {
		if(x<0||y<0||z<0) {
			return 1;
		}
		if(x==0||y==0||z==0) {
			return 0;
		}
		if(dp[x][y][z]!=(double)-1) {
			return dp[x][y][z];
		}
		double exp=n+x*solve(x-1, y, z, n)+y*solve(x+1, y-1, z, n)+z*solve(x, y+1, z-1, n);
		return dp[x][y][z]=exp;
	}
}
