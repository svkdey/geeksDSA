package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HashingProblems {
	public static LinkedHashMap<Integer, Integer> getFrequency(int[] arr) {
//		HashMap<Integer, Integer> m=new HashMap<>();
		LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));
			}
		}
		return m;
	}

	public static void noOfdistinctElement(int[] arr) {
		HashMap<Integer, Integer> m = getFrequency(arr);
		System.out.println(m.size());
	}

	public static void frequency(int[] arr) {
		LinkedHashMap<Integer, Integer> m = getFrequency(arr);
		System.out.println(m);
	}

	public static void intersectionOf2Array(int[] arr1, int arr2[]) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			if (!m.containsKey(arr1[i])) {
				m.put(arr1[i], 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (m.containsKey(arr2[i])) {
				set.add(arr2[i]);
			}
		}
		System.out.println(set);

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noOfdistinctElement(new int[] { 1, 2, 3, 3, 4, 4, 5 });
		frequency(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 });
		intersectionOf2Array(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 }, new int[] { 1, 9, 4, 4, 5 });
		union(new int[] {3,3,3 }, new int[] {3,3 });
	}
	

}
