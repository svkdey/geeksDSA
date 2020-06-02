package GraphAlgorithm;
import java.util.*;
import java.lang.*;
import java.io.*;
class DijkstraMatrix{
    public static boolean isValid(int c, int r, int N, int M) {
		// System.out.print(c+" "+r+" "+N+" "+M);
		if (c >= 0 && c < M && r >= 0 && r < N) {
			return true;
		} else {
			return false;
		}
	}

	static int dijkstra(int arr[][], int N, int M) {
		// java code added
		int grid[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];
		int n = 4;
		int[] rDir = { -1, 0, 0, 1 };
		int[] cDir = { 0, -1, 1, 0 };
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
					grid[i][j] = Integer.MAX_VALUE;
				}
			}
		q1.add(0);
		q2.add(0);
		grid[0][0]=arr[0][0];
		visited[0][0]=true;
				
		while (!q1.isEmpty()) {
	
			int r = q1.remove();
			int c = q2.remove();
			for (int i = 0; i < n; i++) {
				int rNew = r + rDir[i];
				int cNew = c + cDir[i];	
				if (isValid(cNew, rNew, N, M) && (grid[rNew][cNew] > grid[r][c] + arr[rNew][cNew])) {
					grid[rNew][cNew] = grid[r][c] + arr[rNew][cNew];
					q1.add(rNew);
					q2.add(cNew);
					visited[rNew][cNew]=true;
				}
			}

		}

		return grid[N-1][M-1];

	}
        
    
		
	
public static void main (String[] args) throws IOException {
	BufferedReader sc =
                new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(sc.readLine());
        while(t-->0){
            int c=Integer.parseInt(sc.readLine());
           int mat[][]=new int[c][c];
            int k=0;
            String[] s=sc.readLine().split(" ");
            for(int i=0;i<c;i++){
                for(int j=0;j<c;j++){
                   mat[i][j]=Integer.parseInt(s[k]);
                    k++;
                }
                
            }
           System.out.println(dijkstra(mat,c,c));
	}
	
}
}