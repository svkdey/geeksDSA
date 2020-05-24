package MatheMatics;

public class MatheMatics {
    static int count = 0;

    static int noOfDigit(int digit) {
        if (digit == 0) return count;
        count++;
        return noOfDigit(digit / 10);
    }

    static int noOfDigitConstTime(int digit) {
        return (int) (Math.log10(digit) + 1);

    }

    /**
     * 1.Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
     * 2.Initially, let p equal 2, the first prime number.
     * 3.Starting from p2, count up in increments of p
     * and mark each of these numbers greater than or equal to p2 itself in the list. These numbers will be p(p+1), p(p+2), p(p+3), etc..
     * 4.Find the first number greater than p in the list that is not marked.
     * If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3
     **/
    //    o(nln (ln n))
    static void generatePrimeNumberTillN(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        //initially we are taking all number as prime
        for (int p = 2; p * p <= n; p++) {

            if (!isNotPrime[p]) {

                for (int i = p * p; i <= n; i = i + p) {

                    isNotPrime[i] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void generatePrimeNumberTillNInRange(int L, int R) {
        boolean[] isNotPrime = new boolean[R + 1];
        //generate till R form 2
        for (int p = 2; p * p <= R; p++) {

            if (!isNotPrime[p]) {
                for (int i = p * p; i <= R; i = i + p) {
                    isNotPrime[i] = true;
                }
            }
        }
        //print L to R
        for (int i = L; i <= R; i++) {
            if (!isNotPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * The Euclidean algorithm is based on the below facts:
     * If we subtract the smaller number from larger (we reduce larger number), GCD doesn't change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
     * Now instead of subtraction, if we divide the smaller number, the algorithm stops when the remainder is found to be 0.
     * <p>
     * gcd(6,4){
     * gcd(4%6,6)=>gcd(4,6){
     * gcd(6%4,4)=>gcd(2,4){
     * gcd(4%2,2){
     * gcd(0,2){
     * return 2;
     * }
     * }
     * }
     * }
     * }
     */
    static int GCD(int greater, int smaller) {
        if (greater == 0) {
            return smaller;
        }
        return GCD(smaller % greater, greater);
    }

    public static void primeFactors(int n) {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
//             While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }
    /*
    another efficient approach can be for i>5 find if the number expressed as 6i+1 or 6i-1
    */

    public static boolean isPrime(int N) {
        //Your code here
        boolean isprime = true;

        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                isprime = false;
                break;
            }
        }
        return isprime;
    }

    //if there lies a prime number whose square lies in N then it has exactly 3divisor
    public static int exactly3Divisors(int N) {
        //Your code here
        int count = 0;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    ;

    public static void main(String[] args) {
        //generatePrimeNumberTillNInRange(10,50);
        int n = 3152;
//        primeFactors(n);
        for (int i = 3; i < 100; i++) {
            System.out.println(i + " ->>" + isPrime(i));
        }
    }
}
