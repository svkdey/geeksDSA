package LeetCode;

import java.util.Arrays;

public class LeetCode1035 {
	 public int maxUncrossedLines(int[] A, int[] B) {
	        int t[][]=new int[A.length+1][B.length+1];
	        
	        for(int i=1;i<A.length;i++) {
	        	for(int j=1;j<B.length;j++) {
	        		if(A[i-1]==B[j-1]) {
	        			t[i][j]=1+t[i-1][j-1];
	        		}else {
	        			t[i][j]=Math.max( t[i-1][j],t[i][j-1]);
	        		}
	        	}
	        }
	        for(int i=0;i<A.length;i++) {
	        	System.out.println(Arrays.toString(t[i]));
	        }
	        return t[A.length][B.length];
	    }
}
