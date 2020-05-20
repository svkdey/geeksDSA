package Sorting;

import java.util.Arrays;

public class FindTripletSumZero {


    public boolean findTriplets(int arr[], int n) {
        //add code here.
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1; //left and right corner cases are require
            int r = n - 1;//left and right corner cases are require
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }

        return found;

    }
}


