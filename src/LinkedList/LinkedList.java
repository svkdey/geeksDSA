package LinkedList;

public class LinkedList implements LinkList {
	LinkedListNode head;
	int length;

	

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", length=" + length + "]";
	}

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(int data) {
		LinkedListNode node = new LinkedListNode(data);
		this.head = node;
	}

	public void insertBegin(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = head;
		this.head = newNode;
		this.length++;
	}

	public void traverse() {
		LinkedListNode currentNode = this.head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public LinkedListNode lastNode() {
		LinkedListNode currentNode = this.head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public void addLast(int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (this.head == null) {
			this.head = node;
		} else {
			LinkedListNode lNode = lastNode();
			lNode.next = node;
		}
		this.length++;
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertBegin(10);
		l.insertBegin(20);
		l.addLast(50);
		System.out.println(l);

	}
}