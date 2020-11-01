package LeetCode;

import java.util.Arrays;

public class LeetCode190 {
    public static int reverseBits(int n) {
    	StringBuilder s=new StringBuilder();
        for(int i=31;i>=0;i--) {
        	int temp=(n&1);
        	n=n>>>1;
        	s.append(temp);
        }
        System.out.println(s.toString());
        int num=Integer.parseUnsignedInt(s.toString(),2);
        System.out.println(num);
        return num;
    }
    public static void main(String[] args) {
		reverseBits(27);
	}
}
