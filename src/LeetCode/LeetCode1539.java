package LeetCode;

import java.util.HashSet;

public class LeetCode1539 {
	 public int findKthPositive(int[] arr, int k) {
	        HashSet<Integer> set=new HashSet<Integer>();
	        for(int x:arr) {
	        	set.add(x);
	        }
	        int i=0,j=1;
	        while(true){
                if(!set.contains(j)) {
                	i++;
                }
                if(k==i) {
                	return j;
                }
                j++;
            }
	    }
	 
}
