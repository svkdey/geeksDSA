package StackDSA;

import java.util.Arrays;

public class StackImplByArray {
	private int arr[] = null;
	private int top = -1;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public StackImplByArray(int size) {
		super();
		this.size = size;
		this.arr = new int[size];
	}

	public void push(int data) {
		if (top == this.size - 1) {
			System.out.println("Stack is full");
		} else {
			top++;
			arr[top] = data;
		}

	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
		int val = arr[top];
		arr[top]=-1;
		top--;
		return val;
	}

	public int peek() {
		if (top == -1) {
			return -1;
		}
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int stackSize() {
		return top + 1;
	}

	@Override
	public String toString() {
		return "StackImplByArray [arr=" + Arrays.toString(arr) + ", top=" + top + ", size=" + size + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImplByArray stack = new StackImplByArray(5);

		stack.push(5);
		stack.push(10);

		stack.push(5);
		stack.push(10);

//		stack.push(5);
//		stack.push(10);



	
		System.out.println(stack.isEmpty());
		System.out.println(stack.stackSize());
//		while (!stack.isEmpty()) {
//			
//			System.out.println(stack.pop());
//		}
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
		stack.push(100);
		System.out.println(stack);
	}

}
