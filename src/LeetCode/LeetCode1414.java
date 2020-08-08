package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode1414 {
	static ArrayList<Integer> l = null;

	private static void generate(int n) {
		l.add(0);
		l.add(1);
		for (int i = 2; i <= n; i++) {
			int k = l.get(i - 1) + l.get(i - 2);
			l.add(k);
			if (k > n) {
				break;
			}
		}

	}

	public static int findMinFibonacciNumbers(int k) {
		l=new ArrayList<Integer>();
		generate(k + 1);
		System.out.println(l);
		int ans = findCount(k);
		System.out.println(ans);
		return ans;
	}

	
	public static int findCount(int k) {
		int count = 0;
		int j = l.size() - 1;
		while (k != 0 && j > 1) {
			count += (k / l.get(j));
			k = k % l.get(j);
			j--;
		}
		return count;
	}

	public static void main(String[] args) {

		findMinFibonacciNumbers(19);
	}

}
