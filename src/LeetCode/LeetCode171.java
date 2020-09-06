package LeetCode;
//Important question
public class LeetCode171 {
	 public int titleToNumber(String s) {
	        char carr[]=s.toCharArray();
	        int colNum=0;
	        for(int i=0;i<carr.length;i++) {
	        	colNum*=26;
	        	colNum+=carr[i]-'A'+1;
	        }
	        return colNum;
	    }
}
