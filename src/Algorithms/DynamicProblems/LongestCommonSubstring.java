package Algorithms.DynamicProblems;

public class LongestCommonSubstring {
    public static int[][] dp = null;

    public static int LCSbyDPTabular(String str1, String str2, int m, int n) {
       for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
               }else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }
       return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "AyyyAbeaskXXEZ";
        String str2 = "AEZ";
        int m = str1.length();
        int n = str2.length();
        dp=new int[m+1][n+1];


        System.out.println(LCSbyDPTabular(str1, str2, m, n));
        // System.out.println(Arrays.toString(dp));
    }
}
