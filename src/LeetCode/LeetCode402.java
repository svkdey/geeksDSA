package LeetCode;

import java.util.Stack;

public class LeetCode402 {
	public String removeKdigits(String num, int k) {
		char charArr[] = num.toCharArray();
		Stack<Character> s = new Stack<Character>();
		if(k>=charArr.length) {
			return "0";
		}
		for (char c : charArr) {
			while (!s.isEmpty() && (int) s.peek() > (int) c && k != 0) {
				s.pop();
				k--;
			}
			s.add(c);

		}
		System.out.println(s);
		while(k!=0&&!s.isEmpty()) {
			s.pop();
			k--;
		}
		System.out.println(s);
		if(s.isEmpty()) {
			return "0";
		}
		StringBuilder sb=new StringBuilder();
		
		while (!s.isEmpty()) {
			sb.append(s.pop());

		}
		sb.reverse();
		int i = 0;
		while ((i!=sb.length())&&sb.charAt(i) == '0') {
			sb.deleteCharAt(i);
			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LeetCode402 solve = new LeetCode402();
		System.out.println(solve.removeKdigits("0110",2));
	}
}
