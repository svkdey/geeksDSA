package Algorithms.DynamicProblems;

import java.util.Arrays;

public class FibonacciByDP {
    static int dp[] = new int[1000];

    public static void setDPArray() {
        for (int i = 0; i < 1000; i++) {
            dp[i] = -1;
        }
    }

    public static void resetDPArray() {
        for (int i = 0; i < 1000; i++) {
            dp[i] = -1;
        }
    }

    public static int findFibonacchiTopDown(int n) {
        if (dp[n] == -1) {
            int res = 0;
            if (n == 0 || n == 1) {
                res = n;
            } else {
                res = findFibonacchiTopDown(n - 1) + findFibonacchiTopDown(n - 2);

            }
            dp[n] = res;
        }
        return dp[n];

    }


    public static void main(String[] args) {

    }
}
