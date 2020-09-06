package LeetCode;

public class LeetCode832 {
	  public int[][] flipAndInvertImage(int[][] A) {
	        int colNumber=A[0].length;
	        
	       for(int x=0;x<A.length;x++) {
	    	   int i=0;
		       int j=colNumber-1;
	    	   while(j>i) {
	    		   int temp=A[x][i];
	    		   A[x][i]=A[x][j];
	    		   A[x][j]=temp;
	    		   j--;i++;
	    	   }
	       }
	       for(int x=0;x<A.length;x++) {
	    	   for(int y=0;y<A[x].length;y++) {
	    		   A[x][y]= (A[x][y]==1)?0:1;
	    	   }
	    	   
	       	}
	      return A;
	    }
}
