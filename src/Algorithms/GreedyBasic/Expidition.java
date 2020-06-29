package Algorithms.GreedyBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//spoj.com
public class Expidition {
	// d for direction and f for fuel
	static class Pair {
		int d;
		int f;

		public Pair() {
		}

		public Pair(int f, int s) {
			this.d = f;
			this.f = s;
		}

		@Override
		public String toString() {
			return "Pair [d=" + d + ", f=" + f + "]";
		}

	}

	public static void solve(ArrayList<Pair> list, int dist, int n, int fuel) {
		Comparator<Pair> rule = (a, b) -> {
			return b.d - a.d;
		};
		Collections.sort(list, rule);
		System.out.println(list);
		for (int i = 0; i < n; i++) {
			list.get(i).d = dist - list.get(i).d;
		}
		System.out.println(list);
		int prev = 0; // previously gone city
		int x = 0; // current position
		boolean cantReach = false;

		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		while (x < n) {
			// if we have fuel to reach city
			if (fuel >= (list.get(x).d - prev)) {
				fuel -= (list.get(x).d - prev);

				pq.add(list.get(x).f);

				prev = list.get(x).d;
				x++;
			}
			// if we dont have capacity. we will fuel up
			else {
				// check if any station is visited
				if (pq.isEmpty()) {
					// cant reach
					cantReach = true;
					break;
				}
				// refuel
				fuel += pq.remove();
				ans++;

			}
			// we have visited the city

			// we may need
		}

		if (cantReach) {
			System.out.println(-1);
			return;
		}
		dist -= list.get(n - 1).d;
		if (fuel >= dist) {
			System.out.println(ans);
			return;
		}

		while (fuel < dist) {
			if (pq.isEmpty()) {
				cantReach = true;
				break;
			}
			fuel += pq.remove();
			ans++;
		}
		if (cantReach) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(ans);
			return;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		ArrayList<Pair> list = new ArrayList<Pair>();
		list.add(new Pair(4, 4));
		list.add(new Pair(5, 2));
		list.add(new Pair(11, 5));
		list.add(new Pair(15, 10));
		int fuel = 10;
		int dist = 25;
		solve(list, dist, n, fuel);
	}

}
