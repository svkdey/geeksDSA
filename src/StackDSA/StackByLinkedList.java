package StackDSA;

import LinkedList.LinkedListNode;

public class StackByLinkedList {
	LinkedListNode head = null;
	int length = 0;

	public StackByLinkedList() {
		super();
		this.head = new LinkedListNode();
		// TODO Auto-generated constructor stub
	}

	public void push(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = this.head;
		this.length++;
		this.head = newNode;
	}

	public int pop() {
		if(this.head==null) {
			System.out.println("stack is empty");
			return -1;
		}
		int data = this.head.data;
		this.head = this.head.next;
		this.length--;
		return data;
	}

	public int peek() {
		return this.head.data;
	}

	public int size() {
		return this.length;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public String toString() {
		return "StackByLinkedList [head=" + head + "]";
	}

	public static void main(String[] args) {
		StackByLinkedList stack=new StackByLinkedList();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
//		System.out.println(stack);
	}

}
