package LinkedList;

public class DoublyLinkedList implements LinkList {
	DoublyLinkedListNode head;
	int length;

	public DoublyLinkedList(int data) {
		super();
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		this.head = node;
		this.length++;
	}

	public DoublyLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
