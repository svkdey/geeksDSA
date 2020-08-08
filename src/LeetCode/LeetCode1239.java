package LeetCode;

import java.util.HashSet;
import java.util.List;

public class LeetCode1239 {
	public String filter(List<String> arr,int n) {
		StringBuilder s=new StringBuilder();
		int i=0;
		while(n!=0) {
			if((n&1)==1) {
				s.append(arr.get(i));
			}
			n=n>>>1;
			i++;
		}
		return s.toString();
	}
	
	public boolean isUnique(String s) {
		HashSet<Character> set=new HashSet<Character>();
		char sArr[]=s.toCharArray();
		for(char c:sArr) {
			if(set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}
	public int maxLength(List<String> arr) {
		int numOfPerMulation=(int) Math.pow(2, arr.size());
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<numOfPerMulation;i++) {
			String str=filter(arr,i);
			System.out.println(str);
			if(isUnique(str)) {
				ans=Math.max(ans, str.length());
			}
		}
		return ans;
	}
}
