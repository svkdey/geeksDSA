package Recursion;

import java.util.HashSet;
import java.util.Set;

public class AllTheSubStrings {
	public static void substring(String str) {
		Set<String> list = new HashSet<String>();
		System.out.println(makeSubStr(list, str, "", 0));
	}

	public static Set<String> makeSubStr(Set<String> list, String s, String cur, int i) {
		if (i == s.length()) {
			list.add(cur);

		} else {
			makeSubStr(list, s, cur + s.charAt(i), i + 1);
			makeSubStr(list, s, cur, i + 1);
		}
		list.remove("");
		return list;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		substring("abc");
	}

}

