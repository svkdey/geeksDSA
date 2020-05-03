package stringDSA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class CaseSort {
	

	public static String caseSort(String str) {
        // Your code here
        Queue<Character> lower = new PriorityQueue<>();
        Queue<Character> upper = new PriorityQueue<>();
        
        for(int i = 0; i < str.length(); ++i) {
            
            if(Character.isLowerCase(str.charAt(i)))
                lower.add(str.charAt(i));
            else
                upper.add(str.charAt(i));
        }
        
        String ans = "";
        
        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            
            if(Character.isLowerCase(c))
                ans += lower.remove();
            else
                ans += upper.remove();
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((int) "Z".charAt(0));
		System.out.println(caseSort("defRTSersUXI"));
	}

}
