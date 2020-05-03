package Playground;

import Data.ArrayData;

public class LeftIndex {
	static int findLeftMostIndex(int arr[], int x, int n) {
		int start = 0;
		int end = n - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x)) {
				return mid;
			}
			if (arr[mid] >= x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	//for input type 1,1,1,1,0,0,0,0,

	static int findRightMostIndex(int arr[], int x, int n) {
		int start = 0;
		int end = n - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x && (mid == n-1 || arr[mid +1] != x)) {
				return mid;
			}
			if (arr[mid] > x) {
				end = mid-1 ;
				
				
			} else {
				start = mid+1 ;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRightMostIndex(ArrayData.findInd, 1,ArrayData.findInd.length));

	}

}
