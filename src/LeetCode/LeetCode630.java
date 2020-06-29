package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode630 {
	public static int scheduleCourse(int[][] courses) {
		Comparator<int[]> rule = (a, b) -> {
			return a[1]-b[1];
		};
		Arrays.sort(courses, rule);
//		for (int x[] : courses) {
//			System.out.println(Arrays.toString(x));
//		}
		int time = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
		for(int x[]:courses) {
			time+=x[0];
			pq.add(x[0]);
			if(time>x[1]) {
				time-=pq.remove();
				
			}
//			System.out.println(pq);
		}
//		System.out.println(pq);

		return pq.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c[][] = { { 5, 15 }, { 3, 19 }, { 6, 7 }, { 2, 10 }, { 5, 16 }, { 8, 14 }, { 10, 11 }, { 2, 19 } };
		int a[][] = { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		System.out.println(scheduleCourse(c));
	}

}
