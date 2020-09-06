package LeetCode;

import java.util.Stack;

public class LeetCode1249 {
	public static String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				if (s.charAt(i) == '(') {
					stack.push(i);
				} else if(s.charAt(i) == ')'){
					if(!stack.isEmpty()&&s.charAt(stack.peek())=='(') {
						stack.pop();
					}else {
						stack.push(i);
					}
				}
			}
		}
		String ans="";	
		for (int i = 0; i < s.length(); i++) {
			if(!stack.contains(i)) {
				ans+=s.charAt(i);	
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		minRemoveToMakeValid("(a(b(c)d)");
	}
}
