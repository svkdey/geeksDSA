package Arrayproblems;

class SortedRotated {

    // Function to check if array is sorted and rotated
    // arr[]: input array
    // num: size of array
    public static boolean checkAsendingSorted(int arr[], int n) {

        // Your code
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] >= arr[i]) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkdesendingSorted(int arr[], int n) {

        // Your code
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] <= arr[i]) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void rotateClock(int arr[], int n) {

        // Your code
        int last = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = last;
    }


    public static boolean checkRotatedAndSorted(int arr[], int num) {

        // Your code
        int i = 0;
        int n = arr.length;
        if (checkdesendingSorted(arr, n) || checkAsendingSorted(arr, n)) {
            return false;
        }
        while (i < num) {
            rotateClock(arr, n);
            if (checkdesendingSorted(arr, n) || checkAsendingSorted(arr, n)) {
                return true;
            }
            i++;
        }
        return false;

    }
    public static boolean checkRotatedAndSortedBetterSolution(int arr[], int num){
        int countup = 0, countdown = 0;
        for (int i = 1; i < num; i++) {
            countup = (arr[i] > arr[i -1]) ? countup + 1 : countup;
            countdown = (arr[i] < arr[i -1]) ? countdown + 1 : countdown;

        }
        System.out.println(countup +" " +countdown );
        return ((countup == num - 2 && countdown == 1 && arr[0] > arr[num - 1])
                || (countdown == num - 2 && countup == 1 && arr[0] < arr[num - 1])) ? true : false;
    }


    public static void main(String[] args) {
        int arr[] = {30 ,20, 10, 50, 35};

        System.out.println(checkRotatedAndSortedBetterSolution(arr,2));
    }

}