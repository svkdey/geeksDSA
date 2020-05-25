package Recursion;

public class PrintPermutationOfStrings {
    public static void printPermutationOfStringsImpl(String str,String ans) {
//        System.out.println("string ==>"+str);
        if (str.length()==0) {
            System.out.println(ans+" ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutationOfStringsImpl(ros, ans + ch);
        }
    }



    public static void main(String[] args) {
        printPermutationOfStringsImpl("abc", "");
    }
}
