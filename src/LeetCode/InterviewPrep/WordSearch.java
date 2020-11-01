package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	 public List<String> findWords(char[][] board, String[] words) {
	        List<String> ans=new ArrayList<String>();
	        for(String x:words){
	            if(exist(board,x)){
	                ans.add(x);
	            }
	        }
	        return ans;
	        
	    }
	 public boolean exist(char[][] board, String word) {
	        int n=board.length;
	        int m=board[0].length;
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        		boolean v[][]=new boolean[n][m];
	        		if(word.charAt(0)==board[i][j]&&search(board,word,i,j,0,n,m,v)) {
	        			return true;
	        		}
	        	}
	        }
	        return false;
	    }
	 public boolean search(char[][] board, String word,int i,int j,int wordIdx,int n,int m,boolean v[][]) {

		 if(wordIdx==word.length()) {
			 return true;
		 }
		 if(i<0||i>=n||j<0||j>=m||word.charAt(wordIdx)!=board[i][j]||v[i][j]) {
			 return false;
		 }
		 v[i][j]=true;
		 
		 if(search(board, word, i+1, j, wordIdx+1, n, m,v)) {
			 return true;
		 }
		 if(search(board, word, i-1, j, wordIdx+1, n, m,v)) {
			 return true;
		 }
		 if(search(board, word, i, j+1, wordIdx+1, n, m,v)) {
			 return true;
		 }
		 if(search(board, word, i, j-1, wordIdx+1, n, m,v)) {
			 return true;
		 }
		 v[i][j]=false;
		 return false;
	 }
}
