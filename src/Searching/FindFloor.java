package Searching;

import Data.ArrayData;

public class FindFloor {
	static int findFloor(long arr[], int left, int right, long x) {
		int ans =-1;
		while(right>=left) {
			int mid=left+(right-left)/2;
			if(arr[mid]<=x) {
				ans= mid;
				break;
			}if(arr[mid]>x) {
				right=mid-1;
			}else {
				ans=mid;
				left=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFloor(ArrayData.findFloor,0,ArrayData.findFloor.length-1,10));
	}

}
