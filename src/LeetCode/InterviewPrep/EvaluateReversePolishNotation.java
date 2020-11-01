package LeetCode.InterviewPrep;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	  public int evalRPN(String[] tokens) {
	        int ans=0;
	        Stack<Integer> stack=new Stack<Integer>();
	        for(String s:tokens) {
	        	if(s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-")) {
	        		int a=stack.pop();
	        		int b=stack.pop();
	        		int subAns=0;
	        		if(s.equals("*")) {
	        			subAns=a*b;
	        		}else if(s.equals("/")) {
	        			subAns=a/b;
	        		}
	        		else if(s.equals("+")) {
	        			subAns=a+b;
	        		}else {
	        			subAns=a-b;		
	        		}
	        		stack.add(subAns);
	        	}else {
	        		stack.add(Integer.parseInt(s));
	        	}
	        }
	        return stack.pop();
	    }
}
