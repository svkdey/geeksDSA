package Matrix;

import Data.ArrayData;
import Data.MatrixData;

public class BeautifulArray {
	/*
	 * It's a bit observation kind of Question : apply the formula
	 * 
	 * ( maximum sum of row (col ) * (n)) - (total sum of all elements of matrix);
	 */
	static int findMinOperation(int n, int mat[][]) {
		// Your code here
		MatrixProblems.matrixPrint(mat);
		int rowSum = 0;
		int colSum = 0;
		int total=0;
		for (int i = 0; i < n; i++) {
			int sumRow = 0;
			int sumCol = 0;
			for (int j = 0; j < n; j++) {
				sumRow += mat[i][j];
				total+=mat[i][j];
				sumCol+= mat[j][i];
			}
			rowSum = Math.max(sumRow, rowSum);
			colSum = Math.max(sumCol, colSum);
		}
//		for (int j = 0; j < n; j++) {
//			int sum = 0;
//			for (int i = 0; i < n; i++) {
//				sum += mat[i][j];
//			}
//			colSum = Math.max(sum, colSum);
//		}
		System.out.println(rowSum+" "+colSum+" "+total);
		int numberOfMoves=n*(Math.max(rowSum, colSum))-total;
		return numberOfMoves;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMinOperation(3, MatrixData.arr);
	}

}
