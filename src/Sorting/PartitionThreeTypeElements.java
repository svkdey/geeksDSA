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
    public static void partitionThreeTypeElements(int arr[], int size,int a,int b) {
        // set up initial
    	 int low= 0;
         int high=size-1;
         //here for condition is important that j<=h  and h is variable where h going on reduction after swaps
         for (int j = 0; j <=high;) {
             if (arr[j] <a ) {
                 swap(arr, low, j);
                 low++;
                 j++;
             } else if (arr[j] >b) {
                 swap(arr, j, high);
                 high--;
             }else {
                 j++;
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
    	int a[] = {5, 6, 2, 4, 1, 9, 7, 100, 13, 25, 36, 46, 35, 88, 54, 67, 84, 27, 3, 13, 99};
    	partitionThreeTypeElements(a,  a.length,5,13);

        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(arr));
    }

}
