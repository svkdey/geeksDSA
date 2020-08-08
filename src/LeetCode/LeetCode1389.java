package LeetCode;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1389 {
	public static int[] createTargetArray(int[] nums, int[] index) {
		 List<Integer> x = new ArrayList<>();
	        for(int i=0; i<nums.length; i++){
	            x.add(index[i], nums[i]);
	        }
	        
	        for(int i=0; i<nums.length; i++)
	            nums[i] = x.get(i);
	        
	        return nums;
	    }
	public static void main(String[] args) {
		int nums[] = {0,1,2,3,4};int index[] = {0,1,2,2,1};
		createTargetArray(nums, index);
	}
}
