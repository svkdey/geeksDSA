package stringDSA;

import Recursion.GlobalMathFunctions;

public class LaxiographicRank {
	

	static int findCountOfSmallerInRight(String str, int low, int high) {
		int countRight = 0, i;

		for (i = low + 1; i <= high; ++i)
			if (str.charAt(i) < str.charAt(low))
				++countRight;

		return countRight;
	}

// A function to find rank of a string in 
// all permutations of characters 
	static int findRank(String str) {
		int len = str.length();
		
		int factor = GlobalMathFunctions.factorial(len);
		int rank = 1;
		int countRight;

		for (int i = 0; i < len; ++i) {
			factor = factor / (len - i);

// count number of chars smaller than str[i] in right hand side of i
			countRight = findCountOfSmallerInRight(str, i, len - 1);
			rank += countRight * factor;
		}

		return rank;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRank("BAA"));

	}

}
