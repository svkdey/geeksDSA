package Arrayproblems;

public class SlidingWindowTechnique {
    /*
     * naive solution O((n-k)*k)
     *
     */
    public static int maxSumOfKconsicutiveElement(int[] arr, int k, int n) {

        int maxSum = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    /*
     * better approach: 1st get sum of k element. get one by one sum by k to n by
     * sum+= a[i]-a[i-k];
     */
    public static int maxSumOfKconsicutiveElementByWindowSliding(int[] arr, int k, int n) {

        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // sliding window
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // best solution o(n)
    public static int findIfSumExists(int[] arr, int target, int k, int n) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // sliding window
        if (sum == target) {
            return
                    0;
        }
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (sum == target) {
                return i - 1;
            }
        }
        return -1;
    }


    //sum may contains any number of elements
    //but element has to be non -ve
    //but window should be contineous
    public static int findIfSumExistInUnsortedArray(int[] arr, int target, int n) {
        //taking arr of O as sum and 0 as starting point
        int sum = arr[0];
        int start = 0;

        int j=1;
        for (j = 1; j <=n; j++) {
            //clean the prev window
            while (sum > target && start < j) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                System.out.println("sum is btwn " + start + " and " + (j - 1));
                return 1;
            }
            ;
            if (j < n) {
                sum += arr[j];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, -3, 33, 10, 20, 5};
//		System.out.println(maxSumOfKconsicutiveElementByWindowSliding(arr, 3, 5));
        System.out.println(findIfSumExistInUnsortedArray(arr, 65, arr.length));
    }

}
