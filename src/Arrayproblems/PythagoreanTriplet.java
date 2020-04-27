package Arrayproblems;

import java.util.HashSet;

public class PythagoreanTriplet {
	public static boolean pythagorean(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i] * arr[i]);
		}
		for (Integer i : set) {
			for (Integer j : set) {
				System.out.println(i+"--->"+j);
				if (set.contains(i - j)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pythagorean(new int[] {3, 2, 4, 6, 5}));
	}

}
