package Sorting;

import java.util.Arrays;

public class BubbleSortImpl {
	public static void bubblesortImpl(int args[]) {
		// TODO Auto-generated method stub
		for(int i=0;i<args.length-1;i++) {
			for(int j=i+1;j<args.length;j++) {
				if(args[i]>args[j] ){
					swap(args,i,j);
				}
			}
		}
		
	}
	static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 7, 10, 11,5 };
		bubblesortImpl(arr);
		System.out.println(Arrays.toString(arr));
	}

}
