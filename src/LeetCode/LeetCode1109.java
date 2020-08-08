package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode1109 {
	 public static int[] corpFlightBookings(int[][] bookings, int n) {
	      int list[]=new int[n];
	       for(int i=0;i<bookings.length;i++) {
	    	   System.out.println(bookings[i][0]+" --->"+bookings[i][0]);
	    	   for(int j=bookings[i][0];j<=bookings[i][1];j++) {
	    		   list[j-1]+=bookings[i][2];
	    	   }
	       }
	       return list;
	    }
	 public static int[] corpFlightBookings2(int[][] bookings, int n) {
	        int[] res = new int[n];
	        //fill the array with initial values for prices
	        for (int[] b : bookings) {
	            res[b[0] - 1] += b[2];
	            //mark the next element after series end with -(price) value
	            if (b[1] < n) {
	                res[b[1]]-=b[2];
	            }
	        }
	        System.out.println(Arrays.toString(res));
	        //calculate final result based on sum of previously calculated values
	        for (int i=1; i<n; i++) {
	            res[i]+=res[i-1];
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bookings[][] = {{1,2,10},{2,3,20},{2,5,25}},n = 5;
		System.out.println(Arrays.toString(corpFlightBookings2(bookings,n)));
	}

}
