package Arrayproblems;

import java.util.Arrays;
import java.util.HashSet;

public class PythagoreanTriplet {
    //o (n^2) o(n space)
    public static boolean pythagorean(int arr[]) {
        Arrays.sort(arr);
        boolean isFound = false;
        HashSet<Double> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add((double)arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a=arr[i],b=arr[j];
                double c = Math.sqrt((a*a) + (b * b));
                if (set.contains(c)) {
                    System.out.println((int)a+ " " + (int)b + " " + (int)c);
                    isFound = true;
                    break;
                }
            }
        }
        return isFound;
    }

    //better o(n^2) solution with const space
    static boolean isTriplet(int arr[], int n)
    {
        // Square array elements
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        // Sort array elements
        Arrays.sort(arr);

        // Now fix one element one by one and find the other two
        // elements
        for (int i = n - 1; i >= 2; i--) {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i - 1; // index of the last element in arr[0..i-1]
//            by 2 pointer approach find a arr[l]+arr[r]=arr[i]
            while (l < r) {
                // A triplet found
                if (arr[l] + arr[r] == arr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }

        // If we reach here, then no triplet found
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(pythagorean(new int[]{ 3, 1, 4, 6, 5 }));
    }
}
