package Algorithms.BackTrackinBasic;

public class NQueenProblem {
    public static void solveNqueen(int arr[][],int N) {
            if(solveNQueenImpl(arr,0,N)){
                for(int i=0;i<arr.length;i++){
                    for (int j=0;j<arr[i].length;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }

            }else{
                System.out.println("No valid solution");
            }
    }

    public static boolean solveNQueenImpl(int arr[][], int startCol, int N) {
        if (startCol == N) return true;

//        putting queens coloum wise
        for (int i = 0; i < N; i++) {
            //if ith coloum is safe
            if (isSafe(arr, i, startCol, N)) {
//                lets mark is same
                arr[i][startCol] = 1;
//                for that added queue can we reach solution
                if (solveNQueenImpl(arr, startCol + 1, N)) {
//                    if yes return true true
                    return true;
                }
                //else return false;
                arr[i][startCol] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int arr[][], int row, int col, int n) {
        //checking if quene is in same row
        for (int i = 0; i < col; i++) {
            if (arr[row][i] == 1) {
                return false;
            }
        }
        //check upper diagonals
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        //check lower diagonals
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        solveNqueen(arr,5);
    }

}
