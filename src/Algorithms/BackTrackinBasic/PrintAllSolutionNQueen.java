package Algorithms.BackTrackinBasic;

import java.util.Arrays;
import java.util.BitSet;

import javax.naming.spi.DirStateFactory.Result;

public class PrintAllSolutionNQueen {
	public static void solve(int board[][], int size) {
		backTrack(board, 0, size);
	}

	private static boolean isSafe(int board[][], int col, int row, int n) {
		// check column
		for (int j = 0; j < n; j++) {
			if (board[row][j] == 1) {
				return false;
			}
		}
		int x = row;
		int y = col;
		// upper diagonal
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y--;
		}
		x = row;
		y = col;
		// lower diagonal
		while (x < n && y >= 0) {
			if (board[x][y] == 1) {
				return false;
			}
			x++;
			y--;
		}

		return true;
	}

	private static void backTrack(int board[][], int col, int n) {
		if (col == n) {
			for (int i = 0; i < board.length; i++) {
				System.out.println(Arrays.toString(board[i]));

			}
			System.out.println();
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {

			if (isSafe(board, col, i, n)) {

				board[i][col] = 1;
				backTrack(board, col + 1, n);

				board[i][col] = 0;
			}

		}
	}

	
	/**
	 * 1.here below bit musking method for same code that makes complexity ((n^n)/n).
	 * 
	 * 
	 * taking 3 arrays to remember that where last q was place instead of searching for it
	 * 
	 * using back track it can be done as below
	 * 
	 * 
	 * **/
	
	
	
	static BitSet col = new BitSet(30);
	static BitSet uDigonal = new BitSet(30);
	static BitSet lDiagonal = new BitSet(30);

	public static void bitSetHelper(int r, int ans, int n, int result[][]) {
		if (r == n) {
			ans++;

			for (int i = 0; i < result.length; i++) {
				System.out.println(Arrays.toString(result[i]));

			}
			System.out.println();
			System.out.println();
			return;
		}
		for (int c = 0; c < n; c++) {
			if (!col.get(c) && !uDigonal.get(r + c) && !lDiagonal.get(r - c + n - 1)) {
				result[r][c] = 1;
				col.set(c, true);
				uDigonal.set(c + r, true);
				lDiagonal.set(r - c + n - 1, true);

				bitSetHelper(r + 1, ans, n, result);

				result[r][c] = 0;
				col.set(c, false);
				uDigonal.set(c + r, false);
				lDiagonal.set(r - c + n - 1, false);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		int ans = 0;
		bitSetHelper(0, ans, 4, arr);
		System.out.println(ans);
	}

}
