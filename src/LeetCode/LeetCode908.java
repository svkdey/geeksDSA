package LeetCode;

public class LeetCode908 {
	 public int smallestRangeI(int[] A, int K) {
	        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	        for(int x:A) {
	        	min=Math.min(x, min);
	        	max=Math.max(x, max);
	        }
	        int range=max-min;
	        if(2*K>=Math.abs(range)) {
	        	return 0;
	        }else {
	        	return Math.abs(range)-2*K;
	        }
	    }
}
