package SegmentTree;

public class SegmentTreeImpl {
	static int tree[] = null;

	public static void createSegmentTree(int[] arr) {
		tree = new int[4 * arr.length];
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
			;
		}

	}

}
