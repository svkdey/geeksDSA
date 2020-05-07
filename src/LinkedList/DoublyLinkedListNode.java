package LinkedList;

public class DoublyLinkedListNode {
	public int data;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode prev;
	
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
