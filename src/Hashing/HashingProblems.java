package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashingProblems {
	public static LinkedHashMap<Integer, Integer> getFrequency(int[] arr, int start, int end) {
		// HashMap<Integer, Integer> m=new HashMap<>();
		LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
		for (int i = start; i < end; i++) {
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));

			}
		}

		return m;
	}

	public static int noOfdistinctElement(int[] arr, int start, int end) {
		HashMap<Integer, Integer> m = getFrequency(arr, 0, arr.length);
		// System.out.println(m.size());
		return m.size();
	}

	public static void frequency(int[] arr) {
		LinkedHashMap<Integer, Integer> m = getFrequency(arr, 0, arr.length);
		System.out.println(m);
	}

	public static void intersectionOf2Array(int[] arr1, int arr2[]) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i : arr1) {
			hs.add(i);
		}
		for (int i : arr2) {
			if (hs.contains(i)) {
				System.out.print(i + " ");
			}
		}

	}

	public static void union(int[] arr1, int arr2[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			set.add(arr2[i]);
		}
		System.out.println(set.size());
	}

	public static String findMaxFrequenelement(int arr[], int n) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int maxFrequncy = 0;
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
				maxFrequncy = Math.max(maxFrequncy, hm.get(arr[i]));
			} else {
				hm.put(arr[i], 1);
				maxFrequncy = Math.max(maxFrequncy, hm.get(arr[i]));
			}

		}

		System.out.println(maxFrequncy);
		return Integer.toString(maxFrequncy);
	}

	public static void get1stRepeatedElement(int arr[]) {
		HashSet<Integer> hs = new HashSet<>();
		for (Integer i : arr) {
			if (hs.contains(i)) {
				System.out.println(i);
				break;
			} else {
				hs.add(i);
			}
		}
	}

	static void findEqual(int a[], int b[]) {
		int same = 1;
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (hm1.containsKey(a[i])) {
				hm1.put(a[i], hm1.get(a[i]) + 1);
			} else {
				hm1.put(a[i], 1);
			}
		}
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		for (int i = 0; i < b.length; i++) {
			if (hm2.containsKey(b[i])) {
				hm2.put(b[i], hm2.get(b[i]) + 1);
			} else {
				hm2.put(b[i], 1);
			}
		}
		if (hm1.size() == hm2.size()) {
			for (Map.Entry<Integer, Integer> item : hm1.entrySet()) {
				if (item.getValue() != hm1.get(item.getKey())) {
					same = 0;
					break;
				}
			}

		} else {
			same = 0;
		}
		System.out.println(same);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 9, 2, 3, 3, 4, 4, 5 };
		// noOfdistinctElement(new int[] { 1, 2, 3, 3, 4, 4, 5 },0,7);
		// frequency(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 });
		// intersectionOf2Array(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 }, new int[] { 1, 9,
		// 4, 4, 5 });
		// union(new int[] {3,3,3 }, new int[] {3,3 });
		// System.out.println(findMaxFrequenelement(new int[] { 2 ,3, 4, 5, 5 }, 5));
		// get1stRepeatedElement(new int[] {1 ,5 ,3 ,4 ,3 ,5 ,6});
		get1stRepeatedElement(arr);
		findEqual(new int[] { 8, 9, 7, 5, 3, 1 }, new int[] { 5, 4, 2, 5, 1, 7 });
	}

}
