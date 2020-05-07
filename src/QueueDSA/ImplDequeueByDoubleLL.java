package QueueDSA;

import LinkedList.DoublyLinkedListNode;

public class ImplDequeueByDoubleLL {
	DoublyLinkedListNode front = null;
	DoublyLinkedListNode rear = null;

	public ImplDequeueByDoubleLL() {

	}

	public void insertFront(int x) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(x);
		if (this.front == null && this.rear == null) {
			this.front = node;
			this.rear = node;
		}
		else if (this.front == this.rear) {
			node.next = this.front;
			this.front.prev = node;
			this.front = node;

		} else {
			this.front.prev = node;
			node.next = this.front;
			this.front = node;
		}
	}

	void insertRear(int x) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(x);
		if (this.front == null && this.rear == null) {
			this.front = node;
			this.rear = node;
		}
		else if (this.front == this.rear) {
			node.prev = this.rear;
			this.rear.next = node;
			this.rear = node;

		} else {
			this.rear.next = node;
			node.prev = this.rear;
			this.rear = node;
		}
	}

	int removeFront() {
		if (this.front == null||this.front.prev==null) {
			throw new Error("Dequeue if empty");
		} else {
			int temp = front.data;
			this.front = this.front.next;
			
			this.front.prev = null;
			return temp;
		}
	}

	int removeRear() {
		if (this.rear == null||this.rear.next==null) {
			throw new Error("Dequeue if empty");
		} else {
			int temp = rear.data;
			this.rear = this.rear.prev;
			
			this.rear.next = null;
			return temp;
		}
	}

	int peekFront() {
		return this.front.data;
	}

	int peekRear() {
		return this.rear.data;
	}

	boolean isEmpty() {
		if (this.rear == null && this.front == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "ImplDequeueByDoubleLL [front=" + front + ", rear=" + rear + "]";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplDequeueByDoubleLL q = new ImplDequeueByDoubleLL();
		q.insertFront(10);
		q.insertRear(20);
		q.insertFront(30);
		q.insertRear(40);
//		System.out.println(q);
		System.out.println(q.isEmpty());
		System.out.println(q.peekFront());
		System.out.println(q.peekRear());
		while (!q.isEmpty()) {
			System.out.println(q.removeFront());
//			System.out.println(q.removeRear());
		}
//		System.out.println(q.peekFront());

	}
}
