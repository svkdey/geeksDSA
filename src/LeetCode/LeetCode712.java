package LeetCode;

import java.util.Arrays;

public class LeetCode712 {
	 public int minimumDeleteSum(String s1, String s2) {
	    int t[][]=new int[s1.length()+1][s2.length()+1];
	    for(int i=1;i<=s2.length();i++) {
	    	t[0][i]=t[0][i-1]+s2.charAt(i);
	    }
	    
	    for(int i=1;i<=s1.length();i++) {
	    	t[i][0]=t[i-1][0]+s1.charAt(i);
	    }
	    
	    for(int i=1;i<=s1.length();i++) {
	    	 for(int j=1;j<=s2.length();j++) {
	    		 if(s1.charAt(i-1)==s2.charAt(j-1)) {
	    			 t[i][j]=t[i-1][j-1];
	    		 }else {
	    			 t[i][j]=Math.min(t[i-1][j]+s1.charAt(i-1),t[i][j-1]+s2.charAt(j-1));
	    		 }
	 	    	
	 	    }
	    }
	    
	    return t[s1.length()+1][s2.length()+1];
	    
	   }
	
	 
}
