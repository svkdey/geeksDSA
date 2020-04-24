package Matrix;

import Data.Data;

public class MatrixProblems {
	static void matrixPrint(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}
	}



	static void printSnakePattern(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");

				}
			} else {
				for (int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");

				}
			}

		}
		System.out.println();
	}

	static void boundaryTraversal(int arr[][], int r, int c) {
		if (r == 1) {
			for (int i = 0; i < c; i++) {
				System.out.print(arr[0][i] + "-");
			}
		}
		if (c == 1) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i][0] + "-");
			}
		} else {
			for (int i = 0; i < c; i++) {
				System.out.print(arr[0][i] + "-");
			}
			for (int i = 1; i < r; i++) {
				System.out.print(arr[i][c - 1] + "-");
			}
			for (int i = c - 2; i >= 0; i--) {
				System.out.print(arr[r - 1][i] + "-");
			}
			for (int i = r - 2; i >= 1; i--) {
				System.out.print(arr[i][0] + "-");
			}
		}

	}

	public static void transpose(int arr[][]) {
		matrixPrint(arr);
		int temp[][] = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				temp[j][i] = arr[i][j];
			}
		}
		matrixPrint(temp);

	}
	//only applied for n * n
	public static int[][] transposesol2(int arr[][]) {
//		matrixPrint(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr[i].length; j++) {
				if(i!=j) {
				int temp=arr[j][i];
				arr[j][i]=arr[i][j];
				arr[i][j]=temp;
				}
			}
		}
		System.out.println("------------------->");
		matrixPrint(arr);
	
		return arr;

	}
	public static void rotateAntiClock90(int arr[][]) {
		matrixPrint(arr);
		int temp[][]=new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				temp[arr.length-j-1][i]=arr[i][j];
			}
		}
		matrixPrint(temp);

	}
	//1st transpose
	//2nd  1st row will be last,2nd row will be n-1 row
	public static void rotateAntiClock90Sol2(int arr[][]) {
		matrixPrint(arr);
		int temp[][]=transposesol2(arr);
		System.out.println("-------------------------------->");
		for(int i=0;i<temp.length;i++) {
			int l=0,h=temp.length-1;
			while(h>l) {
				
				
				int a=temp[l][i];
				temp[l][i]=temp[h][i];
				temp[h][i]=a;
	
				l++;
				h--;
			}
		}
		matrixPrint(temp);

	}
	static void swap(int a,int b) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printSnakePattern(Data.matrixDataNcrossN);
//		boundaryTraversal(Data.matrixDataNcrossM, 4, 3);
//		rotateAntiClock90(Data.matrixDataNcrossN);
//		rotateClock90Sol2(Data.matrixDataNcrossN);
		rotateAntiClock90Sol2(Data.matrixDataNcrossN);
	}

}
