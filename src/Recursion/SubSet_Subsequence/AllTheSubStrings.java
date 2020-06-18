package Recursion.SubSet_Subsequence;

import java.util.ArrayList;

public class AllTheSubStrings {
    public static void solve(char in[],ArrayList<Character> l,int i,int j,int n) {
    	if(i==n) {
    		System.out.println(l);
    		return ;
    	}
    	
    	 l.add(Character.valueOf(in[i]));
    	//keep jTh in i
    	solve(in, l, i+1, j+1, n);
    	//back track
    	l.remove(j);
    	// don't keep last j value over ride with ith value
    	solve(in, l, i+1, j, n);
    	
	}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       char ip[]= {'a','a','b'};
      ArrayList<Character> list = new ArrayList<Character>();
       
       solve(ip, list, 0, 0, ip.length);
       
       
    }

}

