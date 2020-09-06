package LeetCode;

import java.util.Stack;

public class LeetCode856 {
	  public int scoreOfParentheses(String S) {
	        Stack<Integer> pastScore = new Stack<Integer>();
	        int currentScore=0;
	        for(char c:S.toCharArray()) {	
	        	if(c=='(') {
	        		pastScore.push(currentScore);
	        		currentScore=0;
	        	}else {
	        		currentScore=pastScore.pop()+Math.max(2*currentScore,1);
	        	}
	        	
	        }
	        return currentScore;
	    }
}
