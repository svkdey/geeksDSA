package LinkedList;

public class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode next;
	DoublyLinkedListNode prev;
	
	public DoublyLinkedListNode() {
		// TODO Auto-generated constructor stub
		
	}
	public DoublyLinkedListNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.next=null;
		this.prev=null;
	}
	@Override
	public String toString() {
		return "DoublyLinkedListNode [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
	

}
