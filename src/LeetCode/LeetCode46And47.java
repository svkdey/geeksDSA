package LeetCode;

import java.util.*;

public class LeetCode46And47 {
	 public static void solve(int arr[]) {
	        Arrays.sort(arr); //sort is require if element are not distinct
	        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
	        backTrack(arr,0,set);
	        System.out.println(new ArrayList<>(set));
	    }
	    public static void swap(int arr[],int i,int j) {
	        int temp=arr[i];
	        arr[i]=arr[j];
	        arr[j]=temp;
	    }
	    public static void backTrack(int arr[],int idx,HashSet<ArrayList<Integer>> set) {
	        if(arr.length==idx){
	            ArrayList<Integer> l=new ArrayList<>();
	            for(int x:arr){
	                l.add(x);
	            }
	            set.add(l);
	            return;
	        }
	        for(int i=idx;i<arr.length;i++){
	                swap(arr,idx,i);
	                backTrack(arr,idx+1,set);
	                swap(arr,idx,i);
	            }

	    }

	    public static void main(String[] args) {
	        int arr[] ={1,2,3};
	        solve(arr);
	    }

}
