package DisJointSet;

import java.util.Arrays;
// number of disconnected component => number of parent[i]=i
public class DisjointSetSimpleImpl {

	public int parent[] = null;

	@Override
	public String toString() {
		return "DisjointSetSimpleImpl [parent=" + Arrays.toString(parent) + "]";
	}

	private void initialize(int n) {
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public DisjointSetSimpleImpl(int n) {
		super();
		this.parent = new int[n];
		initialize(n);

	}

	// o(n)
	public int find(int x) {
		// if x is parent of x it self return x
		if (parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}

	// o(n)
	public void union(int x, int y) {
		int x_rep = find(x);
		int y_rep = find(y);

		if (x_rep == y_rep)
			return;
		// x is parent of y
		parent[y_rep] = x_rep;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSetSimpleImpl dijointSetSimpleImpl = new DisjointSetSimpleImpl(5);
		dijointSetSimpleImpl.union(2, 3);
		dijointSetSimpleImpl.union(0, 1);
		dijointSetSimpleImpl.union(0, 4);
		System.out.println(dijointSetSimpleImpl.find(3));
		System.out.println(dijointSetSimpleImpl);
	}

}
