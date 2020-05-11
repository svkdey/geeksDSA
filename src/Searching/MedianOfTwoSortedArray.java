package Searching;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
	// assume B>=A in size
	// do binary search in A arrray ,and mid is i1
	// make arr1 and arr2
	// mid of B , i2=[(n1+n2+1)/2 -i1]
	// 0 to i2-1 and i2-n2

	static double medianOfTwoSortedArray(int A[], int B[]) {
		int n1 = A.length, n2 = B.length;
		int begin1 = 0;
		int end1 = n1;

		while (begin1 <= end1) {
			int i1 = begin1 + (end1 - begin1) / 2;
			int i2 = (n1 + n2 + 1) / 2 - i1;

			int min1 = i1 == n1 ? Integer.MAX_VALUE : A[i1];
			int max1 = i1 == 0 ? Integer.MIN_VALUE : A[i1 - 1];

			int min2 = i2 == n2 ? Integer.MAX_VALUE : B[i2];
			int max2 = i2 == 0 ? Integer.MIN_VALUE : B[i2 - 1];

			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0) {
					return (double) (Math.max(max1, min2) + Math.max(min1, max2)) / 2;
				} else {
					return (double) Math.max(max1, min2);
				}
			} else if (max1 > min2) {
				end1 = i1 - 1;
			} else {

				begin1 = i1 + 1;
			}
		}
		return 0;
	}

	// o(n) solution
	public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
		int i = 0, j = 0, k = 0;

// Traverse both array 
		while (i < n1 && j < n2) {
// Check if current element of first 
// array is smaller than current element 
// of second array. If yes, store first 
// array element and increment first array 
// index. Otherwise do same with second array 
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}

// Store remaining elements of first array 
		while (i < n1)
			arr3[k++] = arr1[i++];

// Store remaining elements of second array 
		while (j < n2)
			arr3[k++] = arr2[j++];
	}

	static int medianOfTwoSortedArrayLinearSolution(int a[], int b[]) {
		boolean isEven=(a.length+b.length)%2==0;
		int [] res=new int[a.length+b.length];
		
		mergeArrays(a,b,a.length,b.length,res);

		int mid=res.length/2;
		if(isEven) {
			return (res[mid]+res[mid-1])/2;
			
		}else {
			return res[mid];
		}
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int arr1[] = { 1, 2, 3, 4 };
		int arr2[] = { 11, 12, 13, 14 };
		System.out.println(medianOfTwoSortedArrayLinearSolution(arr2, arr1));
	}

}
