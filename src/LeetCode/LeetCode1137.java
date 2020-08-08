package LeetCode;

public class LeetCode1137 {
	public int tribonacci(int n) {
        int dp[]=new int[21474836];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
            System.out.println(i+"--->"+dp[i]);
        }
        return dp[n];
    }
	public static void main(String[] args) {
		LeetCode1137 s=new LeetCode1137();
		System.out.println(s.tribonacci(5));
	}
}
