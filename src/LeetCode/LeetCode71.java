package LeetCode;

import java.util.LinkedList;

public class LeetCode71 {
	public static String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder("/");
	    LinkedList<String> stack = new LinkedList<String>();
		for(String s: path.split("/")){
			if(s.equals("..")){
			    if(!stack.isEmpty())
				    stack.removeLast();
			}
			else if(!s.equals("") && !s.equals("."))
				stack.add(s);
		}
		System.out.println(stack);
		for(String s: stack){
			sb.append(s+"/");
		}
		if(!stack.isEmpty()) sb.setLength(sb.length()-1);
		return sb.toString();
		
	}
	public static void main(String[] args) {
		String str="/home/..//foo/";
		System.out.println(simplifyPath(str));
	}
}
