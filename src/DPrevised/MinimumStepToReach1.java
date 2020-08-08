package DPrevised;

import java.util.Arrays;

public class MinimumStepToReach1 {
//	static int ans=0;
	static int dp[]=null;
	public static int minSteps(int n) {
//		look up state
		if(dp[n]!=-1) {
			return dp[n];
		}
		if(n<1) {
			return 0;
		}
		if(n==1) {
			return 0;
		}
		int op1,op2,op3;
		op1=Integer.MAX_VALUE;
		op2=Integer.MAX_VALUE;
		
		op3=Integer.MAX_VALUE;
		if(n%3==0) {
			op1=minSteps(n/3)+1;
		}
		if(n%2==0) {
			op2=minSteps(n/2)+1;
		}
		else {
			op3=minSteps(n-1)+1;
		}
		 dp[n]=Math.min(op1, Math.min(op2, op3));
		return dp[n];
	}
	
	public static int bottomUp(int n) {
		int lookUp[]=new int[10000];
		for(int i=2;i<=n;i++) {
	
			int op1,op2,op3;
			op1=Integer.MAX_VALUE;
			op2=Integer.MAX_VALUE;
			op3=Integer.MAX_VALUE;
			if(i%3==0) {
				op1=lookUp[i/3]+1;
			}
			if(i%2==0) {
				op2=lookUp[i/2]+1;
			}
			else {
				op3=lookUp[i-1]+1;
			}
			lookUp[i]=Math.min(op2, Math.min(op1, op3));
		//	System.out.println(Arrays.toString(lookUp));
		}
	
		return lookUp[n];
	}
	
	public static void main(String[] args) {
		dp=new int[100000];
		Arrays.fill(dp, -1);
		int a=bottomUp(4);
		System.out.println(a);
	}
}
