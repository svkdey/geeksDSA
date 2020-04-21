package Recursion;

import java.util.ArrayList;

public class AllTheSubStrings {
	public static void substring(String str) {
		ArrayList<String> list = new ArrayList<String>();
		makeSubStr(list, str, "", 0);
		System.out.println(list);
	}

	public static void makeSubStr(ArrayList<String> list, String s, String cur, int i) {
		if (i == s.length()) {
			list.add(cur);

		} else {
			makeSubStr(list, s, cur + s.charAt(i), i + 1);
			makeSubStr(list, s, cur, i + 1);
		}
		list.remove("");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		substring("abc");
	}

}

