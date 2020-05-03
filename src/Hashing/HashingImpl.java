package Hashing;

import java.util.ArrayList;

import Data.ArrayData;

public class HashingImpl {
	public static void separateChaining(int arr[], int n, ArrayList<ArrayList<Integer>> hashTable, int hashSize) {
		// Your code here
		int tmpIndx;
		for (int i = 0; i < n; i++) {
			tmpIndx = arr[i] % hashSize;
			hashTable.get(tmpIndx).add(arr[i]);// pushing element arr[i] in the arrayList hashTable at position
												// arr[i]%hashSize
		}
		System.out.println(hashTable);
	}

	static void linearProbing(int hash_table[], int hash_size, int arr[], int array_size) {
		// Your code here
		// Your code here
		int j = 1;
		for (int i = 0; i < array_size; i++) {
			int pos = arr[i] % hash_size;
			if (hash_table[pos] != -1) {
				hash_table[pos] = arr[i];
			} else {
				pos = pos + j;
				pos = pos % hash_size;
				j++;
				hash_table[pos] = arr[i];
			}
		}
	}

	static void linearProbing2(int hash_table[], int hash_size, int arr[], int array_size) {

		for (int num : arr) {
			int hashValue = num % hash_size;
			if (hash_table[hashValue] == -1)
				hash_table[hashValue] = num;
			else {
				int i;
				for (i = 1; i < hash_size; i++) {
					if (hash_table[(hashValue + i) % hash_size] == -1) {
						hash_table[(hashValue + i) % hash_size] = num;
						break;
					}
				}
				if (i == hash_size)
					return;
			}
		}
	}
	static void quadraticProbing(int hash_table[], int hash_size, int arr[], int array_size)
	{
	    //Your code here
	    for (int num : arr) {
				int hashValue = num % hash_size;
				if (hash_table[hashValue] == -1)
					hash_table[hashValue] = num;
				else {
					int i;
					for (i = 1; i < hash_size; i++) {
						if (hash_table[(hashValue + i*i) % hash_size] == -1) {
							hash_table[(hashValue + i*i) % hash_size] = num;
							break;
						}
					}
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int hash=5;
//		ArrayList<ArrayList<Integer>> hashTable=new ArrayList<ArrayList<Integer>>(hash);
//		for(int i=0;i<hash;i++) {
//			ArrayList<Integer> l=new ArrayList<Integer>();
//			hashTable.add(l);
//		}
//		System.out.println(hashTable);
//		separateChaining(ArrayData.arrangeData1, ArrayData.arrangeData1.length, hashTable, 5);
//	
		int hash[] = new int[200];

	}

}
