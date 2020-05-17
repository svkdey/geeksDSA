package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapProblems {
	// https://www.geeksforgeeks.org/nearly-sorted-algorithm/
	// nlog k time
	static int[] kSortedArray(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		int idx = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[idx] = pq.poll();
			idx++;
			pq.add(arr[i]);
		}
		while (!pq.isEmpty()) {
			arr[idx] = pq.poll();
			idx++;
		}

		return arr;
	}

	// o(n) + o(count*ln n)
	static int parcheseMaxItem(int arr[], int sum) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int count = 0;
		while (sum >= pq.peek()) {
			sum -= pq.poll();

			count++;
		}
		return count;
	}

//	2o(n)+o((n-k)*ln n)
	static void KlargestElementInOrder(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		int numberOfelemenyPoped = 0;
		while (numberOfelemenyPoped < arr.length - k) {
			pq.poll();
			numberOfelemenyPoped++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (pq.contains(arr[i])) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	static void mergeKSortedArray(ArrayList<ArrayList<Integer>> arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (ArrayList<Integer> list : arr) {
			list.forEach(i -> pq.add(i));
		}
		int res[] = new int[pq.size()];
		int i = 0;
		while (!pq.isEmpty()) {
			res[i] = pq.poll();
			i++;
		}
		System.out.println(Arrays.toString(res));
	}

//25 7 11 15 20
	static void printMedianOfStream(int arr[]) {
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
		max.add(arr[0]);
		System.out.print(max.peek() + " ");
		for (int i = 1; i < arr.length; i++) {
			//check if max is greater in size min.if greater then we will add in min, else always max

			if (max.size() > min.size()) {
				// checking where should we send this in coming element
				// if max.peek>arr[i] =>arr[i] in max. max.peek in min
				if (max.peek() > arr[i]) {
					min.add(max.poll());
					max.add(arr[i]);
				} else {
					min.add(arr[i]);
				} // even case
				// when array size becomes equal it makes it even
				System.out.print((double) (min.peek() + max.peek()) / 2 + " ");
			} else {

				// check min top element>arr[i]
				// if yes then add maxHeap;
				// else add in minHeap, remove and push in max Heap.
				if (arr[i] <= min.peek()) {
					max.add(arr[i]);

				} else {
					min.add(arr[i]);
					max.add(min.poll());

				}

				// odd case
				System.out.print(max.peek() + " ");

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int listOfPrice[] = { 20, 11, 5, 30, 100 };
//		System.out.println(parcheseMaxItem(listOfPrice,35));
		// KlargestElementInOrder(listOfPrice,2);
//		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> l = new ArrayList<Integer>();
//		l.add(1);
//
//		l.add(12);
//		l.add(22);
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		a.add(5);
//		a.add(13);
//		a.add(46);
//
//		ArrayList<Integer> b = new ArrayList<Integer>();
//		b.add(2);
//		b.add(3);
//		b.add(32);
//		b.add(44);
//
//		arr.add(l);
//		arr.add(a);
//		arr.add(b);
//		mergeKSortedArray(arr);

		int arr[] = { 25, 7, 11, 15, 20 };
		printMedianOfStream(arr);
	}

}
