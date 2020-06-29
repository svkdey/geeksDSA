package Playground;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sagheer {

	private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	private static int M_MAX;
	private static int N, M;
	private static int MATRIX[][] = new int[16][150];
	private static int ILL[] = new int[16]; // has index of last bulb while entering from left.
	private static int ILR[] = new int[16]; // has index of last bulb while entering from right.
	private static int FINAL_FLOOR_WHERE_BULB_IS_PRESENT = 0;

	private static void readInput() {
		try {
			String[] NM = buf.readLine().split("\\s");
			N = Integer.parseInt(NM[0]); // total floors in building.
			M = Integer.parseInt(NM[1]); // cols in building.
			M_MAX = M + 2;// M_MAX is the total cols of building including stairs on either sides.
			for (int i = 0; i < N; i++) {
				String AR[] = buf.readLine().split("");
				for (int j = 0; j < M_MAX; j++) {
					MATRIX[i][j] = Integer.parseInt(AR[j]);
					if (MATRIX[i][j] == 1) {
						ILL[N - i - 1] = j;
						ILR[N - i - 1] = Math.max(M_MAX - j - 1, ILR[N - i - 1]);
						FINAL_FLOOR_WHERE_BULB_IS_PRESENT = Math.max(FINAL_FLOOR_WHERE_BULB_IS_PRESENT, N - i - 1);
						;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Excepiton while input " + e);
		}
	}

	private static int minTime(boolean isLeft, int floor, int totalDist) {
		// base case
		if (floor == FINAL_FLOOR_WHERE_BULB_IS_PRESENT) {
			if (isLeft) {
				totalDist += ILL[floor];
			} else {
				totalDist += ILR[floor];
			}
			return totalDist;
		} else {

			// totalDistToLeft is moving from current position to next floor from left most
			// stairs
			// totalDistToRight is moving from current position to next floor from right
			// most stairs
			// return min distance after going to next floor through left and right
			if (isLeft) {
				totalDist += ILL[floor];
				int totalDistToLeft = totalDist + ILL[floor] + 1;
				int totalDistToRight = totalDist + (M_MAX - ILL[floor] - 1) + 1;
				return Math.min(minTime(true, floor + 1, totalDistToLeft), minTime(false, floor + 1, totalDistToRight));

			} else {
				totalDist += ILR[floor];
				int totalDistToLeft = totalDist + (M_MAX - ILR[floor] - 1) + 1;
				int totalDistToRight = totalDist + ILR[floor] + 1;
				return Math.min(minTime(true, floor + 1, totalDistToLeft), minTime(false, floor + 1, totalDistToRight));
			}
		}
	}

	public static void main(String abc[]) {
		readInput();
		int result = minTime(true, 0, 0);
		System.out.println(result);
	}
}