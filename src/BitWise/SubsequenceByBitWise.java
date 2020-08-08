package BitWise;

import java.util.ArrayList;

public class SubsequenceByBitWise {
	public static void solve(String s) {
		int totalBits=(int)Math.pow(2,s.length());
		char[] arr=s.toCharArray();
		for(int i=0;i<=totalBits;i++) {
			filter(i, arr);
		}
	}
	
	
	private static String filter(int n,char[] arr) {
		String s="";
		int j=0;
		while(n>0&&j<arr.length) {
			int l_bit=(n&1);
			
			if(l_bit==1) {
				s+=arr[j];
			}
			n=n>>1;
			j++;
		}
		System.out.println(s);
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve("abc");
	}

}
