package LeetCode;

import java.util.Stack;

public class LeetCode682 {
	public int calPoints(String[] ops) {
        Stack<Integer> lastInsertedScore=new Stack<>();
        int current=0;
        for(String x:ops) {
        	if("D".equals(x)) {
        		lastInsertedScore.add(lastInsertedScore.peek()*2);
        	}else if("C".equals(x)) {
        		lastInsertedScore.pop();
        	}else if("+".equals(x)) {
        		int lastPoints1=lastInsertedScore.pop();
        		int lastPoints2=lastInsertedScore.pop();
     
        		
        		lastInsertedScore.push(lastPoints2);
        		lastInsertedScore.push(lastPoints1);

        		lastInsertedScore.push(lastPoints2+lastPoints1);
        		
        	}else {
        		lastInsertedScore.add(Integer.parseInt(x));
        		
        	}
        	
        }
        while(!lastInsertedScore.isEmpty()) {
        	current+=lastInsertedScore.pop();
        }
        return current;
    }
}
