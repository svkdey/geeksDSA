package GraphAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
class Area {
    static int c = 0;
    static boolean visited[][]=null;
    static int findMaxArea(int N, int M, int A[][]) {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String s = Integer.toString(i) + Integer.toString(j);
                if (visited[i][j]==false && A[i][j] == 1) {

                    DFS(A, i, j, N, M);
                    //   System.out.print(c);
                    count = Math.max(c, count);
                    c=0;
                }

            }
        }
        visited=null;
        return count;
    }

    public static void DFS(int[][] graph, int i, int j, int n, int m) {
        String s = Integer.toString(i) + Integer.toString(j);
        if (i < 0 || i >= n || j < 0 || j >= m || graph[i][j] == 0 ||visited[i][j]==true) {
            return;
        }
        visited[i][j]=true;
        c++;

        DFS(graph, i + 1, j, n, m);
        DFS(graph, i - 1, j, n, m);
        DFS(graph, i, j + 1, n, m);
        DFS(graph, i, j - 1, n, m);
        DFS(graph, i + 1, j + 1, n, m);
        DFS(graph, i - 1, j - 1, n, m);
        DFS(graph, i - 1, j + 1, n, m);
        DFS(graph, i + 1, j - 1, n, m);

    }
}