package LeetCode;

public class LeetCode930 {
	 public int[] diStringMatch(String S) {
	        int n=S.length();
	        int ans[]=new int[n];
	        int d=n;
	        int i=0;
	        char cArry[]=S.toCharArray();
	        for(int k=0;k<S.length();k++) {
	        	if(cArry[k]=='I') {
	        		ans[k]=i++;
	        	}else {
	        		ans[k]=d--;
	        	}
	        }
	        return ans;
	    }
}
