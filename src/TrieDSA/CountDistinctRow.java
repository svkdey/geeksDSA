package TrieDSA;

public class CountDistinctRow {
	static class TrieNode {
		TrieNode[] child = null;

		public TrieNode() {
			this.child = new TrieNode[10];
		}

	}

	public static boolean insert(TrieNode root, int row, int mat[][]) {
		TrieNode current = root;
		boolean flag = false;
		for (int i = 0; i < mat.length; i++) {
			int idx = mat[row][i];

			if (current.child[idx] == null) {
				current.child[idx] = new TrieNode();
				flag = true;
			}
			current = current.child[idx];
		}
		return flag;
	}

	public static void countDistinctRow(int mat[][]) {
		TrieNode root = new TrieNode();
		int res = 0;
		for (int i = 0; i < mat.length; i++) {
			if (insert(root, i, mat) == true) {
				res++;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };
		countDistinctRow(matrix);
	}

}
