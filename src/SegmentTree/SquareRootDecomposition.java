package SegmentTree;

import java.util.*;

public class SquareRootDecomposition {
	int arr[] = null;
	int blocks[] = null;
	int rn = 0;

	public SquareRootDecomposition(int a[]) {
		arr = a;
		rn = (int) Math.sqrt(arr.length);
		Build();
		System.out.println(Arrays.toString(blocks));
	}

	// build
	private void Build() {

		blocks = new int[rn + 1];
		int block_id = -1;
		for (int i = 0; i < arr.length; i++) {
			if (i % rn == 0) {
				block_id++;
			}
			blocks[block_id] += arr[i];
		}

	}

	// update
	private void Update(int idx, int value) {
		int blockId = idx / rn;
		blocks[blockId] += (value - arr[idx]);
		arr[idx] = value;
	}

	// query
	private int Queries(int L, int R) {
		int ans = 0;
		while (L < R && L != 0 && L % rn != 0) {
			ans += arr[L];
			L++;
		}
		while (L + rn <= R) {
			int blockId = L / rn;
			ans += blocks[blockId];
			L += rn;
		}
		while (L <= R) {
			ans += arr[L];
			L++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SquareRootDecomposition sqrt = new SquareRootDecomposition(arr);
		System.out.println(sqrt.Queries(2, 8));
		sqrt.Update(5, 15);
		System.out.println(sqrt.Queries(2, 8));
	}
}
