package LeetCode;

public class LeetCode925 {
	 public boolean isLongPressedName(String name, String typed) {
	       int countTyped[]=new int[256];
	       int countName[]=new int[256];
	       for(int i=0;i<typed.length();i++) {
	    	   int idx=(int)typed.charAt(i);
	    	   countTyped[idx]++;
	       }
	       for(int i=0;i<name.length();i++) {
	    	   int idx=(int)name.charAt(i);
	    	   countName[idx]++;
	       }
	       
	       for(int i=0;i<256;i++) {
	    	   if(countName[i]!=0) {
	    		   if(countTyped[i]<countName[i]) {
	    			   return false;
	    		   }
	    	   }
	       }
		   return true;
	    }
	 public static void main(String[] args) {
		 LeetCode925 solve=new LeetCode925();
		 System.out.println(solve.isLongPressedName("saeed","ssaaedd"));
	}
}
