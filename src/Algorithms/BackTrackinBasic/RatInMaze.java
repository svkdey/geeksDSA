package Algorithms.BackTrackinBasic;

public class RatInMaze {
    public static boolean ratInMazeImpl(int arr[][], int n, int m, int result[][]) {
        return ratInMazeImplRecusion(arr,0,0,n,m,result);
    }
    public static boolean ratInMazeImplRecusion(int arr[][],int i,int j, int n, int m, int result[][]) {
            if(i==n-1&&j==m-1){
                result[i][j]=1;
                return true;
            }
            if(isnextMoveValid(arr,i,j,n,m)){
                result[i][j]=1;

                if(ratInMazeImplRecusion(arr,i+1,j,n,m,result)){
                    return true;
                }

                else if(ratInMazeImplRecusion(arr,i,j+1,n,m,result)){
                    return true;
                }
                //resetting the move as it is not going to be in solution
                result[i][j]=0;

            }
            return false;

    }

    static boolean isnextMoveValid(int arr[][], int i, int j, int n, int m) {
        if (i < n && j < m && arr[i][j] == 1) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 1, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        int result[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.println(ratInMazeImpl(arr, 4, 4, result));
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
