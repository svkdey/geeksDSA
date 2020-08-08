package LeetCode;

import java.util.Arrays;

public class LeetCode1108 {
	public static String defangIPaddr(String address) {
        String s[]=address.split("\\.");
        StringBuilder str=new StringBuilder();
        System.out.print(Arrays.toString(s));
        return str.toString();
    }
	public static void main(String[] args) {
		defangIPaddr("1.1.1.1");

	}

}
