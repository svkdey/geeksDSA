package LeetCode;

import java.util.*;

public class LeetCode989 {
	   public  static List<Integer> addToArrayForm(int[] A, int K) {
		   ArrayList<Integer> list=new ArrayList<Integer>();
		   Stack<Integer> s=new Stack<Integer>();
		   int carry=0;
	        for(int i=A.length-1;i>=0;i--) {
	        	int val=A[i]+K+carry;
	        	K=0;
	        	
	        	s.add(val%10);
	        	carry=val/10;
	        	
	        }
	        while(carry!=0){ 
	       
	            s.push(carry%10);
	         
		        carry=carry/10;
		      
	           
	        }
//	        System.out.println(s);
	        while(!s.isEmpty()) {
	        	list.add(s.pop());
	        }
	        System.out.println(list);
	        return list;
	    }
	   public static void main(String[] args) {
		int ip[]= {0},K=1000;
		addToArrayForm(ip,K);
//		Integer.to
	}
}
