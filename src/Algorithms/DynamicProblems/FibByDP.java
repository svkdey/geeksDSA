package Algorithms.DynamicProblems;

import java.util.Arrays;

public class FibByDP {
    static int dp2[]=new int[1000];

    public static int findFibonacchiBottomUp(int n) {

        dp2[1] = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                System.out.println(dp2[i - 1] +" "+ dp2[i - 2]);
                dp2[i] = (dp2[i - 1] + dp2[i - 2]);

            }
        }
        return dp2[n];

    }
    public static void main(String[] args) {
        System.out.println(findFibonacchiBottomUp(5));

    }
}
