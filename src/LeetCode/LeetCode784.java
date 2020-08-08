package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
	public static List<String> letterCasePermutation(String S) {
		List<String> ans=new ArrayList<String>();
		util(S.toCharArray(), 0, S.length(),ans );
		System.out.println(ans);
		return ans;
	}

	public static void util(char arr[], int i, int end, List<String> ans) {
		if(i==end) {
			ans.add(new String(arr));
			return;
		}
		
			if(isSafe(arr[i])) {
				arr[i]=Character.toUpperCase(arr[i]);
				util(arr, i+1, end, ans);
				arr[i]=Character.toLowerCase(arr[i]);
				util(arr, i+1, end, ans);
			}
			else {
				
				util(arr, i+1, end, ans);
			}
	
	}
	public static boolean isSafe(char c) {
		return Character.isAlphabetic(c);
	}
	public static char covertToLowerchar(char c) {
		return (char)((int)c-32);
	}
	public static char covertToUpperchar(char c) {
		return (char)((int)c+32);
	}
	public static void main(String[] args) {
		letterCasePermutation("c");
	}
}
