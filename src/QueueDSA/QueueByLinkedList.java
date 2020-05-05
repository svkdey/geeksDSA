package QueueDSA;

import LinkedList.LinkedListNode;

public class QueueByLinkedList {
	LinkedListNode front;
	LinkedListNode rear;
	int length;

	

	void push(int data) {
		LinkedListNode newnode = new LinkedListNode(data);
		if (front == null) {
			
			front = newnode;
			rear = front;
		} else {
			newnode.next = front;
			front = newnode;
		}
		length++;
	}

	boolean isEmpty() {
		if ( front == null) {
			return true;
		} else {
			return false;
		}
	}

	int pop() {
		if (length != 0) {
			int temp = front.data;
			front = front.next;
			length--;
			return temp;
		} else {
			front=null;
			rear=null;
			System.out.println("Stack is empty");
			return -1;
		}
	}

	int peek() {
		if (front != null) {
			return front.data;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}
	int size() {
		return length;
	}
	@Override
	public String toString() {
		return "QueueByLinkedList [front=" + front + ", rear=" + rear + ", length=" + length + "]";
	}

	public static void main(String[] args) {
	QueueByLinkedList q=new QueueByLinkedList();
	q.push(10);
	q.push(20);
	q.push(300);
	System.out.println(q);
	System.out.println(q.size());
	System.out.println(q.pop());
	System.out.println(q.pop());
	System.out.println(q.size());
	System.out.println(q);;
	while(!q.isEmpty()) {
		System.out.println(q.pop());
	}
	

	}

}
