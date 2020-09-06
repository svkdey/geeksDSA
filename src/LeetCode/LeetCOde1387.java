package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeetCOde1387 {
	static class Details{
		int number;
		int steps;
		public Details(int number, int steps) {
		
			this.number = number;
			this.steps = steps;
		}
		@Override
		public String toString() {
			return "Details [number=" + number + ", steps=" + steps + "]";
		}
		
	}
	public int getKth(int lo, int hi, int k) {
        ArrayList<Details> l=new ArrayList<Details>();
		for(int i=lo;i<=hi;i++) {
			step=0;
			dfs(i);
			l.add(new Details(i, step));
		}
		Comparator<Details> rule=(a,b)->{
			if(a.steps==b.steps) return a.number-b.number;
			else return a.steps-b.steps;
		};
		Collections.sort(l,rule);
		System.out.println(l);
		return l.get(k-1).number;
    }
	static int step=0;
	void dfs(int num) {
		if(num==0) {
			return;
		}
		step++;
		System.out.println(num);
		if(step%2==0) {
			dfs(num/2);
		}else {
			dfs((3*num)+1);
		}
	}
	
}
