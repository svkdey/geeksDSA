package Searching;

import Data.ArrayData;

public class RevBinarySearch {
	static int revBinarySearch(int arr[], int x) {
		int start = 0;
		int end = arr.length - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x) {
				return mid;
			}
			if (arr[mid] > x) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return -1;

	}
	static int revBinarySearchForRightMostIndex(int arr[], int x) {
		int start = 0;
		int end = arr.length - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x&&(mid==arr.length-1||arr[mid+1]!=x)) {
				return mid;
			}
			if (arr[mid] >= x) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return -1;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(revBinarySearchForRightMostIndex(ArrayData.REV_BINARY_FINDIDX, 1));
	}

}
