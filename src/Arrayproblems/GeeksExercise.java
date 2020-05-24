package Arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GeeksExercise {
	public static int majorityWins(int arr[], int n, int x, int y) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int x_count = map.get(x);
		int y_count = map.get(y);
		if (x_count > y_count) {
			return x_count;
		}
		if (x_count == y_count) {
			return Math.max(x, y);
		} else {
			return y_count;
		}

	}

//most efficient solution
	static void largestAndSecondLargest(int sizeOfArray, int arr[]) {

		int i, first, second,arr_size=arr.length;

		/* There should be atleast two elements */
		if (arr_size < 2)
		{
			System.out.print(" Invalid Input ");
			return;
		}

		first = second = Integer.MIN_VALUE;
		for (i = 0; i < arr_size ; i++)
		{
            /* If current element is smaller than
            first then update both first and second */
			if (arr[i] > first)
			{
				second = first;
				first = arr[i];
			}

            /* If arr[i] is in between first and
               second then update second  */
			//removing first value duplication also
			else if (arr[i] > second && arr[i] != first)
				second = arr[i];
		}
		System.out.println(first+" "+second);

	}

	public static void reverse(ArrayList<Integer> mv, int start, int end) {
		while (end > start) {
			int temp = mv.get(start);
			mv.set(start, mv.get(end));
			mv.set(end, temp);
			start++;
			end--;
		}
	}

	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
		// add your code here
		if (k > n) {
			reverse(mv, 0, n - 1);
			return mv;
		} else {
			int start = 0;
			while (n > start) {
				if (n > start + k) {
					reverse(mv, start, start + k - 1);
				}
				start = start + k;
			}
			reverse(mv, start - k, n - 1);

			return mv;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] a = { 5, 6, 8, 9 };
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		System.out.println(reverseInGroups(list, 4, 7));
	}

}
