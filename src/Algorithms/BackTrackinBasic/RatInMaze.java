package Algorithms.BackTrackinBasic;

public class RatInMaze {
    public static void solve(int[][] maze, int N) {
        int grid[][]=new int[N][N];
        // add your code here
        boolean res=dfs(maze,N,0,0,grid);

        if(res){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println(false);
        }
    }

    static boolean isSafe(int[][] maze, int N, int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dfs(int[][] maze, int N, int x, int y, int grid[][]) {
        // add your code here

        if (x == N - 1 && y == N - 1) {
            grid[x][y] = 1;
            return true;
        }
        int jumps = maze[x][y];
        for (int i = 1; i <= jumps; i++) {
            grid[x][y] = 1;
            if (isSafe(maze, N, x, y ) && dfs(maze, N, x, y + i, grid)) {
                return true;
            }
            if (isSafe(maze, N, x , y) && dfs(maze, N, x + i, y, grid)) {
                return true;
            }

            grid[x][y] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int grid[][] = {{2, 1, 0, 0,},
                        {3, 0, 0, 1},
                        {0, 1, 0, 1},
                        {3, 0, 0, 1}};
//        int grid[][]={{1,1},{1,1}};
        solve(grid,2);

    }
}
