package LinkedList;

public class LinkedListNode {
	int data;
	public LinkedListNode next;

	public LinkedListNode() {
		super();

	}

	public LinkedListNode(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedListNode [value=" + data + ", next=" + next + "]";
	}

}
