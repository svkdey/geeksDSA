package LeetCode;

import java.util.Arrays;

public class LeetCode238 {
	 public static int[] productExceptSelf(int[] nums) {
	        int[] res=new int[nums.length];
	        int m=1;
	        for(int i=0;i<res.length;i++){
	            res[i]=m;
	            m=m*nums[i];
	        }
	        System.out.println(Arrays.toString(res));
	        m=1;
	        for(int i=res.length-1;i>=0;i--){
	            res[i]=res[i]*m;
	            m*=nums[i];
	        }
	        System.out.println(Arrays.toString(res));
	        return res;
	    }
	 public static void main(String[] args) {
		int arr[]= {1,2,0,4};
		productExceptSelf(arr);
		
	}
}
