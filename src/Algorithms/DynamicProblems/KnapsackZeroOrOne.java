package Algorithms.DynamicProblems;

import java.util.Arrays;
//NP hard problems
public class KnapsackZeroOrOne {
    //o(2^N)
    public static int knapsackZeroOrOneRecursive(int vol[], int W[], int target, int n) {
        if (n == 0 || target == 0) {
            return 0;
        }
        if (target >= W[n - 1]) {
            return knapsackZeroOrOneRecursive(vol, W, target, n - 1);
        } else {
            return Math.max(knapsackZeroOrOneRecursive(vol, W, target, n - 1),
                    vol[n - 1] + knapsackZeroOrOneRecursive(vol, W, target - W[n - 1], n - 1));
        }
    }

    //o(Wn) but sudo polynomial . if W is big . then it may run worse than 2^n .space (O(wn))
    public static int knapsackZeroOrOneRecursiveDP(int vol[], int W[], int target, int n) {
//        take independent axis row and dependent axis as col
        int dp[][] = new int[target + 1][n + 1];

        for (int i = 0; i <= target; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= target; i++) {
            //for  1--->targer we will try place max Vol with in i weight
            for (int j = 1; j <= n; j++) {
                if (i <= W[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    //as we taking vol we should reduce target weight by deducting weight
                    dp[i][j] = Math.max(dp[i][j - 1], vol[j - 1] + dp[i - W[j - 1]][j - 1]);
                }
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[target][n];
    }

    public static void main(String[] args) {
        int vol[] = {10, 40, 30, 50};
        int weight[] = {5, 4, 6, 3};
        System.out.println(knapsackZeroOrOneRecursiveDP(vol, weight, 10, vol.length));
    }
}
