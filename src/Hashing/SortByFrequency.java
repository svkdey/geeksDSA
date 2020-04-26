package Hashing;

import java.util.*;
import java.util.Map.*;

import Arrayproblems.ArrayPreoblems;
import Data.ArrayData;

public class SortByFrequency {
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByDesending(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByAscending(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		return sortedEntries;
	}
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByDesendingOrderMinComesFirst(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				if(e2.getValue()!=e1.getValue()) {
					return e2.getValue().compareTo(e1.getValue());
					}
				else {
					return ((Integer) e1.getKey()).compareTo((Integer) e2.getKey());
				}
			}
		});

		return sortedEntries;
	}
	static void sortByFreq(int arr[], int n) {
		// add your code here
		int maxVal = arr[0], minVal = arr[0];
		LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));
			}
		}
		List<Entry<Integer, Integer>> list=entriesSortedByValuesByDesendingOrderMinComesFirst(m);
		System.out.println(list);
		int i = 0;
		for (Entry<Integer, Integer> e:list) {
			
				int k = 0;
				while (k < e.getValue()) {
					arr[i] = e.getKey();
					k++;
					i++;
				}
				
			}
//		ArrayPreoblems.showArr(arr, arr.length);
		}

		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortByFreq(ArrayData.arrangeData1, ArrayData.arrangeData1.length);
	}

}
