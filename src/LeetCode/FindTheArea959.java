package LeetCode;

import java.util.Arrays;

public class FindTheArea959 {
	public int regionsBySlashes(String[] grid) {
		int n=grid.length;
		int m=grid[0].length();
		int maze[][]=new int[3*n][3*n];
		for(int i=0;i<grid.length;i++) {
			char c[]=grid[i].toCharArray();
			for(int j=0;j<c.length;j++) {
				if(c[j]=='/') {
					maze[3*i][3*j+2]=1;
					maze[3*i+1][3*j+1]=1;
					maze[3*i+2][3*j]=1;
				}
				if(c[j]=='\\') {
					maze[3*i][3*j]=1;
					maze[3*i+1][3*j+1]=1;
					maze[3*i+2][3*j+2]=1;
				}
				}
			}
		
		int ans=0;
		boolean v[][]=new boolean[3*n][3*m];
		for(int i=0;i<3*n;i++) {
			System.out.println(Arrays.toString(maze[i]));
			for(int j=0;j<3*m;j++) {
				if(!v[i][j]&&maze[i][j]==0) {
					dfs(maze,v,i,j,3*n);
					ans++;
				}
				
			}
		}
			
		return ans;
	}
	public void dfs(int maze[][],boolean v[][],int i,int j,int s) {
		if(i<0||i>=s||j<0||j>=s||maze[i][j]==1) {
			return;
		}
		if(v[i][j]) {
			return;
		}
		v[i][j]=true;
		dfs(maze,v,i+1,j,s);
		dfs(maze,v,i-1,j,s);
		dfs(maze,v,i,j+1,s);
		dfs(maze,v,i,j-1,s);
		
	}
	public static void main(String[] args) {
		FindTheArea959 f=new FindTheArea959();
		// TODO Auto-generated method stub
		String grid[]={
		                " /",
		                "/ "
		};
		System.out.println(f.regionsBySlashes(grid));
	}

}
