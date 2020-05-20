package Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] merge(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0;
        int res[] = new int[n + m];
        int k = 0;
        while (i < n && j < m) {
            if (a[i] > b[j]) {
                res[k] = b[j];
                j++;
            } else {
                res[k] = a[i];
                i++;
            }
            k++;
        }
        while (i < n) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            res[k] = b[j];
            j++;
            k++;
        }
        System.out.print(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr1[] = {2, 4, 5, 10};
        int arr2[] = {1, 3, 5, 8};
        merge(arr1, arr2);
    }

}
