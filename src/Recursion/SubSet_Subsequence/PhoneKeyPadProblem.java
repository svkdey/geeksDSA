package Recursion.SubSet_Subsequence;

import java.util.ArrayList;
import java.util.stream.Collectors;
//very important problem
public class PhoneKeyPadProblem {
	static String keypad[][] = { {}, {}, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" }, { "J", "K", "L" },
			{ "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };

	public static void solve(int i, int in[], ArrayList<String> op) {
		if (i == in.length) {
			//joining strings
			String str = op.stream().map(e->e.toString()).collect(Collectors.joining());
			System.out.println(str);
			return;
		}
		
		int digit = in[i];
		//blank case
		if (digit == 1 || digit == 0) {
			solve(i + 1, in, op);
		}
		String str[] = keypad[digit];
		for (int k = 0; k < str.length; k++) {
				//	add element
			op.add(str[k]);
			// add 2nd next element
			solve(i + 1, in, op);
			// back track last element
			op.remove(op.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		int ip[] = {3, 2, 3 };
		ArrayList<String> list = new ArrayList<String>();
		solve(0, ip, list);
	}
}
