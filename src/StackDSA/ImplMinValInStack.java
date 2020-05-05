package StackDSA;

import java.util.Stack;

public class ImplMinValInStack {
	Stack<Integer> m = null;
	Stack<Integer> a = null;

	public ImplMinValInStack() {
		super();
		this.m = new Stack<Integer>();
		this.a = new Stack<Integer>();
	}

	public void push(int data) {
		if (m.isEmpty()) {
			m.push(data);
			a.push(data);
		} else {
			m.push(data);
			if (a.peek() >= m.peek()) {
				a.push(data);
			}
		}
	}

	public int pop() {
		if (a.peek() >= m.peek()) {
			a.pop();
		}
		return m.pop();

	}
	public int minVal() {
		return a.peek();
	}
	
	public static void main(String[] args) {
		ImplMinValInStack implminStack=new ImplMinValInStack();
		implminStack.push(100);
		implminStack.push(170);
		implminStack.push(50);
		implminStack.push(160);
		System.out.println(implminStack.minVal());
		implminStack.pop();
		implminStack.pop();
		System.out.println(implminStack.minVal());
		implminStack.pop();
		System.out.println(implminStack.minVal());
		implminStack.pop();
		System.out.println(implminStack.minVal());
		System.out.println(implminStack);
	}

	@Override
	public String toString() {
		return "ImplMinValInStack [m=" + m + ", a=" + a + "]";
	}

}
