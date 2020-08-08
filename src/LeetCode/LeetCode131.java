package LeetCode;

import java.util.*;

public class LeetCode131 {
	public static List<List<String>> partition(String s) {
		HashSet<ArrayList<String>> set= new HashSet<ArrayList<String>>();
		backTrack(s, s.length(), 0, new ArrayList<String>(),set);
		return new ArrayList<List<String>>(set);
    }
	
	public static void backTrack(String s,int n,int i,ArrayList<String> op,HashSet<ArrayList<String>> ans) {
		if(i==n) {
			ans.add(new ArrayList<>(op)) ;//all the subset with size 3
		}
//		System.out.println(op);//all the subset
		for(int start=i;start<n;start++) {
			if(palidrome(s,i,start)) {
			op.add(s.substring(i,start+1));
			backTrack(s, n, start+1, op, ans);
			op.remove(op.size()-1);
			}
		}
		
    }
	public static boolean palidrome(String s,int i ,int j) {
		while(j>i) {
			if(s.charAt(i++)!=s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
//		char arr[]= {'a','a','c'};
		String arr="aac";
		System.out.println(partition(arr));
	}
	
}
