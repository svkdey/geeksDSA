package Algorithms.BackTrackinBasic;

public class SodukoProblems {
    public static boolean solve(int board[][],int n){
        // find i,j where value is 0
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {

            if (isSafe(board, board.length,row, col, num)) {
                board[row][col] = num;
                if (solve(board, n)) {
                    // print(board, n);
                    return true;
                }
                else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static boolean isSafe(int board[][],int size,int i,int j,int num){
        //check number is repeating in row if false
        //check number is repeating in culumn if false
      //  System.out.println(i+" "+j);
        for(int k=0;k<size;k++){
            if(board[i][k]==num||board[k][j]==num){
                return false;
            }
        }


        //check in box if false
        /**
         this calculation is important as you need to find co ordinates of positions in grid
        **/
        int s=(int)Math.sqrt(size);
        int rs=i-(i%s);
        int cs=j-(j%s);

        for(int a=0;a<s;a++){
            for(int b=0;b<s;b++){
                if(board[a+rs][b+cs]==num){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(6%4);
    int board[][]={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        solve(board,board.length);
        for(int a=0;a<board.length;a++){
            for(int b=0;b<board[a].length;b++){
                System.out.print(board[a][b]+" ");
                }
            System.out.println();
            }
        }


}
