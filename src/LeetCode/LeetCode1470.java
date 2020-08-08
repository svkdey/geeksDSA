package LeetCode;

import java.util.Arrays;

public class LeetCode1470 {
	 public static int[] shuffle(int[] nums, int n) {
	        int m=2*n;
	        int result[]=new int[m];
	        int k=0;
	        for(int i=0;i<m;i=i+2){
	            result[i]=nums[k];
	            result[i+1]=nums[k+n];
	            k++;
	        }
	       
	        System.out.println(Arrays.toString(result));
	        return result;
	    }
	 public static void main(String[] args) {
		int arr[]= {2,5,1,3,4,7};
		shuffle(arr, arr.length/2);
	}
}
