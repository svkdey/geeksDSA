package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode442 {
	public List<Integer> findDuplicates(int[] nums) {
       ArrayList<Integer> l=new ArrayList<Integer>();
       for(int i=0;i<nums.length;i++) {
    	   int idx=nums[i];
    	   if(nums[idx]<0) {
    		   l.add(idx);
    	   }
    	   nums[idx-1]=-1*nums[idx];
       }
       System.out.println(Arrays.toString(nums));
       return l;
    }
}
