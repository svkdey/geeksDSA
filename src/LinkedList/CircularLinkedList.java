package LinkedList;

public class CircularLinkedList{
	CircularLinkListNode head;
	CircularLinkListNode tail;
	int length;

	public CircularLinkedList(int data) {
		super();
		CircularLinkListNode node = new CircularLinkListNode(data);
		this.head = this.tail = node;
		this.length++;
	}

	@Override
	public String toString() {
		return "CircularLinkedList [head=" + head + ", tail=" + tail + ", length=" + length + "]";
	}

	public CircularLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	};
}
