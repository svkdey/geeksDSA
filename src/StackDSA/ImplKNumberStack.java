package StackDSA;

import java.util.Arrays;

public class ImplKNumberStack {
	int stack[] = null;
	int top[] = null;
	int next[] = null;
	int capacity;
	int numberOfstack;
	int freeTop;

	public ImplKNumberStack(int capacity, int numberOfstack) {
		// TODO Auto-generated constructor stub
		this.numberOfstack = numberOfstack;
		this.capacity = capacity;
		stack = new int[capacity];
		next = new int[capacity];
		top = new int[numberOfstack];

		Arrays.fill(top, -1);
		for (int i = 0; i < capacity - 1; i++) {
			next[i] = i + 1;
		}
		next[capacity - 1] = -1;
	}

	boolean isFull() {
		return this.freeTop == -1;
	}

	void push(int data, int sn) {
		if (isFull()) {
			System.out.println("stack is full");
			System.exit(1);
		} else {
			
			//get last free spcae
			int i = freeTop;
			// push data into last free index
			stack[i] = data;
			// update freetop for next index
			freeTop = next[i];

			// update next value at last index =top index value;
			next[i] = top[sn];
			// update top index
			top[sn] = i;

		}
	}
	 int peek(int sn) {
		return stack[top[sn]];
	}
	 boolean isEmpty(int sn) {
		 return top[sn]==-1;
	 }
	 int pop(int sn) {
		 if (isEmpty(sn))  
         { 
             System.out.println("Stack Underflow"); 
             return Integer.MAX_VALUE; 
         } else {
        	 int i=top[sn];
        	 top[sn]=next[i];
        	 next[i]=freeTop;
        	 freeTop=i;
        	 return stack[i];
         }

	 }
	 
	@Override
	public String toString() {
		return "ImplKNumberStack [stack=" + Arrays.toString(stack) + ", top=" + Arrays.toString(top) + ", next="
				+ Arrays.toString(next) + ", capacity=" + capacity + ", numberOfstack=" + numberOfstack + ", freeTop="
				+ freeTop + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplKNumberStack kstack=new ImplKNumberStack(5, 3);
		kstack.push(10,1);
		kstack.push(20,2);
		kstack.push(30,2);
		kstack.push(40,2);
		kstack.push(50,0);
		System.out.println(kstack);
		kstack.pop(2);
		kstack.pop(2);
		kstack.push(100,0);
		System.out.println(kstack);
	

	}

}
