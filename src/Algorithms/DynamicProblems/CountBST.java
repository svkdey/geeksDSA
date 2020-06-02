package Algorithms.DynamicProblems;
/**
 res(n)=sum of res(i)*res(n-i-1); for( 0<i<n-1)
 and res(0)=1
 
 
 res(1)=res(0)*res(0)
 res(2)=res(0)*res(1)+res(1)res(0);
 res(3)=res(0)res(2)+res(1)*res(1)+res(2)res(0)
 
 **/

// space o(n^2) space=o(n)
public class CountBST {
	public static int countBST(int n) {
		int dp[]=new int[n+1];
		dp[0]=1;
		
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<i;j++) {
				dp[i]+=dp[i]*dp[i-j-1];
			}
		}
		return dp[n];		
	}
	
//	solution 2:
	
	//number of bst(n) =catalon number of(n)=(1/(n+1))* (2nCn)
	
}
