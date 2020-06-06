package Algorithms.DynamicProblems;

public class OptimalStrategyOfTheGame {
    public static int findOptimalStrategyToWin(int arr[], int i, int j, int sum) {
        if (i + 1 == j) {
            //if 2 element left i will pick highest
            return Math.max(arr[i], arr[j]);
        }
        //always removing highest
        return Math.max(sum - findOptimalStrategyToWin(arr, i + 1, j, sum - arr[i]),
                sum - findOptimalStrategyToWin(arr, i, j - 1, sum - arr[j]));
    }

    public static int findOptimalStrategyToWinWrapper(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return findOptimalStrategyToWin(arr, 0, n - 1, sum);
    }

    public static int solutiontwo(int arr[], int i, int j) {
        if (i + 1 == j) {
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(arr[i] + Math.min(solutiontwo(arr, i + 2, j), solutiontwo(arr, i + 1, j - 1)),
                arr[j] + Math.min(solutiontwo(arr, i + 1, j - 1), solutiontwo(arr, i, j - 2)));
    }
    
    
    public static int solutionDP(int arr[], int n) {
      int dp[][]=new int[n][n];
      for(int i=0;i<n-1;i++){
          dp[i][i+1]=Math.max(arr[i],arr[i+1]);
      }
      for(int gap=3;gap<n;gap=gap+2){
          for(int i=0;i+gap<n;i++){
              int j=i+gap;
              dp[i][j]=Math.max(arr[i]+Math.min(dp[i+1][j],dp[i+1][j-1]),
                      arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
          }
      }
      return dp[0][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 8, 5, 6, 7};
        System.out.println(findOptimalStrategyToWinWrapper(arr, arr.length));

    }
}
