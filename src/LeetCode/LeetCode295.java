package LeetCode;

import java.util.*;
import java.util.List;

public class LeetCode295 {
	class MedianFinder {

	    /** initialize your data structure here. */
	     PriorityQueue<Integer> min = null;
		PriorityQueue<Integer> max = null;
	    public MedianFinder() {
	        min=new PriorityQueue<>();
	        max=new PriorityQueue<>(Collections.reverseOrder());
	    }
	    
	    public void addNum(int x) {
	        
		        max.add(x);
		        min.add(max.poll());
		        
		        if (min.size() > max.size())
		        {
		            max.add(min.poll());
		        }
	    }
	    
	    public double findMedian() {
	         if (max.size() == min.size())
		        {
		            double first = ((double)(min.peek()))/2;
		            double second = ((double)(max.peek()))/2;
		            return (double) (first + second);
		        }
		        return (double) max.peek();
	    }
	}

}
