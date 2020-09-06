package LeetCode;

import java.util.Stack;

public class LeetCode168 {
	public static String convertToTitle(int n) {
		StringBuilder sb=new StringBuilder();
		while (n != 0) {
			int rem=n%26;
			if(rem==0) {
				sb.append("Z");
				n=(n/26)-1;
			}else {
				sb.append((char)((rem-1)+'A'));
				n=n/26;
			}
		}
		
		return sb.reverse().toString();
	}
	
	public static String binary(int n) {
		Stack<Integer> l = new Stack<Integer>();
		while (n != 0) {
			l.add(n % 2);
			n = (n / 2);
		}
		String s="";
		while (!l.isEmpty()) {
			s+=l.pop();
		}
		return s;
		
	}
	public static void decimal(String s) {
		int ans=0;
		int j=0;
		for(int i=0;i<s.length();i++) {
			ans+=Math.pow(2,j)*Integer.parseInt(Character.toString(s.charAt(s.length()-i-1)) );
			j++;
		}
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
//		decimal(binary(701));
		System.out.println(convertToTitle(701));
	}
}
