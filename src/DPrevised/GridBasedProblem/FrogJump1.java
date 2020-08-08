package DPrevised.GridBasedProblem;

import java.util.Arrays;

public class FrogJump1 {

	public static void solve(int stones[], int N) {
		int dp[] = new int[200];
		Arrays.fill(dp, -1);

//	
		dp[0]=0;
		dp[1]=Math.abs(stones[1]-stones[0]);
		for(int i=2;i<N;i++) {
			int op1=Math.abs(stones[i]-stones[i-1])+dp[i-1];
			int op2=i-2>=0?Math.abs(stones[i]-stones[i-2])+dp[i-2]:Integer.MAX_VALUE;
			dp[i]=Math.min(op1, op2);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}
	
	public static void topDown(int stones[], int N) {
		
		int op1=0,op2=0;
		
	}


	public static void main(String[] args) {
		int stones[] = { 10, 30, 40, 50 ,40};
		solve(stones, stones.length);
	}

}
