package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode1235 {
	class Jobs{
		int s,e,p;

		public Jobs(int s, int e, int p) {
			super();
			this.s = s;
			this.e = e;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Jobs [s=" + s + ", e=" + e + ", p=" + p + "]";
		}
		
	}
	   public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
	        Comparator<Jobs> rule=(a,b)->{
	        	if(a.e==b.e) {
	        		return b.p-a.p;
	        	}
	        	return a.e-b.e;
	        };
	        List<Jobs> job=new ArrayList<Jobs>();
	        for(int i=0;i<startTime.length;i++) {
	        	job.add(new Jobs(startTime[i], endTime[i], profit[i]));
	        }
	        Collections.sort(job,rule);
	        System.out.println(job);
	        Jobs currentJob=job.get(0);
	        
	        int ans=currentJob.p;
	        for(int i=1;i<job.size();i++) {
	        	if(currentJob.e>job.get(i).s) {
	        		
	        	}else {
	        		currentJob=job.get(i);
	        		ans+=currentJob.p;
	        	}
	        }
	        return ans;
	    }
}
