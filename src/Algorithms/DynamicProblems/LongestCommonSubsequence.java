package Algorithms.DynamicProblems;


public class LongestCommonSubsequence {
    public static void resetDP(int m,int n){
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
    }
    public static int LCSbyRecusion(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + LCSbyRecusion(str1, str2, m - 1, n - 1);
        } else {
            return Math.max(LCSbyRecusion(str1, str2, m - 1, n), LCSbyRecusion(str1, str2, m, n - 1));
        }
    }

    public static int[][] dp = null;

    public static int LCSbyDP(String str1, String str2, int m, int n) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        else {
            if (m == 0 || n == 0) {
                dp[m][n] = 0;
            }
            else if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                dp[m][n] = 1 + LCSbyDP(str1, str2, m - 1, n - 1);
            } else {
                dp[m][n] = Math.max(LCSbyDP(str1, str2, m, n - 1), LCSbyDP(str1, str2, m - 1, n));
            }
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        String str1 = "AXXZ";
        String str2 = "AZ";
        int m = str1.length();
        int n = str2.length();
        dp=new int[m+1][n+1];
        resetDP(m,n);

        System.out.println(LCSbyDP(str1, str2, m, n));
       // System.out.println(Arrays.toString(dp));
    }
}
