package Algorithms.BackTrackinBasic;

import java.util.Arrays;

public class SolveSudokuBetterApproach {
	public static boolean isSafe(int board[][], int i, int j, int size, int number) {
		// check row or col
		for (int x = 0; x < size; x++) {
			if (board[i][x] == number || board[x][j] == number) {
				return false;
			}
		}
		// that box can have number
		int rn = (int) Math.sqrt(size);
		int sx = (i / rn) * rn;
		int sy = (j / rn) * rn;

		for (int x = sx; x < sx + rn; x++) {
			for (int y = sy; y < sy + rn; y++) {
				if (board[x][y] == number) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean solve(int board[][], int i, int j, int size) {
		// we will solve row wise

		// if it is solved then
		if (i == size) {
//			print
			for (int x = 0; x < size; x++) {
				System.out.println(Arrays.toString(board[x]));
			}
			return true;
		}
		// if we are at end of a row then go to next row
		if (j == size) {
			return solve(board, i + 1, 0, size);
		}
		// skip filled

		if (board[i][j] != 0) {
			return solve(board, i, j + 1, size);
		}

		for (int k = 1; k <= 9; k++) {
			if (isSafe(board, i, j, size, k)) {
				board[i][j] = k;
				if (solve(board, i, j + 1, size)) {
					return true;
				}
				board[i][j] = 0;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		solve(board, 0, 0, board.length);
	}

}
