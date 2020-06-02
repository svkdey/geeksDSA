package Algorithms.BackTrackinBasic;

public class PowerSetOfAstring {
	public static void powerSetImpl(String s,int idx,String curr) {
		int n=s.length();
		if(idx==n) {
			System.out.println(curr);
			return;
		}
		powerSetImpl(s, idx+1, curr);
		powerSetImpl(s, idx+1, curr+s.charAt(idx));
		
		
		
	}
	public static void main(String[] args) {
		String s="abc";
		powerSetImpl(s, 0, "");
	}
}
