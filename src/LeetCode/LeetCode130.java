package LeetCode;

public class LeetCode130 {
	 public void solve(char[][] grid) {
         
	        int n=grid.length;
	        if(n==0) return ;
	        int m=grid[0].length;
	        if(m==0) return ;
	        
	      
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(grid[i][j]=='O'&&dfs(grid,i,j,n,m)){
	                    grid[i][j]='X';
	                }
	            }
	        }
	    }
	    
	   public boolean dfs(char board[][],int i,int j,int n,int m){
	       
	       // base
	      if(i<0||i>=n||j<0||j>=m){
	        return false;
	      }
	       // recusive
	       
	           board[i][j]='X';
	           if(dfs(board,i+1,j,n,m)&&dfs(board,i-1,j,n,m)&&dfs(board,i,j+1,n,m)&&dfs(board,i,j-1,n,m)){
	               return true;
	           }
	            board[i][j]='O';
	       
	    
	        return false;
	       
	   } 
}
