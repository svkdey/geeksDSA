package LinkedList;

public class LinkedListNode {
	int value;
	LinkedListNode next;

	public LinkedListNode() {
		super();

	}

	public LinkedListNode(int value) {
		super();
		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedListNode [value=" + value + ", next=" + next + "]";
	}

}
