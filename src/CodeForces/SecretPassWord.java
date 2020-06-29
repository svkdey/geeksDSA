package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;



public class SecretPassWord {
	static class DisJointSet {
		int set[] = null;

		@Override
		public String toString() {
			return "DisJointSet [set=" + Arrays.toString(set) + "]";
		}

		public DisJointSet(int n) {
			super();
			this.set = new int[n];

			for (int i = 0; i < n; i++) {
				set[i] = i;
			}
		}

		public int find(int x) {
			if (x == set[x]) {
				return x;
			}
			return set[x] = find(set[x]);
		}

		public void union(int v1, int v2) {
			int v1_root = find(v1);
			int v2_root = find(v2);
			if (v1_root == v2_root)
				return;
			set[v1_root] = v2_root;
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(sc.readLine());
		DisJointSet dsu=new DisJointSet(26);
		HashSet<Integer> l=new HashSet<Integer>();
		for(int i=0;i<t;i++) {
			String s =sc.readLine();
			char c[]=s.toCharArray();
			for(int j=0;j<c.length-1;j++) {
				int val1=c[j]-'a';
				int val2=c[j+1]-'a';
				l.add(val1);l.add(val2);
				dsu.union(val1, val2);
			}
			if(c.length==1) {
				int val1=c[0]-'a';
				l.add(val1);
			}
			
		
		}
		int ans=0;
		for(int x:l) {
			if(dsu.set[x]==x) {
				ans++;
			}
		}
	
		System.out.println(ans);
		
	}
}
