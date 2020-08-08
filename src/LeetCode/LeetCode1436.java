package LeetCode;

import java.util.*;

import Playground.Graph.DfsOfCGraph;


public class LeetCode1436 {
	public String destCity(List<List<String>> paths) {
	      HashMap<String, String> map=new HashMap<String, String>();
	        
	        for(List<String> x:paths) {
	        	map.put(x.get(0), x.get(1));
	        }
	        Stack<String> s = new Stack<String>();
	        HashSet<String> v=new HashSet<String>();
	        Dfs(map,s,paths.get(0).get(0),v);
	        System.out.print(s);
	        return s.peek();
	    }
	private void Dfs(HashMap<String, String> map,Stack<String> s,String src,HashSet<String> v) {
		if(v.contains(src)){
            return;
        }
       v.add(src);
		s.add(src);
		if(map.containsKey(src)) {
			Dfs(map, s, map.get(src),v);
		}else {
			return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
