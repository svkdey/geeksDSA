package Arrayproblems;

public class MaxSumSubArray {
    // also known as kadane's algorithm
    // o(n)

    // maxEnding[i]=max(maxEnding[i-1]+arr[i],arr[i])
    // result=max(result,maxEnding)

    public static int maxSumSubArray(int[] arr, int n) {
        int maxEnding = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {

            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            result = Math.max(result, maxEnding);
        }

        return result;
    }
//importatnt
    static void maxSubArraySum(int a[], int size) {
        int max_so_far = Integer.MIN_VALUE,max_ending_here = 0, start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
            System.out.println("Maximum contiguous sum is "
                    + max_so_far);
            System.out.println("Starting index " + start);
            System.out.println("Ending index " + end);
        }
    }

    // naive solution
    public static int maxSumCircularSubArray(int[] arr, int n) {

        int result = arr[0];
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];
            int maxSum = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n; // to get circular value
                currentSum += arr[index];
                maxSum = Math.max(currentSum, maxSum);
            }
            result = Math.max(result, maxSum);
        }

        System.out.println(result);
        return result;
    }

    //	best approach
    /*
     * 1 maxNormalSum= 1st find normal max Sub array sum 2. sumMinusMinSum= find all
     * element sum- miniMum sub array sum .return Max(maxNormalSum,sumMinusMinSum)
     *
     */

//    https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/

    public static int maxSumCircularSubArrayBetterSolution(int[] arr, int n) {
        //if all -ve
        boolean allNeg=true;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                allNeg=false;
            }
        }
        if(allNeg){
            return maxSumSubArray(arr,n);
        }

        //-ve + +ve both
        int maxKadane=maxSumSubArray(arr,n);
        System.out.println(maxKadane);
        int sum=totalSum(arr,n);
        for(int i=0;i<n;i++){
            arr[i]=-arr[i];
        }
        int wrappedSum=maxSumSubArray(arr,n);
        int maxKadaneWrap=sum+wrappedSum;
        System.out.println(wrappedSum);
        if(maxKadaneWrap>maxKadane){
            return maxKadaneWrap;
        }else{
            return maxKadane;
        }
    }

    public static int totalSum(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

//        System.out.println(sum);
        return sum;
    }

    public static int minSumSubArray(int[] arr, int n) {
        int maxEnding = arr[0];
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.min(maxEnding + arr[i], arr[i]);
            result = Math.min(result, maxEnding);
        }
        System.out.println(result);
        return result;
    }

    public static int minSumSubArrayApproach2(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1 * arr[i];
        }
        return -1 * maxSumSubArray(arr, n);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {-12,-14};
            System.out.println(maxSumCircularSubArrayBetterSolution(arr, arr.length));
//        maxSubArraySum(arr, arr.length);
    }

}
