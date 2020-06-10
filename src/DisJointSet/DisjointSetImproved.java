package DisJointSet;

import java.util.Arrays;

public class DisjointSetImproved {
	public int parent[] = null;
	public int rank[] = null;

	@Override
	public String toString() {
		return "DisjointSetImproved [parent=" + Arrays.toString(parent) + "]";
	}

	private void initialize(int n) {
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public DisjointSetImproved(int n) {
		super();
		this.parent = new int[n];
		this.rank = new int[n];
		initialize(n);

	}

	// o(log n)
	public int find(int x) {
		// if x is parent of x it self return x
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);// path compression technique used
		}
		return parent[x];
	}

	// o(log n)
	public void union(int x, int y) {
		int x_rep = find(x);
		int y_rep = find(y);

		// if they are already part of set
		if (x_rep == y_rep)
			return;

		// if height of x tree is bigger then x will be parent of y
		if (rank[x_rep] > rank[y_rep]) {
			parent[y_rep] = x_rep;
		}
		// if height of y tree is bigger then y will be parent of x
		if (rank[y_rep] > rank[x_rep]) {
			parent[x_rep] = y_rep;
		}

		// x is parent of y
		else {
			parent[y_rep] = x_rep;
			rank[x_rep]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSetImproved dijointSetSimpleImpl = new DisjointSetImproved(5);
		dijointSetSimpleImpl.union(0, 1);
		dijointSetSimpleImpl.union(2, 3);
		
		dijointSetSimpleImpl.union(0, 4);
		System.out.println(dijointSetSimpleImpl.find(3));
		System.out.println(dijointSetSimpleImpl);
	}

}
