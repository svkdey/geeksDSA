package SegmentTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 
 * Query based  problem
 * brute force solution
 * 
 * -->offline query
 * -->No update 
 * 
 * https://www.geeksforgeeks.org/mos-algorithm-query-square-root-decomposition-set-1-introduction/
 * */

public class MOalgorithms {
	static class Query {
		int L, R;

		public Query(int l, int r) {
			
			L = l;
			R = r;
		}

	}

	private static void query(int a[], int n, ArrayList<Query> query, int m) {
		int blocks = (int) Math.sqrt(n);
		Comparator<Query> rule = (x, y) -> {
			if (x.L / blocks != y.L / blocks) {
				return x.L - y.L;
			} else {
				return x.R - y.R;
			}
		};
		Collections.sort(query, rule);
		int currL = 0, currR = 0;
		int currSum = 0;
		for (Query q : query) {
			int l = q.L, r = q.R;

			while (currL < l) {
				currSum -= a[currL];
				currL++;
			}

			while (currL > l) {
				currSum += a[currL - 1];
				currL--;
			}
			while (currR <= r) {
				currSum += a[currR];
				currR++;
			}

			while (currR > r + 1) {
				currSum -= a[currR - 1];
				currR--;
			}
			System.out.println(currSum);
		}
		
	}
	 public static void main(String argv[]){ 
	        ArrayList<Query> q = new ArrayList<Query>(); 
	        q.add(new Query(0,4)); 
	        q.add(new Query(1,3)); 
	        q.add(new Query(2,4)); 
	  
	        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};  
	        query(a, a.length, q, q.size());  
	    } 
}
