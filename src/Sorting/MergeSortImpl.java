package Sorting;import java.util.Arrays;

public class MergeSortImpl {
	public static void mergeSort(int arr[],int startIdx,int lastIdx) {
		if(lastIdx>startIdx) {
			//find mid
			int mid=startIdx+(lastIdx-startIdx)/2;
			//left devide 
			mergeSort(arr, startIdx,mid);
			//left devide
			mergeSort(arr, mid+1, lastIdx);
			
			//call sorted merge
			merge(arr,startIdx,mid,lastIdx);
		}
	}
	
//	vvi merging algo
	public static void merge(int arr[],int start,int mid,int last) {
		//creating 2 arrays from start to mid , and mid to last
		
		//size of a[] array
		int n = mid-start+1;
		//size of b array
		int m = last-mid;
		int i = 0, j = 0;
		int a[]=new int[n];
		int b[]=new int[m];
		
		//copying start to  mid-start+1;
		for(int c=0;c<n;c++) {
			a[c]=arr[start+c];
		}
		//copying start to  mid-last;
		for(int c=0;c<n;c++) {
			b[c]=arr[mid+1+c];
		}
		
		// arr starting sorting index
		int k = start;
		
		// normal merge function
		while (i < n && j < m) {
			if (a[i] > b[j]) {
				arr[k] = b[j];
				j++;
			} else {
				arr[k] = a[i];
				i++;
			}
			k++;
		}
		while (i < n) {
			arr[k] = a[i];
			i++;
			k++;
		}
		while (j < m) {
			arr[k] = b[j];
			j++;
			k++;
		}
//		System.out.print(Arrays.toString(arr));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 8,3,5,7 };
		mergeSort(arr, 0, 3);
		System.out.println(Arrays.toString(arr));
	}

}
