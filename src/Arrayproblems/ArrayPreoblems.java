package Arrayproblems;
import java.util.ArrayList;

import Data.ArrayData;
import SortingClassExample.SortingMain;

/*
 * insert(O(n))
 * searchLinear(O(n)) //unsorted
 * searchBinary(o(log(n)) ) //sorted
 * delete(o(n))
 * get(o(1));
 * update(o(1));
 * 
 * */
public class ArrayPreoblems {
//	Big O= o(n)
	public static int linearSearch(int[] arr, int n, int x) {
		for (int i = 0; i < n; i++) {
			if (x == arr[i]) {
				return i;
			}
		}
		return -1;

	}

//	Big O= o(n)
	public static int insertXatN(int[] arr, int size, int n, int cap, int x) {
		showArr(arr, cap);
		if (size == cap) {
			return -1;
		}
		for (int i = cap - 1; i >= n; i--) {
			arr[i + 1] = arr[i];
		}
		arr[n] = x;
		showArr(arr, cap);
		return 1;

	}

	public static void showArr(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void reverse(int[] arr, int size) {
		showArr(arr, size);
		int low = 0;
		int high = size - 1;
		while (high > low) {
			//swap high and low
			int temp = arr[high];
			arr[high] = arr[low];
			arr[low] = temp;

			low++;
			high--;
		}
		showArr(arr, size);

	}

	public static int removeDuplicateInSortedArr(int[] arr, int size) {
		/*
		 * ArrayList<Integer> list=new ArrayList<>(); for(int i=0;i<size;i++) {
		 * if(!list.contains(arr[i])) { list.add(arr[i]); } } System.out.println(list+
		 * " "+list.size()); return list.size();
		 */

		/*
		 * //better solution int[] temp=new int[size]; temp[0]=arr[0]; int res=1;
		 * for(int i:arr) { if(temp[res-1]!=i) { temp[res]=i; res++; } } showArr(temp,
		 * res); System.out.println(res); return res;
		 */
		// best soultion

		//without extra space
		showArr(arr, size);
		int res = 1;
		for (int i : arr) {
			if (arr[res - 1] != i) {
				arr[res] = i;
				res++;
			}
		}
		showArr(arr, res);
		System.out.println(res);
		return res;
	}

	public static void leftRotate(int[] arr, int size) {
		showArr(arr, size);
		for (int i = 0; i < size - 1; i++) {
			int temp = arr[i + 1];
			arr[i + 1] = arr[i];
			arr[i] = temp;

		}
		showArr(arr, size);

	}

	public static void leftRotateByd(int[] arr, int size, int d) {
//		showArr(arr, size);
		/*
		 * naive solution o(n*d) for (int j = 0; j < d; j++) { for (int i = 0; i < size
		 * - 1; i++) { int temp = arr[i + 1]; arr[i + 1] = arr[i]; arr[i] = temp;
		 * 
		 * } }
		 */
		// better approach
		/*
		 * int[] temp = new int[d]; 
		 * for (int i = 0; i < d; i++) {
		 * 	 temp[i] = arr[i]; 
		 * 	} //
		 * showArr(temp, d); 
		 * for (int i = d; i < size; i++) {
		 * 	 arr[i - d] = arr[i]; } //
		 * showArr(arr, size); 
		 * for (int i = 0; i < d; i++) { 
		 * 	arr[size - d + i] = temp[i];
		 * }
		 * 
		 * showArr(arr, size);
		 */
		reversePartly(arr, 0, d - 1);
		showArr(arr, size);
		reversePartly(arr, d, size - 1);
		showArr(arr, size);
		reversePartly(arr, 0, size - 1);
		showArr(arr, size);

	}
/** reverse between low and high Idx**/
	public static void reversePartly(int[] arr, int low, int high) {

		while (high > low) {
			int temp = arr[high];
			arr[high] = arr[low];
			arr[low] = temp;
//			System.out.println(high +" "+ low);
			low++;
			high--;
		}

	}

	// element is said to be leader if all right hand element <element
	public static void leader(int[] arr, int size) {
		/*o(n^2)
		 * for (int i = 0; i < size; i++) {
			if (checkRighthand(arr, arr[i], i + 1, size)) {
				System.out.println(arr[i]);
			}

		}*/
		//o(n) solution
		
		int cur_leader=arr[size-1];

		for(int i=size-2;i>=0;i--) {
			if(arr[i]>cur_leader) {
				cur_leader=arr[i];

			}
		}
		System.out.println(cur_leader);
		
	}

	public static boolean checkRighthand(int[] arr, int x, int d, int size) {
		for (int i = d; i < size; i++) {
			if (arr[i] >= x) {
				return false;
			}
		}
		return true;
	}
	
	public static void maxDiff(int[] arr, int size) {
		int max=arr[0];
		int min=arr[0];
		for(int i=1;i<size;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		System.out.println(max + " " +min);
		System.out.println(max-min);
	}
	
	 public static void rearrange(int arr[], int n){
	        
	        // Your code here
	       int j=0,k=n-1;
	       int temp[]=new int[n];
	        for(int i=0;i<n;i++) {
	        	if(i%2==0) {
	        		temp[i]=arr[k];
	        		k--;
	        	}else {
	        		temp[i]=arr[j];
	        		j++;
	        	}
	        }
	        for(int i=0;i<n;i++) {
	        	System.out.println(temp[i]);
	        }
	        
	    }
	 /*
	  * Example:
	Input:
	3
	2
	1 0
	5
	4 0 2 1 3
	4
	3 2 0 1
	
	Output:
	0 1
	3 4 2 0 1
	1 0 3 2
*/
	 static void arrange(long arr[], int n)
	    {
	        // your code here
	     
		       long temp[]=new long[n];
		        for(int i=0;i<n;i++) {
		        	int hold=(int)arr[i];
		        	temp[i]=arr[hold];
		        }
		      //  StringBuilder sb=new StringBuilder();  

		        for(int i=0;i<n;i++) {
		        arr[i]=temp[i];
		        }
//		        showArr(temp, temp.s);
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20,20,30,30, 30,40 };
		int arr1[] = { 10, 20, 30 };
		int arr2[] = { 10, 20, 30, 40 };
//		int[] arr =new int[5];
//		
//		for(int i=0;i<=3;i++)
//		{
//			arr[i]=1;
//		}
//		System.out.println(linearSearch(arr, 3, 5));
//		insertXatN(arr, 3, 4, 4, 10);
//		ArrayList<Integer> list=new ArrayList<>();
//		list.add(10);
//		System.out.println(list.contains(1));
//		list.add(0, 5);
//		System.out.println(list);
//		list.set(0, 100);
//		System.out.println(list);
//		System.out.println(list.size());
//		list.remove(1);
//		System.out.println(list);

//		reverse(arr1, 3);
//		reverse(arr2, 4);
//		int[] arr = { 10,50, 100,20,50, 30, 40 };
//		leftRotateByd(arr, 7, 3);
//		removeDuplicateInSortedArr(arr, 6);
//		maxDiff(arr, 7);
//		arrange(ArrayData.arrangeData, ArrayData.arrangeData.length);
		leftRotateByd(arr2,arr2.length,2);
	}

}
