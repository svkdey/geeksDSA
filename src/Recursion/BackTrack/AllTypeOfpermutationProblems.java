package Recursion.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;

public class AllTypeOfpermutationProblems {
	private static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void solve(int arr[],int j,ArrayList<Integer> v) {
		if(j==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=j;i<arr.length;i++) {
			swap(arr,i,j);
			
			solve(arr, j+1, v);
			//back track
			swap(arr,i,j);
			
			
		}
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		ArrayList<Integer> list = new ArrayList<Integer>();
		solve(arr, 0, list);
	}
}
