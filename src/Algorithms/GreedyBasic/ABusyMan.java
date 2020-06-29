package Algorithms.GreedyBasic;

import java.util.Arrays;
import java.util.Comparator;

public class ABusyMan {
	static class Job{
		//s= start e=end
		int s;int e;String desc;


		public Job(int s, int e, String desc) {
			super();
			this.s = s;
			this.e = e;
			this.desc = desc;
		}


		@Override
		public String toString() {
			return "Job [s=" + s + ", e=" + e + ", desc=" + desc + "]";
		}
	
	
	}
	
	
	public static void solve(Job jobs[],int n) {
		
		//arrange array according to end time.
		
		Comparator<Job> c=(a,b)->{
			return a.e-b.e;
		};
		Arrays.sort(jobs,c);
		
		
		
		Job currentJob=jobs[0];
		int totalJobIsDone=1;
		System.out.println(jobs[0].desc);
		for(int i=1;i<n;i++) {
			if(currentJob.e<=jobs[i].s) {
				totalJobIsDone++;
				currentJob=jobs[i];
				System.out.println(jobs[i].desc);
			}
		}
		System.out.println(totalJobIsDone);
	}

	public static void main(String[] args) {
		Job arr[]=new Job[6];
		arr[0]=new Job(1,5,"dating cursh");
		arr[1]=new Job(1,8,"participate in contest");
		arr[2]=new Job(2,5,"watch movie");
		arr[3]=new Job(6,9,"play dota");
		arr[4]=new Job(8,12,"study for exam");
		arr[5]=new Job(9,12,"sleep peacefully");
		solve(arr, arr.length);
	}
}
