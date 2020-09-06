package LeetCode;
import java.util.ArrayList;

public class LeetCode1313 {
	public static int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();	
		util(nums, 0, l);
		int ans[]=new int[l.size()];
		for(int i=0;i<l.size();i++) {
			ans[i]=l.get(i);
		}
		return ans;
    }
	public static void util(int[] nums,int i,ArrayList<Integer> list) {
        	if(i>=nums.length) {
        		return;
        	}
        	for(int k=0;k<nums[i];k++) {
        		list.add(nums[i+1]);
        	}
        	util(nums, i+2, list);
		
    }
	public static void main(String[] args) {
		int nums[]= {1,1,2,3};
		decompressRLElist(nums);
	}
}
