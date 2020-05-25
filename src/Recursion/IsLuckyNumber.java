package Recursion;

public class IsLuckyNumber {
    static int counter=0;
    public static boolean IsLuckyNumberImpl (int n) {
        int nextNumber=n;
        if(counter>n){
            return true;
        }
        if(n%counter==0){
            return false;
        }
        nextNumber=nextNumber-(n/counter);
        counter++;
        return IsLuckyNumberImpl(nextNumber);

    }

    public static void main(String[] args) {
        counter=2;
        System.out.println(IsLuckyNumberImpl(7));
        counter=0;
    }
}
