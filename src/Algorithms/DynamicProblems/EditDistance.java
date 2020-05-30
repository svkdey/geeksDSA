package Algorithms.DynamicProblems;

public class EditDistance {
    public static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }
        else if (n == 0) {
            return m;
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistance(s1, s2, m - 1, n - 1);
        } else {
            //here we can do 3 operations
            //1. dlt,2.insert 3.delete
            int delete = editDistance(s1, s2, m - 1, n); //satu   sun
            int insert = editDistance(s1, s2, m, n - 1);// satur +(n-n)    sun-n
            int update = editDistance(s1, s2, m - 1, n - 1);// satu  su
            return 1 + Math.min(delete, Math.min(insert, update));
        }

    }
    public static int editDistanceDP(String s1, String s2, int m, int n){
        int dp[][]=new int[m+1][n+1];
        for(int col=0;col<=n;col++){
            dp[0][col]=col;
        }
        for(int row=0;row<=m;row++){
            dp[row][0]=row;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                //    showDPArry(dp,m,n);
            }
        }

        return dp[m][n];

    }
    static void showDPArry(int arr[][],int m,int n){
        System.out.println("------------------------");
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String s1="CAT",s2="CUT";
        int m=s1.length(),n=s2.length();
        System.out.println(editDistanceDP(s1,s2,m,n));
    }
}
