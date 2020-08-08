package LeetCode;

import java.util.*;

public class LeetCode77 {
	  
	public List<List<Integer>> combine(int n, int k) {
		  int arr[]=new int[k];
		  for(int i=1;i<=k;i++) {
			  arr[i-1]=k;
		  }
		  HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		  backTrack(arr, arr.length, n, 0, new ArrayList<Integer>(), set);
		  return new ArrayList<List<Integer>>(set);
	    }
	public static void backTrack(int s[],int n,int k,int i,ArrayList<Integer> op,HashSet<ArrayList<Integer>> ans) {
		if(op.size()==k) {
			System.out.println(op);
			ans.add(new ArrayList<>(op));

		}

		for(int start=i;start<n;start++) {
			op.add(s[start]);
			backTrack(s, n,k, start+1, op, ans);
			op.remove(op.size()-1);
			
		}
		
    }
	public static void main(String[] args) {
	
	
	}
	
}
