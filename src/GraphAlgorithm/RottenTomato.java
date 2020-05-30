package GraphAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RottenTomato {


	public static void solve(int[][] graph, int n, int m) {
	int count=BFS(graph,n,m);
		System.out.println(count);
	}

	public static boolean isSafe(int i, int j, int n, int m) {

	    if (i >= 0 && i < n && j >= 0 && j < m) {
	        return true; 
	        }
	    else return false; 
	}
	//idea is me make if 2 makes any tomato rotten we mark as 3
	//3 makes any tomato rotten we make it 4
	//4 make 5 ... goes no.
	//so we can say max time taken is last tomato to rot -number

	public static int BFS(int v[][], int n, int m) {
		boolean changed = false; 
		int initailRotNumber=2;
	    int rot = 2; 
	    while (true) { 
	        for (int i = 0; i < n; i++) { 
	            for (int j = 0; j < m; j++) { 
	  
	                // Rot all other oranges present at 
	                // (i+1, j), (i, j-1), (i, j+1), (i-1, j) 
	                if (v[i][j] == rot) { 
	                    if (isSafe(i + 1, j,n,m) && v[i + 1][j] == 1) { 
	                        v[i + 1][j] = v[i][j]+1; 
	                        changed = true; 
	                    } 
	                    if (isSafe(i, j + 1,n,m) && v[i][j + 1] == 1) { 
	                    	 v[i ][j+1] = v[i][j]+1; 

	                        changed = true; 
	                    } 
	                    if (isSafe(i - 1, j,n,m) && v[i - 1][j] == 1) { 
	                    	 v[i - 1][j] = v[i][j]+1; 
 
	                        changed = true; 
	                    } 
	                    if (isSafe(i, j - 1,n,m) && v[i][j - 1] == 1) { 
	                    	 v[i][j-1] = v[i][j]+1; 

	                        changed = true; 
	                    } 
	                } 
	            } 
	        } 
	  
	        // if no rotten orange found it means all 
	        // oranges rottened now 
	        if (!changed) 
	            break; 
	        changed = false; 
	        rot++; 
	    } 
	    for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) {
            	if(v[i][j]==1) {
            		return -1;
            	}
            }
        }
	    return rot-initailRotNumber;
	  
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(r);
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] n = in.readLine().split(" ");
			int N = Integer.parseInt(n[0]);
			int M = Integer.parseInt(n[1]);
			int graph[][] = new int[N][M];
			String[] g = in.readLine().split(" ");
			int k = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					graph[i][j] = Integer.parseInt(g[k]);
					k++;
				}
			}
			ShowGraph.show(graph);
			solve(graph, N, M);
		}

	}

}
