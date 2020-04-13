package BitWise;

/*
 * Basic bit wise operators are
 *  $(AND) ,: (OR) ,^ (XOR) ,<< m (left shift by m bits) ,
 * 	>>m (right shift by m bits)  ,~ (NOT)
 * Notes:1.The left shift and right shift operators cannot be used with negative numbers.
 * 2.  >> /<< on a number  N means N/2 / N*2 respectively
 * 
 * */

public class BitWiseOperation {
	public static void findEvenOrOdd(int n) {
		// idea: any number suppose 4 (0100) bit wise AND with 1 (0001)
		// the if out put = 0 then even number else odd number

		if ((n & 1) == 0) {
			System.out.println("EVEN");
		} else {
			System.out.println("ODD");
		}
	}

	public static void checkKthBitOfNisSet(int num, int k) {
		/*
		 * 1st left shift by 1 by k times 1<<k
		 * 
		 * then AND with n =>num$(1<<k) ===1
		 */
		System.out.println("====>" + (num & (1 << (k))));
		if (((num & (1 << (k))) == 0)) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}

	}

	public static void setNthBitOfNum(int num, int n) {
		/*
		 * 1st left shift by 1 by n times 1<<n then OR with n =>num|(1<<n)
		 */
		System.out.println((num | (1 << n)));
	}

	public static void unsetNthBitOfNum(int num, int n) {
		/*
		 * 1st left shift by 1 by n times 1<<n then NOT ~(1<<n) then AND with n
		 * =>num$~(1<<n)
		 */
		System.out.println((num & (~(1 << n))));
	}
//	given and array arr[];find max value of & by any 2 pairs

	public static void maxAndvalue(int[] a, int n) {
		int maxi = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				maxi = Math.max(maxi, a[i] & a[j]);
		}

		System.out.println(maxi);
	}

	public static int getFirstSetBitPos(int n) {
		if (n == 0)
			return 0;
		// Your code here
		int res = 1;
		while ((n & 1) != 1) {
			n = n >> 1;
			res++;
		}
		return res;

	}

	public static void log2(int x) {

		int res = 0;
		while (x > 1) {
			x = x >> 1;
			res++;
		}
		System.out.println(res);

	}

	public static int posOfRightMostDiffBit(int m, int n) {
		if (m == n)
			return -1;
		int res = 1;
		while ((m & 1) == (n & 1)) {
			m = m >> 1;
			n = n >> 1;
			res++;
		}
		return res;
		// Your code here

	}

	// find no of flips required to convert a to b;
	public static int countBitsFlip(int a, int b) {

		// Your code here
		int xor = a ^ b;
		int res = 0;
		while (xor != 0) {
			xor = xor & (xor - 1);
			res++;
		}
		return res;

	}

	// Function to swap odd and even bits
	public static int swapBits(int n) {

		// Your code
		int eve = (n & 0xAAAAAAAA); // get value of even position 1.most imp line
		int odd = (n & 0x55555555); // odd position 2.most imp line
//	    	System.out.println(eve+" ---"+odd);
		eve = eve >> 1; // right shift of even bit
		odd = odd << 1; // left shift of odd bit
//	    	System.out.println(eve+"----"+odd);
		int out = (eve | odd); // combine both even and or term
		return out;

	}

	public static void checkingRightAndLeftShift(int a, int b) {
		while (a != 0) {
			System.out.print(a + " ");
			a = a >> 1;
		}
		System.out.println("-------------------------");
		while (b != 0) {
			System.out.print(b + " ");
			b = b << 1;
		}
	}

	public static void checkConsicutiveSetBit(int num) {
		// List<Integer> list=new ArrayList<Integer>();
		int res = 0;
		int max = 0;
		while (num > 0) {
			if ((num & 1) == 1) {
				res++;
				max = Math.max(res, max);
			} else {
//	    			list.add(max);
				res = 0;
			}
//	    		System.out.println(num);
			num = num >> 1;
		}
//	    	list.add(max);
		// System.out.println(list);
		System.out.println(max);
		/** Your code here **/
//	    	alternative
//	        int max = 0;
//	        
//	        while(num>0){
//	            num = num&(num<<1);
//	            max++;
//	       }
////	       return max;
	}

	public static boolean isSparse(int n) {
		int noOf1 = 0;
		while (n > 0) {
			n = n & (n << 1);
			noOf1++;
		}
		System.out.println(noOf1);
		return !(noOf1 >= 2);
		// Your code here

	}

	public static void findMSB(int num) {
		if (num == 0)
			System.out.println(0);
		else {
			int msb = 0;
			while (num > 0) {
				num = num >> 1;
				msb++;

			}
			System.out.println(1 << msb);
		}
	}

	// function to conver given N binary to grey
	public static int greyConverter(int n) {
		return n ^ (n >> 1);
		// Your code here

	}

	// function to conver given N Gray to Binary
	public static int grayToBinary(int n) {

		// Your code here
		int res = 0;
		while (n > 0) {
			res = res ^ n;
			n = n >> 1;
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		findEvenOrOdd(9);
//		setNthBitOfNum(2, 2);
//		unsetNthBitOfNum(6, 2);
//		checkKthBitOfNisSet(4, 2);
//		log2(25);
		System.out.println(isSparse(7));
		swapBits(6);
//		checkingRightAndLeftShift(5,6);
		checkConsicutiveSetBit(39);
	}

}
