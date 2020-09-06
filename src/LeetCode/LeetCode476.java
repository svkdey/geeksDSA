package LeetCode;

import java.util.Stack;

public class LeetCode476 {
    public int findComplement(int num) {
    	Stack<Integer> s = new Stack<Integer>();
        while(num!=0) {
        	if((num&1)==1) {
        		s.add(1);
        	}else {
        		s.add(0);
        	}
        	num=num>>1;
        }
        System.out.println(s);
       int ans=0;
       int i=0;
       while(!s.isEmpty()) {
    	   int bit=s.pop();
    	   if(bit==0) {
    		   ans+=(bit)*Math.pow(2, i);
    	   }i++;
    	
       }
       return ans;
    }
}
