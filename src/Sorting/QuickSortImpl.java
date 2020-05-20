package Sorting;

import java.util.Arrays;

/*//idea if every element is its sorted position then whole array is sorted .
 * devide and conquer
 * Key part is partition 
 * Worst complexity may be o(n^2)
 * but preferred above others
 * as 1. it tail recusive ,in place ,cache friendly ,average complexity (n log(n))
 * o(ln n)+1  stack space
 * */
public class QuickSortImpl {
	public static void quickSortbylomutoPartition(int arr[]) {
		int n = arr.length - 1;
		quickSortutilbylomutoPartition(arr, 0, n);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSortutilbylomutoPartition(int arr[], int startIdx, int endIdx) {
		if (endIdx > startIdx) {

			// find the index where last element its position
			int partitionIndex = PartitionTheories.lomutoPartition(arr, startIdx, endIdx);
			// make left side position sorted
			quickSortutilbylomutoPartition(arr, startIdx, partitionIndex - 1);
			// make right side position sorted
			quickSortutilbylomutoPartition(arr, partitionIndex + 1, endIdx);
		}
	}

	public static void quickSortbyHoarePartition(int arr[]) {
		int n = arr.length - 1;
		quickSortutilbyHoarePartition(arr, 0, n);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSortutilbyHoarePartition(int arr[], int startIdx, int endIdx) {
		if (endIdx > startIdx) {

			// find the index where last element its position
			int partitionIndex = PartitionTheories.hoareAlgorithm(arr, startIdx, endIdx);
			// make left side position sorted
			quickSortutilbyHoarePartition(arr, startIdx, partitionIndex);
			// make right side position sorted
			quickSortutilbyHoarePartition(arr, partitionIndex + 1, endIdx);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 4, 5, 6, 1, 22 };
		quickSortbyHoarePartition(arr);

	}

}
