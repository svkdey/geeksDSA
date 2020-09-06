package GraphQuickRecap;

import java.util.Arrays;

public class LeetCode1561 {
	 public int maxCoins(int[] piles) {
	        Arrays.sort(piles);
	        /*
	         * 
	      		Example: [9,8,7,6,5,1,2,3,4]
				After sorting [1,2,3,4,5,6,7,8,9]
	         * */
	        int ans=0;
	        int j=piles.length-2;
	        for(int i=0;i<piles.length/3;i++) {
	        	ans+=piles[j];
	        	j=j-2;
	        	
	        }
	        return ans;
	    }
}
