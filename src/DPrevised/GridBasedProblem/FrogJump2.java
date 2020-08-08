package DPrevised.GridBasedProblem;

import java.util.Arrays;
//o(NK)
public class FrogJump2 {
	public static void solve(int k,int stones[],int N) {
		int dp[] = new int[200];
		Arrays.fill(dp, -1);

//	
		dp[0]=0;
		dp[1]=Math.abs(stones[1]-stones[0]);
		
		for(int i=2;i<N;i++) {
			int minVal=Integer.MAX_VALUE;
			for(int j=1;j<=k;j++) {
				if(i-k>=0) {
					int op1=Math.abs(stones[i]-stones[i-k])+dp[i-k];
					minVal=Math.min(minVal, op1);
				}
			}
			dp[i] = minVal != Integer.MAX_VALUE ? minVal : 0;
			
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = { 10, 30, 40, 50 ,40};
		solve(3,stones, stones.length);
	}

}
