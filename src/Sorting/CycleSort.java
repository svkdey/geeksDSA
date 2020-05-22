package Sorting;

import java.util.Arrays;

/*
1. o(n^2)
2. minimum write in memory
3. in place sort
4.why read this?
--how many minimum swap needed to sort the array.

* */
public class CycleSort {
    //find how many element is smaller that i th element
    //
    static void cycleSortImpl(int arr[], int n) {
        int writes = 0;
        //we traverse till last index -1  as. in inner loop will we will go to endIdx ,and that will give the sort if require
        for (int c_start = 0; c_start <= n - 2; c_start++) {
            //set the  c_start index and value
            int item = arr[c_start];
            int pos = c_start;
            //here we will go upto n
            for (int i = c_start + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            //skipping if both idx are same
            if (pos == c_start)
                continue;

            //ignore all duplicates
            while (arr[pos] == item) {
                pos+=1;
            }
            //swap with position where item suppose to go
            if (pos != c_start) {
                int temp=item;
                item=arr[pos];
                arr[pos]=temp;
                writes++;
            }

            //rotate rest cycle
            while (pos != c_start) {
                pos=c_start;
                for (int i = c_start + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                //skipping if both idx are same


                //ignore all duplicates
                while (arr[pos] == item) {
                    pos+=1;
                }
                //swap with position where item suppose to go
                if (item != arr[pos]) {
                   int temp=item;
                   item=arr[pos];
                   arr[pos]=temp;
                    writes++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4};
        cycleSortImpl(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
