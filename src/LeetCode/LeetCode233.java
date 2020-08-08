package LeetCode;

public class LeetCode233 {
		private int count(String n) {
			char narr[]=n.toCharArray();
			int ans=0;
			for(char x:narr) {
				if(x=='1') {
					ans++;
				}
			}
			return ans;
		}
	 public int countDigitOne(int n) {
	       int ans=0;
	       for(int i=1;i<=n;i++) {
	    	   ans+=count(Integer.toString(i));
	       }
	       return ans;
	  }
}
