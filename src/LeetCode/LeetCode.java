package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode {
	  public static int[] smallerNumbersThanCurrent(int[] nums) {
		  ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int x:nums) {
	        	list.add(x);
	        	
	        }
	        Collections.sort(list);
//	        System.out.println(list);
//	        System.out.println(list.indexOf(2));
//	        System.out.println(list.indexOf(2));
	        int ans[]=new int[nums.length];
	        for(int i=0;i<nums.length;i++) {
	        	ans[i]=list.indexOf(nums[i]);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {8,1,2,2,3};
		smallerNumbersThanCurrent(nums);
	}

}
