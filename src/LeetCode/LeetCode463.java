package LeetCode;
//idea :when i am moving form new to visited room just return . when i am returning due to room=0||boundry add sum+1;

public class LeetCode463 {
	 static int sum=0;
	    public int islandPerimeter(int[][] grid) {
	        int n=grid.length;
	        if(n==0) return 0;
	        int m=grid[0].length;
	        if(m==0) return 0;
	        
	       boolean visited[][]=new boolean[n][m];
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(!visited[i][j]&&grid[i][j]==1){
	                    
	                     dfs(grid, i,j,n,m,visited);
	                    // break;
	                }
	            }
	        }
	        int ans=sum;
	        sum=0;
	        return ans;
	    }
	    public void dfs(int[][] a, int i, int j,int n,int m,boolean v[][]) {
	        if(i<0||i>=n||j<0||j>=m||a[i][j]==0){
	            sum++;
	            return;
	        }
	        if(v[i][j]){
	            return;
	        }
	        v[i][j]=true;
	        dfs(a, i+1,j,n,m,v); 
	        dfs(a, i-1,j,n,m,v);
	        dfs(a, i,j+1,n,m,v); 
	        dfs(a, i,j-1,n,m,v);
	    }
}
