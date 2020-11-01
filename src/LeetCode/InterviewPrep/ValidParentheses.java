package LeetCode.InterviewPrep;

import java.util.Stack;

public class ValidParentheses {
	 public boolean validate(char a,char b) {
		 if((a=='('&&b==')')||(a=='{'&&b=='}')||(a=='['&&b==']')) {
			 return true;
		 }
		 return false;
	 }
	 public boolean isValid(String s) {
	        Stack<Character> stack=new Stack<Character>();
	        char sarr[]=s.toCharArray();
	        for(char c:sarr) {
	        	if(c=='('||c=='{'||c=='[') {
	        		stack.add(c);
	        	}else {
	        		if(stack.isEmpty()) {
	        			stack.add(c);
	        		}else {
	        			if(validate(stack.peek(),c)) {
	        				stack.pop();
	        			}else {
	        				stack.add(c);
	        			}
	        		}
	        	}
	        }
	        return stack.isEmpty();
	       
	    }
}
