package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode480 {
	static PriorityQueue<Integer> min = new PriorityQueue<>();
	static    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
	    public static double[] medianSlidingWindow(int[] nums, int k) {
	        double[] result = new double[nums.length - k + 1];
	        
	        for (int i = 0; i < nums.length; i++)
	        {
	            add(nums[i]);
	            
	            if (i >= k-1)
	            {
	                result[i-k+1] = getMedian();
	                remove(nums[i-k+1]);
	            }
	        }
	        return result;
	    }
	    
	    private static void add(int x)
	    {
	        max.add(x);
	        min.add(max.poll());
	        
	        if (min.size() > max.size())
	        {
	            max.add(min.poll());
	        }
	    }
	    
	    private static void remove(int x)
	    {
	        if (max.peek() >= x)
	            max.remove(x);
	        else
	            min.remove(x);
	        
	        if(min.size() - max.size() > 1) {            
	            max.add(min.poll());
	        } else if(max.size() - min.size() > 1) {
	            min.add(max.poll());
	        }
	    }
	    
	    private static double getMedian()
	    {
	        if (max.size() == min.size())
	        {
	            double first = ((double)(min.peek()))/2;
	            double second = ((double)(max.peek()))/2;
	            return (double) (first + second);
	        }
	        return (double) max.peek();
	    }

	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		medianSlidingWindow(arr, 3);
	}
}
