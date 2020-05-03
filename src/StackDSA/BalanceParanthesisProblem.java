package StackDSA;

import java.util.Stack;

import Data.StackData;

public class BalanceParanthesisProblem {
	static boolean balanceParanthesisProblem(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char item = str.charAt(i);
			if (isOpening(str.charAt(i))) {
				s.push(item);
			} else {
				if (s.isEmpty() == true) {
					return false;
				}
				boolean val = paranthsisChecker(s.pop(), item);
				if (val == false) {
					return false;
				}
			}
		}
		if (s.isEmpty() == false) {
			return false;
		} else {
			return true;
		}
	}

	static boolean isOpening(char c) {
		if (c == '{' || c == '[' || c == '(') {
			return true;
		} else {
			return false;
		}
	}

	static boolean paranthsisChecker(char c1, char c2) {
		if ((c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')')) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanceParanthesisProblem(StackData.PARANTHESIS1));
		System.out.println(balanceParanthesisProblem(StackData.PARANTHESIS2));
		System.out.println(balanceParanthesisProblem(StackData.PARANTHESIS3));
		System.out.println(balanceParanthesisProblem(StackData.PARANTHESIS4));
		System.out.println(balanceParanthesisProblem(StackData.PARANTHESIS5));
	}

}
