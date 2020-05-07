package QueueDSA;

import java.util.Stack;

public class QueueByStack {
	
	    Stack<Integer> s1 = new Stack<Integer>();
	    Stack<Integer> s2 = new Stack<Integer>();

	    /* The method insert to push element
	       into the queue */
	    void insert(int B)
	    {
		   // Your code here
		   s1.push(B);
	    }
		
	    
	    /* The method remove which return the
	      element popped out of the queue*/
	    int remove()
	    {
		   // Your code here
		   while(!s1.isEmpty()){
		       s2.push(s1.pop());
		       
		   }
		   int temp=s2.pop();
		   while(!s2.isEmpty()){
		       s1.push(s2.pop());
		       
		   }
		   return temp;
	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
