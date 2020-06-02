package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Given an array arr of integers that might contain duplicates, return all
 * possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets. The subsets must be sorted lexicographically.
 * 
 * 
 **/
public class SubSetofArray {
	static LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();

	public static void SubSetofArrayImpl(int arr[], int n, int idx, ArrayList<Integer> l) {
		ArrayList<Integer> list = new ArrayList<Integer>(l);
		result.add(list);
		for (int i = idx; i < n; i++) {
			l.add(arr[i]);
			SubSetofArrayImpl(arr, n, i + 1, l);
			l.remove(l.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2 };
		ArrayList<Integer> l = new ArrayList<>();
		SubSetofArrayImpl(arr, arr.length, 0, l);
		StringBuilder s=new StringBuilder();
		for(ArrayList<Integer> list:result) {
			if(list.size()==0) {
				s.append("()");
			}else {
				s.append(" (");
				String str="";
				for(int i:list) {
					str+=Integer.toString(i)+ " ";
				};
				str=str.substring(0,str.length()-1);
				s.append(str+")");
			}
		}
		System.out.println(s);
	}
}
