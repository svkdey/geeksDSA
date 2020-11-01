package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
	 public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> l=new ArrayList<List<Integer>>();
		 subsetsUtil(nums, 0,l);
		 System.out.println(l);
		 return l;
	    }
	 
	 public void subsetsUtil(int[] nums,int start,List<List<Integer>> l) {
		 if(start==nums.length) {
			 l.add(Arrays.stream(nums)
		      .boxed()
		      .collect(Collectors.toList()));
		 }
		 for(int i=start;i<nums.length;i++) {
			 swap(nums,i,start);
			 subsetsUtil(nums,start+1,l);
			 swap(nums,i,start);
		 }
	 }
	 private static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	 public static void main(String[] args) {
		Subsets s=new Subsets();
		int nums[]= {1,2,3};
		s.subsets(nums);
	}
}
