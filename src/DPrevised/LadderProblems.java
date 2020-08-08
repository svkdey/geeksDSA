package DPrevised;

import java.util.Arrays;
//(nk)
public class LadderProblems {
	static int dp[]=null;
	public static int solve(int numberOfStep,int steps[]) {
		if(numberOfStep<0) return 0;
		if(numberOfStep==0) return dp[0];
		if(dp[numberOfStep]!=-1) {
			return dp[numberOfStep];
		}
		int ans=0;
		for(int i=0;i<steps.length;i++) {
			ans+=solve(numberOfStep-steps[i], steps);
		}
		dp[numberOfStep]=ans;
		return dp[numberOfStep];
	}
	
	
//	dp[n]=sum of dp[i-k]
	public static int bottomUp(int numberOfStep,int steps[]) {
		int temp[]=new int[100];
		temp[0]=1;
		
		for(int i=1;i<=numberOfStep;i++) {
			temp[i]=0;
			for(int j=0;j<steps.length;j++) {
				if(i-steps[j]>=0) {
					temp[i]+=temp[i-steps[j]];
				}
			}
		}
		System.out.println(Arrays.toString(temp));
		return temp[numberOfStep];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp=new int[100];
		Arrays.fill(dp,-1);
		dp[0]=1;
		int steps[]= {1,2,3};
		System.out.println(bottomUp(4, steps));
//		System.out.println(Arrays.toString(dp));
	}

}
