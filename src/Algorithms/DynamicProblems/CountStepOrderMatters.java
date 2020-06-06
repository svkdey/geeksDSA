package Algorithms.DynamicProblems;

public class CountStepOrderMatters {
	public static int CountStepOrderMattersSolveRecusive(int n){
		//base case 
		if(n==1||n==2) {
			return n;
		}else {
			//one can take 1/2 step at beginning . one would choose the path where he has to travel minimum
			return 1+Math.min(CountStepOrderMattersSolveRecusive(n-1),CountStepOrderMattersSolveRecusive(n-2));
		}
	}
	public static int CountStepOrderMattersSolveDP(int n){
		//base case 
		int dp[]=new int[n+1];
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=n;i++) {
			dp[i]=1+Math.min(dp[i-1],dp[i-2]);
		}
		
		return dp[n];
	}
	/**
	 * 	if order does not matter then use the the following eqtn m/2+m/3+...m/n +1 where [1,2,3,4,5..n] steps are allowed and order doesnot matter
	 * 
	 * 
	 * **/
	public static void main(String[] args) {
		System.out.println(CountStepOrderMattersSolveRecusive(3));
		System.out.println(CountStepOrderMattersSolveRecusive(4));
		System.out.println(CountStepOrderMattersSolveRecusive(5));
		System.out.println(CountStepOrderMattersSolveRecusive(7));
		System.out.println(CountStepOrderMattersSolveRecusive(8));
		System.out.println(CountStepOrderMattersSolveRecusive(10));
		System.out.println(CountStepOrderMattersSolveRecusive(11));
		System.out.println(CountStepOrderMattersSolveRecusive(12));
		
		System.out.println("------------------------------------------");
		System.out.println(CountStepOrderMattersSolveDP(3));
		System.out.println(CountStepOrderMattersSolveDP(4));
		System.out.println(CountStepOrderMattersSolveDP(5));
		System.out.println(CountStepOrderMattersSolveDP(7));
		System.out.println(CountStepOrderMattersSolveDP(8));
		
		System.out.println(CountStepOrderMattersSolveDP(9));
		System.out.println(CountStepOrderMattersSolveDP(10));
		System.out.println(CountStepOrderMattersSolveDP(11));
		System.out.println(CountStepOrderMattersSolveDP(12));
	}
}
