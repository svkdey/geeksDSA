package Algorithms.DynamicProblems;

public class NumbeOfwaysToCountN {
	static int count=0;
	public static void NumbeOfwaysToCountN(int target,int start) {
		if(target==0) {
			count=count+1;
//			System.out.println(count);
			return ;
		}
		for(int i=start;i<=target;i++) {
			NumbeOfwaysToCountN(target-i, i);
		}
	}
	public static int NumbeOfwaysToCountDP(int target) {
		int dp[]=new int[target+1];
		
		dp[0]=1;
		for(int i=1;i<target;i++) {//possible numbers
			for(int j=i;j<=target;j++) {//coint maney coins needed to maked i
				dp[j]+=dp[j-i];
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int count=0;
		NumbeOfwaysToCountDP(3);
		System.out.println(NumbeOfwaysToCountDP(3));
	}

}
