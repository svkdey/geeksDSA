package LeetCode;

import java.util.PriorityQueue;

public class LeetCode455 {
	public static int solve(int g[],int s[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int x:g) {
			pq.add(x);
		}
		int ans=0;
		for(int c:s) {
			if(c>=pq.peek()) {
				ans++;
				pq.remove();
			}
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[]= {1,2};
		int g[]= {1,2,3};
		System.out.println(solve(g, s));
	}

}
