package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode973 {
	
	public int[][] kClosest(int[][] points, int K) {
		Comparator<int[]> rule = (a, b) -> {
			return  (a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1]) ;
		};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(rule);
		for (int point[] : points) {
			pq.add(point);
		}
		int ans[][]=new int[K][2];
		int i=0;
		while(!pq.isEmpty()&&K!=0) {
			K--;
			int co[]=pq.remove();
			ans[i++]=co;
			System.out.println(Arrays.toString(co));
		}

		return ans;
	}
}
