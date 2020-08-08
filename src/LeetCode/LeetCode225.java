package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode225 {
	 Deque<Integer> dq=null;
    public LeetCode225() {
        dq=new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        dq.addFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return dq.removeFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return dq.peekFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dq.isEmpty();
    }
}
