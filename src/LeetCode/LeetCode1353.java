package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1353 {
	public static void solve(int events[][]) {
		Comparator<int[]> rule=(a,b)->{
			return a[1]-b[1];
		};
		Arrays.sort(events,rule);
		int ans=1;
		for(int i=1;i<events.length;i++) {
			if(events[i-1][1]>events[i][0]) {
				ans++;
			}
		}
		System.out.println(ans);
//		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
