package SegmentTree;

public class SegmentTreeImpl {
	static int tree[] = null;
	static int lazy[] = null;

	public static void createSegmentTree(int[] arr) {
		tree = new int[4 * arr.length + 1];
		lazy = new int[1000000];
		constructTree(arr, 0, arr.length, 0);
	}

	// ss=segment start,se=segment end, si=segment idx
	public static int constructTree(int[] arr, int ss, int se, int si) {
		// left node condition
		if (ss == se) {
			tree[si] = arr[ss];
			return arr[ss];
		}
		// internal node condition
		int mid = ss + (se - ss) / 2;
		tree[si] = constructTree(arr, ss, mid, 2 * si + 1) + constructTree(arr, mid + 1, se, 2 * si + 2);
		return tree[si];
	}

	public static int getSum(int qs, int qe, int arrSize) {
		if (qs > qe || qe > arrSize - 1 || qs < 0) {
			System.out.println("Invalid Input");
		}
		return getSumUtil(qs, qe, 0, arrSize - 1, 0);
	}

	private static int getSumUtil(int qs, int qe, int ss, int se, int si) {
		// base cases
		if (qs > se || qe < ss) {
			return 0;
		}

		if (qs <= ss || qe >= se) {
			return tree[si];
		}

		// compute mid
		int mid = ss + (se - ss) / 2;

		return getSumUtil(qs, qe, ss, mid, 2 * si + 1) + getSumUtil(qs, qe, mid + 1, se, 2 * si + 2);

	}

	public static void updateSum(int idx, int value, int arrSize, int arr[]) {
		int diff = arr[idx] - value;
		updateSumUtil(idx, 0, arrSize - 1, 0, diff);

	}

	public static void updateSumUtil(int i, int ss, int se, int si, int diff) {
		if (i < ss || i > se) {
			return;
		}
		tree[si] = diff + tree[si];

		if (se > ss) {
			int mid = ss + (se - ss) / 2;

			updateSumUtil(mid, 0, mid, 2 * si + 1, diff);
			updateSumUtil(i, mid + 1, se, 2 * si + 2, diff);

		}

	}

	public static void updateRangeLazy(int ss, int se, int l, int r, int inc, int idx) {
		// clear lazy propagation;
		if (lazy[idx] != 0) {
			tree[idx] += lazy[idx];
			if (ss != se) {
				lazy[2 * idx] += lazy[idx];
				lazy[2 * idx + 1] += lazy[idx];
			}
			lazy[idx] = 0;
		}
		// base case
		if (r < ss || l > se) {
			return;
		}
		// recursive case

//		1. complete overlap
		if (ss >= l && se <= r) {
			tree[idx] += inc;
			if (ss != se) {
				lazy[2 * idx] += inc;
				lazy[2 * idx + 1] += inc;

			}
			return;

		}

//		2. partial
		int mid = ss + (se - ss) / 2;

		updateRangeLazy(ss, mid, l, r, inc, 2 * idx);
		updateRangeLazy(mid, se, l, r, inc, 2 * idx + 1);
		tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
		return;
	}

	public static int queryRangeLazy(int ss, int se, int qs, int qe, int idx) {
		// clear lazy propagation;
		if (lazy[idx] != 0) {
			tree[idx] += lazy[idx];
			if (ss != se) {
				lazy[2 * idx] += lazy[idx];
				lazy[2 * idx + 1] += lazy[idx];
			}
			lazy[idx] = 0;
		}
		// query logic
		if (ss > qe || se < qs) {
			return Integer.MAX_VALUE;
		}
		if (ss >= qs && se <= qe) {
			return tree[idx];
		}
		//partial
		int mid = ss + (se - ss) / 2;

		int left=queryRangeLazy(ss, mid,qs,qe, 2 * idx);
		int right=queryRangeLazy(mid+1, se,qs,qe, 2 * idx+1);
		
		return left+right;
	}
}
