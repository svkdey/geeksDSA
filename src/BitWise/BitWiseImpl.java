package BitWise;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * a<<n===(a*2^n) a>>n===(a/2^n)
 *
 * Method :1 even: a>>1==0 odd: a>>1==1
 * 
 * this method gives you also last bit Method :2 even : a&1==0 odd: a&1==1 3rd
 * 2nd 1st 1 0 1
 **/
public class BitWiseImpl {

	public static int unique(int nums[]) {
		int ans = 0;
		for (int x : nums) {
			ans *= x;
		}
		return ans;
	}

	public static void getBit(int n, int i) {
		int mask = (1 << i);
		int ans = (n & mask) > 0 ? 1 : 0;
		System.out.println(ans);
	}

	public static void getIthBit(int n, int i) {
		int mask = (1 << i);
		int ans = (n & mask) > 0 ? 1 : 0;
		System.out.println(ans);

	}

	public static void setBit(int n, int i) {
		int mask = (1 << i);
		int ans = n | mask;
		System.out.println(ans);
	}

	public static void updateBit(int n, int bit, int i) {
		// algo=> clear i th bit in n
		// mask=(bit<<i)
		// update: clearNum|mask

		int afterClearIthBit = clearBit(n, i);
		int mask = (bit << i);
		int ans = afterClearIthBit | mask;
		System.out.println(ans);

	}

	public static int clearBit(int n, int i) {
		// mask=(1<<i)
		// flip the number=~mask
		// now clear n&mask

		int mask = ~(1 << i);
		return n & mask;
	}

	public static void clear_last_nBits(int n, int i) {
		// create your mask
		int mask = (-1 << i);
		int ans = n & mask;
		System.out.println(mask);
	}

	public static int clear_i_to_j_Bits(int n, int i, int j) {
		// create your mask // i
		int mask_A = (-1 << i + 1); // 1111100000
//									     j									
		int mask_B = ~(-1 << j);// 00000000001

		int mask = (mask_A | mask_B);

		// apply mask
		int ans = n & mask;

		System.out.println(ans);
		return ans;

	}

	public static int ReplaceNwithMBtwItoJ(int N, int M, int i, int j) {
		// clear N bit btwn i to j
		int cleared_N = clear_i_to_j_Bits(N, i, j);
//		move M to j bit left to OR
		int moveMtoJ = M << j;
		int ans = cleared_N | moveMtoJ;
		return ans;
	}

	public static void decimalToBinary(int N) {
		// clear N bit btwn i to j
		Stack<Integer> ans = new Stack<Integer>();
		while (N > 0) {
			int lbit = N & 1;
			ans.add(lbit);
			N = N >> 1;
		}
		while (!ans.isEmpty()) {
			System.out.print(ans.pop() + "");
		}
	}

	// 4,1,2,1,2,3,5,7,3
	public static void UniqueNumber_2(int nums[]) {
		int xor = 0;
		for (int x : nums) {
			xor ^= x; // 1num^2num
		}
		int temp = xor;
		System.out.println("xor   " + xor);
		// get 1st set bit from right
		int pos = 0;
		while ((temp & 1) != 1) {
			pos++;
			temp = temp >> 1;
		}
		System.out.println(pos);
		int mask = (1 << pos);
		int Num_1 = 0;
		for (int x : nums) {
			if ((x & mask) > 0) {
				System.out.println(x);
				Num_1 ^= x;
			}
		}

		int Num_2 = xor ^ Num_1;
		System.out.println(Num_1 + " " + Num_2);
	}

	/**
	 * 3,3,3,1,1,1,2
	 * 
	 * 
	 * xor=1^2^3 //so xor approach wont work
	 * 
	 * MN+1--->m=3 here, we need to remove MN and get the 1 number
	 * 
	 **/

	public static void UniqueNumber_3(int nums[]) {
		// holds all the count of bit
		int arr[] = new int[64];

		for (int x : nums) {
			int j = 0;
			while (x > 0) {
				if ((x & 1) == 1) {
					arr[j]++;
				}
				x = x >> 1;
				j++;
			}
			System.out.println(Arrays.toString(arr));
		}
		int ans = 0;
		int p = 1;
		for (int i = 0; i < 64; i++) {
			arr[i] = arr[i] % 3;
			ans += (arr[i] * p);
			p = p << 1;
		}

		System.out.println(ans);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getIthBit(5, 2);
//		setBit(5,1);
//		updateBit(5, 0, 1);
//		updateBit(5, 1, 1);
//		//00011111 ->16+8+4+2+1
		// 00010001
//		clear_i_to_j_Bits(31, 3,1);
//		decimalToBinary(7);
//		System.out.println();
		int arr[] = { 1, 4, 1, 2, 1, 2, 2, 3, 3, 3 };
		UniqueNumber_3(arr);
	}

}
