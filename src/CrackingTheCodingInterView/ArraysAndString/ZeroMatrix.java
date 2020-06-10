package CrackingTheCodingInterView.ArraysAndString;

import java.util.Arrays;

import Utility.Utils;

public class ZeroMatrix {

	static void zeroMatrixImpl(int matrix[][], int r, int c) {
		int row[] = new int[r];
		int col[] = new int[c];
		// store the value row value and col value for a 0 in particular row |column
		// array

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		// if you find col/row value is for i/j is one .make that cell 0

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (row[i] == 1 || col[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 1, 2, 0 }, { 2, 0, 1 }, { 3, 1, 1 } };
		zeroMatrixImpl(mat, 3, 3);

	}

}
