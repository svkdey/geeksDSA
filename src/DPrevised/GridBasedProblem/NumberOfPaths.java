package DPrevised.GridBasedProblem;

import java.util.Arrays;

public class NumberOfPaths {
	/**
	 * dp[x,y]=dp[x-1][y]+dp[x][y-1]);
	 **/

	static int givenMatrix[][] = { { 1, 2, 3, 1 }, { 2, 3, 0, 2 }, { 5, -1, 2, 4 } };
	static int result[][] = null;

	public static void solveRat() {
		result = new int[givenMatrix.length][givenMatrix[0].length];

		for (int x = 0; x < givenMatrix.length; x++) {
			for (int y = 0; y < givenMatrix[0].length; y++) {
				if (x == 0 && y == 0) {
					result[x][y] = 1;
				} else if (x == 0) {
					result[x][y] = 1;
				} else if (y == 0) {
					result[x][y] = 1;
				} else {
					result[x][y] = result[x][y - 1] + result[x - 1][y];
				}
			}
		}
		for (int x = 0; x < givenMatrix.length; x++) {
			System.out.println(Arrays.toString(result[x]));
		}
	}
//for n th i,j dog can take 1,2,3,..n step
	public static void solveDog() {
		result = new int[givenMatrix.length][givenMatrix[0].length];

		for (int x = 0; x < givenMatrix.length; x++) {
			for (int y = 0; y < givenMatrix[0].length; y++) {
				if (x == 0 && y == 0) {
					result[x][y] = 1;
				} else if (x == 0) {
					result[x][y] = calCulate(x, y, 'y');
				} else if (y == 0) {
					result[x][y] = calCulate(y, x, 'x');
					;
				} else {
					result[x][y] = calCulate(x, y, 'y') + calCulate(y, x, 'x');
				}
			}
		}
		for (int x = 0; x < givenMatrix.length; x++) {
			System.out.println(Arrays.toString(result[x]));
		}
	}

	private static int calCulate(int constaxis, int varAxis, char direct) {
		int sum = 0;
		if (direct == 'x') {
			for (int i = 0; i < varAxis ; i++) {
				sum += result[i][constaxis];
			}

		}
		if (direct == 'y') {
			for (int i = 0; i < varAxis ; i++) {
				sum += result[constaxis][i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		solveRat();
		solveDog();
	}

}
