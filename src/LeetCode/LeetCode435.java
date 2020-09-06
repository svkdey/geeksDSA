package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode435 {
	 public int eraseOverlapIntervals(int[][] intervals) {
	        List<int[]> l=new ArrayList<int[]>(Arrays.asList(intervals));
	        Comparator<int[]> rule=(a,b)->{
	        	return a[1]-b[1];
	        };
	        Collections.sort(l,rule);
	        for(int[] x:l){
                System.out.println(Arrays.toString(x));
            }
	        int start[]=l.get(0);
	        int ans=0;
	        for(int i=1;i<l.size();i++) {
	        	if(start[1]>l.get(i)[0]) {
	        		ans++;
	        		
	        	}else {
	        		start=l.get(i);
	        	}
	        }
	        return ans;
	        
	        
	    }
}
