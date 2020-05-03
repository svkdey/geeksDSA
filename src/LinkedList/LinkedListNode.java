package LinkedList;

public class LinkedListNode {
	public int data=Integer.MIN_VALUE;
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
