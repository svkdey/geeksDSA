package LeetCode;

import java.util.*;

public class LeetCode39And40 {
	 public static void solve(int arr[], int target) {
//       Arrays.sort(arr); //sort is require if element are not distinct
		 
       HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
       backTrack(arr, 0, arr.length, new ArrayList<Integer>(), set, target);
       System.out.println(new ArrayList<>(set));
   }


   public static void backTrack(int arr[], int start, int n, ArrayList<Integer> op, HashSet<ArrayList<Integer>> set, int target) {


       if (target == 0) {
           set.add(new ArrayList<>(op));
           return;
       } else if (target < 0) {
           return;
       }
       for (int i = start; i < arr.length; i++) {
           op.add(arr[i]);
           backTrack(arr, i, n, op, set, target - arr[i]);// i+1  for 40 number qstn
           op.remove(op.size() - 1);
       }

   }

   public static void main(String[] args) {
       int arr[] = {1, 2, 2};
       solve(arr, 4);
   }
}
