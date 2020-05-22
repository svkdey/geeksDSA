package Sorting;

import java.util.Arrays;

public class MinimumPlatform {
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 1;
        int platFormNeed = 1;
        int result = 1;
        while (i < n && j < n) {
            if (arr[j] <= dep[i]) {
                result++;
                j++;
            }else {
                result--;
                i++;
            }
            platFormNeed=Math.max(platFormNeed,result);
        }
        return platFormNeed;
    }
    // Driver program to test methods of graph class
    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }

}

