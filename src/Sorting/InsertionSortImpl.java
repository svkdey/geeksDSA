package Sorting;

import java.util.Arrays;

public class InsertionSortImpl {
	// algo:
	// we will start from index one to n .
//	and find for index i element is there any element before? if yes then copy things right and and insert at that position
	public static void insertionSortImpl(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
//			the index j will search for position of i th element
			int j = i - 1;
//			jth position value is greater that ith pos value copy to left
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			// now there is no element at j that is > i
//			so
			arr[j + 1] = key;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 7, 5, 10, 11 };
		insertionSortImpl(arr);
		System.out.println(Arrays.toString(arr));
	}

}
