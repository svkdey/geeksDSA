package Sorting;

import java.util.Arrays;

public class PartitionTheories {
	public static void naivePatition(int arr[], int k) {
		int temp[] = new int[arr.length];
		int tempIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < k) {
				temp[tempIdx] = arr[i];
				tempIdx++;
			}

		}
		temp[tempIdx] = k;
		tempIdx++;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > k) {
				temp[tempIdx] = arr[i];
				tempIdx++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];

		}

	}

	public static int lomutoPartition(int arr[], int startIdx, int endIdx) {

		int pivot = arr[endIdx];
		int i = startIdx - 1;
		for (int j = startIdx; j <= endIdx - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, j, i);
			}
		}
		i++;
		swap(arr, i, endIdx);
		return (i);

	}

	public static int lomutoPartitionWithpartitionIndex(int arr[], int startIdx, int endIdx, int partitionIndex) {
		swap(arr, partitionIndex, endIdx);

		int pivot = arr[endIdx];
		int i = startIdx - 1;
		for (int j = startIdx; j <= endIdx - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, j, i);
			}
		}
		i++;
		swap(arr, i, endIdx);
		return (i);

	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int hoareAlgorithm(int arr[], int start, int end) {
		int pivot = arr[start];
		int i = start - 1;
		int j = end;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j)
				return j;
			swap(arr, j, i);
		}
	}

	/*
	 * discussions: 1.Hoare Algo/lomuto are not stable as in same element array it
	 * changes position of element.but naive is stable 2.Hoare takes less
	 * comparisons but does not ensure pivot at right place 3.Lomuto makes more
	 * comparisons but ensures that pivot should be at its position
	 * 
	 */
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 2, 1, 3 };
		lomutoPartition(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
