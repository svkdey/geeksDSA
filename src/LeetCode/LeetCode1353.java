package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1353 {
	public static int solve(int events[][]) {
		Comparator<int[]> rule=(a,b)->{
			return a[1]-b[1];
		};
		Arrays.sort(events,rule);
		
		int ans=1;
		int day =2;
		for(int i=1;i<events.length;i++) {
			if(events[i][0]<=day&&events[i][1]>=day) {
				day++;
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
