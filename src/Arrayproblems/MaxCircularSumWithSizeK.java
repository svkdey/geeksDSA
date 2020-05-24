package Arrayproblems;

import java.util.Arrays;

public class MaxCircularSumWithSizeK {
    public static int maxSumWithSliding(int arr[], int k, int n) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = Math.max(sum, maxSum);
        for (int j = k; j < n; j++) {
            sum += arr[j] - arr[j - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void MaxCircularSumWithSizeKImpl(int arr[], int k, int n) {
        int withOutRotationMaxSum = maxSumWithSliding(arr, k, n);
        //left shift array in n space
        reverseInWindow(arr, 0, k - 1, n);
        reverseInWindow(arr, k, n - 1, n);
        reverseInWindow(arr, 0, n - 1, n);

        int withRotationMaxSum = maxSumWithSliding(arr, k, n);

        System.out.println(Math.max(withRotationMaxSum, withOutRotationMaxSum));


    }

    public static void reverseInWindow(int arr[], int startIdx, int endIdx, int n) {
        int i = startIdx;
        int j = endIdx;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    //    alterNateWith out rotating
// efficient method
    public static int maxSumInCircularArrayWithSliding(int arr[], int k, int n) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = Math.max(sum, maxSum);
        for (int j = k; j < n + k; j++) {
            //finding value in rotating array
            sum += arr[j % n] - arr[(j - k) % n];
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println(maxSum);
        return maxSum;

    }

    public static void main(String[] args) {
        int arr[] = {18, 4, 3, 4, 5, 6, 7, 8, 2, 10}, k = 3;
        maxSumInCircularArrayWithSliding(arr, k, arr.length);
        MaxCircularSumWithSizeKImpl(arr, k, arr.length);
    }
}
