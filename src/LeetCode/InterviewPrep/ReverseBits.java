package LeetCode.InterviewPrep;

public class ReverseBits {
	 public int reverseBits(int n) {
	        String s=Integer.toBinaryString(n);
	        StringBuilder sb=new StringBuilder(s);
	        s=sb.reverse().toString();
	        return Integer.parseInt(s, 2);
	    }
	 
}
