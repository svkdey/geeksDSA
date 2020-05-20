package Heaps;

import java.util.Arrays;

public class MinHeapImpl {
	int arr[] = null;
	int size = 0;
	int capacity = 0;

	public MinHeapImpl(int capacity) {
		// TODO Auto-generated constructor stub
		this.arr = new int[capacity];
		this.size = 0;
		this.capacity = capacity;

	}

	static int getLeft(int index) {
		return 2 * index + 1;
	}

	static int getRight(int index) {
		return 2 * index + 2;
	}

	static int getParent(int index) {
		return (int) Math.floor((index - 1) / 2);
	}

//o(ln n) 
	void insert(int value) {

		if (this.size < this.capacity) {
			this.size++;
			arr[this.size - 1] = value;
			// go up to 0 while parent>i
			for (int i = this.size - 1; i != 0 && arr[getParent(i)] > arr[i];) {
				swap(arr, i, getParent(i));
				i = getParent(i);
			}
		}

	}

	void swap(int arr[], int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

//time :o(ln n) space:o(h)
	void heapify(int i) {
		int left = getLeft(i), right = getRight(i);
		// considering smallest is i at first;
		int smallest = i;
		// check who is smallest among i,left ,right
		if (left < this.size && arr[i] > arr[left]) {
			smallest = left;
		}
		if (right < this.size && arr[smallest] > arr[right]) {
			smallest = right;
		}
		// if not i then swap and pass the new index to heapify
		if (smallest != i) {
			swap(this.arr, smallest, i);
			heapify(smallest);
		}
	}

	int getMinValue() {
		return this.arr[0];
	}

	int extractMin() {
		if (this.size == 0) {
			return -1;
		}
		if (this.size == 1) {
			this.size--;
			return arr[0];
		}
		int minVal = this.arr[0];
		swap(this.arr, 0, this.size - 1);
		this.arr[this.size - 1] = -1;
		this.size--;
		heapify(0);
		return minVal;
	}

	void decreaseKey(int i, int value) {
		if (size > i) {
			arr[i] = value;
			for (int j = i; j != 0 && this.arr[j] < this.arr[getParent(j)];) {
				swap(this.arr, j, getParent(j));
				j = getParent(j);
			}
		} else {
			System.out.println("Invalid operation");
		}
	}

	//logic :exhange position wih minimum value
	// delete from top
	void deleteAKeyAtIndex(int index) {
		decreaseKey(index, Integer.MIN_VALUE);
		extractMin();
	}
	
	void buildHeap(int arr[]) {
		this.arr=arr;
		for(int i=((arr.length-1)-1)/2;i>=0;i--) {
			heapify(i);
		}
	}

	@Override
	public String toString() {
		return "MinHeapImpl [arr=" + Arrays.toString(arr) + ", size=" + size + ", capacity=" + capacity + "]";
	}

	public static void main(String[] args) {
		MinHeapImpl mh = new MinHeapImpl(10);
		int arr[] = { 10, 15, 4, 5, 6, 13 };
		for (int i : arr) {
			mh.insert(i);
		}
		mh.buildHeap(arr);
		System.out.println(mh);
		System.out.println(Arrays.toString(arr));
//		System.out.println(mh.getMinValue());

//		System.out.println(mh.extractMin());

//		System.out.println(mh.getMinValue());
//		mh.insert(4);
//		mh.decreaseKey(3, 3);
//		mh.deleteAKeyAtIndex(1);
	//	System.out.println(mh);
	}
}
