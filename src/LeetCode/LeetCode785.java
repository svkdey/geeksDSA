package LeetCode;

public class LeetCode785 {
	public boolean isBipartite(int[][] adjList) {
		isBiparatile=true;
		int n=adjList.length;
		int color[]=new int[n];
		for(int i=0;i<n;i++) {
			if(color[i]==0) {
				dfs(adjList, color, i, n, 0, -1);
			}
		}
		return isBiparatile;
	}
	static boolean isBiparatile=true;
	public void dfs(int[][] adjList,int color[],int src,int n,int col,int parent) {
		
		color[src]=col;
		
		for(int child:adjList[src]) {
			if(color[child]==0) {
				dfs(adjList, color, child, n,3-col,src);
			}else {
				if(parent!=child && col==color[child]) {
					isBiparatile=false;
				}
			}
		}
		
	}
}
