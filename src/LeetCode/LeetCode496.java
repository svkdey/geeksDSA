package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode496 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<nums2.length;i++) {
			map.put(nums2[i], i);
		}
        int result[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int ans=0;
            for(int j=map.get(nums1[i]);j<nums2.length;j++) {
            	if(nums2[j]>nums1[i]) {
            		ans++;
            	}
            }
            result[i]=ans==0?-1:ans;
            
        }
        return result;
    }
}
