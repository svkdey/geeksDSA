package CrackingTheCodingInterView.ArraysAndString;

public class Rotate90 {
	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int x = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = x;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			int s = 0, e = matrix[i].length - 1;
			while (e >= s) {
				int x = matrix[i][s];
				matrix[i][s] = matrix[i][e];
				matrix[i][e] = x;
				e--;
				s++;
			}
		}
	}
}
