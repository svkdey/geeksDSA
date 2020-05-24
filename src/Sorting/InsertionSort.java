package Sorting;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort1(int n, int[] arr) {
        for(int i=n-2;i>=0;i--){
            int last=arr[n-1];
            int j=n-2;
            while(j>=0&&arr[j]>last){
                arr[j+1]=arr[j];
                j--;
                System.out.println(Arrays.toString(arr));
            }

            if(j!=n-2||last<arr[j+1]){
                arr[j+1]=last;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    static void insertionSort2(int n, int[] arr) {

        int j=1,i=0;
        for(i=0;i<j&&j<n;i++){
            if(arr[i]>arr[i+1]){
                int item=arr[i+1];
                int k=i;
                while(k>=0&&arr[k]>item){
                    arr[k+1]=arr[k];
                    k--;
                }


                if(k+1>=0&&arr[k+1]>item){
                    arr[k+1]=item;
                }

            }
            j++;
            System.out.println(Arrays.toString(arr));
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[]={3 ,4, 7, 5, 6, 2, 1};
        insertionSort2(arr.length,arr);
    }
}
