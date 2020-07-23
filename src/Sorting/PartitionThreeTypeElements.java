package Sorting;

import java.util.Arrays;

public class PartitionThreeTypeElements {
    /*
     * partition 0,1,2 partition threeElement when multiple occurance of pivot
     * preset partition on basis of range partition on condition
     *
     *
     * Algorithm is called Dutch flag algorith
     */
    /*
     * idea: 1. |--------------|----------------|===============|-------------| all
     * 0s (low) all 1s (mid) unknown (high) all 2s
     *
     * we will maintain position of low mid high indexs
     */
    public static void partitionThreeTypeElements(int arr[], int size) {
        // set up initial
        int low = 0, high = size - 1, mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                //note there we wont do mid++
                high--;
            }

        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = {1, 1, 2, 0, 2, 0, 1};
        partitionThreeTypeElements(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
