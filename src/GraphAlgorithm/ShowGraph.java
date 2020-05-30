package GraphAlgorithm;

import java.util.Arrays;

public class ShowGraph<T> {
    public static <T> void show(int[][] visited){
        System.out.println("--------------------------------------");
        for(int i=0;i<visited.length;i++){
            System.out.println(Arrays.toString(visited[i]));
        }
    }
    public static <T> void show(boolean[][] visited){
        System.out.println("--------------------------------------");
        for(int i=0;i<visited.length;i++){
            System.out.println(Arrays.toString(visited[i]));
        }
    }
}
