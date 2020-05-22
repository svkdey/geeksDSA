package Sorting;

import java.util.Arrays;

public class HeapSortImpl {
    public static int getLeft(int idx) {
        return 2 * idx + 1;
    }

    public static int getRight(int idx) {
        return 2 * idx + 2;
    }

    public static int getParent(int idx) {
        return (int) Math.floor((idx - 1) / 2);
    }


    public static void heapSortImpl(int arr[], int n) {
        //build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            Maxheapify(arr, i, n);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            Maxheapify(arr, i, n);
        }

    }

    public static void Maxheapify(int arr[], int idx, int size) {
        int largest = idx;
        int left = getLeft(idx);
        int right = getRight(idx);

        //find largest
        if (left < size && arr[left] > arr[idx]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != idx) {
            swap(arr, idx, largest);
            Maxheapify(arr, largest, size);
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4};
        heapSortImpl(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
