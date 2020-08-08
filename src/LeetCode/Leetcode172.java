package LeetCode;

public class Leetcode172 {
	 public static int trailingZeroes(int n) {
	        float ans=0;
	        for(int i=1;i<=n;i++){
	            ans+= (float)Math.log10(i);
	        }
	        return (int)ans;
	    
	}
	 public static void main(String[] args) {
		 Leetcode172 s=new Leetcode172();
		 System.out.println(s.trailingZeroes(5));
	}
}
