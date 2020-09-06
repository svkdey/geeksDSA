package LeetCode;

import java.util.Stack;

public class LeetCode921 {
	 public int minAddToMakeValid(String S) {
	        Stack<Integer> s=new Stack<Integer>();
	        char chararr[]=S.toCharArray();
	        for(int i=0;i<chararr.length;i++) {
	        	if(chararr[i]=='(') {
	        		s.add(i);
	        	}else {
	        		if(!s.isEmpty()&&chararr[s.peek()]==chararr[i]) {
	        			s.pop();
	        		}else {
	        			s.add(i);
	        		}
	        	}
	        }
	        return s.size();
	    }
}
