package LeetCode.InterviewPrep;

public class LongestIncreasingPathinMatrix {
	 public int longestIncreasingPath(int[][] matrix) {
	        int n=matrix.length;
	        int m=matrix[0].length;
	        ans=0;
	        for(int i=0;i<n;i++) {
	        	 for(int j=0;j<n;j++) {
	 	        	//boolean v[][]=new boolean[n][m];
	 	        	dfs(matrix, n, m, i, j, -1);
	 	        }
	        }
	        return ans;
	    }
	 static int dir[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	 static int ans=0;
	 public int dfs(int[][] matrix,int n,int m,int i,int j,int prev) {
		 if(i<0||i>n||j<0||j>m||matrix[i][j]<=prev) {
			 return 0;
		 }
		 System.out.println("i :"+i +" j: "+j);
		 int current_ans=1;
		 int prev_ans=1;
		 for(int k=0;k<4;k++) {
			 int cur_i=i+dir[k][0];
			 int cur_j=j+dir[k][1];
			 
			 int sub_ans=dfs(matrix, n, m, cur_i, cur_j, matrix[i][j]);
			 prev_ans=Math.max(prev_ans, sub_ans);
			 
		 }
		 current_ans+=prev_ans;
		 ans=Math.max(ans, current_ans);
		return current_ans; 
	 }
}
