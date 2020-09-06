package SegmentTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Dquery {
	static class Query {
		int L, R;

		public Query(int l, int r) {
			super();
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
		HashMap<Integer,Integer>  freq=new HashMap<>();
		for (Query q : query) {
			int l = q.L, r = q.R;

			while (currL < l) {
				if(freq.containsKey(a[currL])) {
					if (freq.get(a[currL])>0) {
						freq.put(a[currL], freq.get(a[currL])-1);
					}
					if(freq.get(a[currL])==0) {
						freq.remove(a[currL]);
					}
				}
				currL++;
			}

			while (currL > l) {
				freq.put(a[currL-1], freq.getOrDefault(a[currL-1], 0)+1);
				currL--;
			}
			while (currR <= r) {
				freq.put(a[currR], freq.getOrDefault(a[currR], 0)+1);
				
				currR++;
			}

			while (currR > r + 1) {
				if(freq.containsKey(a[currR-1])) {
					if (freq.get(a[currR-1])>0) {
						freq.put(a[currR-1], freq.get(a[currR-1])-1);
					}
					if(freq.get(a[currR-1])==0) {
						freq.remove(a[currR-1]);
					}
				}
				
				currR--;
			}
			System.out.println(freq);
			System.out.println(freq.size());
		}
		
	}
	
	static int calculateCost(HashMap<Integer,Integer>  freq) {
		int ans=0;
		for(int item:freq.keySet()) {
			int k=freq.get(item);
			int c=item;
			ans+=k*k*c;
		}
		return ans;
	}
	 public static void main(String argv[]){ 
	        ArrayList<Query> q = new ArrayList<Query>(); 
	        q.add(new Query(1,6)); 
	        q.add(new Query(0,5)); 
	        q.add(new Query(1,6)); 
	  
	        int a[] = {1,1,2,2,1,3,1,1};  
	        query(a, a.length, q, q.size());  
	    } 
}
