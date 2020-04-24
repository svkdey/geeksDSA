package Matrix;

import Data.Data;

public class SpiralPrint {
	static void spiralPrint(int arr[][], int r, int c) {MatrixProblems.matrixPrint(arr);
	
		
		int top = 0, left = 0, right = c - 1, bottom = r - 1;
		while (bottom >= top && right >= left) {
			// top row printing
			for (int i = left; i <= right; i++) {
				System.out.print(arr[top][i] + " ");
				
			}top++;
			for (int i = top; i <= bottom; i++) {
				System.out.print(arr[i][right] + " ");
				
			}right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					System.out.print(arr[bottom][i] + " ");
					
				}bottom--;
			}
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][left] + " ");
					
				}left++;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spiralPrint(Data.matrixDataNcrossM, 4, 3);
	}

}
