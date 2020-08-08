package LeetCode;

import java.util.Stack;

public class LeetCode1047 {
	 public String removeDuplicates(String S) {
	        char c[]=S.toCharArray();
	        Stack<Character> s = new Stack<Character>();
	        for(char x:c) {
	        	if(!s.isEmpty()&&s.peek()==x) {
	        		s.pop();
	        	}else {
	        		s.push(x);
	        	}
	        }
	        String ans="";
	        while(!s.isEmpty()) {
	        	ans=s.pop()+ans;
	        }
	        return ans;
	        
	    }
}
