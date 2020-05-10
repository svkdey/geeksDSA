package StackDSA;

import java.util.Stack;

public class InfixToPostFix {
	/*
	 * Algorithm 1. Scan the infix expression from left to right. 2. If the scanned
	 * character is an operand, output it. 3. Else, ….. 3.1 If the precedence of the
	 * scanned operator is greater than the precedence of the operator in the
	 * stack(or the stack is empty or the stack contains a ‘(‘ ), push it. ….. 3.2
	 * Else, Pop all the operators from the stack which are greater than or equal to
	 * in precedence than that of the scanned operator. After doing that Push the
	 * scanned operator to the stack. (If you encounter parenthesis while popping
	 * then stop there and push the scanned operator in the stack.) 4. If the
	 * scanned character is an ‘(‘, push it to the stack. 5. If the scanned
	 * character is an ‘)’, pop the stack and and output it until a ‘(‘ is
	 * encountered, and discard both the parenthesis. 6. Repeat steps 2-6 until
	 * infix expression is scanned. 7. Print the output 8. Pop and output from the
	 * stack until it is not empty.
	 */

	static int isOparand(char c) {
		if (c == '+' || c == '-') {
			return 1;
		}
		if (c == '*' || c == '/') {
			return 2;
		}
		if (c == '^') {
			return 3;
		} else {
			return -1;
		}
	}

	public static String inFixToPostfix(String s) {
		Stack<Character> stack = new Stack<Character>();

		String Q = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				Q += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					Q += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && isOparand(c) <= isOparand(stack.peek())) {
					if (stack.peek() == '(') {
						return "Invalid expression";
					} else {
						Q += stack.pop();
					}
				}

				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid expression last";
			} else {
				Q += stack.pop();
			}
		}

		return Q;

	}

	static int calculate(String a, String b, String oprand) {
		int val1 = Integer.parseInt(a);
		int val2 = Integer.parseInt(b);
		char newC = oprand.charAt(0);
		if (newC == '*') {
			return val1 * val2;
		}
		if (newC == '/') {
			return val1 / val2;
		}
		if (newC == '+') {
			return val1 + val2;
		}
		if (newC == '-') {
			return val1 - val2;
		}
		if (newC == '^') {
			return (int) Math.pow(val1, val2);
		} else
			return 0;
	}

	static boolean isOparandEval(String c) {
		char newC = c.charAt(0);
//		System.out.println(newC=='+');
		if (newC == '+' || newC == '*' || newC == '-' || newC == '/' || newC == '^') {
			return true;
		} else {
			return false;
		}
	}

	public static int postFixToValue(String s) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {

			String c = Character.toString(s.charAt(i));
			boolean isOparand = isOparandEval(c);
			if (isOparand) {

				if (stack.size() > 1) {
					String v1 = stack.pop();
					String v2 = stack.pop();
					int calculatedVal = calculate(v2, v1, c);
					stack.push(Integer.toString(calculatedVal));
				} else {
					return -1;
				}
			} else {
				stack.push(c);
			}
		}

		return Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "756+*";
		System.out.println(postFixToValue(s));

	}

}
