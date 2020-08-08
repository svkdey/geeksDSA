package LeetCode;

public class LeetCode1528 {
public String restoreString(String s, int[] indices) {
        	int corrected[]=new int[indices.length];
        	for(int i=0;i<indices.length;i++) {
        		corrected[indices[i]]=i;
        	}
        	char c[]=s.toCharArray();
        	StringBuilder sb=new StringBuilder();
        	for(int x:corrected) {
        		sb.append(c[x]);
        	}
        	return sb.toString();
    }
}
