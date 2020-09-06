package GraphQuickRecap;

import java.util.Arrays;

public class FloodFillAlgo {
    public static void floodfillALgoImpl(int image[][], int i, int j, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean visited[][] = new boolean[n][m];
        dfs(image, 0, 0, color, n, m, visited);
        for (int k = 0; k < n; k++) {
            System.out.println(Arrays.toString(image[k])
            );
        }
    }

    public static void dfs(int image[][], int i, int j, int color, int n, int m, boolean v[][]) {
        if (i < 0 || i >= n || j < 0 || j >= m || v[i][j]||image[i][j]==0) {
            return;
        }
        image[i][j] = color;
        v[i][j] = true;

        dfs(image, i + 1, j, color, n, m, v);
        dfs(image, i - 1, j, color, n, m, v);
        dfs(image, i, j + 1, color, n, m, v);
        dfs(image, i, j - 1, color, n, m, v);

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
        floodfillALgoImpl(image, 1, 1, 2);
    }
}
