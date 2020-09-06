package LeetCode;

public class LeetCode999 {
	 public int numRookCaptures(char[][] board) {
	        int x=-1,y=-1;
	        for(int i=0;i<board.length;i++) {
	        	for(int j=0;j<board[i].length;j++) {
	        		if(board[i][j]=='R') {
	        			x=i;
	        			y=j;
	        		}
	        	}
	        }
	        System.out.println(x+" "+y);
	        int ans=0;
	        for(int i=x-1;i>=0;i--) {
	        	if(board[i][y]!='.') {
	        		if(board[i][y]!='p') {
	        			ans++;
	        			break;
	        		}else {
	        			break;
	        		}
	        	}
	        	 System.out.println(i+" "+y);
	        }
	        
	        for(int i=x+1;i<board.length;i++) {
	        	if(board[i][y]!='.') {
	        		if(board[i][y]!='p') {
	        			ans++;
	        			break;
	        		}else {
	        			break;
	        		}
	        	}
	        	 System.out.println(i+" "+y);
	        }
	        for(int i=y-1;i>=0;i--) {
	        	if(board[x][i]!='.') {
	        		if(board[x][i]!='p') {
	        			ans++;
	        			break;
	        		}else {
	        			break;
	        		}
	        	}
	        	 System.out.println(i+" "+x);
	        }
	        
	        for(int i=y+1;i<board[0].length;i++) {
	        	if(board[x][i]!='.') {
	        		if(board[x][i]!='p') {
	        			ans++;
	        			break;
	        		}else {
	        			break;
	        		}
	        	}
	        	 System.out.println(i+" "+x);
	        }
	        return ans;
	    }
}
