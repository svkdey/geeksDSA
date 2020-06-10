package Algorithms.DynamicProblems;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStackingProblem {
	static class Box {
		int w;
		int b;
		int h;

		public Box(int w, int b, int h) {
			super();
			this.w = w;
			this.b = b;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Box [w=" + w + ", b=" + b + ", h=" + h + "]";
		}

	}

	/**
	 * 
	 * 1) Generate all 3 rotations of all boxes. The size of rotation array becomes
	 * 3 times the size of the original array. For simplicity, we consider width as
	 * always smaller than or equal to depth.
	 * 
	 * 2) Sort the above generated 3n boxes in decreasing order of base area.
	 * 
	 * 3) After sorting the boxes, the problem is same as LIS with following optimal
	 * substructure property. 
	 * msh[0]=sortedBoxArray[0].h;
	 * now Find LIS form n=1... 3n, on condition currentBox.w < prevBox.w && currentBox.b < prevBox.b 
	 * and update msh[i]=val+current[i].h;
	 * 
	 * 4) To get overall maximum height, we return max(MSH(i)) where 0 < i < n
	 **/

	public static void solve(Box[] boxs, int n) {
		// generate all the box permutations

		Box[] permuatedBox = new Box[3 * n];
		for (int i = 0; i < n; i++) {
			int w = boxs[i].w;
			int h = boxs[i].h;
			int b = boxs[i].b;

			permuatedBox[3 * i] = new Box(w, h, b);
			permuatedBox[3 * i + 1] = new Box(h, b, w);
			permuatedBox[3 * i + 2] = new Box(b, w, h);

		}
		System.out.println(Arrays.toString(permuatedBox));
		Comparator<Box> c = (o1, o2) -> {
			return (o2.w * o2.b) - (o1.w * o1.b);
		};
		Arrays.sort(permuatedBox, c);
		// System.out.println(Arrays.toString(permuatedBox));
		int count = 3 * n;
		int maxPossibleStackHeight[] = new int[count];

		maxPossibleStackHeight[0] = permuatedBox[0].h;

		for (int i = 1; i < count; i++) {
			int val = 0;
			Box currentBox = permuatedBox[i];
			for (int j = i - 1; j >= 0; j--) {
				Box prevBox = permuatedBox[j];
				if (currentBox.w < prevBox.w && currentBox.b < prevBox.b) {
					val = Math.max(val, maxPossibleStackHeight[j]);
				}
			}
			maxPossibleStackHeight[i] = val + currentBox.h;
		}
		// System.out.println(Arrays.toString(maxPossibleStackHeight));
		int result = -1;
		for (int i = 0; i < count; i++) {
			result = Math.max(result, maxPossibleStackHeight[i]);
		}
		System.out.println(result);

	}

	public static void main(String[] args) {
		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);
		solve(arr, arr.length);
	}
}
