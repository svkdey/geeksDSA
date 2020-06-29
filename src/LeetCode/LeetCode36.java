package LeetCode;

public class LeetCode36 {
	public static boolean check(String[][] board,int row,int col,String val){
	        for(int i=0;i<board.length;i++){
	            if(board[row][i]==val&&i!=col){
	            	System.out.println("at row check "+i+" "+row);
	                return true;
	            }
	            if(board[i][col]==val && i!=row){
	            	System.out.println("at col check "+i+" "+col);
	                return true;
	            }
	        }
	        // that box can have number
			int rn = (int) Math.sqrt(board.length);
			int sx = (row/ rn) * rn;
			int sy = (col/ rn) * rn;
	        
	        for(int i=sx;i<sx+rn;i++){
	             for(int j=sy;j<sy+rn;j++){
	                if(board[i][j]==val&&i!=row&&j!=col){
	                	System.out.println("at sq check "+i+" "+j);
	                    return true;
	                }
	            }
	        }
	        return false;
	        
	    }
	    
	    public static boolean isValidSudoku(String[][] board) {
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                if(board[i][j]!="."&&check(board,i,j,board[i][j])){
	                    System.out.println(i+" "+j+" "+ board[i][j]);
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c[][]= {
				{"5","3",".",".","7",".",".",".","."},
{"6",".",".","1","9","5",".",".","."},
{".","9","8",".",".",".",".","6","."},
		              {"8",".",".",".","6",".",".",".","3"},
		              {"4",".",".","8",".","3",".",".","1"},
		              {"7",".",".",".","2",".",".",".","6"},
		              {".","6",".",".",".",".","2","8","."},
		              {".",".",".","4","1","9",".",".","5"},
		              {".",".",".",".","8",".",".","7","9"}
		            };
		System.out.println(isValidSudoku(c));
	}

}
